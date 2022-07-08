package com.yqp.mapper;

import com.yqp.domain.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000812:42
 * @Description TODO
 */
@Mapper
public interface LogMapper {

    /**
     * 添加一条日志
     * @param log
     * @return
     */
    int add(@Param("log") Log log);

    /**
     * 列表查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Log> getList(@Param("pageNum") Integer pageNum,
                      @Param("pageSize") Integer pageSize);

    /**
     * 获取当前次数
     * @return
     */
    Integer getCurrentNum();
}
