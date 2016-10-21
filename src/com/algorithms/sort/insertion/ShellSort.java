package com.algorithms.sort.insertion;

/**
 * Standard Shell Sort By Donald L. Shell, 1959
 * 标准希尔排序 - Donald L. Shell, 1959
 */
public class ShellSort extends InsertionSortR1 {

    /**
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      h_k = Math.floor(N / (2^k)), k >= 1
     * LaTeX格式:
     *      h_{k} = \left \lfloor \frac {N} {2^{k}} \right \rfloor, h_{k} \geqslant 1
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
        for (int i = 2; data.length / i > 0; i *= 2) {
            count += sortByGap(data, data.length / i);
        }
        return count;
    }
}
