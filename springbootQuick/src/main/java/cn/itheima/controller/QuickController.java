package cn.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: mingjian
 * @create: 2020-03-19 21:55
 */
@Controller
public class QuickController {

    @RequestMapping("/")
    @ResponseBody
    public String quick() {
        return "hello springboot";
    }
}
