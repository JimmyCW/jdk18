package com.wx.jdk18.factorymode;

public class Factory {

    public static <T> T getInstance(String className) {
        T t = null;
        try {
            t = (T) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
