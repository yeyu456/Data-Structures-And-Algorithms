package com.algorithms.sort.exchange;

/**
 * Quick Sort Optimized With 3-Way Partition By Edsger Dijkstra, 1976
 * 快速排序优化 - 三向切分 - Edsger Dijkstra, 1976
 */
public class ThreeWayQuickSort extends QuickSort {

    @Override
    protected void quickSort(int lo, int hi, int[] data) {
        if (hi <= lo) {
            return;
        }
        int[] p = partitionByPivots(lo, hi, data[lo], data);
        quickSort(lo, p[0] - 1, data);
        quickSort(p[1] + 1, hi, data);
    }

    protected int[] partitionByPivots(int lo, int hi, int pivot, int[] data) {
        int i = lo;
        int lt = lo;
        int gt = hi;
        while (i <= gt) {
            if (data[i] < pivot) {
                swap(i, lt, data);
                i++;
                lt++;

            } else if (data[i] > pivot) {
                swap(i, gt, data);
                gt--;

            } else {
                i++;
            }
        }
        return new int[]{lt, gt};
    }
}
