package com.yjh.controller;

import com.yjh.entity.Cars;
import com.yjh.resource.request.CarTemplateRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
public interface CarController {
    /**
     * 添加车辆
     * @param carTemplateRequest
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/addCar",consumes = MediaType.APPLICATION_JSON_VALUE)
    int addCar(@RequestBody CarTemplateRequest carTemplateRequest);

    /**
     * 删除车辆
     * @param id
     */
    @ResponseBody
    @PostMapping(value = "/deleteCar/{id}")
    void deleteCar(@PathVariable String id);

    /**
     * 更改车辆信息
     * @param carTemplateRequest
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/updateCar/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    int updateCar(@RequestBody CarTemplateRequest carTemplateRequest,@PathVariable String id);

    @ResponseBody
    @PostMapping(value = "queryCar/{id}")
    Cars queryCar(@PathVariable String id);
}
