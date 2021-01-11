package com.company;

public class EndlessThread implements Runnable {
    private volatile boolean  finish = false;

    public void finishThread() {
        finish = true;
    }

    @Override
    public void run() {
        while(!finish) {
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
