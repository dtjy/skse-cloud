package com.skse.controller;

import com.skse.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Scope("prototype")
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    private int temp = 0;

    @GetMapping("/t3")
    public Object t3(){
        System.out.println(temp++);
        return temp;
    }

    @GetMapping("/t2")
    public Object t2(){
        System.out.println(temp++);
        return temp;
    }

    @RequestMapping(value="/t1111",method = RequestMethod.POST)
    public Object test1(@RequestParam("id")String id){

        log.info(">>>>>>>>>>>>>>>>>>>{}",id);

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("userName","xxxxx");
        map.put("password","123456");
        return map;
    }

    @CrossOrigin
    @PostMapping("t1")
    public Person test(@RequestBody Person person){
        return person;
    }
}
