package com.yqp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000812:53
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class Page {

    private int pageNum = 1;//分页页码，默认第一页

    private int pageSize = 10;//每页条数，默认10条
}
