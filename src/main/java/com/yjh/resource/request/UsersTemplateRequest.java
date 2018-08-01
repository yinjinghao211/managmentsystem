package com.yjh.resource.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersTemplateRequest {

    private String userName;
    private String userAge;
    private String userEmail;
    private String userPhone;
    private String userIdCard;
    private String userQQ;
    private String userWeChat;
}
