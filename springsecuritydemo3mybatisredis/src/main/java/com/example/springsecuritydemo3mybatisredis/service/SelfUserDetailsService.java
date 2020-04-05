package com.example.springsecuritydemo3mybatisredis.service;

import com.example.springsecuritydemo3mybatisredis.dao.UserMapper;
import com.example.springsecuritydemo3mybatisredis.entity.SelfUserDetails;
import com.example.springsecuritydemo3mybatisredis.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: mingjian
 * @create: 2020-04-04 22:26
 * 继承UserDetailsService，用户认证的业务代码
 */
@Component
public class SelfUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //通过username查询用户
        UserEntity user = userMapper.getUser(username);
        if(user == null){
            //仍需要细化处理
            throw new UsernameNotFoundException("该用户不存在");
        }

        Set authoritiesSet = new HashSet();
        // 模拟从数据库中获取用户角色
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        authoritiesSet.add(authority);

        return new SelfUserDetails(user.getId(),user.getLogin(),user.getPassword(),authoritiesSet);
    }
}
