package com.java.lhb.thread;

/**
 * @author harryper
 * @date 2021/4/12
 */
public class VolatileTest {
    private static volatile boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {

            }
            System.out.println("flag changed.");
        }).start();
        Thread.sleep(1000);
        flag = false;
    }
}



