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


}
