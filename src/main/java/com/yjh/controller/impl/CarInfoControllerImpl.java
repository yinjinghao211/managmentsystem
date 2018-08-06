package com.yjh.controller.impl;

import com.yjh.controller.CarInfoController;
import com.yjh.entity.CarInfo;
import com.yjh.resource.request.CarInfoTemplateRequest;
import com.yjh.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarInfoControllerImpl implements CarInfoController {

    @Autowired
    private CarInfoService carInfoService;
    @Override
    public List<CarInfo> queryCarInfo(@RequestBody CarInfoTemplateRequest message, @PathVariable String carType) {
        return carInfoService.queryCarInfo(message, carType);
    }

    @Override
    public CarInfo addCarInfo(@PathVariable String carId) {
        return carInfoService.addCarInfo(carId);
    }

    @Override
    public void deleteCarInfo(@PathVariable String carInfoId) {
        carInfoService.deleteCarInfo(carInfoId);
    }

    @Override
    public CarInfo updateCarInfo(@RequestBody CarInfoTemplateRequest carInfoTemplateRequest,
                                 @RequestParam(value = "carInfoId",defaultValue = "0") String carInfoId) {
        return carInfoService.updateCarInfo(carInfoTemplateRequest,carInfoId);
    }

    @Override
    public Double countMoney(@PathVariable String carId,@PathVariable String carInfoId) {
        return carInfoService.countMoney(carId,carInfoId);
    }
}
