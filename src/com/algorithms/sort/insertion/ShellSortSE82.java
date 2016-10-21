package com.algorithms.sort.insertion;

/**
 * Shell Sort Optimized Gap By Sedgewick, 1982
 * 希尔排序优化间隔 - Sedgewick, 1982
 */
public class ShellSortSE82 extends InsertionSortR1 {

    /**
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      h_k = 4^k + 3 * 2^(k-1) + 1, h_k < N
     * LaTeX格式:
     *      h_{k} = 4 ^ {k} + 3 \times 2 ^ {k-1} + 1, h_{k} < N
     *
     * @param data 待排序数组
     * @return 排序主要语句执行次数
     */
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        int k = 1;
        while (((4 << k) + 3 * (2 << k - 1) + 1) < data.length) {
            k++;
        }
        while (k > 0) {
            count += sortByGap(data, ((4 << k) + 3 * (2 << k - 1) + 1));
            k--;
        }
        count += sortByGap(data, 1);
        return count;
    }
}
