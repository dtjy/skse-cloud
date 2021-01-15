package com.skse.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author jiangyao
 * @Date 2021/1/15 13:48
 **/
@FeignClient(value = "skse-storage",path = "/storage")
public interface StorageFeign {

    @GetMapping("/t1")
    public String o1();

    @GetMapping("/create")
    public Integer create(@RequestParam("id")Integer id, @RequestParam("storageData")String storageData);
}
