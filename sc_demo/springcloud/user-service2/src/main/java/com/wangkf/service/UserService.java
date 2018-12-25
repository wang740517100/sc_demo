package com.wangkf.service;

import com.wangkf.mapper.UserMapper;
import com.wangkf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangk on 2018-12-22.
 *
 */
@Service //service注册
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(String username) {
        return userMapper.selectByPrimaryKey(username);
    }



}
