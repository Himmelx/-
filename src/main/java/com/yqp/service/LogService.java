package com.yqp.service;

import com.yqp.domain.Log;
import com.yqp.domain.Page;

import java.util.List;


public interface LogService {

    /**
     * 添加一条日志
     * @param log
     * @return
     */
    int add(Log log);

    /**
     * 列表查询
     * @return
     */
    List<Log> getList(Page page);

    /**
     * 获取当前次数
     * @return
     */
    int getCurrentNum();
}
