package com.java.lhb.integer;

/**
 * @author harryper
 * @date 2021/1/29
 */
public class IntegerTest {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = -1 >>> 1;

    public static void main(String[] args) {
        System.out.println("CAPACITY = " + CAPACITY);
    }
}
