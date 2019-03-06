package com.wx.jddk.cgliborjdk.jdkproxynew;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author weixing
 * @date 2018/11/28
 **/
public class BananaProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("a");
        Object a = method.invoke(target, args);
        System.out.println("b");
        return a;
    }

    public static void main(String[] args) {
        Fruit fruit = new Banana();
        BananaProxy bananaProxy = new BananaProxy();
        fruit = (Fruit) bananaProxy.bind(fruit);
        fruit.getType();
    }
}
