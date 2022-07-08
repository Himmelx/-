package com.yqp.controller;

import com.yqp.common.ResponseJson;
import com.yqp.domain.Log;
import com.yqp.domain.Page;
import com.yqp.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000812:32
 * @Description TODO
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Resource
    private LogService logService;

    @GetMapping("/list")
    @ResponseBody
    public String getLogList(Page page, Model model){
        List<Log> list = logService.getList(page);
        model.addAttribute("list",list);
        return "logs";
    }


}
