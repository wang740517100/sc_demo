package com.wangkf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import com.wangkf.pojo.User;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * 1:整合RestTemplate（http远程调用） 注释代码示例
 * 对基于Http的客户端进行了封装，并且实现了对象与json的序列化和反序列化，非常方便。
 * RestTemplate并没有限定Http的客户端类型，而是进行了抽象，目前常用的3种都有支持：
 * HttpClient
 * OkHttp
 * JDK原生的URLConnection（默认的）

 * 2:整合Feign
 * Feign里面集成有负载均衡和断路器
 *
 * Created by wangk on 2018-12-22.
 *
 */

//@SpringBootApplication
//@EnableDiscoveryClient //开启注册中心(包含开启Eureka客户端)
//@EnableCircuitBreaker //开启熔断器
@SpringCloudApplication //包含上面三个标签
@EnableFeignClients
public class ComsumerApplication {

    public static void main(String[] srgs) {
        SpringApplication.run(ComsumerApplication.class);
    }


    /*
    @Bean //产生一个Bean，然后交给Spring容器
    @LoadBalanced //开启负载均衡，Eureka中已经集成了Ribbon，无需引入新的依赖
    public RestTemplate restTemplate() {
        // 默认的RestTemplate，底层是走JDK的URLConnection方式。
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
    */

}
