package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-03-20 20:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testFindAll(){
        List<User> users=userService.findAll();
        System.out.println(users);
    }

    @Test
    public void testFindOne(){
        User user=userService.findById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user=userService.findById(1);
        System.out.println(user);
        user.setAge(55);
        userService.updateUser(user);
        user=userService.findById(1);
        System.out.println(user);
    }
}
