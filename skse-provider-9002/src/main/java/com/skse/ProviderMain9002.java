package com.skse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author jiangyao
 * @Date 2020/12/24 11:36
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProviderMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMain9002.class, args);
    }
}
