package com.yjh.service.impl;

import com.yjh.dao.CarsDaoJPA;
import com.yjh.entity.Cars;
import com.yjh.resource.request.CarTemplateRequest;
import com.yjh.service.CarsService;
import com.yjh.utils.CheckUtil;
import com.yjh.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarsServiceImpl implements CarsService{

    @Autowired
    private CarsDaoJPA carsDaoJPA;

    @Override
    public int addCar(CarTemplateRequest carTemplateRequest) {
        CheckUtil.checkArgument(carTemplateRequest!=null);
        Cars cars = new Cars();
        BeanUtils.copyProperties(carTemplateRequest,cars);
        cars.setCarId(UUID.randomUUID().toString().replace("-",""));
        try {
            carsDaoJPA.saveAndFlush(cars);
            return 1;
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return 0;
        }
    }

    @Override
    public void deleteCar(String id) {
        CheckUtil.checkArgument((id!=null));
        carsDaoJPA.delete(id);
    }

    @Override
    public int updateCar(CarTemplateRequest carTemplateRequest, String id) {
        CheckUtil.checkArgument(carTemplateRequest!=null);
        CheckUtil.checkArgument(id!=null);
        try {
            Cars cars = carsDaoJPA.findOne(id);
            BeanUtils.copyProperties(carTemplateRequest,cars);
            cars.setCarId(id);
            return 1;
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return 0;
        }
    }

    @Override
    public Cars queryCar(String id) {
        System.out.println(id+"---------------------------------");
        CheckUtil.checkArgument(id!=null);
        try{
            Cars cars = carsDaoJPA.findOne(id);
            return cars;
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return null;
        }
    }

    @Override
    public Page<Cars> queryCarPageable(Integer page,Integer size) {
        Sort sort = new Sort(Sort.Direction.ASC,"carId");
        Pageable pageable = new PageRequest(page,size,sort);
        return carsDaoJPA.findAll(pageable);
    }

    @Override
    public void export(){
        ExcelUtil<Cars> excelUtil = new ExcelUtil();
        List<String> headerName = new ArrayList<>();
        headerName.add("车辆ID");
        headerName.add("车辆名称");
        headerName.add("车牌号");
        headerName.add("车辆身份");
        headerName.add("用户ID");
        List<String> headerId = new ArrayList<>();
        headerId.add("carId");
        headerId.add("carName");
        headerId.add("carNumber");
        headerId.add("carType");
        headerId.add("userId");
        List<Cars> carsList =carsDaoJPA.findAll();
        excelUtil.exportExcel("车辆导出报表",headerName,headerId,carsList);
    }
}
