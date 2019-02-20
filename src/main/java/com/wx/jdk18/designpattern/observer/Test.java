package com.wx.jdk18.designpattern.observer;

/**
 * @author weixing
 * @date 2019/2/17
 **/
public class Test {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer1 = new BinaryObserver(subject);
        Observer observer2 = new OctalObserver(subject);
        subject.setState(2);
        subject.setState(3);
        subject.setState(4);
    }
}
