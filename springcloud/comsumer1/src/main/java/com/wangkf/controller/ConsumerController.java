package com.wangkf.controller;

import com.wangkf.client.UserClient;
import com.wangkf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangk on 2018-12-22.
 *
 *
 */
@RestController
@RequestMapping("comsumer")

public class ConsumerController {

    @Autowired
    private UserClient userClient;

    @GetMapping("{username}")
    public User queryById (@PathVariable("username") String username){
        return userClient.queryById(username);
    }


    /**
     * RestTemplate示例

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{username}") //@RequestMapping(method = RequestMethod.GET)的缩写
    public User queryById (@PathVariable("username") String username){  //@PathVariable指定URL变量名

        return restTemplate.getForObject("http://localhost:8081/user/" + username, User.class);
    }
     */


}
