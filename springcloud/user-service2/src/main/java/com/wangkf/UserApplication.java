package com.wangkf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

/**
 * 整合mybatis示例使用xml方式
 *
 * Created by wangk on 2018-12-22.
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.wangkf.mapper") //mybatis扫包
public class UserApplication {

    public static void main(String[] srgs) {
        SpringApplication.run(UserApplication.class);
    }



    /*
    下面是RestTemplate模板工具类:
    对基于Http的客户端进行了封装，并且实现了对象与json的序列化和反序列化，非常方便。
    RestTemplate并没有限定Http的客户端类型，而是进行了抽象，目前常用的3种都有支持：
    - HttpClient
    - OkHttp
    - JDK原生的URLConnection（默认的）*/
    @Bean //产生一个Bean，然后交给Spring容器
    public RestTemplate restTemplate() {
        // 默认的RestTemplate，底层是走JDK的URLConnection方式。
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }


}
