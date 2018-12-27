package com.wangkf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 * 1:链路追踪zipkin
 *
 */
@SpringBootApplication
@EnableZipkinServer //启用链路追踪server
public class ZipkinApplication {
    public static void main(String[] args){
        SpringApplication.run(ZipkinApplication.class,args);
    }

}
