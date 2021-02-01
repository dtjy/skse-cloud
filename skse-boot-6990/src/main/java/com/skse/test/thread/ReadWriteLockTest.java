package com.skse.test.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author jiangyao
 * @Date 2021/1/25 16:30
 **/
public class ReadWriteLockTest {

    AtomicReference<Thread> readLock = new AtomicReference<>();
    AtomicReference<Thread> writeLock = new AtomicReference<>();

    public void getReadLock(){
        //判断写锁
        Thread thread = Thread.currentThread();
        while (!(writeLock.get()==null)){

        }
        readLock.set(thread);
        System.out.println(thread.getName()+"获取到读锁");
    }

    public void unReadLock(){
        Thread thread = Thread.currentThread();
        if (readLock.compareAndSet(thread,null)){
            System.out.println(thread.getName()+"释放读锁");
        }else {
            System.out.println(thread.getName()+"释放读锁时，有其他线程正在暂用读锁");
        }
    }

    public void getWriteLock(){
        Thread thread = Thread.currentThread();
        //判断是否读锁被使用
        while (!(readLock.get()!=null)){

        }
        System.out.println(thread.getName()+"读锁判断null成功");

        //判断写锁是否被占用
        while (writeLock.compareAndSet(null,thread)){

        }
        System.out.println(thread.getName()+"获取写锁成功");
    }

    public void unWriteLock(){
        Thread thread = Thread.currentThread();
        writeLock.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();

        //获取写锁
        new Thread(()->{
            try {
                readWriteLockTest.getWriteLock();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("A业务代码,写");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                readWriteLockTest.unWriteLock();
            }

        },"A").start();

        //B获取写锁
        new Thread(()->{
            try {
                readWriteLockTest.getWriteLock();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("B业务代码,写");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                readWriteLockTest.unWriteLock();
            }

        },"B").start();

        //C获取写锁
        new Thread(()->{
            try {
                readWriteLockTest.getReadLock();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("C业务代码,读");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                readWriteLockTest.unReadLock();
            }

        },"C").start();
    }
}
