package com.algorithms.sort.insertion;

import com.algorithms.sort.Sort;

/**
 * Standard Insertion Sort And Its Optimizations
 * 标准插入排序及其改进版本
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] data) {
        if (!valid(data)) {
            return;
        }
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0 && data[j - 1] > data[j]; j--) {
                swap(j, j - 1, data);
            }
        }
    }

    public void sortR1(int[] data) {
        if (!valid(data)) {
            return;
        }
        sortByGap(data, 1);
    }

    public void sortByGap(int[] data, int gap) {
        for (int i = gap; i < data.length; i++) {
            int index = i;
            int value = data[i];
            for (int j = i; j > 0 && data[j - gap] > data[j]; j -= gap) {
                data[j] = data[j - gap];
                index = j - gap;
            }
            data[index] = value;
        }
    }
}
