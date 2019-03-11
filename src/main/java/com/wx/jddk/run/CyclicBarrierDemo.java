package com.wx.jddk.run;

import java.util.concurrent.CyclicBarrier;

/**
 * @author weixing
 * @date 2019/3/7
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //回环栅栏
        int num = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num, () ->{
            System.out.println("rrrrrrrrrrrrrrrrr");
        });
        for(int i = 0; i < num; i++) {
            new Thread(new Writer(cyclicBarrier, i * 1000)).start();
        }
    }

    static class Writer implements Runnable {

        int i;

        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier, int i) {
            this.cyclicBarrier = cyclicBarrier;
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("thread " + Thread.currentThread().getName() + " writing data..");
            try {
                Thread.sleep(i);
                System.out.println(" thread " + Thread.currentThread().getName() + " written over..");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
