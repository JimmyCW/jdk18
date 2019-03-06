package com.wx.jddk.designpattern.singleton;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class SingletonEnum {
    private SingletonEnum() {

    }

    public static SingletonEnum getInstance() {
        return Singleton.INSTANCE.instance;
    }

    private enum Singleton {
        INSTANCE;
        private final SingletonEnum instance;
        Singleton() {
            instance = new SingletonEnum();
        }
        public SingletonEnum getInstance() {
            return instance;
        }
    }


}
