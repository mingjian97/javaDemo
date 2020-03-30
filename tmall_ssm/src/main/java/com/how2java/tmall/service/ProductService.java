package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-03-13 12:19
 */

public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    void setFirstProductImage(Product p);
    void fill(List<Category> cs);
    void fill(Category c);//填充category对象中的products
    void fillByRow(List<Category> cs);
    void setSaleAndReviewNumber(Product p);
    void setSaleAndReviewNumber(List<Product> ps);
    List<Product> search(String keyword);
}
