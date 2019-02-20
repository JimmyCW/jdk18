package com.wx.jdk18.beanop;

import java.util.List;

/**
 * @author weixing
 * @date 2018/12/3
 **/
public class AClass {
    private String x;

    public <T> String output(List<? extends T> list) {
        return list.get(0).toString();
    }

}

interface BClass<T> {
    T output(T t);
}