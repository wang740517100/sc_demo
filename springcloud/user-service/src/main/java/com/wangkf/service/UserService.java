package com.wangkf.service;

import com.wangkf.mapper.UserMapper;
import com.wangkf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangk on 2018-12-22.
 *
 */
@Service //service注册
public class UserService {

    @Autowired //对成员变量、方法和构造函数进行自动装配
    private UserMapper userMapper;

    public User queryById(String username) {
         return userMapper.selectByPrimaryKey(username);
    }



}
