package com.yjh.controller.impl;

import com.yjh.controller.CarController;
import com.yjh.entity.Cars;
import com.yjh.resource.request.CarTemplateRequest;
import com.yjh.service.CarsService;
import org.springframework.web.bind.annotation.ResponseBody;

public class CarControllerImpl implements CarController {

    private CarsService carsService;

    @ResponseBody
    @Override
    public int addCar(CarTemplateRequest carTemplateRequest) {
        return carsService.addCar(carTemplateRequest);
    }

    @Override
    public void deleteCar(String id) {
        carsService.deleteCar(id);
    }

    @Override
    public int updateCar(CarTemplateRequest carTemplateRequest, String id) {
        return carsService.updateCar(carTemplateRequest,id);
    }

    @Override
    public Cars queryCar(String id) {
        return carsService.queryCar(id);
    }
}
