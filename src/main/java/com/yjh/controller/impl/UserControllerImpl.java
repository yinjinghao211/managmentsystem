package com.yjh.controller.impl;

import com.yjh.controller.UserController;
import com.yjh.entity.Users;
import com.yjh.resource.request.UsersTemplateRequest;
import com.yjh.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 此类用来实现与Users类相关的功能
 */
@RestController
public class UserControllerImpl implements UserController{

    @Autowired
    private UsersService usersService;

    /**
     *添加user
     */
    @ResponseBody
    @Override
    public int addUsers(@RequestBody UsersTemplateRequest usersTemplateRequest){
        int i = usersService.addUsers(usersTemplateRequest);
        return i;
    }

    @ResponseBody
    @Override
    public int updateUser(@PathVariable String id, @RequestBody UsersTemplateRequest usersTemplateRequest){
        int i = usersService.updateUser(id,usersTemplateRequest);
        return i;
    }
    @ResponseBody
    @Override
    public void deleteUser(@PathVariable String id){
      usersService.deleteUser(id);
    }

    @ResponseBody
    @Override
    public Users queryUser(@PathVariable String id) {
        return usersService.queryUser(id);
    }

    @Override
    public String queryIdentity(@PathVariable String id) {
        return usersService.queryUserIdentity(id);
    }
}
