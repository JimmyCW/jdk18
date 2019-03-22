package com.wx.jddk.run;

/**
 * @author weixing
 * @date 2019/3/17
 **/
public class DeadLock {
    public static void main(String[] args) {
        deaLock();
    }

    public static void deaLock() {
        final Object obj1 = "obj1";
        final Object obj2 = "obj2";
        Thread t1 = new Thread(()->{
            synchronized (obj1) {
                System.out.println("thread 1 lock obj1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("thread 1 lock obj2");
                }
            }
        });
        Thread t2 = new Thread(() ->{
            synchronized (obj2) {
                System.out.println("thread 2 lock obj2");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("thread 2 lock obj1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
