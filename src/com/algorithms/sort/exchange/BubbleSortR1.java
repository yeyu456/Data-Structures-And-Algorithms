package com.algorithms.sort.exchange;

import com.algorithms.sort.Sort;

/**
 * Bubble Sort Optimized Last Swapped Elements
 * 冒泡排序优化最后交换过的元素
 */
public class BubbleSortR1 implements Sort {

    @Override
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        int n = data.length;
        do {
            int newN = n;
            for (int i = 1; i < n; i++) {
                if (data[i - 1] > data[i]) {
                    swap(i - 1, i, data);
                    newN = i;
                }
                count++;
            }
            n = newN;
        } while (n == 0);
        return count;
    }
}
