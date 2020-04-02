package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.OrderMapper;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderExample;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-03-13 21:17
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;

    @Override
    public float add(Order c, List<OrderItem> ois) {
        float total = 0;
        add(c);
        if (false)
            throw new RuntimeException();

        for (OrderItem oi : ois) {
            oi.setOid(c.getId());
            orderItemService.update(oi);
            total += oi.getProduct().getPromotePrice() * oi.getNumber();
        }
        return total;
    }

    @Override
    public void add(Order c) {
        orderMapper.insert(c);
    }

    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Order c) {
        orderMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public Order get(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List list() {
        OrderExample example = new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> result = orderMapper.selectByExample(example);
        setUser(result);
        return result;
    }

    @Override
    public List list(int uid, String excludeStatus) {
        OrderExample example = new OrderExample();
        example.createCriteria().andUidEqualTo(uid).andStatusNotEqualTo(excludeStatus);
        example.setOrderByClause("id desc");
        return orderMapper.selectByExample(example);
    }

    public void setUser(Order o) {
        User user = userService.get(o.getUid());
        o.setUser(user);
    }

    public void setUser(List<Order> os) {
        for (Order o : os)
            setUser(o);
    }

}
