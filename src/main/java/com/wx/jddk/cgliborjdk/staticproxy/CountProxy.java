package com.wx.jddk.cgliborjdk.staticproxy;

/**
 * @author weixing
 * @date 2018/10/26
 **/
public class CountProxy implements Count {

    private Count count;

    public CountProxy(Count count) {
        this.count = count;
    }

    @Override
    public void queryCount() {
        System.out.println("before querycount");
        count.queryCount();
        System.out.println("after querycount");
    }

    @Override
    public void updateCount() {
        System.out.println("before updateCount");
        count.updateCount();
        System.out.println("after updateCount");
    }

    /**
     * 静态代理的缺点很明显：一个代理类只能对一个业务接口的实现类进行包装
     * ，如果有多个业务接口的话就要定义很多实现类和代理类才行。而且，如果
     * 代理类对业务方法的预处理、调用后操作都是一样的（比如：调用前输出提
     * 示、调用后自动关闭连接），则多个代理类就会有很多重复代码。这时我们
     * 可以定义这样一个代理类，它能代理所有实现类的方法调用：根据传进来的
     * 业务实现类和方法名进行具体调用。——那就是动态代理。
     * @param args
     */
    public static void main(String[] args) {
        Count count = new CountImpl();
        CountProxy countProxy = new CountProxy(count);
        countProxy.queryCount();
        countProxy.updateCount();
    }
}
