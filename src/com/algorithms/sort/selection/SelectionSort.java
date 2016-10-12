package com.algorithms.sort.selection;

import com.algorithms.sort.Sort;

/**
 * Selection Sort Implement
 * 选择排序实现
 */
public class SelectionSort implements Sort {

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
            }
            int tmp = data[min];
            data[min] = data[i];
            data[i] = tmp;
        }
    }
}
