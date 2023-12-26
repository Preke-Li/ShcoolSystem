package com.schoolsystem.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    //目标资源方法（controller）运行前运行,返回true,放行；返回flase, 不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle.................");

        //1.获取请求url，以便判断请求路径中有么有login路径
        String url=request.getRequestURI().toString();
        log.info("获取到的url为：{}",url);

        //2. 判断请求url是否包含login，如果包含，说明是登录操作，放行，不拦截
        if(url.contains("login")){
            log.info("是登录操作，放行");
            return true;
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

            return false;
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

            return false;
        }

        return true;
    }

    //目标资源方法（controller）运行后 运行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle........");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //视图渲染完毕后运行，最后运行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion..............");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
