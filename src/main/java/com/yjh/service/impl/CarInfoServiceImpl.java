package com.yjh.service.impl;

import com.yjh.dao.CarInfoDaoJPA;
import com.yjh.dao.CarsDaoJPA;
import com.yjh.entity.CarInfo;
import com.yjh.resource.request.CarInfoTemplateRequest;
import com.yjh.service.CarInfoService;
import com.yjh.utils.CheckUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarInfoServiceImpl implements CarInfoService {
    @Autowired
    private CarInfoDaoJPA carInfoDaoJPA;
    @Autowired
    private CarsDaoJPA carsDaoJPA;
    @Override
    public List<CarInfo> queryCarInfo(CarInfoTemplateRequest message, String carType) {
        //https://www.cnblogs.com/rulian/p/6533109.html
        CheckUtil.checkArgument(message!=null);
        //查询carInfo是message的对象
        CarInfo carInfo = new CarInfo();
        carInfo.setParkingTime(message.getParkingTime());
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("parkingTime", ExampleMatcher.GenericPropertyMatchers.startsWith())//parkingTime采用开始匹配方式查询
                .withIgnoreCase()//忽略大小写
                .withIgnorePaths("carInfoId");//忽略属性

        Example<CarInfo> example = Example.of(carInfo,matcher);
        try{
            return carInfoDaoJPA.findAll(example);
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return null;
        }
    }

    @Override
    public CarInfo addCarInfo(String cardId) {
        CheckUtil.checkArgument(cardId!=null);
        CarInfo carInfo = new CarInfo();
        carInfo.setCarId(cardId);
        carInfo.setCarInfoId(UUID.randomUUID().toString().replaceAll("-",""));
        try {
            return carInfoDaoJPA.save(carInfo);
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return null;
        }
    }

    @Override
    public void deleteCarInfo(String carInfoId) {
        CheckUtil.checkArgument(carInfoId!=null);
        try {
            carInfoDaoJPA.delete(carInfoId);
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
        }
    }

    @Override
    public CarInfo updateCarInfo(CarInfoTemplateRequest carInfoTemplateRequest, String carInfoId) {
        CheckUtil.checkArgument(carInfoTemplateRequest !=null);
        CheckUtil.checkArgument(carInfoId!=null);
        CarInfo carInfo =new CarInfo();
        BeanUtils.copyProperties(carInfoTemplateRequest,carInfo);
        carInfo.setCarId(carInfoId);
        try {
            carInfoDaoJPA.delete(carInfoId);
            carInfoDaoJPA.saveAndFlush(carInfo);
            return carInfo;
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return null;
        }
    }

    @Override
    public Double countMoney(String carId, String carInfoId) {
        CheckUtil.checkArgument(carId!=null);
        CheckUtil.checkArgument(carInfoId!=null);
        String carType = carsDaoJPA.getOne(carId).getCarType();
        //只能计算一天以内的数据
        Integer startTime = Integer.getInteger(carInfoDaoJPA.findOne(carInfoId).getOriginTime());
        Integer endTime = Integer.getInteger(carInfoDaoJPA.findOne(carInfoId).getEndTime());
        if(carType.equals("VIP")){
            //一小时一元，六折
            return (endTime-startTime)*0.6;
        }else if(carType.equals("USUAL")){
            //一小时一元，八折
            return (endTime-startTime)*0.8;
        }else{
            return null;
        }
    }
}
