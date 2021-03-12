package com.skse.config.stock;

import com.skse.model.StockMailTask;
import com.skse.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

/**
 * @Author jiangyao
 * @Date 2020/5/28 10:40
 **/
@Component
public class StockTaskLoadComponent implements ApplicationRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(StockTaskLoadComponent.class);

    @Autowired
    StockService stockService;

    @Autowired
    ThreadPoolTaskScheduler taskScheduler;

    private ScheduledFuture scheduledFuture;

    @Override
    public void run(ApplicationArguments args) {
        LOGGER.info("》》》》》》》STOCK邮件任务初始化开始");
        List<StockMailTask> list = stockService.listRightStockTask();
        list.forEach( (o) -> {
            scheduledFuture = taskScheduler.schedule(new StockSchedulingRunnable(o),new CronTrigger(o.getCronExpress()));
            StockSchedulingConfig.stockRunableMap.put(o.getStockCode()+"_"+o.getCronExpress(),scheduledFuture);
        });
        LOGGER.info("》》》》》》》STOCK邮件任务初始化结束");
    }
}
