package com.how2java.tmall.comparator;

import com.how2java.tmall.pojo.Product;

import java.util.Comparator;

/**
 * @author: mingjian
 * @create: 2020-03-15 15:36
 * 销量比较器
 * 把 销量高的放前面
 */
public class ProductSaleCountComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getSaleCount()-o1.getSaleCount();
    }
}
