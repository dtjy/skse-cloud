package com.skse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author jiangyao
 * @Date 2021/1/21 9:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private int age;
    private String sex;
    private String userCode;
    private String password;
    public void add(){
        this.age+=1;
    }

    public Person(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
