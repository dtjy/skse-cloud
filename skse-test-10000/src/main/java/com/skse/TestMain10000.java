package com.skse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author jiangyao
 * @Date 2021/2/7 10:35
 **/
@SpringBootApplication
@Slf4j
public class TestMain10000 {

    public static void main(String[] args) {
        SpringApplication.run(TestMain10000.class, args);
        log.info("skse-test启动成功");
    }
}
