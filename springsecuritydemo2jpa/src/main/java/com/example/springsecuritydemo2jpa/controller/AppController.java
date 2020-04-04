package com.example.springsecuritydemo2jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: mingjian
 * @create: 2020-04-03 22:38
 */
@Controller
public class AppController {
    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello ,spring security!";
    }
}
