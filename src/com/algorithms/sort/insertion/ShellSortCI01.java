package com.algorithms.sort.insertion;

/**
 * Shell Sort Optimized Gap By Ciura, 2001
 * 希尔排序优化间隔 - Ciura, 2001
 */
public class ShellSortCI01 extends InsertionSortR1 {

    /**
     *  使用实验出来的间隔 1, 4, 10, 23, 57, 132, 301, 701, 1750
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
        int[] gap = new int[]{1, 4, 10, 23, 57, 132, 301, 701, 1750};
        for (int i = gap.length - 1; i >= 0; i--) {
            if (gap[i] < data.length) {
                count += sortByGap(data, gap[i]);
            }
        }
        return count;
    }
}
