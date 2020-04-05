package com.example.springsecuritydemo3mybatisredis.service.impl;

import com.example.springsecuritydemo3mybatisredis.dao.DemoMapper;
import com.example.springsecuritydemo3mybatisredis.entity.DemoEntity;
import com.example.springsecuritydemo3mybatisredis.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-04-04 18:58
 */

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<DemoEntity> getUser() {
        return demoMapper.getUser();
    }
}
