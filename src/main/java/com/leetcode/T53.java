package com.leetcode;

/**
 * @author harryper
 * @date 2021/5/13
 */
public class T53 {
    public static int maxSubArray(int[] nums) {
        // 前面已遍历的最大和
        int sum = 0;
        // 结果值
        int result = nums[0];
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            result = Math.max(sum, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, -1};
        int t = maxSubArray(array);
        System.out.println(t);
    }
}
