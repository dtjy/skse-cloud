package com.skse.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "enable.autoConfiguration",matchIfMissing = true)
public class MyStartTest {

    static {
        System.out.println("自定义初始化的autoconfig");
    }
}
