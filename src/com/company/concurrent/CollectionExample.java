package com.company.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollectionExample {
    private static Map map = new ConcurrentHashMap();//Collections.synchronizedMap(new HashMap());

    public static void put(Object key, Object value) {
        map.put(key, value);
    }

    public static Object get(Object key) {
        return map.get(key);
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        int countThread = 8;
        CountDownLatch cdl = new CountDownLatch(countThread);

        ExecutorService pool = Executors.newFixedThreadPool(countThread);
        for(int i = 0; i<8; i++) {
            pool.execute(() -> {
                for(int j = 0; j< 10000000; j++) {
                    int value = new Random().nextInt(100);
                    CollectionExample.put(value, value);

                    CollectionExample.get(value);
                }
                cdl.countDown();
            });
        }

        cdl.await();
        System.out.println("Time: " + (System.currentTimeMillis() - startTime));

        pool.shutdownNow();
    }
}
