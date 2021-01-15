package com.skse.service;

import com.skse.dao.StorageInfoDao;
import com.skse.feign.AccountFeign;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author jiangyao
 * @Date 2021/1/14 18:09
 **/
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageInfoDao storageInfoDao;

    @Autowired
    AccountFeign accountFeign;

    @Override
    public int create(Integer id, String storageData) {
        int i = storageInfoDao.create(id,storageData);
        int j = accountFeign.create(id,storageData);
        return i+j;
    }
}
