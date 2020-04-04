package com.example.springsecuritydemo2jpa.repository;

import com.example.springsecuritydemo2jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mingjian
 * @create: 2020-04-04 11:55
 */
public interface UserRepository extends JpaRepository<User,Integer> {
     User findOneByLogin(String login);
}
