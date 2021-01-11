package com.company.sync;

public class ThreadLoader implements Runnable {
    private final CommonRes commonRes;

    public ThreadLoader(CommonRes commonRes) {
        this.commonRes = commonRes;
    }

    @Override
    public void run() {
        for(int i = 1; i <=10; i++) {
            System.out.println("Loaded "+ i*10 + "%");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ThreadLoader finish");
        commonRes.setResult("Final result!");
        synchronized (commonRes) {
            commonRes.notifyAll();
        }
    }
}
