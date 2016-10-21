package com.algorithms.sort.selection;

import com.algorithms.sort.Sort;

/**
 * Standard Selection Sort
 * 标准选择排序
 */
public class SelectionSort implements Sort {

    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                    count++;
                }
            }
            int tmp = data[min];
            data[min] = data[i];
            data[i] = tmp;
        }
        return count;
    }
}
