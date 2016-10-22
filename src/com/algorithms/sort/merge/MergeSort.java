package com.algorithms.sort.merge;

import com.algorithms.sort.Sort;

import java.util.Arrays;

/**
 * Standard Merge Sort
 * 标准归并排序
 */
public class MergeSort implements Sort {

    @Override
    public long sort(int[] data) {
        if (!valid(data)) {
            return 0;
        }
        return top2bottom(0, data.length - 1, data);
    }

    private long top2bottom(int start, int end, int[] data) {
        if (start >= end) {
            return 0;
        }
        long count = 0;
        int mid = (start + end) / 2;
        count += top2bottom(start, mid, data);
        count += top2bottom(mid + 1, end, data);
        count += merge(start, mid, end, data);
        return count;
    }

    protected long merge(int start, int mid, int end, int[] data) {
        long count = 0;
        if (start >= end) {
            return count;
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
            count++;
        }
        return count;
    }
}
