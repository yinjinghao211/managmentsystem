package com.yjh.controller;

import com.yjh.entity.Cars;
import com.yjh.resource.request.CarTemplateRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
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
     * 更改车辆信息--此方法不可用，更改信息到CarInfo中修改
     * @param carTemplateRequest
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/updateCar/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    int updateCar(@RequestBody CarTemplateRequest carTemplateRequest,@PathVariable String id);

    /**
     * 查询车辆信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryCar/{id}")
    Cars queryCar(@PathVariable String id);

    /**
     * 分页查询车辆信息(暂时按照car的类别来查询)(1页5个)
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryCarPageable/{page},{size}")
    Page<Cars> queryCarPageable(@PathVariable(value = "page") Integer page,
                                @PathVariable(value = "size") Integer size);

    /**
     * 导出车辆信息报表
     */
    @RequestMapping(value = "/export")
    void export();
}
