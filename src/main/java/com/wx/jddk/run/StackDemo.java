package com.wx.jddk.run;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author weixing
 * @date 2019/3/16
 **/
public class StackDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("asd");
        });
        Thread thread1 = new Thread(() ->{
            System.out.println("bababa");
            thread.start();

        });

    }


}
