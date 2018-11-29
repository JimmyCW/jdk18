package com.wx.jdk18.cgliborjdk.jdkproxynew;

/**
 * @author weixing
 * @date 2018/11/28
 **/
public class Banana implements Fruit {

    private final static String TYPE = "BANANA";

    @Override
    public String getType() {
        System.out.println(TYPE);
        return TYPE;
    }

    @Override
    public void disappear() {
        System.out.println("disappear");
    }
}
