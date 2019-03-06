package com.wx.jddk.designpattern.visitor;

/**
 * @author weixing
 * @date 2019/3/5
 **/
public interface Subject {
    void accept(Visitor visitor);
    String getSubject();
}
