package com.how2java.tmall.comparator;

import com.how2java.tmall.pojo.Product;

import java.util.Comparator;

/**
 * @author: mingjian
 * @create: 2020-03-15 15:35
 * 新品比较器
 * 把 创建日期晚的放前面
 */
public class ProductDateComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getCreateDate().compareTo(o2.getCreateDate());
    }
}
