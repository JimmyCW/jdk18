package com.wx.jdk18.run;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author weixing
 * @date 2018/10/20
 **/
public class Compare {
    public static void main(String[] args) {

        BiFunction<String, String, String> mm = (String a, String b) -> {
            if(a.length() > b.length()) {
                return a;
            } else {
                return b;
            }
        };
        String x = mm.apply("aa", "c");
        System.out.println(x);

    }
}
