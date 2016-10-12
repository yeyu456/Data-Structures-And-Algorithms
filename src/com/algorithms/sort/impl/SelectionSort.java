package com.algorithms.sort.impl;

/**
 * Algorithms 4th Section 2.1.2 Selection Sort
 * 算法第4版 章节 2.1.2 选择排序
 */
public class SelectionSort extends BaseSort {

    public void sort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
                int tmp = data[min];
                data[min] = data[i];
                data[i] = tmp;
            }
        }
    }
}
