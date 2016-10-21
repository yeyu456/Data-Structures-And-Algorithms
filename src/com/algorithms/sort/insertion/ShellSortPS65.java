package com.algorithms.sort.insertion;

/**
 * Shell Sort Optimized Gap By Papernov & Stasevich, 1965
 * 希尔排序优化间隔 - Papernov & Stasevich, 1965
 */
public class ShellSortPS65 extends InsertionSortR1 {

    /**
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      h_k = 2^k + 1, h_k < N
     * LaTeX格式:
     *      h_{k} = 2^{k} + 1, h_{k} < N
     *
     * @param data 待排序数组
     * @return 排序主要语句执行次数
     */
    @Override
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        int k = 0;
        while (((2 << k) + 1) < data.length) {
            k++;
        }
        while (k >= 0) {
            count += sortByGap(data, (2 << k) + 1);
            k--;
        }
        return count;
    }
}
