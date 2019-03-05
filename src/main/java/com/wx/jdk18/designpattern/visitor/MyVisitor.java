package com.wx.jdk18.designpattern.visitor;

/**
 * @author weixing
 * @date 2019/3/5
 **/
public class MyVisitor implements Visitor {
    @Override
    public void visitor(Subject subject) {
        System.out.println("visit the sub " + subject.getSubject());
    }
}
