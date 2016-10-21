package com.algorithms.sort.insertion;

/**
 * Shell Sort Optimized Gap By Tokuda, 1992
 * 希尔排序优化间隔 - Tokuda, 1992
 */
public class ShellSortTO92 extends InsertionSortR1 {

    /**
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      h_k = Math.ceil((9^k - 4^k) / (5 * 4^(k-1))), h_0 = N
     * LaTeX格式:
     *      h_{k} = \left \lceil \frac{9^{k} - 4^{k}}{5 \times 4^{k-1}} \right \rceil
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
        int k = 1;
        while (((9 << k) - (4 << k)) / (5 * (4 << (k - 1))) < data.length) {
            k++;
        }
        while (k > 0) {
            count += sortByGap(data, ((9 << k) - (4 << k)) / (5 * (4 << (k - 1))));
            k--;
        }
        return count;
    }
}
