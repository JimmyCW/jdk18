package com.wx.jddk.run;

/**
 * @author weixing
 * @date 2019/3/17
 **/
public class ThreadTest {
    public static void main(String[] args) {
        Runnable runnable = () ->{
            System.out.println("a");
        };
        Thread t1 = new Thread(runnable);
        t1.run();
        t1.start();
    }

}
