package com.wx.jddk.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weixing
 * @date 2019/3/1
 **/
public class CareTaker {
    private List<Memento> mementos = new ArrayList<>();

    public void add(Memento memento) {
        mementos.add(memento);
    }

    public Memento get(int index) {
        return mementos.get(index);
    }

}
