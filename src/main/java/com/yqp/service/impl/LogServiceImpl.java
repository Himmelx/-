package com.yqp.service.impl;

import com.yqp.common.Utils;
import com.yqp.domain.Log;
import com.yqp.domain.Page;
import com.yqp.mapper.LogMapper;
import com.yqp.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000812:51
 * @Description TODO
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;

    @Override
    public int add(Log log) {
        return logMapper.add(log);
    }

    @Override
    public List<Log> getList(Page page) {
        page.setPage((page.getPage()-1)* page.getLimit());
        return logMapper.getList(page.getPage(), page.getLimit());
    }

    @Override
    public int getCurrentNum() {
        Integer currentNum = logMapper.getCurrentNum();
        if (Utils.isEmpty(currentNum)){
            return 0;
        }else {
            return currentNum;
        }
    }
}
