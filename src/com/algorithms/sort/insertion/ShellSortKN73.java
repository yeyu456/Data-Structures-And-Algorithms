package com.algorithms.sort.insertion;

/**
 * Shell Sort Optimized Gap By Donald Ervin Knuth, 1973
 * 希尔排序优化间隔 - Donald Ervin Knuth, 1973
 */
public class ShellSortKN73 extends InsertionSortR1 {

    /**
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      h_k = (3^k - 1) / 2, h_k <= Math.ceil(N / 3)
     * LaTeX格式:
     *      h_{k} = \frac{3^{k} - 1}{2}, h_{k} \leq \left \lceil \frac{N}{3} \right \rceil
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
        while ((((3 << k) - 1) / 2) < data.length) {
            k++;
        }
        while (k > 0) {
            count += sortByGap(data, ((3 << k) - 1) / 2);
            k--;
        }
        return count;
    }
}
