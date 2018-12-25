package com.wangkf.controller;

import org.apache.http.client.methods.HttpGet;
import com.wangkf.pojo.User;
import com.wangkf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangk on 2018-12-22.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}") //@RequestMapping(method = RequestMethod.GET)的缩写
    public User queryById (@PathVariable("username") String username){  //@PathVariable指定URL变量名
        return userService.queryById(username);
    }


}
