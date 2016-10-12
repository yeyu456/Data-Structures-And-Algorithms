package com.algorithms.sort;

/**
 * Sorting Interface
 * 排序接口
 */
public interface Sort {

    void sort(int[] data);

    default void swap(int index1, int index2, int[] data) {
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }
}
