package com.wx.jddk.cgliborjdk.jdkproxy1;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author weixing
 * @date 2019/3/8
 **/
public class MoveCglib implements MethodInterceptor {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(this.target.getClass());
        return enhancer.create();
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("aaaaaa");
        Object a = proxy.invokeSuper(obj, args);
        System.out.println("bbbbbb");
        return a;
    }

    public static void main(String[] args) {
        Move move = new Run();
        MoveCglib moveCglib = new MoveCglib();
        Move bind = (Move) moveCglib.bind(move);
        bind.moveStraight();
    }
}
