package com.java.lhb.finall;

/**
 * @author harryper
 * @date 2020/9/14
 */
public class FinalTest {

    public int finalTest(int a, final int b) {
        a = a == 0 ? 10 : a;
        // 报错 b = b == 0 ? 10 : b;
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(new FinalTest().finalTest(5, 20));
    }
}
