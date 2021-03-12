package com.skse.service;

import com.skse.model.StockMailTask;
import com.skse.model.req.StockMailTaskReqVO;

import java.util.List;

/**
 * @Author jiangyao
 * @Date 2020/4/17 20:57
 **/
public interface StockService {

    int insertOne(StockMailTask stockMailTask);

    void sendMail(StockMailTask stockMailTask) throws Exception;

    int deleteOne(StockMailTaskReqVO stockMailTask) throws Exception;

    int updateOne(StockMailTaskReqVO stockMailTask) throws Exception;

    List<StockMailTask> listRightStockTask();
}
