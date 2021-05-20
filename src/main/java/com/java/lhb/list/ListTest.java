package com.java.lhb.list;

import java.util.*;

/**
 * @author harryper
 * @date 2020/9/14
 */
public class ListTest {

    public static void list() {
        String[] strings = new String[]{"hehe", "haha"};
        List<String> list = Arrays.asList(strings);

        list.forEach(System.out::println);

        // 使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方
        // 法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
        // 说明：asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList 体现的是适
        // 配器模式，只是转换接口，后台的数据仍是数组。
        list.add("lala");
    }

    public static void main(String[] args) {
        //list();
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(25, "小明"));
        list.add(new Person(23, "小明"));
        compare(list);
        //list.forEach(t -> System.out.println(t.getAge()));
    }

    public static void compare(List<Person> list) {
        // 如果返回正数，就从小到大，返回负数就从大到小
        Collections.sort(list, Comparator.comparing(Person::getAge));

        list.forEach(t -> System.out.println(t.getAge()));
    }


    static class Person {
        private int age;
        private String name;

        public Person() {
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
