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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String getLogList(Page page, Model model){
        List<Log> list = logService.getList(page);

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("message","");
        map.put("count",logService.getCount());
        map.put("data",list);
        model.addAttribute("list",list);
        return "logs";
    }


}
