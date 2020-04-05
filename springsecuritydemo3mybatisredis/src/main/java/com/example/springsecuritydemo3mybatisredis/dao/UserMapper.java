package com.example.springsecuritydemo3mybatisredis.dao;

import com.example.springsecuritydemo3mybatisredis.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author: mingjian
 * @create: 2020-04-04 22:28
 */

@Component
public interface UserMapper {

    //通过username查询用户
    UserEntity getUser(@Param("username") String username);

}