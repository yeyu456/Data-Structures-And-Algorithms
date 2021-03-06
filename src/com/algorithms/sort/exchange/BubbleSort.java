package com.algorithms.sort.exchange;

import com.algorithms.sort.Sort;

/**
 * Standard Bubble Sort
 * 标准冒泡排序
 */
public class BubbleSort implements Sort {

    @Override
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        boolean isSwapped;
        do {
            isSwapped = false;
            for (int i = 1; i < data.length; i++) {
                if (data[i - 1] > data[i]) {
                    swap(i - 1, i, data);
                    isSwapped = true;
                }
                count++;
            }
        } while (isSwapped);
        return count;
    }
}
