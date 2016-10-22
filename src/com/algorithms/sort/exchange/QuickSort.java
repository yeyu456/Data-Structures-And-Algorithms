package com.algorithms.sort.exchange;

import com.algorithms.random.lcg.LCG;
import com.algorithms.sort.Sort;

/**
 * Quick Sort Implement
 * 快速排序实现
 */
public class QuickSort implements Sort {

    @Override
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        return count;
    }

    protected void shuffle(int[] data) {
        LCG random = new LCG();
        for (int i = 0; i < data.length; i++) {

        }
    }
}
