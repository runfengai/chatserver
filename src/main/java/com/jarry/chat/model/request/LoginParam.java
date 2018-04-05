package com.jarry.chat.model.request;

/**
 * Description:
 * User: Jarry
 * Date: 2018-01-28
 * Time: 17:26
 */
public class LoginParam {
    private String phone;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String userName) {
        this.phone = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
