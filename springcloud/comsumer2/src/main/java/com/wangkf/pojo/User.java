package com.wangkf.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String username;

    private String password;

    private String phone;

    private Date created;

    private String salt;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Date getCreated() {
        return created;
    }

    public String getSalt() {
        return salt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
