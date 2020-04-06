package com.example.springsecuritydemo3mybatisredis.common.security;

import com.alibaba.fastjson.JSON;
import com.example.springsecuritydemo3mybatisredis.common.VO.ResultVO;
import com.example.springsecuritydemo3mybatisredis.common.enums.ResultEnum;
import com.example.springsecuritydemo3mybatisredis.common.utils.AccessAddressUtil;
import com.example.springsecuritydemo3mybatisredis.common.utils.JwtTokenUtil;
import com.example.springsecuritydemo3mybatisredis.common.utils.RedisUtil;
import com.example.springsecuritydemo3mybatisredis.entity.SelfUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: mingjian
 * @create: 2020-04-04 21:47
 * 用户登录成功时返回给前端的数据
 */

@Component
@Slf4j
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Value("${token.expirationSeconds}")
    private int expirationSeconds;

    @Value("${token.validTime}")
    private int validTime;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        SelfUserDetails userDetails=(SelfUserDetails) authentication.getPrincipal();
//        String jwtToken= JwtTokenUtil.generateToken(userDetails.getUsername(),1500);
//        response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_SUCCESS,jwtToken,true)));
//

        //获取请求的ip地址
        String ip = AccessAddressUtil.getIpAddress(request);
        Map<String,Object> map = new HashMap<>();
        map.put("ip",ip);
        SelfUserDetails userDetails = (SelfUserDetails) authentication.getPrincipal();
        String jwtToken = JwtTokenUtil.generateToken(userDetails.getUsername(), expirationSeconds, map);
        //刷新时间
        Integer expire = validTime*24*60*60*1000;
        //获取请求的ip地址
        String currentIp = AccessAddressUtil.getIpAddress(request);
        redisUtil.setTokenRefresh(jwtToken,userDetails.getUsername(),currentIp);
        log.info("用户{}登录成功，信息已保存至redis",userDetails.getUsername());

        response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_SUCCESS,jwtToken,true)));

    }
}
