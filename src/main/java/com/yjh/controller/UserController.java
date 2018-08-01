package com.yjh.controller;

import com.yjh.entity.Users;
import com.yjh.resource.request.UsersTemplateRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public interface UserController {
    /**
     * 添加user
     * @param usersTemplateRequest
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/add" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    int addUsers(@RequestBody UsersTemplateRequest usersTemplateRequest);

    /**
     * 更新user
     * @param id
     * @param usersTemplateRequest
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/update/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    int updateUser(@PathVariable String id, @RequestBody UsersTemplateRequest usersTemplateRequest);

    /**
     * 删除user
     * @param id
     */
    @DeleteMapping(value = "delete/{id}")
    @ResponseBody
    void deleteUser(@PathVariable String id);

    /**
     * 根据id查询user
     * @param id
     * @return
     */
    @PostMapping(value = "query/{id}")
    @ResponseBody
    Users queryUser(@PathVariable String id);

    /**
     * 根据id查询user身份
     * @param id
     * @return
     */
    @PostMapping(value = "queryIdentity/{id}")
    @ResponseBody
    String queryIdentity(@PathVariable String id);
}
