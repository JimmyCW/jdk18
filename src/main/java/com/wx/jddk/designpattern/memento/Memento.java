package com.wx.jddk.designpattern.memento;

/**
 * @author weixing
 * @date 2019/3/1
 **/
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
