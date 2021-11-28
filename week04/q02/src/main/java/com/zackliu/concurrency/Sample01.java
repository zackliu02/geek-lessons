package com.zackliu.concurrency;


import java.util.concurrent.atomic.AtomicInteger;


public class Sample01 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(() -> result.set(sum()));
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步计算结果为：" + result);
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
