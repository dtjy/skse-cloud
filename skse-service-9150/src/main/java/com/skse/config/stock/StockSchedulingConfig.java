package com.skse.config.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author jiangyao
 * @Date 2020/5/26 14:01
 **/
@Configuration
public class StockSchedulingConfig {

    public static Map<String, ScheduledFuture> stockRunableMap = new ConcurrentHashMap();

    @Bean
    public ThreadPoolTaskScheduler stockTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        // 定时任务执行线程池核心线程数
        taskScheduler.setPoolSize(Runtime.getRuntime().availableProcessors());
        taskScheduler.setRemoveOnCancelPolicy(true);
        taskScheduler.setThreadFactory(Executors.defaultThreadFactory());
        taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskScheduler.setRemoveOnCancelPolicy(Boolean.TRUE);  //设置任务可删除
        taskScheduler.setThreadNamePrefix("【StockTaskPool】-");
        return taskScheduler;
    }
}
