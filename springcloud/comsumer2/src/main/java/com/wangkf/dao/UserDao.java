package com.wangkf.dao;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.wangkf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 *
 * 该dao用来访问user服务，主要演示Hystix断路器用
 *
 */
@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient; //拉取在eureka注册的服务列表

    @HystrixCommand(fallbackMethod = "queryByIdFallBack") //开启熔断功能
    @LoadBalanced //开启负载均衡
    public User queryById(String username) {
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

    /**
     * 断路器的熔断方法，熔断后进入该方法
     * 该方法参数和返回值类型必须和开启熔断功能的方法一致
     * @param username
     * @return User
     */
    public User queryByIdFallBack(String username) {
        User user = new User();
        user.setUsername("未查询到" + username + "用户！！！");
        return user;
    }


}
