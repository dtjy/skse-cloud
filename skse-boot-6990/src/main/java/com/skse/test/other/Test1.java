package com.skse.test.other;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author jiangyao
 * @Date 2021/2/2 10:08
 **/
public class Test1 {

    public static void main(String[] args) {
        Map params = new HashMap();
        Map resultMap = new HashMap();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        Calendar c = Calendar.getInstance();
        String todayTime=df.format(new Date());
        List timeList=new ArrayList();
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(todayTime);
        }catch(Exception e){
//            logger.error("时间格式转化失败",e);
        }
//        params.put("channel_id", channelId);
        String startTime="";
        String time = "1";
        if ("1".equals(time)){
            c.setTime(date);
            int day=c.get(Calendar.DATE);
            c.set(Calendar.DATE,day-1);
            startTime=new SimpleDateFormat("yyyyMMddHHmmss").format(c.getTime());
        }else if("7".equals(time)||"30".equals(time)){
            c.setTime(date);
            int day=c.get(Calendar.DATE);
            c.set(Calendar.DATE,day-Integer.parseInt(time));
            startTime=new SimpleDateFormat("yyyyMMddHHmmss").format(c.getTime());
//            timeList=createTimeX(time,date);
        }
        DateFormat df2=new SimpleDateFormat("yyyyMMddHHmmss");
        String endTime=df2.format(new Date());
        params.put("start_time",startTime);
        params.put("end_time",endTime);
        System.out.println(params);
    }
}
