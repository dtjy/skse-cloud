package com.skse.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author jiangyao
 * @Date 2021/1/13 15:23
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel () {  //调用日志，yml配置文件中同时添加具体的feign接口
        return Logger.Level.FULL;
    }
}
