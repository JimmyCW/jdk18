package com.wx.jdk18.designpattern.decorator;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class Test {
    public static void main(String[] args) {
        Component component = new DecoratorComponent2(new DecoratorComponent1(new ConcreteComponent()));
        component.doSomething();
    }
}
