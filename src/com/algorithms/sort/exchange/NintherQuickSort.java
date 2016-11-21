package com.algorithms.sort.exchange;

/**
 * Quick Sort Optimized With Chosen Median Of Medians Pivot By John Tukey, 1978
 * 快速排序优化 - 选择分区中值数的中值数作为切分元素 - John Tukey, 1978
 */
public class NintherQuickSort extends MedianQuickSort {

    @Override
    protected void quickSort(int lo, int hi, int[] data) {
        if (hi <= lo) {
            return;
        }
        int interval = (hi - lo) / 3;
        int m1 = getMedian(lo, lo + interval / 2, lo + interval, data);
        int m2 = getMedian(lo + interval, lo + interval + interval / 2, lo + interval * 2, data);
        int m3 = getMedian(lo + interval * 2, lo + interval * 2 + (hi - lo + interval * 2) / 2, hi, data);
        int median = getMedian(m1, m2, m3, data);
        int j = partitionByPivot(lo, hi, data[median], data);
        quickSort(lo, j - 1, data);
        quickSort(j + 1, hi, data);
    }
}
