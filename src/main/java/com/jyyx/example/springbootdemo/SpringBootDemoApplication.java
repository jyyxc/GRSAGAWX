package com.jyyx.example.springbootdemo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
//import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.slf4j.Logger;

@SpringBootApplication
@MapperScan(value="com.jyyx.example.springbootdemo.mapper")
public class SpringBootDemoApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
//		System.out.println("启动成功");
		logger.info("启动成功");
	}
}
