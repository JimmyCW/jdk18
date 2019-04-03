package com.wx.jddk.designpattern.cgliborjdk.staticproxy;

/**
 * @author weixing
 * @date 2018/10/26
 **/
public class CountImpl implements Count {

    @Override
    public void queryCount() {
        System.out.println("querycount");
    }

    @Override
    public void updateCount() {
        System.out.println("updatecount");
    }

    public static void main(String[] args) {
        CountImpl count = new CountImpl();
        Class<?>[] classes = count.getClass().getInterfaces();
        for(Class cla : classes) {
            System.out.println(cla.getName());
        }
    }

}
