package cn.itheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mingjian
 * @create: 2020-03-19 23:22
 */
@RestController
public class QuickController {

    @RequestMapping("/quick2")
    public String quick(){
        return "hehe springboot";
    }
}
