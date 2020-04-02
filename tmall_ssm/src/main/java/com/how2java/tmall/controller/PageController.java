package com.how2java.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: mingjian
 * @create: 2020-03-14 19:27
 * WEB-INF目录下的资源无法通过浏览器直接访问,故使用该controller 用于服务端跳转
 */
@Controller
@RequestMapping("")
public class PageController {
    @RequestMapping("registerPage")
    public String registerPage() {
        return "fore/register";
    }

    @RequestMapping("registerSuccess")
    public String registerSuccessPage() {
        return "fore/registerSuccess";
    }

    @RequestMapping("loginPage")
    public String loginPage() {
        return "fore/login";
    }

    @RequestMapping("forealipay")
    public String alipay() {
        return "fore/alipay";
    }

}
