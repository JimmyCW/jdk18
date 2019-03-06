package com.wx.jddk.designpattern.singleton;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class SingletonLazy1 {
    private static SingletonLazy1 INSTANCE;
    private SingletonLazy1() {
    }
    public synchronized static SingletonLazy1 getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SingletonLazy1();
        }
        return INSTANCE;
    }
}
