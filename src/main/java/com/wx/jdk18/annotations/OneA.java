package com.wx.jdk18.annotations;

/**
 * @author weixing
 * @date 2018/11/29
 **/
@One(real = true)
public class OneA {

    public static void main(String[] args) throws Exception{
        OneA oneA = OneA.class.newInstance();
        One one = oneA.getClass().getAnnotation(One.class);
        System.out.println(one.real());
    }
}
