package com.skse.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.skse.feign.OrderTestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @SentinelResource(value = "test1", blockHandler = "test1_bh",blockHandlerClass = OrderBlockHandler.class, fallback = "test1_fallback")
    @RequestMapping("/t1")
    @ResponseBody
    public String test1(@RequestParam(value = "p1",required = false)String p1,@RequestParam(value = "p2",required = false)String p2){
        Integer.parseInt(p1);
        return orderTestFeign.test1(p2);
    }

    public String test1_fallback(@RequestParam(value = "p1",required = false)String p1,@RequestParam(value = "p2",required = false)String p2, Throwable throwable){
            return "test1_fallback"+throwable.getMessage();
    }


    @RequestMapping("/t2")
    @ResponseBody
    public String test2(@RequestParam(value = "p1",required = false)String p1){
        return orderTestFeign.test2(p1);
    }

    @RequestMapping("/service")
    @ResponseBody
    public Object service(){
        return discoveryClient.getServices();
    }

}
