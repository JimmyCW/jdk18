package com.wx.jdk18.designpattern.order;

/**
 * @author weixing
 * @date 2019/2/22
 **/
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.execute();
    }

}
