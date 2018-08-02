package com.yjh.resource.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagementTemplateRequest {

    private String userId;
    private String carInfoId;
    private String tollCollector;
    private String totalTime;
    private String chargeType;
    private String money;
}
