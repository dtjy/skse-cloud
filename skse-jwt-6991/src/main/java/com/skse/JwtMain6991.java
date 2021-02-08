package com.skse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author jiangyao
 * @Date 2021/2/7 15:22
 **/
@Slf4j
@SpringBootApplication
public class JwtMain6991 {

    public static void main(String[] args) {
        SpringApplication.run(JwtMain6991.class,args);
        log.info("springboot-jwt启动成功");
    }
}
