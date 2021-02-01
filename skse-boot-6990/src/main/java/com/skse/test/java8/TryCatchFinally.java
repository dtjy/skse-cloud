package com.skse.test.java8;

/**
 * @Author jiangyao
 * @Date 2021/2/1 10:15
 **/
public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test(){
        try {
            int i = 1/0;
            return 1;
        }catch (Exception we){
//            return 2;
        }finally {
//            return 3;
        }
        return 4;
    }
}
