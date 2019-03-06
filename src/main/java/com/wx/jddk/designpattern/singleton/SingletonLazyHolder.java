package com.wx.jddk.designpattern.singleton;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class SingletonLazyHolder {
    private SingletonLazyHolder() {
    }

    private static class InstanceHolder {
        private final static SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }

    public static SingletonLazyHolder getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
