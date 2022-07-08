package com.yqp.service.impl;

import com.yqp.common.Utils;
import com.yqp.domain.User;
import com.yqp.mapper.UserMapper;
import com.yqp.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000810:41
 * @Description TODO
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User loginIn(User user, HttpServletRequest request) {
        User user1 = userMapper.loginIn(user.getUsername(), user.getPassword());
        return user1;
    }

    @Override
    public void loginOut(HttpServletRequest request){
        Utils.clearSession(request);
    }
}
