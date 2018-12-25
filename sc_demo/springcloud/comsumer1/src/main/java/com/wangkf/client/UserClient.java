package com.wangkf.client;

import com.wangkf.client.impl.UserClientFallBack;
import com.wangkf.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by wangk on 2018-12-23.
 *
 * 整合Feign
 * Feign中已经自动集成了Ribbon负载均衡
 * Feign默认也有对Hystix的集成
 */
@FeignClient(value = "user-service", fallback = UserClientFallBack.class) //拉取服务列表(服务名)
public interface UserClient {

    @GetMapping("user/{username}") //获取参数
    User queryById(@PathVariable("username") String username);

}
