package com.wx.jddk.run;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author weixing
 * @date 2018/12/4
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(5);

        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
                countDownLatch.countDown();
                long count = countDownLatch.getCount();
                System.out.println(count);
            } catch (Exception e) {

            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
                countDownLatch.countDown();
                long count = countDownLatch.getCount();
                System.out.println(count);
            } catch (Exception e) {

            }
        }).start();
        try {
            System.out.println("等待2个子线程执行完毕...");
            countDownLatch.await(10, TimeUnit.SECONDS);
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (Exception e) {

        }
    }
}
