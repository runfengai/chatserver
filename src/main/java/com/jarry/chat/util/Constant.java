package com.jarry.chat.util;

/**
 * Description:
 * User: Jarry
 * Date: 2018-01-28
 * Time: 17:11
 */
public class Constant {
    public static final String CODE_SUCCESS = "0";//返回成功码
    public static final String CODE_PARAM_NULL = "-2";//参数为空
    public static final String MSG_SUCCESS = "操作成功";//返回成功描述
    public static final String MSG_UPLOAD_SUCCESS = "上传成功";//返回成功描述
    public static final String CODE_ERROR = "-1";//系统错误
    public static final String MSG_ERROR = "系统开小差了";//返回成功描述
    public static final String MSG_PARAM_NULL = "参数为空";//返回成功描述
    /**
     * ====================登录接口描述===========================
     */
    public static final String CODE_LOGIN_ERROR_USER = "1000";//用户名或密码错误
    public static final String CODE_LOGIN_ERROR_USER_NULL = "1001";//用户名不存在
    public static final String CODE_LOGIN_ERROR_USER_EXIST = "1002";//用户已注册
    public static final String CODE_LOGIN_ERROR_PWD = "1002";//密码错误
    public static final String CODE_LOGIN_FORBIDDEN = "-1000";//权限被禁止
    public static final String MSG_LOGIN_SUCCESS = "登录成功";//登录成功
    public static final String MSG_LOGIN_ERROR_USER = "用户名或密码错误";//用户名错误
    public static final String MSG_LOGIN_ERROR_USER_NULL = "用户名不存在";//用户名不存在
    public static final String MSG_LOGIN_ERROR_USER_EXIST = "用户已注册";//用户已注册
    public static final String MSG_LOGIN_ERROR_PWD = "密码错误";//密码错误
    public static final String MSG_LOGIN_FORBIDDEN = "权限被禁止";//权限被禁止
    /**
     * ====================登录接口描述==============================
     */

    /**
     * ====================注册接口描述===========================
     */
    public static final String CODE_REGISTER_ERROR = "1010";//注册错误码
    public static final String MSG_REGISTER_ERROR = "注册失败";//注册失败

    public static final String CODE_REGISTER_PHONE_NULL = "1011";//手机号为空
    public static final String MSG_REGISTER_PHONE_NULL = "手机号为空";//注册失败
    /**
     * ====================注册接口描述==============================
     */
    /**
     * ====================上传文件===========================
     */
    public static final String CODE_FILE_UPLOAD_ERROR = "1020";//上传文件失败
    public static final String MSG_FILE_UPLOAD_ERROR = "上传文件失败";//注册失败
    /**
     * ====================上传文件==============================
     */
}
