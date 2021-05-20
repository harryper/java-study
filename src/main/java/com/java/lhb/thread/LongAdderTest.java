package com.java.lhb.thread;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author harryper
 * @date 2021/1/28
 */
public class LongAdderTest {

    private static LongAdder la = new LongAdder();
    private static final int NUMBER = 10000000;



    public static void main(String[] args) {
        Thread t1 = new Thread(new SubstractTest());
        t1.start();

        for (int i = 0; i < NUMBER; i++) {
            la.increment();
        }

        while (t1.isAlive()) {}
        System.out.println("la = " + la.longValue());
    }

    private static class SubstractTest implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                la.decrement();
            }

        }
    }
}
