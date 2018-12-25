package com.wangkf.client.impl;

import com.wangkf.client.UserClient;
import com.wangkf.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by wangk on 2018-12-23.
 *
 * 熔断接口的实现类
 * 里面写熔断的业务逻辑
 */
@Component //注入到spring里面去
public class UserClientFallBack implements UserClient {

    @Override
    public User queryById(@PathVariable("username") String username) {
        User user = new User();
        user.setUsername("未查询到用户！！！");
        return user;
    }
}
