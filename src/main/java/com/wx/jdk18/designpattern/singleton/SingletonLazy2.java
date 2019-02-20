package com.wx.jdk18.designpattern.singleton;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class SingletonLazy2 {
    private static SingletonLazy2 INSTANCE;
    private SingletonLazy2() {
    }
    //double check 可能会引起空指针异常
    public static SingletonLazy2 getInstance() {
        if(INSTANCE == null) {
            synchronized (SingletonLazy2.class) {
                if(INSTANCE == null) {
                    INSTANCE = new SingletonLazy2();
                }
            }
        }
        return INSTANCE;
    }
}
