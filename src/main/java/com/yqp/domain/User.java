package com.yqp.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000810:37
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class User {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
    /**
     * token
     */
    private String token;

}
