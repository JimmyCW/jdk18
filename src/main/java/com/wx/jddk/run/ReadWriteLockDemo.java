package com.wx.jddk.run;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author weixing
 * @date 2019/3/7
 **/
public class ReadWriteLockDemo {


    static class OperatorOfNumber {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    }
}
