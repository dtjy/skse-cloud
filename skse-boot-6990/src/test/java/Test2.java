import org.assertj.core.util.Lists;
import org.junit.Test;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author jiangyao
 * @Date 2021/2/1 13:41
 **/
public class Test2 {


    @Test
    public void test4(){
//        System.out.println(String.format("http://www.{0}.com","baidu"));
//        System.out.println(MessageFormat.format("http://www.{0}.{1}","baidu","com"));
        System.out.println(String.format("http://www.%s.com","baidu"));
    }
    @Test
    public void test3(){
        Map<String,String> map = new HashMap<>();
        map.put("a","aa");
        map.put("b","bb");
        map.put("c","cc");

        map.forEach((k, v) -> {
            System.out.println(k+"："+v);
        });
    }
    @Test
    public void test2(){
        List<String> list = Lists.newArrayList("a","b","c","d");
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            String str = iterator.next();
            System.out.println(str);
            iterator.remove();


            iterator.remove();
            System.out.println(str.length());
        }


//        System.out.println(list);

    }

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
