package com.algorithms.sort.insertion;

/**
 * Shell Sort Optimized Gap By Gonnet & Baeza-Yates, 1991
 * 希尔排序优化间隔 - Gonnet & Baeza-Yates, 1991
 */
public class ShellSortGB91 extends InsertionSortR1 {

    /**
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      h_k = 2 * Math.floor(N / (2^(k+1))) + 1, k >= 1
     * LaTeX格式:
     *      h_{k} = \max \left \{ \left \lfloor \frac{5 \times h_{k-1}}{11} \right \rfloor, 1 \right \}, h_{0} = N
     *
     * @param data 待排序数组
     * @return 排序主要语句执行次数
     */
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        int gap = data.length * 5 / 11;
        while (gap > 1) {
            count += sortByGap(data, gap);
            gap *= 5 / 11;
        }
        count += sortByGap(data, 1);
        return count;
    }
}
