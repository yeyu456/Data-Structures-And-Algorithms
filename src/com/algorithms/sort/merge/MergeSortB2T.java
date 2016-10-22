package com.algorithms.sort.merge;

/**
 * Bottom to Top Non Recursive Merge Sort
 * 自底向上非递归归并排序
 */
public class MergeSortB2T extends MergeSort {

    @Override
    public long sort(int[] data) {
        if (!valid(data)) {
            return 0;
        }
        return bottom2top(0, data.length, data);
    }

    protected long bottom2top(int start, int end, int[] data) {
        long count = 0;
        for (int i = 1; i < end; i = i + i) {
            for (int j = start; j < (end - i); j += i + i) {
                int last = j + i + i - 1;
                if (last > (end - 1)) {
                    last = end - 1;
                }
                count += merge(j, j + i - 1, last, data);
            }
        }
        return count;
    }
}
