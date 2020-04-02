package com.example.mall.service;

import com.example.mall.common.api.CommonResult;

/**
 * @author: mingjian
 * @create: 2020-04-02 14:15
 * 会员管理service
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
