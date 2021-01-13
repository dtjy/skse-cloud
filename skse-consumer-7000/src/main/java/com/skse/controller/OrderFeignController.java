package com.skse.controller;

import com.skse.feign.OrderTestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiangyao
 * @Date 2021/1/13 10:28
 **/
@RequestMapping("/orderFeign")
@Controller
public class OrderFeignController {

    @Autowired
    OrderTestFeign orderTestFeign;
    @Autowired
    DiscoveryClient discoveryClient;
    @RequestMapping("{t1}")
    @ResponseBody
    public String test1(@PathVariable("t1")String t1){

        System.out.println(discoveryClient.getServices());
        return orderTestFeign.test1(t1);
    }

    @RequestMapping("/t2")
    @ResponseBody
    public String test2(@RequestParam(value = "p1",required = false)String p1){
        return orderTestFeign.test2(p1);
    }

}
