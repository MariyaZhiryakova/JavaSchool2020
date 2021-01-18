package com.company.concurrent;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            Thread.sleep(5000);
            return "Task result";
        };

        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<String> future = pool.submit(task);
        System.out.println(future.get());
        System.out.println("Main thread finish");
    }
}
