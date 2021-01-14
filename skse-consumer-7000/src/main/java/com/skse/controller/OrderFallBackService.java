package com.skse.controller;

import com.skse.feign.OrderTestFeign;
import org.springframework.stereotype.Component;

/**
 * @Author jiangyao
 * @Date 2021/1/14 9:48
 **/
@Component
public class OrderFallBackService implements OrderTestFeign {

    @Override
    public String test1(String p1) {
        return "降级类1";
    }

    @Override
    public String test2(String p1) {
        return "降级类2";
    }
}
