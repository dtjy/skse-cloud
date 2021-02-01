package com.skse.test.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author jiangyao
 * @Date 2021/1/26 13:55
 **/
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("到达");
        });

        new Thread(()->{
            try {
                System.out.println("A");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("AAA");
        },"AAA").start();

//
//        new Thread(()->{
//            try {
//                System.out.println("B");
//                cyclicBarrier.await();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("BBB");
//        },"BBB").start();

        new Thread(()->{
            try {
//                countDownLatch.await();

                System.out.println("CCC");
                TimeUnit.SECONDS.sleep(5);
                cyclicBarrier.await();
                cyclicBarrier.await();
                System.out.println("CCCCCCCC");
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"CCC").start();
    }
}
