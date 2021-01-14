package com.skse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author jiangyao
 * @Date 2020/12/24 11:36
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransactionManagement
public class SeataOrderMain9100 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain9100.class, args);
    }
}
