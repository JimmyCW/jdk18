package com.wx.jdk18.designpattern.decorator;

/**
 * @author weixing
 * @date 2019/2/11
 **/
public class DecoratorComponent1 extends Decorator {

    public DecoratorComponent1(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doAnotherThing();
    }

    public void doAnotherThing() {
        System.out.println("doAnotherThing1");
    }
}
