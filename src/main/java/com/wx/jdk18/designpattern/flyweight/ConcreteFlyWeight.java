package com.wx.jdk18.designpattern.flyweight;

/**
 * @author weixing
 * @date 2018/12/4
 **/
public class ConcreteFlyWeight implements FlyWeight{

    private String status;

    public ConcreteFlyWeight(String status) {
        this.status = status;
    }

    @Override
    public void operation(String status) {
        System.out.println(status);
        System.out.println(this.status);
    }
}
