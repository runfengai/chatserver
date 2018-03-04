package com.jarry.chat.model;

import java.io.Serializable;

/**
 * 同意封装消息类
 */
public class MessageData implements Serializable {
    private String message;//消息内容
    private String code;//返回码
    private Object data;//返回数据

    public MessageData() {
    }

    public MessageData(String message, String code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public MessageData(String message, String code) {
        this.message = message;
        this.code = code;

    }

    //
    public static MessageData createErrorMsg() {
        return new MessageData();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
