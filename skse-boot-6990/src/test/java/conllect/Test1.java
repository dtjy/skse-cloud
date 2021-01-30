package conllect;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author skse
 * @date 2021/1/30 21:27
 */
@Slf4j
public class Test1 {

    @Test
    public void test1(){
        List<String> list = Lists.list("asd");
        list.add("qwe");
    }

    @Test
    public void test2(){

        List<String> list = Lists.list("asd");
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        list.add("qwe");
        System.out.println(list);
        System.out.println(unmodifiableList);
        unmodifiableList.add("aaa");

    }

    @Test
    public void test3(){
        List<String> list = Collections.singletonList("stringLis");
        System.out.println(list.get(0));
//        list.add("qwe");
    }

    @Test
    public void test4(){
        Map<Object, Object> emptyMap = Collections.emptyMap();
        emptyMap.put("1",2);
//        Collections.checkedCollection()
    }

    @Test
    public void test5(){
        List<String> list = Lists.list("asd");
        ImmutableList<String> immutableList = ImmutableList.copyOf(list);
        immutableList.add("a");
    }

    @Test
    public void test6(){
        //1.8
        StringJoiner stringJoiner = new StringJoiner(",","{","}");
        stringJoiner.add("a");
        stringJoiner.add("b");
        stringJoiner.add(null);
        stringJoiner.add("v");
        System.out.println(stringJoiner.toString());
    }

    @Test
    public void test7(){
        //1.8
        StringJoiner stringJoiner = new StringJoiner(",","{","}").setEmptyValue("空");
//        stringJoiner.add("a");
//        stringJoiner.add("b");
//        stringJoiner.add(null);
//        stringJoiner.add("v");
        System.out.println(stringJoiner.toString());
    }


    @Test
    public void test8(){
//        Joiner joiner = Joiner.on(",").skipNulls(); //跳过null
        Joiner joiner = Joiner.on(",").useForNull("空"); //为null赋值
        String joinStr = joiner.join("A", null, "C");
        System.out.println(joinStr);
    }

    @Test
    public void test9(){
        Iterable<String> split = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("雷军,乔布斯,,   沉默王二");

        while (split.iterator().hasNext()){
            System.out.println(split.iterator().next());
        }

    }

    @Test
    public void test(){

    }
}
