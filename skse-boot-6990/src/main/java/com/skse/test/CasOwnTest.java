package com.skse.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author jiangyao
 * @Date 2021/1/25 16:04
 **/
public class CasOwnTest {

    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();

    public void lock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)){
//            System.out.println(thread.getName()+"获取到锁");
        }
        System.out.println(thread.getName()+"获取到锁");

    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(thread,null)){
//            System.out.println(thread.getName()+"释放锁");
        }
        System.out.println(thread.getName()+"释放锁");
    }

    public static void main(String[] args) {
        CasOwnTest casOwnTest = new CasOwnTest();

        new Thread(()->{
            casOwnTest.lock();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("AAAAAAAAAA");
            casOwnTest.unlock();
            System.out.println();
        },"A").start();

        new Thread(()->{
            casOwnTest.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("BBBBBBBBBB");
            casOwnTest.unlock();
        },"B").start();

        new Thread(()->{
            casOwnTest.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("CCCCCCCCCC");
            casOwnTest.unlock();
        },"C").start();

        new Thread(()->{
            casOwnTest.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("DDDDDDDDDD");
            casOwnTest.unlock();
        },"D").start();
    }
}
