package com.wx.jdk18.designpattern.visitor;

/**
 * @author weixing
 * @date 2019/3/5
 **/
public class MySubject implements Subject {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    @Override
    public String getSubject() {
        return "mySubject";
    }
}
