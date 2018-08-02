package com.yjh.service.impl;

import com.yjh.dao.ManagementJPA;
import com.yjh.entity.Management;
import com.yjh.resource.request.ManagementTemplateRequest;
import com.yjh.service.ManagementService;
import com.yjh.utils.CheckUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    ManagementJPA managementJPA;
    @Override
    public Management managementAdd(ManagementTemplateRequest managementTemplateRequest) {
        CheckUtil.checkArgument(managementTemplateRequest!=null);
        Management management = new Management();
        BeanUtils.copyProperties(management,managementTemplateRequest);
        management.setManageId(UUID.randomUUID().toString().replaceAll("-",""));
        try {
            return managementJPA.save(management);
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return null;
        }
    }

    @Override
    public void deleteManagement(String manageId) {
        CheckUtil.checkArgument(manageId!=null);
        try {
            managementJPA.delete(manageId);
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
        }
    }

    @Override
    public Management updateManagement(ManagementTemplateRequest managementTemplateRequest, String manageId) {
        CheckUtil.checkArgument(managementTemplateRequest!=null);
        CheckUtil.checkArgument(manageId!=null);
        Management management = new Management();
        BeanUtils.copyProperties(managementTemplateRequest,management);
        management.setManageId(manageId);
        try {
            managementJPA.delete(manageId);
            return managementJPA.save(management);
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return null;
        }
    }

    @Override
    public Management queryManagement(String manageId) {
        CheckUtil.checkArgument(manageId!=null);
        try {
            return managementJPA.getOne(manageId);
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
            return null;
        }
    }
}
