package com.wx.jddk.designpattern.decorator;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class ConcreteComponent implements Component {
    @Override
    public void doSomething() {
        System.out.println("do Something");
    }
}
