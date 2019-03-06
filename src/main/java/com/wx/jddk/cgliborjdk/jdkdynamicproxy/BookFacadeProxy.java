package com.wx.jddk.cgliborjdk.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author weixing
 * @date 2018/10/26
 **/
public class BookFacadeProxy implements InvocationHandler {
    private Object target;//业务实现类对象，用来调具体的业务方法

    /**
     * 绑定一个业务对象，并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        //通过反射机制，创建一个代理类对象实例并返回，用户进行方法调用时使用
        //创建代理对象时，需要传递该业务类的类加载器（用来获取业务实现类的元数据，在包装方法是调用真正的业务方法）、接口、handler实现类
        Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return obj;
    }

    private BookFacade bookFacade;

    private BookFacade getBookFacade() {
        return () ->
            System.out.println("a");

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("prepare to do sth.");
        result = method.invoke(target, args);
        System.out.println("after do sth.");
        return result;
    }

    public static void main(String[] args) {
        BookFacade bookFacade = new BookFacadeImpl();
        BookFacadeProxy  bookFacadeProxy = new BookFacadeProxy();
        BookFacade bookFacade1 = (BookFacade) bookFacadeProxy.bind(bookFacade);
        bookFacade1.addBook();
    }
}
