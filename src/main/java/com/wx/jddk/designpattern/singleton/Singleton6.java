package com.wx.jddk.designpattern.singleton;

/**
 * @author weixing
 * @date 2019/3/28
 **/
public class Singleton6 {

    private Singleton6(){}

    private final static class SingleInstance {
        private static Singleton6 singleton6 = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return SingleInstance.singleton6;
    }
}
