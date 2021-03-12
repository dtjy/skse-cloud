package com.skse.test;

import java.util.StringJoiner;

/**
 * @Author jiangyao
 * @Date 2021/2/7 17:13
 **/

public class Test1 {

    public static void main(String[] args) {
        String pro = "河北";
        String provinceName = "河北,西藏,青海";
        System.out.println(provinceName.contains(pro));
        //非河北
//        String[] split = provinceName.split(",");
//        StringJoiner stringJoiner = new StringJoiner(",");
//        for (int i=0;i<split.length;i++){
//            if (split[i].equals(pro)){
//                continue;
//            }else {
//                stringJoiner.add(split[i]);
//            }
//        }
//        System.out.println(stringJoiner.toString());
//    }
    }
}
