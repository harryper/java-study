package com.lhb.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author harryper
 * @date 2020/8/3
 * 测试开启 accessible 与关闭的性能
 */
@SuppressWarnings("all")
public class ReflectionAccessibleTest {

    public static void test1() {
        Person person = new Person();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            person.getAge();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("普通方式调用一亿次花费时间为：" + (endTime - startTime) + "ms");
    }

    public static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();

        Method getAge = aClass.getDeclaredMethod("getAge", null);
        getAge.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getAge.invoke(person, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("关闭检查反射调用一亿次花费时间为：" + (endTime - startTime) + "ms");

    }

    public static void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();

        Method getAge = aClass.getDeclaredMethod("getAge", null);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getAge.invoke(person, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射调用一亿次花费时间为：" + (endTime - startTime) + "ms");

    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test1();
        test3();
        test2();
    }

}
