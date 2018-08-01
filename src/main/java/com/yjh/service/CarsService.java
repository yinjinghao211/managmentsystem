package com.yjh.service;

import com.yjh.entity.Cars;
import com.yjh.resource.request.CarTemplateRequest;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CarsService {
    int addCar(CarTemplateRequest carTemplateRequest);

    void deleteCar(String id);

    int updateCar(CarTemplateRequest carTemplateRequest, String id);

    Cars queryCar(String id);

    Page<Cars> queryCarPageable(Integer page,Integer size);

    void export(HttpServletRequest request, HttpServletResponse response);
}
