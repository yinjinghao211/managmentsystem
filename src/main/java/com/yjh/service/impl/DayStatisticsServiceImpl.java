package com.yjh.service.impl;

import com.yjh.dao.CarInfoDaoJPA;
import com.yjh.entity.CarInfo;
import com.yjh.service.DayStatisticsService;
import com.yjh.utils.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class DayStatisticsServiceImpl implements DayStatisticsService {
    @Autowired
    private CarInfoDaoJPA carInfoDaoJPA;
    @Override
    public String chargeByDate(String year, String month, String day) {
        CheckUtil.checkArgument(year!=null);
        CheckUtil.checkArgument(month!=null);
        CheckUtil.checkArgument(day!=null);
        StringBuffer days = new StringBuffer();
        CarInfo carInfo = new CarInfo();
        days.append(year).append(month).append(day);
        carInfo.setParkingTime(days.toString());
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().
                withMatcher("originTime",ExampleMatcher.GenericPropertyMatchers.startsWith()).
                withIgnorePaths("carId").
                withIgnoreCase();
        Example example = Example.of(carInfo,exampleMatcher);
        CarInfo carInfo1 =carInfoDaoJPA.findOne(example);
        return carInfo1.getCarCharge();
    }

    @Override
    public String chargeByParkingId(String parkingId) {
        CheckUtil.checkArgument(parkingId!=null);
        try {
            return carInfoDaoJPA.getcarChargeByParkingId(parkingId);
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return null;
        }
    }
}
