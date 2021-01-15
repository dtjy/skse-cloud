package com.skse.service;

import com.skse.dao.OrderInfoDao;
import com.skse.feign.AccountFeign;
import com.skse.feign.StorageFeign;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author jiangyao
 * @Date 2021/1/14 18:09
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderInfoDao orderInfoDao;

    @Autowired
    StorageFeign storageFeign;

    @Autowired
    AccountFeign accountFeign;

    @GlobalTransactional(name = "order-tx",rollbackFor = Exception.class,noRollbackFor = ArrayIndexOutOfBoundsException.class)
    @Override
    public int create(Integer id, String orderData) {
        int i = orderInfoDao.create(id,orderData);
        int j = storageFeign.create(id,orderData);
        return i+j;
    }
}
