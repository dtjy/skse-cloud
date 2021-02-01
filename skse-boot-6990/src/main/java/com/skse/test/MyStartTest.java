package com.skse.test;

import com.skse.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
@ConditionalOnProperty(name = "enable.autoConfiguration",matchIfMissing = true)
public class MyStartTest {
    public static AtomicInteger m = new AtomicInteger(0);
    public static AtomicInteger n = new AtomicInteger(0);
    static {
//        System.out.println("自定义初始化的autoconfig");
    }

    public static void main(String[] args) throws Exception{
//        AtomicInteger atomicBoolean = new AtomicInteger();
//        atomicBoolean.compareAndSet(1,2);
//        String pattern = "(\\d+)";
//        Pattern p = Pattern.compile(pattern);
//        Matcher m = p.matcher("科技信息化处2021年2月值班表");
//        m.find();
//        String excelYear = m.group();
//        m.find();
//        String excelMonth = m.group();
         final Person person = new Person(0,null);

        final AtomicReference<Person> atomicReference = new AtomicReference(person);
//        AtomicReference<Person> atomicReference1 = new AtomicReference(new Person(1));
////        atomicReference.compareAndSet()
        for (int i=0; i<20; i++){
            new Thread(()->{
                for (int j=1; j<=1000; j++){
//                    person.add();
                    Person p = new Person(atomicReference.get().getAge()+1,null);
//                    person.add();


//                   if (atomicReference.compareAndSet(atomicReference.get(),p)){
//                       m.incrementAndGet();
//                   }else {
//                       n.incrementAndGet();
//                   }
                    while(!atomicReference.compareAndSet(atomicReference.get(),p)){

                    }


//                    person = new Person(person.getAge()+1);
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("------------------------------------");
        System.out.println(((Person)(atomicReference.get())).getAge());
        System.out.println(m.get()+n.get());
//        int nowYear = LocalDate.now().getYear();
//        int nowMonth = LocalDate.now().getMonthValue();
//        if (new SimpleDateFormat("yyyy-MM").parse(excelYear+"-"+excelMonth).compareTo(new SimpleDateFormat("yyyy-MM").parse(nowYear+"-"+nowMonth))<=0){
//            System.out.println("jsss");
//        }
//        System.out.println(LocalDate.now().getMonthValue());
//        String pattern = "(\\d+)";
//        Pattern p = Pattern.compile(pattern);
//        Matcher m = p.matcher("科技信息化处2020年8月值班表");
//        m.find();
//        String year = m.group();
////        m.find();
//        String month = m.group();
//        System.out.println(year);
//        System.out.println(month);
//        if ("2021-01-20".compareTo("2021-01-20")<0||"2021-01-19".compareTo("2021-01-20")<0){
//            System.out.println("ssss");
//        }

//        String qDate = "2021-01-19";
//        String today= cn.hutool.core.date.DateUtil.today();
//        if (qDate.compareTo(today)<0){
//            System.out.println("xxxxx");
//        }
    }
}
