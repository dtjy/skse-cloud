package com.skse.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @Author jiangyao
 * @Date 2021/1/13 10:28
 **/
@RequestMapping("/payFeign")
@Controller
public class PayFeignController {

    @Value("${server.port}")
    String port;

    @SentinelResource(value = "payTest1", fallback = "test1_fb")
    @RequestMapping("/t1")
    @ResponseBody
    public String test1(@RequestParam(value = "p1",required = false)String p1){
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Integer.parseInt(p1);
        return "t1:"+p1+"端口号"+port;
    }
    public String test1_fb(String p1,Throwable throwable){
        System.out.println(throwable.getStackTrace());
        return "服务端 test1 fallback,"+p1;
    }
    @RequestMapping("/t2")
    @ResponseBody
    public String test2(@RequestParam(value = "p1",required = false)String p1){
        if (null == p1){
            return "t2: p1 is null";
        }
        return "t2:"+p1;
    }

}
