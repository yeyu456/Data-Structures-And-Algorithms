package com.algorithms.sort.exchange;

import java.util.Random;

/**
 * Quick Sort Optimized By Chosen Middle Pivot
 * 快速排序优化 - 选择中间元素
 */
public class MiddleQuickSort extends QuickSort {

    @Override
    protected void quickSort(int lo, int hi, int[] data) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        int j = partitionByPivot(lo, hi, data[mid], data);
        quickSort(lo, j - 1, data);
        quickSort(j + 1, hi, data);
    }
}
