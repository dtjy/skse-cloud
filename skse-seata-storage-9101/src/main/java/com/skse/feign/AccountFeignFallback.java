package com.skse.feign;

import org.springframework.stereotype.Component;

/**
 * @Author jiangyao
 * @Date 2021/1/15 16:47
 **/
@Component
public class AccountFeignFallback implements AccountFeign{

    @Override
    public Integer create(Integer id, String accountData) {
        return -999;
    }

    @Override
    public String o1() {
        return "AccountFeign 异常处理fallback";
    }
}
