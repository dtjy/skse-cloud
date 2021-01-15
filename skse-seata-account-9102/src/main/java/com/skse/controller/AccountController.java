package com.skse.controller;

import com.skse.service.AccountService;
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
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/t1")
    public String o1(){
        return "test1";
    }

    @GetMapping("/create")
    public Integer create(@RequestParam("id")Integer id,@RequestParam("accountData")String accountData){
        if (id==1){
            throw new NullPointerException("自定义空指针异常");
        }else if (id==2){
            throw new ArrayIndexOutOfBoundsException("自定义数组异常");
        }
        return accountService.create(id,accountData);
    }
}
