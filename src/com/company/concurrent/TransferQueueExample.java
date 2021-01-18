package com.company.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueExample {
    static TransferQueue<Integer> queue = new LinkedTransferQueue<Integer>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Runnable producer = () -> {
            for (int i = 0;i< 2; i++) {
                try {
                    System.out.println("Producer "+ Thread.currentThread().getName()+ " start transfer"+ i);
                    queue.transfer(i);
                    System.out.println("Producer "+ Thread.currentThread().getName()+ " finish transfer"+ i);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = ()-> {
            for (int i = 0;i< 2; i++) {
                try {
                    System.out.println("Consumer "+ Thread.currentThread().getName()+ " wait element");
                    queue.take();
                    System.out.println("Consumer "+ Thread.currentThread().getName()+ " received"+ i);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        pool.execute(producer);
        pool.execute(consumer);

        pool.shutdown();
    }
}
