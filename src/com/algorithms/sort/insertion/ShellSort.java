package com.algorithms.sort.insertion;

import com.algorithms.sort.Sort;

/**
 * Shell Sort Implement
 * 希尔排序实现
 */
public class ShellSort implements Sort {

    /**
     * By Donald L. Shell, 1959
     * @param data 待排序数组
     */
    @Override
    public void sort(int[] data) {
        for (int i = 2; data.length / i > 0; i*=2) {
            sortByGap(data, data.length / i);
        }
    }

    /**
     * By Frank & Lazarus, 1960
     * @param data 待排序数组
     */
    public void sortR1(int[] data) {
        for (int i = 4; data.length / i * 2 + 1 > 0; i*=2) {
            sortByGap(data, data.length / i * 2 + 1);
        }
    }

    /**
     * By Hibbard, 1961
     * @param data 待排序数组
     */
    public void sortR2(int[] data) {

    }

    private void sortByGap(int[] data, int gap) {
        for (int i = gap; i < data.length; i++) {
            int index = i;
            int value = data[i];
            for (int j = i; j > 0 && data[j - gap] > data[j]; j -= gap) {
                data[j] = data[j - gap];
                index = j - gap;
            }
            data[index] = value;
        }
    }
}
