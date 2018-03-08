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

    }

    public static String getErrorStr(String code) {
        return errorMap.get(code);
    }
}
