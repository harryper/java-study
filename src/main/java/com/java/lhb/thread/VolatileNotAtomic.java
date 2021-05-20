package com.java.lhb.thread;

/**
 *     volatile 不是原子操作，它的英文本义是 挥发、不稳定的” 延伸意义为敏感的。当使用 volatile 修饰变量时
 *     意昧着任何对此变量的操作都会在内存中进行 不会产生副本 以保证共享变量的可见性，局部阻止了指令重排的发生。
 *     本例中的 count ++ 和 count -- 操作，需要有四步执行
 *          1，取到 count 的值压入栈顶
 *          2，常量 1 压入栈顶
 *          3，取出栈顶两个值相加
 *          4，将计算结果赋值给 count
 *     在这个过程中，其他线程有足够时间覆盖变量的值。
 *     要解决可用 synchronized 锁住 ++ 和 -- 操作
 * @author harryper
 * @date 2021/1/28
 */
public class VolatileNotAtomic {
    private static volatile long count = 0L;
    private static final int NUMBER = 10000000;

    public static void main(String[] args) {
        Thread thread = new SubtractThread();
        thread.start();

        for (int i = 0; i < NUMBER; i++) {
            synchronized (VolatileNotAtomic.class) {
                count ++;
            }
        }
        while (thread.isAlive()) {}
        System.out.println("count = " + count);
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                //synchronized (VolatileNotAtomic.class) {
                    count --;
                //}
            }
        }
    }
}
