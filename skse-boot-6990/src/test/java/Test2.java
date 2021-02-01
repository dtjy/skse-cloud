import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author jiangyao
 * @Date 2021/2/1 13:41
 **/
public class Test2 {

    @Test
    public void test1(){
        SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        // 2020年12月26日周六
        c.set(Calendar.DATE, 26);
        System.out.println("YYYY-MM-dd = " + df1.format(c.getTime()));
        System.out.println("yyyy-MM-dd = " + df2.format(c.getTime()));

        // 分割线
        System.out.println("========================");

        // 2020年12月27日 周日
        c.add(Calendar.DATE, 1);
        System.out.println("YYYY-MM-dd = " + df1.format(c.getTime()));
        System.out.println("yyyy-MM-dd = " + df2.format(c.getTime()));

    }
}
