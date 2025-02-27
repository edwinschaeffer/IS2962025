package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import config.DemoConfig;


public class Is296DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfig.class, args);
	}

}
