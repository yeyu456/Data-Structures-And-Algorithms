package com.algorithms.sort.exchange;

/**
 * Quick Sort Optimized By Chosen Median Pivot Of First, Middle And Last Element In Partition
 * 快速排序优化 - 选择分区中的第一个、中间和最后一个元素的中值数作为切分元素
 */
public class MedianQuickSort extends QuickSort {

    @Override
    protected void quickSort(int lo, int hi, int[] data) {
        if (hi <= lo) {
            return;
        }
        int median = getMedian(lo, lo + (hi - lo) / 2, hi, data);
        int j = partitionByPivot(lo, hi, data[median], data);
        quickSort(lo, j - 1, data);
        quickSort(j + 1, hi, data);
    }

    protected int getMedian(int lo, int mid, int hi, int[] data) {
        if (data[hi] < data[lo]) {
            swap(lo, hi, data);
        }
        if (data[mid] <data[lo]) {
            swap(lo, mid, data);
        }
        if (data[hi] < data[mid]) {
            swap(mid, hi, data);
        }
        return mid;
    }

}
