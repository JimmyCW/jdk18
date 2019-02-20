package com.wx.jdk18.designpattern.adapter;

/**
 * @author weixing
 * @date 2019/2/19
 **/
public class PowerAdapter2 implements AC5 {
    private final AC220 ac220;

    public PowerAdapter2(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputAC5() {
        return ac220.output220()/5;
    }
}
