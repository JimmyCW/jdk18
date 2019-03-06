package com.wx.jddk.cgliborjdk.jdkdynamicproxy;

/**
 * @author weixing
 * @date 2018/10/26
 **/
public class BookFacadeImpl implements BookFacade {

    @Override
    public void addBook() {
        System.out.println("add book mehod");
    }
}

