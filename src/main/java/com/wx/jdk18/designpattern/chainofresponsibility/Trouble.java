package com.wx.jdk18.designpattern.chainofresponsibility;

/**
 * @author weixing
 * @date 2019/2/22
 **/
public class Trouble {
    private Integer number;

    public Trouble(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "number=" + number;
    }
}
