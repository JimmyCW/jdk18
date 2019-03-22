package com.wx.jddk.run;

import java.util.Arrays;

/**
 * @author weixing
 * @date 2019/3/16
 **/
public class ThreadGroupDemo {
    public static int a = 1;
    public static void main(String[] args) {
        new Thread(() ->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);
        try {
            add();
            System.out.println(a);
        } catch (Error e) {
            System.out.println(a);
            throw e;
        }
    }
    private static void add() {
        a++;
        add();
    }
}
