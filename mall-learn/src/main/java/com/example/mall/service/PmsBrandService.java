package com.example.mall.service;

import com.example.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-04-01 19:40
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
