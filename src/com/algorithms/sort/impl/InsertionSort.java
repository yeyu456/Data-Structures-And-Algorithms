package com.algorithms.sort.impl;

import com.algorithms.sort.Sort;

/**
 * Insertion Sort Implement
 * 插入排序实现
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0 && data[j - 1] > data[j]; j--) {
                swap(j, j - 1, data);
            }
        }
    }

    public void sortR1(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 1; i < data.length; i++) {
            int index = i;
            int value = data[i];
            for (int j = i; j > 0 && data[j - 1] > value; j--) {
                data[j] = data[j-1];
                index = j - 1;
            }
            data[index] = value;
        }
    }
}
