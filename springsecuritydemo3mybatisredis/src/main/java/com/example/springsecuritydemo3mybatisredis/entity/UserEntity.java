package com.example.springsecuritydemo3mybatisredis.entity;

import lombok.Data;

/**
 * @author: mingjian
 * @create: 2020-04-04 11:30
 */
@Data
public class UserEntity implements java.io.Serializable{

    private Integer id;

    private String login;

    private String password;

    private String role;

}