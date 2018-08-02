package com.yjh.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersServiceTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StringRedisTemplate template;
    /**
     * 测试完成，接下来测试字段就可以
     */
    public void createUsers(){
        System.out.println("createuser");
        try{
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            System.out.println("=============================="+uuid);
            jdbcTemplate.update("INSERT INTO users VALUES('"+uuid+"','张2三','23','1042382584@qq.com','13229728120','239293975791083','10299329','23171467');");
        }catch (Exception e){
            System.out.println("创建失败");
        }
    }
}
