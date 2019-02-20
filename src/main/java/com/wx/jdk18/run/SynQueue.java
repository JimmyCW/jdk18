package com.wx.jdk18.run;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weixing
 * @date 2018/12/4
 **/
public class SynQueue<E>  {
    private int size;
    private boolean isFull;
    private E[] queue;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public SynQueue() {
        this(10);
    }

    public SynQueue(int size) {
        this.size = size;
        queue = (E[]) new Object[size];
    }

    public boolean add(E e) {
        lock.lock();
        try {
            if(isFull) {
                return false;
            } else {
                E[] clonequeue = queue.clone();
                System.arraycopy(queue, 0, clonequeue, 1, queue.length - 1);
                clonequeue[0] = e;
                queue = clonequeue;
                if(queue.length == size) {
                    isFull = true;
                }
                return true;
            }
        } catch (Exception x) {
            x.printStackTrace();
        } finally {
            condition.signal();
        }
        return false;
    }

    public void print() {
        for(E e : queue) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        SynQueue<String> synQueue = new SynQueue<>(5);
        synQueue.add("a");
        synQueue.add("b");
        synQueue.print();

//        int[] a1 = {1,2,3};
//        int[] b1 = new int[5];
//        System.arraycopy(a1, 1, b1, 1, a1.length - 1);
//        System.out.println(b1);
    }


}
