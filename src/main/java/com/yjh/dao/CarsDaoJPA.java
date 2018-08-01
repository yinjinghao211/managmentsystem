package com.yjh.dao;

import com.yjh.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarsDaoJPA extends JpaRepository<Cars,String>{
}
