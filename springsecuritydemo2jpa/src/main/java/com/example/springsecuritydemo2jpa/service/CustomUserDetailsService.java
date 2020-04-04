package com.example.springsecuritydemo2jpa.service;

import com.example.springsecuritydemo2jpa.entity.User;
import com.example.springsecuritydemo2jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: mingjian
 * @create: 2020-04-04 11:35
 */
@Component("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // 1. 查询用户
        User userFromDatabase = userRepository.findOneByLogin(login);
        if (userFromDatabase == null) {
            //log.warn("User: {} not found", login);
            throw new UsernameNotFoundException("User " + login + " was not found in db");
            //这里找不到必须抛异常
        }
        // 2. 设置角色
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userFromDatabase.getRole());
        grantedAuthorities.add(grantedAuthority);
        org.springframework.security.core.userdetails.User user=new org.springframework.security.core.userdetails.User(login,
                userFromDatabase.getPassword(), grantedAuthorities);
        return user;
    }
}