package com.yqp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000812:37
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class Log {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 操作人
     */
    private String operationUser;

    /**
     * 操作时间
     */
    private Date createTime;

    /**
     * 操作类型
     */
    private String type;

    /**
     * 描述
     */
    private String note;

}
