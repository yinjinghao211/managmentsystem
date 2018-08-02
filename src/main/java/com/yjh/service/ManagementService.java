package com.yjh.service;

import com.yjh.entity.Management;
import com.yjh.resource.request.ManagementTemplateRequest;
import org.springframework.stereotype.Service;

@Service
public interface ManagementService {
    Management managementAdd(ManagementTemplateRequest managementTemplateRequest);

    void deleteManagement(String manageId);

    Management updateManagement(ManagementTemplateRequest managementTemplateRequest, String manageId);

    Management queryManagement(String manageId);
}
