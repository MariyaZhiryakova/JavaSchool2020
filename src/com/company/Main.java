package com.company;

import com.company.sync.CommonRes;
import com.company.sync.ThreadHandler;
import com.company.sync.ThreadLoader;

import java.util.logging.Handler;

public class Main {
    private static int counter = 0;

    public synchronized static void increment(){
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread(new MyThread(10000));
//        thread1.start();
//
//        Thread thread2 = new Thread(new MyThread(10000));
//        thread2.start();

//        EndlessThread et = new EndlessThread();
//        Thread endlessThread = new Thread(et);
//        endlessThread.start();
//
//        Thread.sleep(5000);
//        et.finishThread();

//        thread1.join();
//        thread2.join();
//
//        System.out.println("Main thread finish " + counter);

        CommonRes commonRes = new CommonRes();
        new Thread(new ThreadHandler(commonRes)).start();
        new Thread(new ThreadLoader(commonRes)).start();
    }
}
