package com.skse.dao;

import com.skse.model.StockMailTask;
import com.skse.utils.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMailTaskMapper extends BaseMapper<StockMailTask> {

    int updateTaskStatus(@Param("cron") String cron, @Param("mail") String mail);

    List<StockMailTask> listTask(@Param("status") String status);
}