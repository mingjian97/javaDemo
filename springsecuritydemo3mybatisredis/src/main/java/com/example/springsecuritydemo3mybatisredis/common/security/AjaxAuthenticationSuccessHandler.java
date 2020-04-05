package com.example.springsecuritydemo3mybatisredis.common.security;

import com.alibaba.fastjson.JSON;
import com.example.springsecuritydemo3mybatisredis.common.VO.ResultVO;
import com.example.springsecuritydemo3mybatisredis.common.enums.ResultEnum;
import com.example.springsecuritydemo3mybatisredis.common.utils.JwtTokenUtil;
import com.example.springsecuritydemo3mybatisredis.entity.SelfUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: mingjian
 * @create: 2020-04-04 21:47
 * 用户登录成功时返回给前端的数据
 */

@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SelfUserDetails userDetails=(SelfUserDetails) authentication.getPrincipal();
        String jwtToken= JwtTokenUtil.generateToken(userDetails.getUsername(),1500);
        response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_SUCCESS,jwtToken,true)));

    }
}
