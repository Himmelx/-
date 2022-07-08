package com.yqp.mapper;

import com.yqp.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select count(*) from user")
    int allUser();

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User loginIn(@Param("username") String username,
                 @Param("password") String password);

}
