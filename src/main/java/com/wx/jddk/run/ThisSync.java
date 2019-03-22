package com.wx.jddk.run;

/**
 * @author weixing
 * @date 2019/3/17
 **/
public class ThisSync {
    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread(() -> {
            ThisLock.m1();
        }).start();
        new Thread(() ->{
            ThisLock.m2();
        }).start();
    }
}

class ThisLock {

    private final static Object LOCK = new Object();

    public static synchronized void m1() {
        System.out.println("m1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m2() {
        synchronized (LOCK) {
            System.out.println("m2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
