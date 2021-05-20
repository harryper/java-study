package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author harryper
 * @date 2021/5/10
 */
public class T3 {
    public static int lengthOfLongestSubstring(String s) {
        // 右指针，长度
        int rp = 0, length = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            while (rp < s.length()) {
                // 如果集合中不包含元素则添加，包含则移除最前的元素
                if (!set.contains(s.charAt(rp))) {
                    set.add(s.charAt(rp));
                    rp ++;
                } else {
                    length = Math.max(length, set.size());
                    set.remove(s.charAt(i));
                    break;
                }
            }
        }
        return Math.max(length, set.size());
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaa"));
    }
}
