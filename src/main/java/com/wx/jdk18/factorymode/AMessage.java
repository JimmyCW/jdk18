package com.wx.jdk18.factorymode;

public class AMessage implements IMessage {
    @Override
    public void send() {
        System.out.println("send a message");
    }

    public static void main(String[] args) {
        IFruit apple = Factory.getInstance("com.wx.jdk18.factorymode.Apple");
        apple.eat();

    }
}
