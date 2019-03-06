package com.wx.jddk.designpattern.chainofresponsibility;

/**
 * @author weixing
 * @date 2019/2/22
 **/
public class SpecialSupport extends Support {

    private int special;

    public SpecialSupport(String name, int special) {
        super(name);
        this.special = special;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(special == trouble.getNumber()) {
            return true;
        }
        return false;
    }
}
