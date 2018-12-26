package com.wangkf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 整合mybatis使用通用Mapper(通用mapper封装了单表的增删改查等方法)
 *
 * Created by wangk on 2018-12-22.
 *
 */
@SpringBootApplication
@MapperScan("com.wangkf.mapper") //mybatis扫包
@EnableDiscoveryClient //包含@EnableEurekaClient和其它注册中心启用客户端标签
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
