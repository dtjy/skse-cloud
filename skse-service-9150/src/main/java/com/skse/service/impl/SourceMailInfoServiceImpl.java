package com.skse.service.impl;

import com.skse.dao.SourceMailInfoMapper;
import com.skse.model.SourceMailInfo;
import com.skse.service.SourceMailInfoService;
import com.skse.service.StockService;
import com.skse.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @Author jiangyao
 * @Date 2020/4/18 14:19
 **/
@Service
public class SourceMailInfoServiceImpl implements SourceMailInfoService {

    @Autowired
    SourceMailInfoMapper sourceMailInfoMapper;

    @Autowired
    StockService stockService;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public SourceMailInfo getRandomSourceMail(){
        List list = redisUtil.lGet("email_info",0,-1);
        if (list==null||list.size()==0){
            list = sourceMailInfoMapper.listSourceMailInfo();
            redisUtil.lSet("email_info",list,3600);
        }
        return (SourceMailInfo)list.get(new Random().nextInt(list.size()));
    }
}
