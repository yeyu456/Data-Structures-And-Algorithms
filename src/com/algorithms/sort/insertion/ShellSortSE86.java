package com.algorithms.sort.insertion;

/**
 * Shell Sort Optimized Gap By Sedgewick, 1986
 * 希尔排序优化间隔 - Sedgewick, 1986
 */
public class ShellSortSE86 extends InsertionSortR1 {

    /**
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      if k为奇数
     *          h_k = 8 * 2^k - 6 * (2^((k + 1) / 2)) + 1,
     *      k为偶数
     *          h_k = 9 * 2^k - 9 * (2^(k / 2)) + 1,
     *      h_k < N
     * LaTeX格式:
     *          h_{k} =
     *      \begin{cases}
     *          8 \times 2^{k} - 6 \times 2^{(k + 1) \div 2} + 1, & \text{if k is odd}\\
     *          9 \times 2^{k} - 9 \times 2^{k \div 2} + 1, & \text{if k is even}
     *      \end{cases},
     *          h_{k} < N
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
        int k = -1;
        int gap;
        do {
            k++;
            if (k % 2 == 1) {
                gap = 8 * (2 << k) - 6 * (2 << ((k + 1) / 2)) + 1;
            } else {
                gap = 9 * (2 << k) - 9 * (2 << (k / 2)) + 1;
            }
        } while (gap < data.length);

        while (k >= 0) {
            if (k % 2 == 1) {
                gap = 8 * (2 << k) - 6 * (2 << ((k + 1) / 2)) + 1;
            } else {
                gap = 9 * (2 << k) - 9 * (2 << (k / 2)) + 1;
            }
            count += sortByGap(data, gap);
            k--;
        }
        return count;
    }
}
