package com.wx.jddk.designpattern.state;

/**
 * @author weixing
 * @date 2019/3/3
 **/
public class State {

    private int state;

    public State(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void negative() {
        System.out.println("negative");
    }

    public void positive() {
        System.out.println("positive");
    }
}
