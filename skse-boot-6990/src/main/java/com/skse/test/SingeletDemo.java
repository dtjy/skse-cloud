package com.skse.test;

/**
 * @Author jiangyao
 * @Date 2021/1/22 11:29
 **/
public class SingeletDemo {

    private static volatile SingeletDemo singeletDemo = null;
    private SingeletDemo(){
        System.out.println("私有构造函数");
    };

    public static SingeletDemo getInstance(){
        if (null == singeletDemo){
            synchronized (SingeletDemo.class){
                if (null == singeletDemo){
                    singeletDemo = new  SingeletDemo();
                }
            }
        }
        return singeletDemo;
    }
}
