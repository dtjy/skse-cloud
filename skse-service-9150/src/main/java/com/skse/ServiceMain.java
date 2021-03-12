package com.skse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author jiangyao
 * @Date 2021/3/11 12:40
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.skse.dao")
@EnableScheduling
public class ServiceMain {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServiceMain.class);
    public static void main(String[] args) {
        SpringApplication app =  new SpringApplication(ServiceMain.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
        LOGGER.info("启动成功");
    }
}

