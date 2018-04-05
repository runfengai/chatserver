package com.jarry.chat.service.impl;

import com.jarry.chat.mapper.UserInfoMapper;
import com.jarry.chat.model.MessageData;
import com.jarry.chat.model.response.UserInfo;
import com.jarry.chat.service.UserService;
import com.jarry.chat.util.Constant;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: Jarry
 * Date: 2018-03-04
 * Time: 17:11
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public MessageData login(String account, String password) {
        List<UserInfo> user = userInfoMapper.checkAccount(account);
        if (user == null || user.size() == 0)
            return new MessageData(Constant.MSG_LOGIN_ERROR_USER_NULL, Constant.CODE_LOGIN_ERROR_USER_NULL, user);

        List<UserInfo> userInfo = userInfoMapper.login(account, password);
        if (userInfo != null && userInfo.size() > 0)
            return new MessageData(Constant.MSG_LOGIN_SUCCESS, Constant.CODE_SUCCESS, userInfo.get(0));
        return new MessageData(Constant.MSG_LOGIN_ERROR_USER, Constant.CODE_ERROR, userInfo);


    }

    @Override
    public MessageData register(UserInfo userInfo) {
        List<UserInfo> user = userInfoMapper.checkAccount(userInfo.getPhone());
        if (user != null && user.size() > 0)
            return new MessageData(Constant.MSG_LOGIN_ERROR_USER_EXIST, Constant.CODE_LOGIN_ERROR_USER_EXIST, null);

        if (StringUtils.isNullOrEmpty(userInfo.getPassword()))
            userInfo.setPassword("123456");
        int result = userInfoMapper.register(userInfo);
        if (result > 0) {//成功
            return new MessageData(Constant.MSG_SUCCESS, Constant.CODE_SUCCESS, null);
        } else {
            return new MessageData(Constant.MSG_REGISTER_ERROR, Constant.CODE_REGISTER_ERROR, null);
        }
    }
}
