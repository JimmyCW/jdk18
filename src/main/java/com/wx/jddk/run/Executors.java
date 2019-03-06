package com.wx.jddk.run;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author weixing
 * @date 2018/12/4
 **/
public class Executors {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = java.util.concurrent.Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(() -> {
            System.out.println("aa");
            return "x";
        });
        System.out.println(future.get());
    }
}
