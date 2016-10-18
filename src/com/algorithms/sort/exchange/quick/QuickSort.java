package com.algorithms.sort.exchange.quick;

import com.algorithms.random.lcg.LCG;
import com.algorithms.sort.Sort;

/**
 * Quick Sort Implement
 * 快速排序实现
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] data) {
        if (!valid(data)) {
            return;
        }
    }

    protected void shuffle(int[] data) {
        LCG random = new LCG();
        for (int i = 0; i < data.length; i++) {
            random.
        }
    }
}
