package com.example.springsecuritydemo3mybatisredis.common.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * @author: mingjian
 * @create: 2020-04-05 19:57
 * 集合工具类
 * 因为生成token加入ip验证，所以需要这
 */
public class CollectionUtil {

    /**
     * @param map 取值的集合
     * @param key 所想取值的集合的key
     * @return 返回key对应的value
     */
    public static String getMapValue(Map<String,Object> map, String key){
        String result = null;
        if(map != null){
            Iterator<String> iterable = map.keySet().iterator();
            while (iterable.hasNext()){
                Object object = iterable.next();
                if(key.equals(object))
                    if(map.get(object) != null)
                        result = map.get(object).toString();
            }
        }

        return result;
    }

}
