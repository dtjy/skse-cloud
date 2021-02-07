package com.skse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author jiangyao
 * @Date 2021/2/5 15:20
 **/
@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class JTAMain6989 {

    public static void main(String[] args) {
        SpringApplication.run(JTAMain6989.class, args);
        log.info("启动成功");
    }
}
