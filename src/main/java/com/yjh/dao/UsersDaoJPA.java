package com.yjh.dao;

import com.yjh.entity.Users;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersDaoJPA extends JpaRepository<Users, String>{
}
