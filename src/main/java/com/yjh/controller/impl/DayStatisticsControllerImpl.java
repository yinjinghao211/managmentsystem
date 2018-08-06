package com.yjh.controller.impl;

import com.yjh.controller.DayStatisticsController;
import com.yjh.service.DayStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayStatisticsControllerImpl implements DayStatisticsController {
    @Autowired
    private DayStatisticsService dayStatisticsService;
    @Override
    @ResponseBody
    public String chargeByDate(@RequestParam(value = "year" ,defaultValue = "2018") String year,
                               @RequestParam(value = "month",defaultValue = "1") String month,
                               @RequestParam(value = "day",defaultValue = "1") String day) {
        return dayStatisticsService.chargeByDate(year,month,day);
    }

    @Override
    @ResponseBody
    public String chargeByParkingId(@PathVariable String parkingId) {
        return dayStatisticsService.chargeByParkingId(parkingId);
    }

}
