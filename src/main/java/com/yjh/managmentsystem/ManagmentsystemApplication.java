package com.yjh.managmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.yjh.controller","com.yjh.service"})
@EnableJpaRepositories("com.yjh.dao")
@EntityScan("com.yjh.entity")
@EnableAutoConfiguration
@EnableCaching//开启注解
public class ManagmentsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagmentsystemApplication.class, args);
	}
}
