package com.example.springsecuritydemo3mybatisredis.common.security;

import com.alibaba.fastjson.JSON;
import com.example.springsecuritydemo3mybatisredis.common.VO.ResultVO;
import com.example.springsecuritydemo3mybatisredis.common.enums.ResultEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: mingjian
 * @create: 2020-04-04 21:45
 * 用户登录失败时返回给前端的数据
 */

@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_FAILED,false)));
    }
}
