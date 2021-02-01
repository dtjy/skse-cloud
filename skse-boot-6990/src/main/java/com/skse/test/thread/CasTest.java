package com.skse.test.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author jiangyao
 * @Date 2021/1/22 15:54
 **/
public class CasTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (int i=0; i<10; i++){
            new Thread(()->{
                for (int j=0; j<1000; j++){
                    atomicInteger.getAndIncrement();
                }
            }).start();
        }

//        while (Thread.activeCount()>2){
//            Thread.yield();
//        }
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger.get());
    }
}
