package com.algorithms.sort.merge;

/**
 * In-Place Merge Sort By M.A.Kronrod, 1969
 * 原地归并排序 - M.A.Kronrod, 1969
 */
public class MergeSortKR69 extends MergeSortB2T {

    @Override
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        int mid = data.length / 2;
        count += bottom2top(0, mid, data);
        // i < data.length - 1, 合并直到只剩最后一个元素
        for (int i = mid; i < data.length - 1; i += (data.length - i) / 2) {
            count += merge(0, i, (data.length - i) / 2 + i, data);
        }
        //合并最后一个元素
        count += merge(0, data.length - 2, data.length - 1, data);
        return count;
    }
}
