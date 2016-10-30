package com.algorithms.sort.exchange;

import java.util.Random;

/**
 * Quick Sort Optimized By Chosen Randomly Pivot
 * 快速排序优化 - 随机选择切分元素
 */
public class RandomizedQuicksort extends QuickSort {

    @Override
    protected void quickSort(int lo, int hi, int[] data) {
        if (hi <= lo) {
            return;
        }
        int pivot = new Random().nextInt(hi - lo) + lo;
        int j = partitionByPivot(lo, hi, data[pivot], data);
        quickSort(lo, j - 1, data);
        quickSort(j + 1, hi, data);
    }
}
