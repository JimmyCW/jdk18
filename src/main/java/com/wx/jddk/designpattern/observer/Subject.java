package com.wx.jddk.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weixing
 * @date 2019/2/17
 **/
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if(this.state != state) {
            this.state = state;
            notifyAllObserver();
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObserver() {
        observers.stream().forEach(Observer::update);
    }
}
