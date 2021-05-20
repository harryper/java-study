package com.java.lhb.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author harryper
 * @date 2021/4/15
 */
public class ReentrantLockTest {

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Lock lock = new ReentrantLock();

        lock.lock();
        try {
            new Thread(() -> {
                for (int j = 0; j < 1000000000; j++) {
                    i++;
                }
            }).start();
        } finally {
            lock.unlock();
            latch.countDown();
        }

        lock.lock();
        try {
            new Thread(() -> {
                for (int j = 0; j < 1000000000; j++) {
                    i--;
                }
            }).start();
        } finally {
            lock.unlock();
            latch.countDown();
        }

        latch.await();
        System.out.println("i = " + i);
    }
}
