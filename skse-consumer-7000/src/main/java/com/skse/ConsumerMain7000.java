package com.skse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author jiangyao
 * @Date 2020/12/24 13:03
 **/
@SpringBootApplication
@EnableFeignClients(basePackages = "com.skse")
@EnableDiscoveryClient
public class ConsumerMain7000 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain7000.class, args);
    }
}
