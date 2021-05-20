package com.java.lhb.thread;

import java.util.concurrent.*;

/**
 * @author harryper
 * @date 2021/4/7
 */
public class CallableTest {
    public static void main(String[] args) {
        // 缺点：必须从线程池获取线程执行。
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> submit = executorService.submit(new MyCallable());
        try {
            String result = submit.get();
            System.out.println("result = " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call invoke...");
        return "This is call.";
    }
}