package com.skse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class BootApplication6990 {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication6990.class, args);
        log.info("skse-boot启动成功");
    }

}
