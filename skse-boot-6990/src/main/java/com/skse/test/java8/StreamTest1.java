package com.skse.test.java8;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {

    public static void main(String[] args) {
        List<String> arrayList = Arrays.asList("abc","efg");

        arrayList.stream().forEach(s -> {
            s+=s;
        });

        Stream<String> stream = arrayList.stream();
        stream.parallel();
//        arrayList.stream().filter( s -> s.contains("a")).collect()

//        Thread thread = new Thread();
        Stream stream1 = Stream.of(1, 2, 3, 4, "ee");
    }
}

