package com.algorithms.sort.insertion;

/**
 * Shell Sort Optimized Gap By Frank & Lazarus, 1960
 * 希尔排序优化间隔 - Frank & Lazarus, 1960
 */
public class ShellSortFL60 extends InsertionSortR1 {

    /**
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      h_k = 2 * Math.floor(N / (2^(k+1))) + 1, k >= 1
     * LaTeX格式:
     *      h_{k} = 2 \times \left \lfloor \frac {N} {2^{k+1}} \right \rfloor + 1, h_{k} \geqslant 1
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
        for (int i = 4; data.length / i * 2 + 1 > 0; i *= 2) {
            count += sortByGap(data, data.length / i * 2 + 1);
        }
        return count;
    }
}
