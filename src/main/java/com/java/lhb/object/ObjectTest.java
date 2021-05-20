package com.java.lhb.object;

/**
 * @author harryper
 * @date 2020/9/28
 */
public class ObjectTest implements Cloneable {
    public static void main(String[] args) {
        Object o = new Object();

        ObjectTest objectTest = new ObjectTest();

        try {
            Object clone = objectTest.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
