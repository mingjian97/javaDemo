package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-03-20 19:01
 */
public interface IUserDao {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id=#{userId}")
    User findById(Integer userId);

    @Update("update user set username=#{username},password=#{password},age=#{age},sex=#{sex},email=#{email} where id=#{id}")
    void updateUser(User user);
}
