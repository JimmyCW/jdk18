package com.wx.jddk.run;

import java.util.stream.IntStream;

/**
 * @author weixing
 * @date 2019/3/17
 **/
public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            IntStream.range(0, 100).forEach(
                    i->{
                        System.out.println(Thread.currentThread().getName() + i);
                    }
            );
        });
        t1.start();
        t1.join();
        System.out.println("aaaaaaaaaaaa");
        System.out.println("bbb");
    }
}
