package com.yjh.controller;

import com.yjh.entity.CarInfo;
import com.yjh.resource.request.CarInfoTemplateRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface CarInfoController {

    /**
     * 根据给定条件查询carinfo，本实例采用匹配器方式，还可以使用sql拼接语句
     * 可以使用spring-data-jpa的语法，进行条件查询，
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryCarInfo/{carType}")
    List<CarInfo> queryCarInfo(@RequestBody CarInfoTemplateRequest message, @PathVariable String carType);

    /**
     * 按照carId增加车辆信息,生成一个空的信息，之后update
     * @param carId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addCarInfo/{carId}")
    CarInfo addCarInfo(@PathVariable String carId);

    /**
     * 删除某一个车辆信息
     * @param carInfoId
     */
    @ResponseBody
    @RequestMapping(value = "deleteCarInfo/{carInfoId}")
    void deleteCarInfo(@PathVariable String carInfoId);

    /**
     * 更改车辆信息
     * @param carInfoTemplateRequest
     * @param carInfoId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateCarInfo" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    CarInfo updateCarInfo(@RequestBody CarInfoTemplateRequest carInfoTemplateRequest,
                          @RequestParam(value = "carInfoId",defaultValue = "0") String carInfoId);

    @ResponseBody
    @RequestMapping(value = "countMoney/{carId},{carInfoId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    Double countMoney(@PathVariable String carId,@PathVariable String carInfoId);
}
