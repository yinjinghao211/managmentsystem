package com.yjh.resource.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarInfoTemplateRequest {

    private String carCharge;
    private String parkingTime;
    private String payMode;
    private String inTime;
    private String outTime;
    private String tollCollector;
    private String originTime;
    private String endTime;
    private String carReason;
    private String parkingSecurity;
    private String travelRecord;
    private String carModifyTime;
}
