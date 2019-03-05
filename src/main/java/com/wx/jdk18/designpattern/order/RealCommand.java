package com.wx.jdk18.designpattern.order;

/**
 * @author weixing
 * @date 2019/2/22
 **/
public class RealCommand implements Command{

    private Recevier recevier;

    public RealCommand(Recevier recevier) {
        this.recevier = recevier;
    }

    @Override
    public void execute() {
        recevier.action();
    }
}
