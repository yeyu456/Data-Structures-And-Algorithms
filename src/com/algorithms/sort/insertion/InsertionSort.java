package com.algorithms.sort.insertion;

import com.algorithms.sort.Sort;

/**
 * Standard Insertion Sort
 * 标准插入排序
 */
public class InsertionSort implements Sort {

    @Override
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0 && data[j - 1] > data[j]; j--) {
                swap(j, j - 1, data);
                count++;
            }
        }
        return count;
    }
}
