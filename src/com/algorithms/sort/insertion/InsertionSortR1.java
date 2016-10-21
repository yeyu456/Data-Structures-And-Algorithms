package com.algorithms.sort.insertion;

import com.algorithms.sort.Sort;

/**
 *  Insertion Sort Optimized Assignment Time
 *  插入排序-优化赋值次数
 */
public class InsertionSortR1 implements Sort {

    @Override
    public long sort(int[] data) {
        if (!valid(data)) {
            return 0;
        }
        return sortByGap(data, 1);
    }

    /**
     * 根据间隔对数据进行排序
     * @param data 待排序数组
     * @param gap 间隔
     * @return 排序主要语句执行次数
     */
    protected long sortByGap(int[] data, int gap) {
        long count = 0;
        for (int i = gap; i < data.length; i++) {
            int index = i;
            int value = data[i];
            for (int j = i; j > 0 && data[j - gap] > data[j]; j -= gap) {
                data[j] = data[j - gap];
                index = j - gap;
                count++;
            }
            data[index] = value;
        }
        return count;
    }
}
