package com.yjh.dao.impl;


import com.yjh.entity.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        String name = resultSet.getString("user_name");
        String phone = resultSet.getString("user_phone");
        String age = resultSet.getString("user_age");
        return new Users(name,phone,age);
    }
}
