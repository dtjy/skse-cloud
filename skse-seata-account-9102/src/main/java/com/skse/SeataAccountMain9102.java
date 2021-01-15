package com.skse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author jiangyao
 * @Date 2020/12/24 11:36
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建 使用seata
@EnableDiscoveryClient
@EnableFeignClients
public class SeataAccountMain9102 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain9102.class, args);
    }
}
