package com.skse.service.impl;

import com.skse.dao.StockMailTaskMapper;
import com.skse.model.SourceMailInfo;
import com.skse.model.StockMailTask;
import com.skse.model.req.SimpleStockMqVO;
import com.skse.model.req.StockMailTaskReqVO;
import com.skse.service.SourceMailInfoService;
import com.skse.service.StockService;
import com.skse.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author jiangyao
 * @Date 2020/4/17 20:57
 **/
@Service(value = "stockService")
public class StockServiceImpl implements StockService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockServiceImpl.class);

    @Autowired
    StockMailTaskMapper stockMailTaskMapper;

    @Autowired
    SourceMailInfoService sourceMailInfoService;

//    @Resource(name = "simpleStockTopic")
//    Topic topic;

    @Autowired
    StockService stockService;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public int insertOne(StockMailTask stockMailTask) {
        return stockMailTaskMapper.insertSelective(stockMailTask);
    }

    @Override
    public void sendMail(StockMailTask stockMailTask) throws Exception{
        LocalDateTime localDateTime = LocalDateTime.now();
        String nowTime = localDateTime.format(DateTimeFormatter.ofPattern("HHmmss"));
        String week = String.valueOf(localDateTime.getDayOfWeek().getValue());
        String[] times = stockMailTask.getCheckTime().split("\\|",-1);
        for (int i=0; i<times.length; i++){
            String cWeek = times[i].split(",",-1)[1];
            String start = times[i].split(",",-1)[0].split("-",-1)[0];
            String end = times[i].split(",",-1)[0].split("-",-1)[1];
            if (nowTime.compareTo(start)>=0 && nowTime.compareTo(end)<=0 && cWeek.indexOf(week)>=0){
                job(stockMailTask);
                return;
            }
        }
    }

    public void job(StockMailTask task) throws Exception{
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        URL hsurl = new URL(task.getStockCode());
        URLConnection hsurlConnection = hsurl.openConnection();
        InputStream hsinputStream = hsurlConnection.getInputStream();
        InputStreamReader hsinputStreamReader = new InputStreamReader(hsinputStream,"GBK");
        BufferedReader hsbufferedReader = new BufferedReader(hsinputStreamReader);
        String hs = hsbufferedReader.readLine();
        String[] hs_arr = hs.split("\"");
        hs_arr = hs_arr[1].split(",");
        String[] indexs = task.getDataIndex().split(",",-1);
        SourceMailInfo sourceMailInfo = sourceMailInfoService.getRandomSourceMail();
        //采用activemq作为消息队列 ,废弃
//        jmsMessagingTemplate.convertAndSend(topic,
//                JSON.toJSONString(
//                        new SimpleStockMqVO(task.getSendMail(),
//                                hs_arr[Integer.parseInt(indexs[0])]+"-"+ LocalTime.now().toString(),
//                                hs_arr[Integer.parseInt(indexs[1])].concat("，").concat(hs_arr[Integer.parseInt(indexs[2])].concat("%，").concat(hs_arr[Integer.parseInt(indexs[3])])),
//                                sourceMailInfo.getSourceMail(),
//                                sourceMailInfo.getPassword(),
//                                sourceMailInfo.getHost(),
//                                sourceMailInfo.getSmtpPort())));
        String subject = null;
        String content = null;
        //采用rocketmq作为消息队列
        //构造消息体
        if (task.getItem().equals("A50")){
            subject = "上证A50-"+ LocalTime.now().toString();
            //昨日收盘
            BigDecimal last = new BigDecimal(Double.parseDouble(hs_arr[Integer.parseInt(indexs[0])]));
            BigDecimal now = new BigDecimal(Double.parseDouble(hs_arr[Integer.parseInt(indexs[1])]));
            BigDecimal bigDecimal = last.subtract(now).multiply(new BigDecimal(100)).divide(last,2,BigDecimal.ROUND_HALF_UP);
            //现价
            content = bigDecimal.toString()+"%";
        }else {
            subject = hs_arr[Integer.parseInt(indexs[0])]+"-"+ LocalTime.now().toString();
            content = hs_arr[Integer.parseInt(indexs[1])].concat("，").concat(hs_arr[Integer.parseInt(indexs[2])].concat("%，").concat(hs_arr[Integer.parseInt(indexs[3])]));
        }
        SimpleStockMqVO simpleStockMqVO = new SimpleStockMqVO(task.getSendMail(),
                subject,
                content,
                sourceMailInfo.getSourceMail(),
                sourceMailInfo.getPassword(),
                sourceMailInfo.getHost(),
                sourceMailInfo.getSmtpPort());

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
//        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", simpleStockMqVO.getMailHost());
//        props.setProperty("mail.smtp.port", simpleStockMqVO.getSmtpPort());
        //阿里云服务器禁用25端口，所以服务器上改为465端口
        props.put("mail.smtp.socketFactory.port", "468");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        Session session = Session.getInstance(props);
        javax.mail.Message msg = getMimeMessage(session, simpleStockMqVO);
        Transport transport = session.getTransport();
        transport.connect(simpleStockMqVO.getMailCode(), simpleStockMqVO.getPassword());
        transport.sendMessage(msg,msg.getAllRecipients());
        transport.close();
        LOGGER.info("发送成功");
    }

    @Override
    public int deleteOne(StockMailTaskReqVO stockMailTask) {
        return stockMailTaskMapper.updateTaskStatus(stockMailTask.getCronExpress(),stockMailTask.getSendMail());
    }

    @Override
    public int updateOne(StockMailTaskReqVO stockMailTask) {
        return stockMailTaskMapper.updateByPrimaryKeySelective(stockMailTask);
    }

    @Override
    public List<StockMailTask> listRightStockTask() {
//        Example example = new Example(StockMailTask.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("taskStatus","T");
//        example.setOrderByClause("id");
        return stockMailTaskMapper.listTask("T");
    }

    public MimeMessage getMimeMessage(Session session, SimpleStockMqVO simpleStockMqVO) throws Exception{
        //创建一封邮件的实例对象
        MimeMessage msg = new MimeMessage(session);
        //设置发件人地址
        msg.setFrom(new InternetAddress(simpleStockMqVO.getMailCode()));
        /**
         * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
         * MimeMessage.RecipientType.TO:发送
         * MimeMessage.RecipientType.CC：抄送
         * MimeMessage.RecipientType.BCC：密送
         */
//        msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(simpleStockMqVO.getReciveMail()));
        String[] mail = simpleStockMqVO.getReciveMail().split(",");
        Address[] to_mail = new InternetAddress[mail.length];
        for (int i = 0; i < to_mail.length; i++) { // 设置接收邮件人的地址
            to_mail[i] = new InternetAddress(String.valueOf(mail[i]));
        }
        msg.setRecipients(MimeMessage.RecipientType.TO,to_mail);
        //设置邮件主题
        msg.setSubject(simpleStockMqVO.getSubject(),"GBK");
        //设置邮件正文
        msg.setContent(simpleStockMqVO.getContent(), "text/html;charset=GBK");
        //设置邮件的发送时间,默认立即发送
//        msg.setSentDate(new Date());

        return msg;
    }
}
