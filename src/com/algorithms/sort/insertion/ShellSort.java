package com.algorithms.sort.insertion;

import com.algorithms.sort.Sort;

/**
 * Shell Sort Implement
 * 希尔排序实现
 */
public class ShellSort extends InsertionSort {

    /**
     * By Donald L. Shell, 1959
     * @param data 待排序数组
     */
    @Override
    public void sort(int[] data) {
        if (!valid(data)) {
            return;
        }
        for (int i = 2; data.length / i > 0; i*=2) {
            sortByGap(data, data.length / i);
        }
    }

    /**
     * By Frank & Lazarus, 1960
     * @param data 待排序数组
     */
    public void fl60(int[] data) {
        if (!valid(data)) {
            return;
        }
        for (int i = 4; data.length / i * 2 + 1 > 0; i*=2) {
            sortByGap(data, data.length / i * 2 + 1);
        }
    }

    /**
     * By Hibbard, 1963
     * @param data 待排序数组
     */
    public void hi63(int[] data) {
        if (!valid(data)) {
            return;
        }
        int k = 1;
        while (((2 << k) - 1) < data.length) {
            k++;
        }
        while (k > 0) {
            sortByGap(data, (2 << k) - 1);
            k--;
        }
    }

    /**
     * By Papernov & Stasevich, 1965
     * @param data 待排序数组
     */
    public void ps65(int[] data) {
        if (!valid(data)) {
            return;
        }
        int k = 1;
        while (((2 << k) + 1) < data.length) {
            k++;
        }
        while (k > 0) {
            sortByGap(data, (2 << k) + 1);
            k--;
        }
        sortByGap(data, 1);
    }

    /**
     * By Vaughan Pratt, 1971
     * @param data 待排序数组
     */
    public void pt71(int[] data) {
        if (!valid(data)) {
            return;
        }
        int k = 1;
        while ((((3 << k) - 1) / 2) < data.length) {
            k++;
        }
        while (k > 0) {
            sortByGap(data, ((3 << k) - 1) / 2);
            k--;
        }
    }

    /**
     * By Sedgewick, 1986
     * @param data 待排序数组
     */
    public void se86(int[] data) {
        if (!valid(data)) {
            return;
        }
    }

    public void se98(int[] data) {
        if (!valid(data)) {
            return;
        }
        int k = 1;
        while (((4 << k) + 3 * (2 << k - 1) + 1) < data.length) {
            k++;
        }
        while (k > 0) {
            sortByGap(data, ((4 << k) + 3 * (2 << k - 1) + 1));
            k--;
        }
        sortByGap(data, 1);
    }
}
