package com.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author harryper
 * @date 2021/5/19
 */
public class ArrayUtil {
    /**
     * 生产一个指定长度的随机数组
     * @param length
     * @return
     */
    public static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length);
        }
        return array;
    }

    /**
     * 交换
     * @param arr
     * @param left
     * @param right
     */
    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /**
     * 输出
     * @param arr
     */
    public static void sout(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1]);
    }

    /**
     * 给定一个数组，拷贝该数组，返回 java 自带排序后的新数组
     * @param arr
     * @return
     */
    public static int[] sortedArrayCopy(int[] arr) {
        int[] sorted = new int[arr.length];
        System.arraycopy(arr,0, sorted, 0, arr.length);
        Arrays.sort(sorted);
        return sorted;
    }

    /**
     * 比较两个数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean check(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
