package com.algorithms.sort;

/**
 * Sorting Interface
 * 排序接口
 */
public interface Sort {

    /**
     * 排序方法
     * @param data 待排序数组
     */
    void sort(int[] data);

    /**
     * 交换数组中的元素
     * @param index1 元素1的下标
     * @param index2 元素2的下标
     * @param data 待排序数组
     */
    default void swap(int index1, int index2, int[] data) {
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    default boolean valid(int[] data) {
        if (data == null || data.length <= 1) {
            return false;
        } else {
            return true;
        }
    }
}
