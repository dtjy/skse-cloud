package com.skse.service;

import com.skse.dao.account.AccountInfoDao;
import com.skse.dao.storage.StorageInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author jiangyao
 * @Date 2021/2/7 11:01
 **/
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    AccountInfoDao accountInfoDao;

    @Autowired
    StorageInfoDao storageInfoDao;

    @Transactional
    @Override
    public String test(Integer id,String text) {
        accountInfoDao.create(id,text);

        if (id==0){
            int j=1/0;
        }

        storageInfoDao.create(id,text);

        if (id <0){
            int i=1/0;
        }
        return "success";
    }
}
