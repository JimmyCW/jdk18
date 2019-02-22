package com.wx.jdk18.designpattern.chainofresponsibility;

/**
 * @author weixing
 * @date 2019/2/22
 **/
public class LimitSupport extends Support{

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() < limit) {
            return true;
        }
        return false;
    }
}
