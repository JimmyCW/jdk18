package com.wx.jddk.factorymode;

public class AMessage implements IMessage, Cloneable {
    @Override
    public void send() {
        System.out.println("send a message");
    }



    public static void main1(String[] args) {
        IFruit apple = Factory.getInstance("com.wx.jddk.factorymode.Apple");
        apple.eat();
    }

    public AMessage() {}
    public AMessage(Integer i, Integer j, Integer m){//类型是必须是包装类型
        System.out.println(i + "" + j + m);
    }

    public static void main(String[] args) throws Exception {
//        Class<?> c = Class.forName("com.wx.jddk.factorymode.AMessage");
//        Constructor<?> constructor = c.getConstructor(Integer.class, Integer.class, Integer.class);
//        AMessage aMessage =
//                (AMessage) constructor.newInstance(1 , 2, 3);
        AMessage aMessage = Factory.getInstance1("com.wx.jddk.factorymode.AMessage", 1,2,3);
        aMessage.send();
    }
}
