package com.wx.jdk18.cgliborjdk.staticproxy;

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

}
