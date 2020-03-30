package com.how2java.tmall.comparator;

import com.how2java.tmall.pojo.Product;

import java.util.Comparator;

/**
 * @author: mingjian
 * @create: 2020-03-15 15:37
 */
public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int)(o1.getPromotePrice()-o2.getPromotePrice());
    }
}
