package com.company;

public class MyThread implements Runnable {
    private final int count;

    public MyThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i< count;i++){
            Main.increment();
//            System.out.println("Thread: "+ Thread.currentThread().getName()+ " " + i);
        }
        System.out.println("Thread: "+ Thread.currentThread().getName() + "finish");
    }
}
