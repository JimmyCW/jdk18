package com.wx.jdk18.designpattern.singleton;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class SingletonLazy4 {
    private volatile static SingletonLazy4 INSTANCE;
    private SingletonLazy4() {
    }
    public static SingletonLazy4 getInstance() {
        if(INSTANCE == null) {
            synchronized (SingletonLazy4.class) {
                INSTANCE = new SingletonLazy4();
            }
        }
        return INSTANCE;
    }
}
