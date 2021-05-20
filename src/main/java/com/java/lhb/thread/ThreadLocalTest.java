package com.java.lhb.thread;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Java 有四种引用类型
 *      强引用 Object obj = new Object(); 不会被 GC 回收，即使内存溢出;
 *      软应用 SoftReference<Object> srf = new SoftReference<>(new Object()); 内存不足时会被 GC 回收，用作缓存;
 *      弱引用 WeakReference<Object> wrf = new WeakReference<>(new Object()); GC 发现时就会回收，ThreadLocal 底层避免 OOM 问题;
 *      虚引用 PhantomReference<Object> objectPhantomReference = new PhantomReference<>(new Object(), new ReferenceQueue<>()); 用作通知，管理直接内存，如 nio, netty
 * @author harryper
 * @date 2020/8/26
 */
public class ThreadLocalTest {
    static ThreadLocal<String> tl = new ThreadLocal();

    public static void main(String[] args) {
        PhantomReference<Object> objectPhantomReference = new PhantomReference<>(new Object(), new ReferenceQueue<>());

        new Thread(() -> {
            try {

                Thread.sleep(2000);
                System.out.println("tl 的值为: " + tl.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(500);
                tl.set("哈哈哈哈");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
