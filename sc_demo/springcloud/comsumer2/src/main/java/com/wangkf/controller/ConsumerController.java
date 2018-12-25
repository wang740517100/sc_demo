package com.wangkf.controller;

import com.wangkf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Random;

import java.util.List;

/**
 * Created by wangk on 2018-12-22.
 *
 *
 */
@RestController
@RequestMapping("comsumer")

public class ConsumerController {

    /**
     * Robbin负载均衡示例
     */
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient; //拉取在eureka注册的服务列表

    @LoadBalanced
    @GetMapping("/{username}") //@RequestMapping(method = RequestMethod.GET)的缩写
    public User queryById (@PathVariable("username") String username){  //@PathVariable指定URL变量名
        //根据服务id获取实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //随机从实例中获取id和端口
        Random random = new Random();
        int i = random.nextInt(instances.size());
        ServiceInstance instance = instances.get(i);
        String url = "http://" + instance.getServiceId() + ":" + instance.getPort() + "/user/" + username;
        User user = restTemplate.getForObject(url,  User.class);
        return user;
    }



}
