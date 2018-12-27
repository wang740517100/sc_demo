package com.wangkf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by wangk on 2018-12-23.
 *
 * 1:zuul网关
 * 集成负载均衡和断路器
 *
 */
@SpringBootApplication
@EnableZuulProxy  //启用zuul代理
public class ZuulApplication {

    public static void main(String[] args){
        SpringApplication.run(ZuulApplication.class, args);
    }


}
