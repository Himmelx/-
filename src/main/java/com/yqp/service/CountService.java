package com.yqp.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000814:36
 * @Description TODO
 */
public interface CountService {

    int addOrReduOne(String message, String type, HttpServletRequest request);



}
