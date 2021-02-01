package com.skse.test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author jiangyao
 * @Date 2021/1/26 15:54
 **/
public class QueueTest2 {

    public static void main(String[] args) throws Exception{
        SynchronousQueue queue = new SynchronousQueue();

        queue.put("a");

        System.out.println("test");

        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.tryLock();
    }
}
