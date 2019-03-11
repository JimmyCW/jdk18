package com.wx.jddk.run;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weixing
 * @date 2019/3/7
 **/
public class OrderPrint {

    public static void main(String[] args) {
        AlternatePrint alternatePrint = new AlternatePrint();

        new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                alternatePrint.loopA(i);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                alternatePrint.loopB(i);
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                alternatePrint.loopC(i);
            }
        }, "C").start();

    }

}

class AlternatePrint {
    final Lock lock = new ReentrantLock();
    final Condition conditionA = lock.newCondition();
    final Condition conditionB = lock.newCondition();
    final Condition conditionC = lock.newCondition();

    int num = 1;

    public void loopA(int loop) {
        lock.lock();
        try {
            System.out.println("Aawake num = " + num);
            if(num != 1) {
                conditionA.await();
            }
            for(int i = 0; i < loop; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            num = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int loop) {
        lock.lock();
        try {
            System.out.println("Bawake num = " + num);
            if(num != 2) {
                conditionB.await();
            }

            for(int i = 0; i < loop; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            num = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int loop) {
        lock.lock();
        try {
            System.out.println("Cawake num = " + num);
            if(num != 3) {
                conditionC.await();
            }
            for(int i = 0; i < loop; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            num = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}