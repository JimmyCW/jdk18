package com.wx.jdk18.designpattern.singleton;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class SingletonLazy {
    private static SingletonLazy INSTANCE;
    private SingletonLazy() {
    }
    public static SingletonLazy getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SingletonLazy();
        }
        return INSTANCE;
    }
}
