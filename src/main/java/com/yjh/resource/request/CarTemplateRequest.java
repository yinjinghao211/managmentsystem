package com.yjh.resource.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarTemplateRequest {

    private String carName;
    private String carNumber;
    private String carType;
    private String userId;
}
