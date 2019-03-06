package com.wx.jddk.designpattern.observer;

import java.util.Optional;

/**
 * @author weixing
 * @date 2019/2/17
 **/
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        super(subject);
        subject.addObserver(this);
    }

    @Override
    public void update() {
        Optional.of("Octal :" + Integer.toOctalString(subject.getState())).ifPresent(System.out::println);;
    }
}
