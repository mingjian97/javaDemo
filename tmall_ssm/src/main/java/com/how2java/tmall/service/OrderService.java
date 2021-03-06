package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-03-13 21:14
 */
public interface OrderService {
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    float add(Order c, List<OrderItem> ois);

    void add(Order c);

    void delete(int id);

    void update(Order c);

    Order get(int id);

    List list();

    List list(int uid, String excludeStatus);
}
