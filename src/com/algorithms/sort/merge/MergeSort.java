package com.algorithms.sort.merge;

import com.algorithms.sort.Sort;

import java.util.Arrays;

/**
 * Merge Sort Implement
 * 归并排序实现
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

    public void bottom2top(int[] data) {
        if (!valid(data)) {
            return;
        }
        for (int i = 2; i < data.length; i = i + i) {
            for (int j = 0; j < data.length; j += i) {
                int end = j + i - 1;
                if (end > (data.length - 1)) {
                    end = data.length - 1;
                }
                merge(j, (j + end) / 2, end, data);
            }
        }
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
