package com.example.springboot_mongo_login.controller;

import com.example.springboot_mongo_login.entity.User;
import com.example.springboot_mongo_login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: mingjian
 * @create: 2020-03-24 18:45
 */
@Controller
@RequestMapping("/index")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        User user=(User) request.getAttribute("user");
        if(null==user){
            user=new User("##errors##","1234");
            model.addAttribute("user",user);
        }
        return "index";
    }

    @RequestMapping("/openLoginPage")
    public String openLoginPage(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        User user=userRepository.findByUsername(username);
        if(null!=user){
            if(user.getPassword().equals(password)){
                request.setAttribute("user",user);
                return "index";
            }else{
                System.out.println("密码错误");
                return "ferror";
            }
        }else{
            System.out.println("用户不存在");
            return "ferror";
        }
    }

    @RequestMapping("/openRegisterPage")
    public String openRegisterPage(){
        return "register";
    }

    @RequestMapping("register")
    public String register(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user = userRepository.findByUsername(username);
        if(null!=user){
            return "ferror";
        }

        user=new User(username,password);
        userRepository.save(user);
        request.setAttribute("user",user);
        return "index";
    }

}
