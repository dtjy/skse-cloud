package com.skse.test;

import com.skse.domain.Person;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author jiangyao
 * @Date 2021/1/29 17:16
 **/
public class Java8Test1 {

    public static void main(String[] args) {
        Person person = null;

        Person person1 = new Person();
//        Optional.ofNullable(person).map(Person::getAge).orElse(-1);
//        System.out.println( Optional.ofNullable(person).map(Person::getAge).orElse(-1));
//        System.out.println(Optional.ofNullable(person));

        Optional<Person> a = Optional.ofNullable(person);
        Optional<Person> b = Optional.ofNullable(person1);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());

//        System.out.println(a.map());
    }
}
