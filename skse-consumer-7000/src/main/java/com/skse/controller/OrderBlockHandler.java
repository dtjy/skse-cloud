package com.skse.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author jiangyao
 * @Date 2021/1/14 10:39
 **/
public class OrderBlockHandler {


    public static String test1_bh(String p1, String p2,BlockException bk){
        return "消费 test1 blockhandler"+ p1 +","+bk.getMessage();
    }
}
