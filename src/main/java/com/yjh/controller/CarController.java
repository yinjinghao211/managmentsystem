package com.yjh.controller;

import com.yjh.entity.Cars;
import com.yjh.resource.request.CarTemplateRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @PostMapping(value = "/queryCar/{id}")
    Cars queryCar(@PathVariable String id);

    /**
     * 分页查询车辆信息(暂时按照car的类别来查询)(1页5个)
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/queryCarPageable")
    Page<Cars> queryCarPageable(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                @RequestParam(value = "size",defaultValue = "5") Integer size);

    @RequestMapping(value = "/export")
    @ResponseBody
    void export(HttpServletRequest request, HttpServletResponse response);
}
