package com.wx.jddk.cgliborjdk.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author weixing
 * @date 2018/11/28
 **/
public class BookFacadeCglib implements MethodInterceptor {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("aaaaaaaaaaaaaaaaa");
        Object a = methodProxy.invokeSuper(o, objects);
        System.out.println("bbbbbbbbbbbbbbbbb");
        return a;
    }

    public static void main(String[] args) {
        BookFacadeImpl bookFacade = new BookFacadeImpl();
        BookFacadeCglib bookFacadeCglib = new BookFacadeCglib();
        ((BookFacadeImpl)bookFacadeCglib.bind(bookFacade)).addBook();
    }

}
