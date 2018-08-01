package com.yjh.controller.test;

import com.yjh.dao.UsersDao;
import com.yjh.dao.UsersDaoJPA;
import com.yjh.entity.Users;
import com.yjh.service.UsersServiceTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserControllerTest {
    @Autowired
    private UsersDaoJPA usersDaoJPA;
    @Autowired
    private UsersServiceTest usersServiceTest;
    @Autowired
    private StringRedisTemplate template;
    private UsersDao usersDao;
    //使用jpa
    @RequestMapping("/getUsers")
    public String getUsers(){
        //输入uuid即可
        Users users =usersDaoJPA.findOne("b3f28489e8874a51b944ecbe90906e3e");
        return users.getUserName();
    }
    @RequestMapping("/getUsersByName")
    public Users getUserByName(){
        Users users =usersDao.getOne("张2三");
        return users;
    }
    @RequestMapping("/createUser")
    public void createUsers(){
        usersServiceTest.createUsers();
    }
    @RequestMapping("/setkeytoredis")
    public void setKey(){
        try {
            ValueOperations<String, String> ops = template.opsForValue();
            //ops.setBit()可以用偏移量做一个停车场签到系统
            ops.set("asdasda","afsdsds");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
