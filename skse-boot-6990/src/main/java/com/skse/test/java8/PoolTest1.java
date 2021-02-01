package com.skse.test.java8;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author jiangyao
 * @Date 2021/2/1 11:22
 **/
public class PoolTest1 {

    public static ThreadPoolExecutor poolExecutor
            = new ThreadPoolExecutor(3
            ,10
            ,10
            , TimeUnit.SECONDS
            ,new LinkedBlockingQueue<>(10)
            , Executors.defaultThreadFactory()
            ,new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        String s = "s";
    }
}
