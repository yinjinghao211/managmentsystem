package com.yjh.service.impl;

import com.yjh.dao.CarsDaoJPA;
import com.yjh.entity.Cars;
import com.yjh.resource.request.CarTemplateRequest;
import com.yjh.service.CarsService;
import com.yjh.utils.CheckUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

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
        CheckUtil.checkArgument(id!=null);
        try{
            Cars cars = carsDaoJPA.findOne(id);
            return cars;
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return null;
        }
    }
}
