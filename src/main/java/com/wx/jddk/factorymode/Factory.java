package com.wx.jddk.factorymode;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

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

    public static <T> T getInstance1(String className, Object ... conpas) {
        T t = null;
        try {
            Class<?> c = Class.forName(className);
            List<Object> objectList = Arrays.asList(conpas);
            Class[] classes = new Class[conpas.length];
            for (int j = 0; j < conpas.length; j++) {
                classes[j] = objectList.get(j).getClass();
            }

            Constructor<?> constructor = c.getConstructor(classes);
            return (T) constructor.newInstance(conpas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
