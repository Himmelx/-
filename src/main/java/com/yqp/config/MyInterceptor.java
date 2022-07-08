package com.yqp.config;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000814:55
 * @Description TODO
 */
import com.yqp.common.Utils;
import com.yqp.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义拦截器:在方法执行前后添加与业务无关的功能
@Component//交给spring管理bean的ioc di
public class MyInterceptor implements HandlerInterceptor{

    @Resource
    private UserMapper userMapper;

    @Override //在方法执行前调用此处一般用于sso获取token。并验证如果存在则true，不存在重新登陆
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = Utils.getSession(request, "token");
        if (Utils.isEmpty(token)){
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
        Integer integer = userMapper.checkToken(token);
        if (Utils.notEmpty(integer) && integer > 0){
            return true;
        }else {
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
    }
    @Override //在方法执行后调用
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override //都完成后调用
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}

