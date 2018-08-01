package com.yjh.service.impl;

import com.yjh.dao.CarsDaoJPA;
import com.yjh.dao.UsersDaoJPA;
import com.yjh.entity.Cars;
import com.yjh.entity.Users;
import com.yjh.resource.request.UsersTemplateRequest;
import com.yjh.service.UsersService;
import com.yjh.utils.CheckUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersDaoJPA usersDaoJPA;
    @Autowired
    private CarsDaoJPA carsDaoJPA;

    public int addUsers(UsersTemplateRequest usersTemplateRequest){
        CheckUtil.checkArgument(usersTemplateRequest!=null);
        Users users = new Users();
        users.setUserId(UUID.randomUUID().toString().replaceAll("-",""));
//        users.setUserAge(usersTemplateRequest.getUserAge());
//        users.setUserEmail(usersTemplateRequest.getUserEmail());
//        users.setUserIdCard(usersTemplateRequest.getUserIdCard());
//        users.setUserName(usersTemplateRequest.getUserName());
//        users.setUserPhone(usersTemplateRequest.getUserPhone());
//        users.setUserQQ(usersTemplateRequest.getUserQQ());
//        users.setUserWeChat(usersTemplateRequest.getUserWeChat());
        BeanUtils.copyProperties(usersTemplateRequest,users);
        try {
            Users users1 =usersDaoJPA.saveAndFlush(users);
            if(users1!=null){
                return 1;
            }
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
        }
        return 0;
    }

    @Override
    public void deleteUser(String id) {
        CheckUtil.checkArgument(id != null);
        usersDaoJPA.delete(id);
    }

    @Override
    public int updateUser(String id, UsersTemplateRequest usersTemplateRequest) {
        CheckUtil.checkArgument(usersTemplateRequest!=null);
        CheckUtil.checkArgument(id!=null);
        Users users=usersDaoJPA.findOne(id);
        BeanUtils.copyProperties(usersTemplateRequest,users);
        return 1;
    }

    @Override
    public Users queryUser(String id) {
        CheckUtil.checkArgument(id!=null);
        return usersDaoJPA.findOne(id);
    }

    @Override
    public String queryUserIdentity(String id) {
        CheckUtil.checkArgument((id!=null));
        Cars cars = carsDaoJPA.findOne(id);
        return cars.getCarType();
    }
}
