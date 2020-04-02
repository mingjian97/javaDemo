package com.example.malllearn.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: mingjian
 * @create: 2020-04-01 19:35
 */
@Configuration
@MapperScan("com.example.malllearn.mbg.mapper")
public class MyBatisConfig {
}
