package com.wx.jddk.cgliborjdk.jdkproxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author weixing
 * @date 2019/3/8
 **/
public class MoveProxy implements InvocationHandler {

    private Object target;


    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("aaaa");
        Object invoke = method.invoke(target, args);
        System.out.println("bbbb");
        return invoke;
    }

    public static void main(String[] args) {
        Move move = new Run();
        MoveProxy moveProxy = new MoveProxy();
        Move bind = (Move) moveProxy.bind(move);
        bind.moveStraight();
    }

}
