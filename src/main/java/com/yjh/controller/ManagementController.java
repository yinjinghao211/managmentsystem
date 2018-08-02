package com.yjh.controller;

import com.yjh.entity.Management;
import com.yjh.resource.request.ManagementTemplateRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 管理端，实现简单的增删改查即可
 */
@RestController
public interface ManagementController {
    /**
     * 添加管理端
     * @param managementTemplateRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "managementAdd" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    Management managementAdd(@RequestBody ManagementTemplateRequest managementTemplateRequest);

    /**
     * 删除管理端
     * @param manageId
     */
    @ResponseBody
    @RequestMapping(value = "deleteManagement/{manageId}")
    void deleteManagement(@PathVariable String manageId);

    /**
     * 更新管理端
     * @param managementTemplateRequest
     * @param manageId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateManagement/{manageId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    Management updateManagement(@RequestBody ManagementTemplateRequest managementTemplateRequest,
                                @PathVariable String manageId);

    /**
     * 查询管理端信息
     * @param manageId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryManagement/{manageId}")
    Management queryManagement(@PathVariable String manageId);
}
