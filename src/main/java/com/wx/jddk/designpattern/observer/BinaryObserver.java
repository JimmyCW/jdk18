package com.wx.jddk.designpattern.observer;

import java.util.Optional;

/**
 * @author weixing
 * @date 2019/2/17
 **/
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
        subject.addObserver(this);
    }

    @Override
    public void update() {
        Optional.of("binary : " + Integer.toBinaryString(subject.getState())).ifPresent(System.out::println);
    }
}
