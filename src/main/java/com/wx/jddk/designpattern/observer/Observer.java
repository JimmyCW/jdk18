package com.wx.jddk.designpattern.observer;

/**
 * @author weixing
 * @date 2019/2/17
 **/
public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
    }

    public abstract void update();
}
