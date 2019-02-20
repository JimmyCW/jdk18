package com.wx.jdk18.designpattern.singleton;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class SingletonHungry {
    private static final SingletonHungry INSTANCE = new SingletonHungry();
    private SingletonHungry() {

    }

    public static SingletonHungry getInstance() {
        return INSTANCE;
    }

}
