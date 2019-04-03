package com.wx.jddk.run;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author weixing
 * @date 2019/3/7
 **/
public class HashMapReader {

    private Map<String, String> map;

    private ReadWriteLock lock;

    public HashMapReader(ReadWriteLock lock) {
        this.map = new HashMap<>(30);
        this.lock = lock;
    }

    public String read(String key) {
        Lock readLock = this.lock.readLock();
        try {
            readLock.lock();
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void write(String key, String value) {
        Lock writeLock = this.lock.writeLock();
        try {
            writeLock.lock();
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public String toString() {
        return "HashMapReader{" +
                "map=" + map +
                '}';
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        HashMapReader hashMapReader = new HashMapReader(readWriteLock);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        executorService.submit(() -> {
           hashMapReader.write("a", "b");
           countDownLatch.countDown();
        });
        executorService.submit(() -> {
            hashMapReader.write("c", "d");
            countDownLatch.countDown();
        });
        executorService.submit(() -> {
            hashMapReader.write("e", "f");
            countDownLatch.countDown();
        });
        countDownLatch.await();
        System.out.println(hashMapReader.toString());
        Future<?> e = executorService.submit(() -> {
            return hashMapReader.read("e");
        });
        System.out.println(e.get());
        Thread.currentThread().interrupt();
    }

}

