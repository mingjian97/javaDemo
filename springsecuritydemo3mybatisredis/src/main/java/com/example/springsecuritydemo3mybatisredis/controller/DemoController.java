package com.example.springsecuritydemo3mybatisredis.controller;

import com.example.springsecuritydemo3mybatisredis.entity.DemoEntity;
import com.example.springsecuritydemo3mybatisredis.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-04-04 18:57
 */

@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private DemoService orderService;

    @RequestMapping("/getUser")
    @ResponseBody
    public List<DemoEntity> getUser(){
        List<DemoEntity> result = orderService.getUser();
        return result;
    }
}