package com.skse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jiangyao
 * @Date 2021/2/7 15:27
 **/
@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestController {


    @RequestMapping(value = "/t1")
    public String test(){
        return "su";
    }
}
