package com.example;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @author: mingjian
 * @create: 2020-05-01 17:02
 */
public class Test2 {
    /**
     * 匹配查询
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //1.连接rest接口
        HttpHost http=new HttpHost("127.0.0.1",9200,"http");
        RestClientBuilder builder= RestClient.builder(http);//rest构建器
        RestHighLevelClient restHighLevelClient=new RestHighLevelClient(builder);//高级客户端对象

        //2.封装查询请求
        SearchRequest searchRequest=new SearchRequest("sku");
        searchRequest.types("doc"); //设置查询的类型
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        MatchQueryBuilder matchQueryBuilder= QueryBuilders.matchQuery("categoryName","手机");
        searchSourceBuilder.query(matchQueryBuilder);
        searchRequest.source(searchSourceBuilder);

        //3.获取查询结果
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits searchHits = searchResponse.getHits();
        long totalHits = searchHits.getTotalHits();
        System.out.println("记录数："+totalHits);
        SearchHit[] hits = searchHits.getHits();
        for(SearchHit hit:hits){
            String source = hit.getSourceAsString();
            System.out.println(source);
        }

        restHighLevelClient.close();
    }
}
