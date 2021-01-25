package com.skse.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author jiangyao
 * @Date 2021/1/21 10:39
 **/
public class AtomicTest1 {
    public static void main(String[] args) {
//        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1,1);
//        atomicStampedReference.compareAndSet()
        Map map = getMap();
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
//        System.out.println((String)map.get("lat"));
        System.out.println(map.get("lat").toString());
//        new ArrayList<>().add()

//        new CopyOnWriteArrayList<>().add()
//        new ConcurrentHashMap<>()

    }

    private static Map getMap() {
        Map map = new HashMap();
        map.put("lat",121.154678);
        return map;
    }

}
