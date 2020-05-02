package com.example;

import com.alibaba.fastjson.JSON;
import com.example.dao.SkuMapper;
import com.example.domain.Sku;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-05-01 19:34
 * 将数据库中sku导入到elasticsearch
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:*.xml")
public class Main {
    @Autowired
    private SkuMapper skuMapper;

    @Test
    public void test() throws IOException {
        //1 从数据库中将所有的sku信息查出来

        List<Sku> skus = skuMapper.selectAll();

        //2 将sku插入到elasticsearch中
        HttpHost http=new HttpHost("127.0.0.1",9200,"http");
        RestClientBuilder restClientBuilder = RestClient.builder(http).setMaxRetryTimeoutMillis(5*60*1000);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClientBuilder);//高级客户端对象

        BulkRequest bulkRequest = new BulkRequest();    //批量操作

        for(Sku sku:skus){
            IndexRequest indexRequest = new IndexRequest("sku", "doc", sku.getId());
            HashMap hashmap=new HashMap();
            hashmap.put("name",sku.getName());
            hashmap.put("price", sku.getPrice());
            hashmap.put("image", sku.getImage());
            hashmap.put("createTime", sku.getCreateTime());
            hashmap.put("spuId", sku.getSpuId());
            hashmap.put("categoryName", sku.getCategoryName());
            hashmap.put("brandName", sku.getBrandName());
            hashmap.put("spec", JSON.parseObject(sku.getSpec()));
            hashmap.put("saleNum", sku.getSaleNum());
            hashmap.put("commentNum", sku.getCommentNum());

            indexRequest.source(hashmap);
            bulkRequest.add(indexRequest);
        }
        restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        restHighLevelClient.close();
        System.out.println("导入成功");
    }
}
