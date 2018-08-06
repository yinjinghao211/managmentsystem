package com.yjh.service;

import com.yjh.entity.CarInfo;
import com.yjh.resource.request.CarInfoTemplateRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface CarInfoService {
    List<CarInfo> queryCarInfo(CarInfoTemplateRequest message, String carType);

    CarInfo addCarInfo(String carId);

    void deleteCarInfo(String carInfoId);

    CarInfo updateCarInfo(CarInfoTemplateRequest carInfoTemplateRequest, String carInfoId);

    Double countMoney(String carId, String carInfoId);
}
