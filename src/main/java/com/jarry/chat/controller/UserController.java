package com.jarry.chat.controller;

import com.jarry.chat.model.MessageData;
import com.jarry.chat.model.request.LoginParam;
import com.jarry.chat.model.response.UserInfo;
import com.jarry.chat.service.UserService;
import com.jarry.chat.util.Constant;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 用户登录
 */
@RestController
public class UserController {

    @Autowired
    UserService userInfoService;

    @RequestMapping(value = "/login")
    MessageData login(LoginParam param) {
        return userInfoService.login(param.getUserName(), param.getPassword());
    }

    @RequestMapping(value = "/register")
    MessageData register(UserInfo userInfo) {
        if (userInfo == null) return new MessageData(Constant.MSG_PARAM_NULL, Constant.CODE_PARAM_NULL);
        else if (StringUtils.isNullOrEmpty(userInfo.getPhone())) {
            return new MessageData(Constant.MSG_REGISTER_PHONE_NULL, Constant.CODE_REGISTER_PHONE_NULL);
        }
        //生成userid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        userInfo.setUserId(uuid);
        return userInfoService.register(userInfo);
    }
}
