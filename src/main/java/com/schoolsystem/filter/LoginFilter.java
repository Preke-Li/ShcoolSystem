package com.schoolsystem.filter;


import com.alibaba.fastjson.JSONObject;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Slf4j
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

        //1.获取请求url，以便判断请求路径中有么有login路径
        String url=request.getRequestURI().toString();
        log.info("获取到的url为：{}",url);

        //2. 判断请求url是否包含login，如果包含，说明是登录操作，放行，不拦截
        if(url.contains("login")){
            log.info("是登录操作，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //3. 不是登录操作，就要先判断是否有token令牌
        String token=request.getHeader("token");
        log.info("获取到的token为：{}",token);

        //4. 判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if(!StringUtils.hasLength(token)){
            log.info("token不存在");

            Result responseResult = Result.error(-1,"NOT_LOGIN");
            //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
            String json= JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            //响应
            response.getWriter().write(json);

            return;
        }

        //5.解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(token);
        }catch (Exception e){
            log.info("令牌解析失败!");

            Result responseResult = Result.error(-1,"NOT_LOGIN");
            //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            //响应
            response.getWriter().write(json);

            return;
        }

        //6.放行
        filterChain.doFilter(request,response);

    }
}
