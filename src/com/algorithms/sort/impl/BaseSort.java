package com.algorithms.sort.impl;

import com.algorithms.sort.Sort;

/**
 * Created by yuye on 2016/10/12.
 */
public abstract class BaseSort implements Sort {

    @Override
    public abstract void sort(int[] data);

    protected void swap(int index1, int index2, int[] data) {
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }
}
