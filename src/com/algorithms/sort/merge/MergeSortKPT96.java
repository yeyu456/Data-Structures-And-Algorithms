package com.algorithms.sort.merge;

/**
 * Merge Sort Optimized Reducing Movement With Multiple Way Merge By Katajainen, Pasanen & Teuhola, 1996
 * 多路归并排序 - Katajainen, Pasanen & Teuhola, 1996
 */
public class MergeSortKPT96 extends MergeSortB2T {

    @Override
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        int blockSize = data.length / ((int) Math.log(data.length));
        int start = 0;
        while (start + blockSize < data.length) {
            count += bottom2top(start, start + blockSize, data);
        }
        count += kWayMerge(blockSize, data);
        return count;
    }

    private long kWayMerge(int blockSize, int[] data) {
        long count = 0;

    }
}
