package com.wx.jddk.run;

/**
 * @author weixing
 * @date 2019/3/17
 **/
public class DeamonThread {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
