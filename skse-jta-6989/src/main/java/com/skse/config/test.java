package com.skse.config;

/**
 * @Author jiangyao
 * @Date 2021/2/5 16:31
 **/
public class test {

    public static void main(String[] args) {
        String s = "1,1,3";
        String[] arr= s.split(",",-1);
        System.out.println(arr);
    }
}
