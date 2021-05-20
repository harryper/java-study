package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。
 * 返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 例----
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * @author harryper
 * @date 2021/5/10
 */
public class T76 {

    public static String minWindow(String s, String t) {
        return null;
    }
    /**
     * f是否包含s中的所有元素
     * @param f
     * @param s
     * @return
     */
    public static boolean containsAll(List<Character> f, String s) {
        boolean contain = true;
        for (int i = 0; i < s.length(); i++) {
            if (f.contains(s.charAt(i))) {
                continue;
            }
            contain = false;
        }
        return contain;
    }

    /**
     * char list 转为 Stirng
     * @param list
     * @return
     */
    public static String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(t -> sb.append(t));
        return sb.toString();
    }

    public static void main(String[] args) {
      String s = "0012aabcdf";

      int[] need = new int[128];

        for (int i = 0; i < s.length(); i++) {
            need[s.charAt(i)]++;
        }

        for (int i = 0; i < need.length; i++) {
            System.out.println(need[i]);
        }
    }
}
