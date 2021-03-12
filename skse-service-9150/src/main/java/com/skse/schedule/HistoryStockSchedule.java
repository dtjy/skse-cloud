package com.skse.schedule;

import com.skse.dao.StockCollectLogMapper;
import com.skse.dao.StockCollectTaskMapper;
import com.skse.model.StockCollectLog;
import com.skse.model.StockCollectTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @Author jiangyao
 * @Date 2020/6/29 17:49
 **/
@Component
public class HistoryStockSchedule {

    @Autowired
    StockCollectTaskMapper stockCollectTaskMapper;
    @Autowired
    StockCollectLogMapper stockCollectLogMapper;

    private URL url;

    //每天八点
    @Scheduled(cron = "${stock.history.cron}")
    public void task(){
        //获取所有任务
        List<StockCollectTask> taskList = stockCollectTaskMapper.selectAll();
        //任务当日数据采集
        for (StockCollectTask stockCollectTask : taskList){

        }
        taskList.stream().forEach(stockCollectTask -> {
            try {
                StockCollectLog stockCollectLog = query(stockCollectTask);
                //判断是否已有相同数据
                int i = this.stockCollectLogMapper.querySameLog(stockCollectLog);
                if (i==0){
                    this.stockCollectLogMapper.insertSelective(stockCollectLog);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });


    }

    public StockCollectLog query(StockCollectTask stockCollectTask) throws Exception{
        url = new URL(stockCollectTask.getDataUrl());
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"GBK");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String resultStr = bufferedReader.readLine();
        String[] resultArr = resultStr.split("\"");
        resultArr = resultArr[1].split(",");
        String[] indexs = stockCollectTask.getDataIndex().split(",",-1);

        StockCollectLog stockCollectLog = new StockCollectLog();
        stockCollectLog.setItem(resultArr[Integer.parseInt(indexs[0])]);
        stockCollectLog.setStockCode(stockCollectTask.getStockCode());
        stockCollectLog.setWeekDate(LocalDate.now().getDayOfWeek().getValue());
        stockCollectLog.setCreateDate(new Date());
        stockCollectLog.setData(Double.parseDouble(resultArr[Integer.parseInt(indexs[1])]));
        stockCollectLog.setDataPercentage(Double.parseDouble(resultArr[Integer.parseInt(indexs[2])]));
        stockCollectLog.setIncreaseDecrease(Double.parseDouble(resultArr[Integer.parseInt(indexs[3])]));

        return stockCollectLog;
    }


}
