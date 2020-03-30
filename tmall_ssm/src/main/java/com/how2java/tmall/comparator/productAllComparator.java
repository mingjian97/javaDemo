package com.how2java.tmall.comparator;

import com.how2java.tmall.pojo.Product;

import java.util.Comparator;

/**
 * @author: mingjian
 * @create: 2020-03-15 15:29
 * 综合比较器，把 销量x评价 高的放前面
 */
public class productAllComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getSaleCount()*o2.getReviewCount()-o1.getReviewCount()*o1.getSaleCount();
    }
}
