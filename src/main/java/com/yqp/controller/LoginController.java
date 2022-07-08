package com.yqp.controller;

import com.yqp.common.ResponseJson;
import com.yqp.common.Utils;
import com.yqp.domain.User;
import com.yqp.service.CountService;
import com.yqp.service.LogService;
import com.yqp.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Resource
    private LogService logService;

    @PostMapping("/loginIn")
    public String loginIn(User user, HttpServletRequest request, Model model){
        User user1 = loginService.loginIn(user, request);
        Integer currentNum = logService.getCurrentNum();

        if (Utils.isEmpty(user1)){
            model.addAttribute("text","用户名或密码错误！");
            return "index";
        }else {
            //登录成功将用户数据存进session
            Utils.setSession(request,"username",user1.getUsername());
            Utils.setSession(request,"token",user1.getToken());
            model.addAttribute("text","登录成功！");
            model.addAttribute("user",user1);
            model.addAttribute("count",currentNum);
            return "redirect:/count/getNumber";
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request, Model model){
        loginService.loginOut(request);
        return "index";
    }
}
