package com.wx.jddk.designpattern.memento;

/**
 * @author weixing
 * @date 2019/3/1
 **/
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public String getStateFromMemento(Memento memento) {
        return state = memento.getState();
    }

}
