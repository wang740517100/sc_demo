package com.wangkf.controller;

import com.wangkf.pojo.User;
import com.wangkf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangk on 2018-12-22.
 *
 *
 */
@RestController
//@Controller
//@ResponseBody
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}") //@RequestMapping(method = RequestMethod.GET)的缩写
    public User queryById (@PathVariable("username") String username){  //@PathVariable指定URL变量名
        return userService.queryById(username);
    }


}
