package com.algorithm.sort;

/**
 * 选 泡 插
 * 快 归 堆 希 统 计 基
 *
 * @author harryper
 * @date 2021/5/1
 */
public class Sort {

    public static void main(String[] args) {
        //int[] array = {432, 43, 632, 15, 6424, 643245, 2, 5432, 673, 66732};

        for (int i = 10; i < 100; i++) {
            int[] array = ArrayUtil.generateRandomArray(i);
            int[] sortArray = ArrayUtil.sortedArrayCopy(array);

            // 自定义的排序

            // 选择排序
            selectionSort(array);

            if (!ArrayUtil.check(array, sortArray)) {
                System.out.println("算法校验失败");
                System.out.print("array : ");ArrayUtil.sout(array);
                System.out.print("\nsortArray : ");ArrayUtil.sout(sortArray);
                System.exit(0);
            }
        }
        System.out.println("算法成功");
    }

    /**
     * 选择排序，一遍又一遍的过滤数组，每次找到最小的数放到最前面。需要一个 index 记录每一轮循环最小值的下标
     * 时间复杂度 O(n * n)
     * 不稳定
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                index = arr[j] < arr[index] ? j : index;
            }
            ArrayUtil.swap(arr, i, index);
        }
    }

    /**
     * 冒泡排序，内层循环每次都从 1 到最后一个需要判断的元素，即：1->end。for (int i = 1; i < end; i++)
     * 因为每次循环结束最大的数已经排到最右边，所以每次的长度都要减 1；for (int end = arr.length(); end > 0; end --)
     * 时间复杂度：O(n * n)
     * 稳定
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        for (int end = arr.length; end > 0; end--) {
            for (int i = 1; i < end; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 插入排序，从第二个开始和前面的对比，直到找出合适的插入位置
     * 时间复杂度：O(n * n)
     * 稳定
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > cur) {
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = cur;
        }
        return array;
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) { return; }
        int partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, right);
    }

    /**
     * 左右分割数组
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {
        // 中心轴
        int pivot = arr[right];
        // 从左向右的指针
        int leftIndex = left;
        // 从右向左的指针
        int rightIndex = right - 1;

        for(;;) {
            // 如果左指针小于右边界 且 指针的当前值小于分割数，则向右偏移
            while (leftIndex < right && arr[leftIndex] <= pivot) {
                leftIndex ++;
            }
            // 如果右指针大于等于左边界 且 指针的当前值大于分割数，则向左偏移
            while (rightIndex >= left && arr[rightIndex] > pivot) {
                rightIndex --;
            }
            // 如果左指针大于右指针，则说明已经完成了所有遍历，停止
            if (leftIndex > rightIndex) {
                break;
            }
            // 如果左指针不大于右指针，则交换 左右指针数值，继续遍历
            ArrayUtil.swap(arr, leftIndex, rightIndex);
        }
        // 结束遍历，将分割值放到中间
        ArrayUtil.swap(arr, leftIndex, right);
        return leftIndex;
    }
}
