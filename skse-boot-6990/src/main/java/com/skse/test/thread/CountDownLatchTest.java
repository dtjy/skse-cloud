package com.skse.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author jiangyao
 * @Date 2021/1/26 12:50
 **/
public class CountDownLatchTest {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("AAA");
        },"AAA").start();


        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("BBB");
        },"BBB").start();

        new Thread(()->{
            try {
//                countDownLatch.await();

                System.out.println("CCC");
                TimeUnit.SECONDS.sleep(5);
                countDownLatch.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"CCC").start();

        new Thread(()->{
            try {
//                countDownLatch.await();
//                TimeUnit.SECONDS.sleep(5);
                System.out.println("DDD");
                TimeUnit.SECONDS.sleep(5);
                countDownLatch.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"DDD").start();

//        Semaphore ss
    }
}
