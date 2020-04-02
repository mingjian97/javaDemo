package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Property;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-03-12 22:20
 */
public interface PropertyService {
    void add(Property p);

    void delete(int id);

    void update(Property p);

    Property get(int id);

    List list(int cid);
}
