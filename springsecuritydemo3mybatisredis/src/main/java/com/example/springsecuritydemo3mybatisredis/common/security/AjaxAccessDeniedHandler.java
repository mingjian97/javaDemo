package com.example.springsecuritydemo3mybatisredis.common.security;

import com.alibaba.fastjson.JSON;
import com.example.springsecuritydemo3mybatisredis.common.VO.ResultVO;
import com.example.springsecuritydemo3mybatisredis.common.enums.ResultEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: mingjian
 * @create: 2020-04-04 21:44
 * 处理无权访问
 */

@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_NO_ACCESS,false)));
    }
}
