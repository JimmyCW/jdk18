package com.wx.jddk.designpattern.adapter;

/**
 * @author weixing
 * @date 2019/2/19
 **/
public class PowerAdapter1 extends AC220 implements AC5 {
    @Override
    public int outputAC5() {
        return output220()/5;
    }
}
