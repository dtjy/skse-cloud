package com.skse.controller;

import com.skse.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

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
