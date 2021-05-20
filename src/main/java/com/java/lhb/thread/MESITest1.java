package com.java.lhb.thread;


import java.util.concurrent.CountDownLatch;

/**
 * 缓存一致性协议是读取缓存行来失效
 * @author harryper
 * @date 2021/4/13
 */
public class MESITest1 {
    private static Long count = 1_0000_0000L;

    @sun.misc.Contended
    private static class T {
        //public volatile long  p1,p2,p3,p4,p5,p6,p7;
        public volatile long x = 0L;
        //public volatile long  x1,x2,x3,x4,x5,x6,x7;
    }

    private static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                arr[0].x = i;
            }
            latch.countDown();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                arr[1].x = i;
            }
            latch.countDown();
        });

        final Long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        System.out.println((System.nanoTime() - start) / 100_0000L);
    }
}
