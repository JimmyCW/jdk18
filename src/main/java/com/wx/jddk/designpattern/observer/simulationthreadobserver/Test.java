package com.wx.jddk.designpattern.observer.simulationthreadobserver;

import java.util.Arrays;

/**
 * @author weixing
 * @date 2019/2/17
 **/
public class Test {

    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1", "2"));


    }
}
