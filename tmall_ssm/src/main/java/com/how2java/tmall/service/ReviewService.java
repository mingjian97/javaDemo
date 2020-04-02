package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Review;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-03-15 8:57
 */
public interface ReviewService {
    void add(Review c);

    void delete(int id);

    void update(Review c);

    Review get(int id);

    List list(int pid);

    int getCount(int pid);

}
