package com.java.lhb.compare;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author harryper
 * @date 2021/4/20
 */
public class ComparableTest {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>((Integer o1, Integer o2) -> o1.compareTo(o2));

        set.add(2);
        set.add(1);
        set.add(3);
        set.add(4);

        set.forEach((integer -> System.out.println(integer)));
    }
}
