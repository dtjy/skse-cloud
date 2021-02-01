package com.skse.controller;

import com.skse.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author jiangyao
 * @Date 2021/2/1 15:46
 **/
@Slf4j
@RestController
@RequestMapping(value = "login")
public class LoginController {

    @CrossOrigin
    @RequestMapping(value = "/do",method = RequestMethod.POST)
    public String logim(@RequestBody Person person){
        log.info(person.getUserCode());
        log.info(person.getPassword());
        return "success";
    }
}
