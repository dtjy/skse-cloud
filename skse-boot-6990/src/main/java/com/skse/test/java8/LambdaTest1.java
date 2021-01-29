package com.skse.test.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Administrator
 */
@Slf4j
public class LambdaTest1 {

    public static void main(String[] args) {

        FunctionInterFace1 functionInterFace1 = (s) ->  s + s ;
        System.out.println(functionInterFace1.test("abc"));

//        FunctionInterFace1 functionInterFace1 = String ::  s + s ;

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        comparator.compare(1,2);

        Comparator<Integer> comparator1 = Integer :: compare;
//        Integer.compare()
//        Consumer
//        Supplier
//        Predicate
//        Function
//        Integer aa = 1;
//        aa.
//        Function<Integer,String> function = (in,str) -> Integer::e;
    }
}
