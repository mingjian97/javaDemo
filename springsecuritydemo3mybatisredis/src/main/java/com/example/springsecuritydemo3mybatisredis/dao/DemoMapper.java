package com.example.springsecuritydemo3mybatisredis.dao;

import com.example.springsecuritydemo3mybatisredis.entity.DemoEntity;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-04-04 18:59
 */

public interface DemoMapper {
    List<DemoEntity> getUser();
}