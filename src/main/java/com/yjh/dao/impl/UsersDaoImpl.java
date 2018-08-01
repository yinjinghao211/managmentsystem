package com.yjh.dao.impl;

import com.yjh.dao.UsersDao;
import com.yjh.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class UsersDaoImpl implements UsersDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Users getOne(String user_name) {
        String sql = "select * from users where user_name = ?";
        Users user= jdbcTemplate.queryForObject(sql,new MyRowMapper(),user_name);
        return user;
    }
}
