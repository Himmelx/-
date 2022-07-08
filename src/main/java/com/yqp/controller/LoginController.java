package com.yqp.controller;

import com.yqp.common.ResponseJson;
import com.yqp.domain.User;
import com.yqp.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000810:14
 * @Description TODO
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/loginIn")
    @ResponseBody
    public ResponseJson loginIn(User user, HttpServletRequest request){
        return new ResponseJson(loginService.loginIn(user,request));
    }

    @GetMapping("/loginOut")
    @ResponseBody
    public void loginOut(HttpServletRequest request){
        loginService.loginOut(request);
    }
}
