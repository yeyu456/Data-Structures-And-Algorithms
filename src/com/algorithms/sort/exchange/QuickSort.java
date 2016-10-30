package com.algorithms.sort.exchange;

import com.algorithms.sort.Sort;

import java.util.Random;

/**
 * Standard Quick Sort By C. A. R. Hoare, 1960
 * 标准快速排序实现 - C. A. R. Hoare, 1960
 */
public class QuickSort implements Sort {

    @Override
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        shuffle(data);
        quickSort(0, data.length - 1, data);
        return count;
    }

    protected void shuffle(int[] data) {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            int j = random.nextInt(data.length);
            swap(i, j, data);
        }
    }

    protected void quickSort(int lo, int hi, int[] data) {
        if (hi <= lo) {
            return;
        }
        int j = partitionByPivot(lo, hi, data[lo], data);
        quickSort(lo, j - 1, data);
        quickSort(j + 1, hi, data);
    }

    protected int partitionByPivot(int lo, int hi, int pivot, int[] data) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            do {
                i++;
            } while (data[i] < pivot && i < hi);
            do {
                j--;
            } while (data[j] > pivot && j > lo);
            if (i >= j) {
                swap(lo, j , data);
                return j;
            }
            swap(i, j, data);
        }
    }
}
