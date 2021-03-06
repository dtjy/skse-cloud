package com.skse;

import loadbalance.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author jiangyao
 * @Date 2020/12/24 13:03
 **/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
//@RibbonClient(name="skse-provider",configuration = MySelfRule.class)  //对服务配置自定义的负载均衡
public class ConsumerMain7000 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain7000.class, args);
    }
}
