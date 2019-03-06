package com.wx.jddk.designpattern.decorator;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class Decorator implements Component {

    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
