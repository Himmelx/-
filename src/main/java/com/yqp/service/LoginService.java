package com.yqp.service;

import com.yqp.domain.User;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    /**
     * 登录
     * @param user
     * @param request
     * @return
     */
    User loginIn(User user, HttpServletRequest request);

    /**
     * 退出登录
     * @param request
     */
    void loginOut(HttpServletRequest request);


}
