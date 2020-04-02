package com.how2java.tmall.comparator;

import com.how2java.tmall.pojo.Product;

import java.util.Comparator;

/**
 * @author: mingjian
 * @create: 2020-03-15 15:32
 * 人气比较器
 * 把 评价数量多的放前面
 */
public class productReviewComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getReviewCount() - o1.getReviewCount();
    }
}
