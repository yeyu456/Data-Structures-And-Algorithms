package com.algorithms.sort.merge;

import com.algorithms.sort.Sort;

import java.util.Arrays;

/**
 * Standard Merge Sort And Its Optimizations
 * 标准归并排序及其改进版本
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] data) {
        if (!valid(data)) {
            return;
        }
        top2bottom(0, data.length - 1, data);
    }

    private void top2bottom(int start, int end, int[] data) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        top2bottom(start, mid, data);
        top2bottom(mid + 1, end, data);
        merge(start, mid, end, data);
    }

    /**
     * 自底向上归并排序方法
     * @param data 待排序数组
     */
    public void bottom2top(int[] data) {
        if (!valid(data)) {
            return;
        }
        bottom2top(data.length, data);
    }

    private void bottom2top(int len, int[] data) {
        for (int i = 1; i < data.length; i = i + i) {
            for (int j = 0; j < (data.length - i); j += i + i) {
                int end = j + i + i - 1;
                if (end > (data.length - 1)) {
                    end = data.length - 1;
                }
                merge(j, j + i - 1, end, data);
            }
        }
    }

    /**
     * By M.A.Kronrod, 1969
     * @param data 待排序数组
     */
    public void kr69(int[] data) {
        if (!valid(data)) {
            return;
        }
        int mid = data.length / 2;
        bottom2top(mid, data);
        // i < data.length - 1, 合并直到只剩最后一个元素
        for (int i = mid; i < data.length - 1; i += (data.length - i) / 2) {
            merge(0, i, (data.length - i) / 2 + i, data);
        }
        //合并最后一个元素
        merge(0, data.length - 2, data.length - 1, data);
    }

    /**
     * By Katajainen, Pasanen & Teuhola, 1996
     * @param data 待排序数组
     */
    public void kpt96(int[] data) {

    }

    private void merge(int start, int mid, int end, int[] data) {
        if (start >= end) {
            return;
        }
        int[] tmp = Arrays.copyOfRange(data, start, end);
        int j = start;
        int k = mid + 1;
        for (int i = j; i <= end; i++) {
            if (j > mid) {
                data[i] = tmp[k];
                k++;
            } else if (k > end) {
                data[i] = tmp[j];
                j++;
            } else if (data[j] < data[k]) {
                data[i] = tmp[j];
                j++;
            } else {
                data[i] = tmp[k];
                k++;
            }
        }
    }
}
