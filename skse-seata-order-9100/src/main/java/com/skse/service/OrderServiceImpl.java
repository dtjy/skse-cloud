package com.skse.service;

import com.skse.dao.OrderInfoDao;
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

    @Transactional
    @Override
    public int create(Integer id, String orderData) {
        int i = orderInfoDao.create(id,orderData);
        return i;
    }
}
