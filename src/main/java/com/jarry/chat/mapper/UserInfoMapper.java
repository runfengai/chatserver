package com.jarry.chat.mapper;

import com.jarry.chat.model.response.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 * User: Jarry
 * Date: 2018-01-28
 * Time: 22:04
 */
@Mapper
public interface UserInfoMapper {
    UserInfo login(@Param("account") String account, @Param("password") String password);

    UserInfo checkAccount(@Param("account") String account);

    int register(@Param("userInfo") UserInfo userInfo);
}
