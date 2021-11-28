package com.zackliu.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sample06 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        AtomicInteger result = new AtomicInteger(-1);

        Thread thread = new Thread(() -> {
            try {
                lock.lock();
                result.set(sum());
                condition.signal();
            } finally {
                lock.unlock();
            }
        });
        thread.start();

        try {
            lock.lock();
            condition.await();
            System.out.println("异步计算结果为：" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
