package com.yjh.service;

import org.springframework.stereotype.Service;

@Service
public interface DayStatisticsService {
    String chargeByDate(String year, String month, String day);

    String chargeByParkingId(String parkingId);
}
