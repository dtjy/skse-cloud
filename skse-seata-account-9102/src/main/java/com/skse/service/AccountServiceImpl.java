package com.skse.service;

import com.skse.dao.AccountInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author jiangyao
 * @Date 2021/1/14 18:09
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountInfoDao accountInfoDao;

    @Override
    public int create(Integer id, String accountData) {
//        try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }

        int i = accountInfoDao.create(id,accountData);
//        int j = 1/0;
        return i;
    }
}
