package com.skse.config.stock;

import com.skse.model.StockMailTask;
import com.skse.service.StockService;
import com.skse.utils.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author jiangyao
 * @Date 2020/5/27 15:26
 **/
public class StockSchedulingRunnable implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockSchedulingRunnable.class);

    private StockMailTask stockMailTask;

    public StockSchedulingRunnable(StockMailTask stockMailTask) {
        this.stockMailTask = stockMailTask;
    }

    @Override
    public void run() {
        //数据解析存库处理
        try {
            StockService stockService = (StockService) SpringContextUtils.getBean("stockService");
            stockService.sendMail(stockMailTask);
        }catch (Exception e){
            LOGGER.error("任务异常",e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockSchedulingRunnable that = (StockSchedulingRunnable) o;
        return stockMailTask.equals(that.stockMailTask) &&
                stockMailTask.equals(that.stockMailTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockMailTask);

    }
}
