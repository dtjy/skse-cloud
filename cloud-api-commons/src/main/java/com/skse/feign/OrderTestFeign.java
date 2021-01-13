package com.skse.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiangyao
 * @Date 2021/1/13 10:22
 **/
@Component
@FeignClient(name = "skse-payment-service",value = "skse-payment-service",path = "/payFeign")
public interface OrderTestFeign {

    @RequestMapping("{t1}")
//    @ResponseBody
    public String test1(@PathVariable("t1")String t1);

    @RequestMapping("/t2")
//    @ResponseBody
    public String test2(@RequestParam(value = "p1",required = false)String p1);
}
