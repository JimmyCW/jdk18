package com.wx.jdk18.run.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author weixing
 * @date 2018/12/4
 **/
public class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;

    private static final long HOLD = 500L;

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        //小于临界值，则不进行拆分，直接计算初始值到结束值之间所有数之和
        if(length <= HOLD){
            long sum = 0L;

            for (long i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        }else{  //大于临界值，取中间值进行拆分，递归调用
            long middle = (start + end) / 2;

            try {
                ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
                long a = left.fork().get(); //进行拆分，同时压入线程队列
                System.out.println(a);
                ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle+1, end);
                long b = right.fork().get(); //
                System.out.println(b);
                return left.join() + right.join();
            } catch (Exception e) {

            }
            return 0L;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinSumCalculate forkJoinSumCalculate = new ForkJoinSumCalculate(0, 1000L);
        Long a = forkJoinPool.invoke(forkJoinSumCalculate);
        System.out.println(a);
    }
}
