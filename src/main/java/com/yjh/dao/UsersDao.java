package com.yjh.dao;

import com.yjh.entity.Users;


public interface UsersDao {
    Users getOne(String user_name);
}
