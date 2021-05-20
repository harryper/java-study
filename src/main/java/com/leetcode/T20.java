package com.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author harryper
 * @date 2021/5/11
 */
public class T20 {

    public static boolean isValid(String s) {
        // 太费时间内存
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//            s = s.trim().replace("[]", "").replace("()", "").replace("{}", "");
//        }
//        return s.length() == 0;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("()()()()"));
    }
}
