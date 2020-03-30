package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.UserMapper;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.pojo.UserExample;
import com.how2java.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-03-13 19:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void add(User c) {
        userMapper.insert(c);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(User c) {
        userMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public User get(int id) {
        User user =userMapper.selectByPrimaryKey(id);
        String name=user.getName();
        if(name.length()<=1)
            user.setAnoymousName("*");
        else if(name.length()<=2)
            user.setAnoymousName(name.substring(0,1)+"*");
        else{
            StringBuffer sb=new StringBuffer();
            sb.append(name.charAt(0));
            for(int i=1;i<name.length()-1;i++)
                sb.append("*");
            sb.append(name.charAt(name.length()-1));
            user.setAnoymousName(sb.toString());
        }
        return user;
    }

    @Override
    public List list() {
        UserExample example=new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }

    @Override
    public boolean isExist(String name) {
        UserExample example=new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> res=userMapper.selectByExample(example);
        if(!res.isEmpty())
            return true;
        return false;
    }

    @Override
    public User get(String name, String password) {
        UserExample example=new UserExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        List<User> result=userMapper.selectByExample(example);
        if(result.isEmpty())
            return null;
        return result.get(0);
    }
}
