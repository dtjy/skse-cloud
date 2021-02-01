package com.skse.test.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author jiangyao
 * @Date 2021/2/1 9:31
 **/
//@Component
public class TestSchedule {

    @Scheduled(cron = "0/5 * * * 2 ?")
    @Async
    public void test(){
        System.out.println("2021");
    }

    @Scheduled(cron = "0/5 * * * 2 ?")
    @Async
    public void test1(){
        System.out.println("2022");
    }
}
