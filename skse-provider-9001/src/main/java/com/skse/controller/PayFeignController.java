package com.skse.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiangyao
 * @Date 2021/1/13 10:28
 **/
@RequestMapping("/payFeign")
@Controller
public class PayFeignController {

    @Value("${server.port}")
    String port;

    @RequestMapping("{t1}")
    @ResponseBody
    public String test1(@PathVariable("t1")String t1){

        return "t1:"+t1+"端口号"+port;
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
