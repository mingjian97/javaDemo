package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-03-20 19:05
 */
public interface IUserService {

    List<User> findAll();

    User findById(Integer userId);

    void updateUser(User user);
}
