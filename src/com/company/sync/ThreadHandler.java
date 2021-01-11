package com.company.sync;

public class ThreadHandler implements Runnable {
    private final CommonRes commonRes;

    public ThreadHandler(CommonRes commonRes) {
        this.commonRes = commonRes;
    }

    @Override
    public void run() {
        synchronized (commonRes) {
            while(commonRes.getResult() == null) {
                System.out.println("Handler wait...");
                try {
                    commonRes.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Handler get result "+ commonRes.getResult());
    }
}
