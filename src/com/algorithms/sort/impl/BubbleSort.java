package com.algorithms.sort.impl;

import com.algorithms.sort.Sort;

/**
 * Bubble Sort Implement
 * 冒泡排序实现
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        boolean isSwapped;
        do {
            isSwapped = false;
            for (int i = 1; i < data.length; i++) {
                if (data[i - 1] > data[i]) {
                    swap(i - 1, i, data);
                    isSwapped = true;
                }
            }
        } while (isSwapped);
    }

    public void sortR1(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        boolean isSwapped;
        int n = data.length;
        do {
            isSwapped = false;
            int newN = n;
            for (int i = 1; i < n; i++) {
                if (data[i - 1] > data[i]) {
                    swap(i - 1, i, data);
                    isSwapped = true;
                    newN = i;
                }
            }
            n = newN;
        } while (isSwapped);
    }
}
