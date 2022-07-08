package com.yqp.controller;

import com.yqp.common.Utils;
import com.yqp.service.CountService;
import com.yqp.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000814:29
 * @Description TODO
 */
@Controller
@RequestMapping("/count")
public class CountController {

    @Resource
    private LogService logService;

    @Resource
    private CountService countService;


    @GetMapping("/getNumber")
    public String getNumber(Model model,HttpServletRequest request){
        String username = Utils.getSession(request, "username");
        Integer currentNum = logService.getCurrentNum();
        model.addAttribute("count",currentNum);
        model.addAttribute("username",username);
        return "count";
    }

    @PostMapping("/addOrReduOne")
    public String addOrReduOne(String message, String type, HttpServletRequest request){
        countService.addOrReduOne(message, type, request);
        return "count";
    }



}
