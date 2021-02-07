package com.skse.controller;

import com.skse.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jiangyao
 * @Date 2021/2/7 11:04
 **/
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/t1")
    public String test(Integer id,String text) {
        return testService.test(id,text);
    }
}
