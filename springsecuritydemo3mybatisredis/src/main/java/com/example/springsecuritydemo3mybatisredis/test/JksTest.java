package com.example.springsecuritydemo3mybatisredis.test;

import org.junit.Test;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author: mingjian
 * @create: 2020-04-04 23:14
 */
public class JksTest {
    @Test
    public void run(){
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.jks"); // 寻找证书文件
        PrivateKey privateKey = null;
        PublicKey publicKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS"); // java key store 固定常量
            keyStore.load(inputStream, "123456".toCharArray());
            privateKey = (PrivateKey) keyStore.getKey("jwt", "123456".toCharArray()); // jwt 为 命令生成整数文件时的别名
            publicKey = keyStore.getCertificate("jwt").getPublicKey();
            System.out.println(privateKey);
            System.out.println(publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
