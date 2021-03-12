package com.skse.dao;

import com.skse.model.StockCollectLog;
import com.skse.utils.BaseMapper;

public interface StockCollectLogMapper extends BaseMapper<StockCollectLog> {

    int querySameLog(StockCollectLog stockCollectLog);

}