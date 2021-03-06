package com.skse.controller;

import com.skse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jiangyao
 * @Date 2021/1/14 18:06
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/t1")
    public String o1(){
        return "test1";
    }

    @GetMapping("/create")
    public Integer create(@RequestParam("id")Integer id,@RequestParam("orderData")String orderData){
        return orderService.create(id,orderData);
    }
}
