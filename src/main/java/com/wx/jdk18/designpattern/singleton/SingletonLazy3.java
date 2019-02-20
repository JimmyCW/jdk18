package com.wx.jdk18.designpattern.singleton;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class SingletonLazy3 {
    private static SingletonLazy3 INSTANCE;
    private SingletonLazy3() {
    }
    public static SingletonLazy3 getInstance() {
        if(INSTANCE == null) {
            synchronized (SingletonLazy3.class) {
                INSTANCE = new SingletonLazy3();
            }
        }
        return INSTANCE;
    }
}
