package com.example.mall.service.impl;

import com.example.mall.common.api.CommonResult;
import com.example.mall.service.RedisService;
import com.example.mall.service.UmsMemberService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author: mingjian
 * @create: 2020-04-02 14:16
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    /*
    * 生成验证码时，将自定义的Redis键值加上手机号生成一个Redis的key,以验证码为value存入到Redis中，
    * 并设置过期时间为自己配置的时间（这里为120s）。
    * 校验验证码时根据手机号码来获取Redis里面存储的验证码，并与传入的验证码进行比对。
    * */

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb=new StringBuilder();
        Random random=new Random();
        for(int i=0;i<6;i++)
            sb.append(random.nextInt(10));
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(),"获取验证码成功");
    }

    //对输入的验证码进行校验
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if(StringUtils.isNullOrEmpty(authCode))
            return CommonResult.failed("请输入验证码");
        String realAuthCode=redisService.get(REDIS_KEY_PREFIX_AUTH_CODE+telephone);
        boolean result=authCode.equals(realAuthCode);
        if(result)
            return CommonResult.success(null,"验证码校验成功");
        else
            return CommonResult.failed("验证码错误");
    }
}
