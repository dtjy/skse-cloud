package com.skse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @RequestMapping(value="/t1",method = RequestMethod.POST)
    public Object test1(@RequestParam("id")String id){

        log.info(">>>>>>>>>>>>>>>>>>>{}",id);

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("userName","xxxxx");
        map.put("password","123456");
        return map;
    }
}
