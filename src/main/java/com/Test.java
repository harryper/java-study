package com;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author harryper
 * @date 2021/5/13
 */
public class Test {
    public static void main(String[] args) {
        Deque<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println("-------------------");
        list.forEach(System.out::println);
    }
}
