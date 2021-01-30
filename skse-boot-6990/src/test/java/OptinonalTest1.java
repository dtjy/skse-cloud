
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author skse
 * @date 2021/1/30 12:16
 */
public class OptinonalTest1 {

    @Test
    public void test1(){
        AtomicReference<String> str = new AtomicReference<>("abc");
        Person person = new Person(200,null);
        String integer = Optional.ofNullable(person)
                .map(p -> {
                    String temp = p.getName().toUpperCase(Locale.ROOT);
                    str.set(temp);
                    System.out.println(temp);
                    return String.valueOf(temp);
                })
                .orElse("100");

        System.out.println(integer);
        System.out.println(str.get());
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("a","b");

        AtomicReference<String> stringAtomicReference = new AtomicReference<>("");
        list.forEach( o -> {
            String temp = o.toUpperCase(Locale.ROOT);

            stringAtomicReference.set(stringAtomicReference.get()+temp);
//            str="";
        });

        System.out.println(stringAtomicReference.get());
    }
}
