package com.wx.jdk18.cgliborjdk.jdkdynamicproxy;

/**
 * @author weixing
 * @date 2018/10/26
 *  JDK动态代理所用到的代理类在程序调用到代理类对象时
 *  才由JVM真正创建，JVM根据传进来的 业务实现类对象
 *  以及 方法名 ，动态地创建了一个代理类的class文件
 *  并被字节码引擎执行，然后通过该代理类对象进行方法调用
 *
 **/
@FunctionalInterface
public interface BookFacade {

    void addBook();

}
