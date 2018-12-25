package com.wangkf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

/**
 * 整合mybatis示例使用xml方式
 *
 * 整合Robbin负载均衡
 *
 * 整合Hystix断路器
 *
 * Created by wangk on 2018-12-22.
 *
 */
@SpringBootApplication
@EnableDiscoveryClient //开启注册中心(包含开启Eureka客户端)
//@EnableCircuitBreaker //开启熔断器
//@SpringCloudApplication //包含上面三个标签
public class ComsumerApplication {

    public static void main(String[] srgs) {
        SpringApplication.run(ComsumerApplication.class);
    }

    /*
    下面是RestTemplate模板工具类:
    对基于Http的客户端进行了封装，并且实现了对象与json的序列化和反序列化，非常方便。
    RestTemplate并没有限定Http的客户端类型，而是进行了抽象，目前常用的3种都有支持：
    - HttpClient
    - OkHttp
    - JDK原生的URLConnection（默认的）*/
    @Bean //产生一个Bean，然后交给Spring容器
    @LoadBalanced //开启Ribbon负载均衡
    public RestTemplate restTemplate() {
        // 默认的RestTemplate，底层是走JDK的URLConnection方式。
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }


}
