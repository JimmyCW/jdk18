package com.wx.jdk18.designpattern.chainofresponsibility;

/**
 * @author weixing
 * @date 2019/2/22
 **/
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() % 2 == 1) {
            return true;
        }
        return false;
    }
}
