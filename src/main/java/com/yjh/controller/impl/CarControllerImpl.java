package com.yjh.controller.impl;

import com.yjh.controller.CarController;
import com.yjh.entity.Cars;
import com.yjh.resource.request.CarTemplateRequest;
import com.yjh.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarControllerImpl implements CarController {

    @Autowired
    private CarsService carsService;


    @Override
    public int addCar(@RequestBody CarTemplateRequest carTemplateRequest) {
        return carsService.addCar(carTemplateRequest);
    }

    @Override
    public void deleteCar(@PathVariable  String id) {
        carsService.deleteCar(id);
    }

    @Override
    public int updateCar(@RequestBody CarTemplateRequest carTemplateRequest,@PathVariable String id) {
        return carsService.updateCar(carTemplateRequest,id);
    }

    @Override
    public Cars queryCar(@PathVariable String id) {
        System.out.println("---------------------"+id);
        return carsService.queryCar(id);
    }

    @Override
    public Page<Cars> queryCarPageable(@PathVariable Integer page,@PathVariable Integer size) {
        return carsService.queryCarPageable(page,size);
    }

    @Override
    public void export() {
        carsService.export();
    }


}
