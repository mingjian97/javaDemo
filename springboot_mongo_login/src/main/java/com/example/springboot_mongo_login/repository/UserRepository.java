package com.example.springboot_mongo_login.repository;

import com.example.springboot_mongo_login.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: mingjian
 * @create: 2020-03-24 18:44
 */
public interface UserRepository extends MongoRepository<User,String> {

    public User findByUsername(String username);
}
