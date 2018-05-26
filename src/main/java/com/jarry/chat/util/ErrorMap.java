package com.jarry.chat.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: Jarry
 * Date: 2018-03-08
 * Time: 22:50
 */
public class ErrorMap {
    static Map<String, String> errorMap = new HashMap<>();

    static {
        errorMap.put(Constant.CODE_ERROR, Constant.MSG_ERROR);
        errorMap.put(Constant.CODE_REGISTER_PHONE_NULL, "手机号为空");
        errorMap.put(Constant.CODE_LOGIN_ERROR_PWD_NULL, "密码为空");
        errorMap.put(Constant.CODE_USER_INFO_NULL, "用户信息入参为空");
        errorMap.put(Constant.CODE_USER_NOT_EXIST, "用户不存在");
    }

    public static String getErrorStr(String code) {
        return errorMap.get(code);
    }
}
