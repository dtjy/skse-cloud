package com.skse.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author jiangyao
 * @Date 2021/1/26 15:14
 **/
public class QueueTest1 {

    public static void main(String[] args) throws Exception{
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
//        queue.ta
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
                queue.put("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(()->{
            String s = null;
            try {
                while ((s=queue.poll())==null){
                    System.out.println("没有获取到数据");
                }
                TimeUnit.SECONDS.sleep(2);
                System.out.println(s);
            }catch (Exception e){

            }
        }).start();




    }
}
