package com.wx.jddk.run;

import java.util.Date;
import java.util.function.BiFunction;

/**
 * @author weixing
 * @date 2018/10/20
 **/
public class Compare {
    public static void main(String[] args) throws Exception {

        BiFunction<String, String, String> mm = (String a, String b) -> {
            if(a.length() > b.length()) {
                return a;
            } else {
                return b;
            }
        };
        String x = mm.apply("aa", "c");
        System.out.println(x);

        Class<?> clazz = Class.forName("java.util.Date");
        Class<?> cls = new Date().getClass();
        Class c = Date.class;
        Object date = clazz.newInstance();
        System.out.println(date);
    }
}
