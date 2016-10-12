package com.algorithms.sort;

/**
 * Created by yuye on 2016/10/12.
 */
public interface Sort {

    public void sort(int[] data);

    default void swap(int index1, int index2, int[] data) {
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }
}
