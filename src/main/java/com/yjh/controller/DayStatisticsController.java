package com.yjh.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 当天统计
 */
@RestController
public interface DayStatisticsController {

    /**
     * 按日期查询当天收费情况
     * @param year
     * @param month
     * @param day
     * @return
     */
    @ResponseBody
    @RequestMapping("/chargeByDate")
    String chargeByDate(@RequestParam(value = "year" ,defaultValue = "2018") String year,
                        @RequestParam(value = "month",defaultValue = "1") String month,
                        @RequestParam(value = "day",defaultValue = "1") String day);

    /**
     * 按停车场查询当天的收费
     * @param parkingId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/chargeByParkingId/{parkingId}")
    String chargeByParkingId(@PathVariable String parkingId);


}
