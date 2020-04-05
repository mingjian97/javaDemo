package com.example.springsecuritydemo3mybatisredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.Springsecuritydemo3mybatisredis.dao")
public class Springsecuritydemo3mybatisredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springsecuritydemo3mybatisredisApplication.class, args);
    }

}
