package com.example.springsecuritydemo3mybatisredis.service;

import com.example.springsecuritydemo3mybatisredis.entity.DemoEntity;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-04-04 18:58
 */

public interface DemoService {

    List<DemoEntity> getUser();
}
