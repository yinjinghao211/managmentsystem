package com.yjh.controller.impl;

import com.yjh.controller.ManagementController;
import com.yjh.entity.Management;
import com.yjh.resource.request.ManagementTemplateRequest;
import com.yjh.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagementControllerImpl implements ManagementController{
    @Autowired
    private ManagementService managementService;
    @Override
    public Management managementAdd(@RequestBody ManagementTemplateRequest managementTemplateRequest) {
        return managementService.managementAdd(managementTemplateRequest);
    }

    @Override
    public void deleteManagement(@PathVariable String manageId) {
        managementService.deleteManagement(manageId);
    }

    @Override
    public Management updateManagement(@RequestBody ManagementTemplateRequest managementTemplateRequest,
                                       @PathVariable String manageId) {
        return managementService.updateManagement(managementTemplateRequest,manageId);
    }

    @Override
    public Management queryManagement(@PathVariable String manageId) {
        return managementService.queryManagement(manageId);
    }
}
