import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author skse
 * @date 2021/1/31 15:17
 */
public class Test1 {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ThreadPoolExecutor poolExecutor =
            new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(1000), Executors.defaultThreadFactory());
    public static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    public static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
    @Test
    public void test() {

//        threadLocal.get();
//        threadLocal.set();

        while (true) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String dateString = simpleDateFormat.format(new Date());  //当前时间字符串
                    try {
                        System.out.println(dateString);
                        Date parseDate = simpleDateFormat.parse(dateString);  //当前时间字符串 转Date
                        String dateString2 = simpleDateFormat.format(parseDate); //当前时间字符串 转Date 转字符串
                        System.out.println(dateString.equals(dateString2));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Test
    public void test1() {

        stringThreadLocal.set("abc");

        integerThreadLocal.set(100);

        stringThreadLocal.get();
    }

}
