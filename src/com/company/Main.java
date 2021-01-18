package com.company;

import com.company.sync.CommonRes;
import com.company.sync.ThreadHandler;
import com.company.sync.ThreadLoader;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void increment(){
        counter.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(new MyThread(100000));
        thread1.start();

        Thread thread2 = new Thread(new MyThread(100000));
        thread2.start();

//        EndlessThread et = new EndlessThread();
//        Thread endlessThread = new Thread(et);
//        endlessThread.start();
//
//        Thread.sleep(5000);
//        et.finishThread();

        thread1.join();
        thread2.join();

        System.out.println("Main thread finish " + counter+ " Time "+ (System.currentTimeMillis()-start));

//        CommonRes commonRes = new CommonRes();
//        new Thread(new ThreadHandler(commonRes)).start();
//        new Thread(new ThreadLoader(commonRes)).start();
    }
}
