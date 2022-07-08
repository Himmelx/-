package com.yqp.service.impl;

import com.yqp.common.Utils;
import com.yqp.domain.Log;
import com.yqp.service.CountService;
import com.yqp.service.LogService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000814:37
 * @Description TODO
 */
public class CountServiceImpl implements CountService {

    @Resource
    private LogService logService;

    @Override
    public int addOrReduOne(String message,String type, HttpServletRequest request) {
        String username = Utils.getSession(request, "username");//获取当前用户名
        Log log = new Log();
        log.setCreateTime(new Date());
        log.setNote(message);
        log.setType(type);
        log.setOperationUser(username);
        return logService.add(log);
    }



}
