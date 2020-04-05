package com.example.springsecuritydemo3mybatisredis.common.security;

import com.alibaba.fastjson.JSON;
import com.example.springsecuritydemo3mybatisredis.common.VO.ResultVO;
import com.example.springsecuritydemo3mybatisredis.common.enums.ResultEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: mingjian
 * @create: 2020-04-04 21:39
 * 用户未登录时返回给前端的数据
 */

@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_NEED_AUTHORITIES,false)));
    }
}
