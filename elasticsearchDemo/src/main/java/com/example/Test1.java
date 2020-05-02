package com.example;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: mingjian
 * @create: 2020-05-01 16:41
 */
public class Test1 {
    /**
     * 新增数据
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //1 连接rest接口
        HttpHost http=new HttpHost("127.0.0.1",9200,"http");
        RestClientBuilder restClientBuilder= RestClient.builder(http);//rest构建器
        RestHighLevelClient restHighLevelClient=new RestHighLevelClient(restClientBuilder);//高级客户端对象

        //2 封装请求对象
        BulkRequest bulkRequest=new BulkRequest();
        IndexRequest indexRequest=new IndexRequest("sku","doc","5");
        Map skuMap =new HashMap();
        skuMap.put("name","小米10");
        skuMap.put("brandName","小米");
        skuMap.put("categoryName","手机");
        skuMap.put("price",1010441);
        skuMap.put("createTime","2019‐05‐01");
        skuMap.put("saleNum",101021);
        skuMap.put("commentNum",10102321);
        Map spec=new HashMap();
        spec.put("网络制式","移动4G");
        spec.put("屏幕尺寸","5");
        skuMap.put("spec",spec);
        indexRequest.source(skuMap);
        bulkRequest.add(indexRequest);

        //3 获取执行结果
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        int status=bulkResponse.status().getStatus();
        System.out.println(status);

        restHighLevelClient.close();

    }
}
