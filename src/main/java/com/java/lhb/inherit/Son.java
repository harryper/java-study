package com.java.lhb.inherit;

/**
 * @author harryper
 * @date 2021/5/7
 */
class Father {
    public Father() {
        this.out();
    }
    public void out() {
        System.out.println("Father");
    }
}
public class Son extends Father {
    public Son() {
        super();
    }

    @Override
    public void out() {
        System.out.println("Son");
    }
    public static void main(String[] args) {
        new Son();
    }
}
