package com.yjh.service;

import com.yjh.entity.Cars;
import com.yjh.resource.request.CarTemplateRequest;

public interface CarsService {
    int addCar(CarTemplateRequest carTemplateRequest);

    void deleteCar(String id);

    int updateCar(CarTemplateRequest carTemplateRequest, String id);

    Cars queryCar(String id);
}
