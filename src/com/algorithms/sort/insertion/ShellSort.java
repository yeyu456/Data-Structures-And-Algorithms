package com.algorithms.sort.insertion;

/**
 * Standard Shell Sort And Its Optimizations
 * 标准希尔排序及其改进版本
 */
public class ShellSort extends InsertionSort {

    /**
     * By Donald L. Shell, 1959
     *
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      h_k = N / (2^k), k >= 1
     * Latex格式:
     *      h_{k} = \left \lfloor \frac {N} {2^{k}} \right \rfloor, h_{k} \geqslant 1
     *
     * @param data 待排序数组
     */
    @Override
    public void sort(int[] data) {
        if (!valid(data)) {
            return;
        }
        for (int i = 2; data.length / i > 0; i *= 2) {
            sortByGap(data, data.length / i);
        }
    }

    /**
     * By Frank & Lazarus, 1960
     *
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      h_k = 2 * (N / (2^(k+1))), k >= 1
     * Latex格式:
     *      h_{k} = 2 \times \left \lfloor \frac {N} {2^{k+1}} \right \rfloor + 1, h_{k} \geqslant 1
     *
     * @param data 待排序数组
     */
    public void fl60(int[] data) {
        if (!valid(data)) {
            return;
        }
        for (int i = 4; data.length / i * 2 + 1 > 0; i *= 2) {
            sortByGap(data, data.length / i * 2 + 1);
        }
    }

    /**
     * By Hibbard, 1963
     *
     * 假设 N 为给定数组长度
     * 排序间隔的表达式:
     *      h_k = 2^k - 1, h_k < N
     * Latex格式:
     *      h_{k} = 2^{k} - 1, h_{k} <  N
     *
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
     * By Pratt, 1971
     * @param data 待排序数组
     */
    public void pr71(int[] data) {
        if (!valid(data)) {
            return;
        }
    }

    /**
     * By Donald Ervin Knuth, 1973
     * @param data 待排序数组
     */
    public void kn73(int[] data) {
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
     * By Sedgewick, 1982
     * @param data 待排序数组
     */
    public void se82(int[] data) {
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

    /**
     * By Sedgewick, 1986
     * @param data 待排序数组
     */
    public void se86(int[] data) {
        if (!valid(data)) {
            return;
        }
        int k = -1;
        int gap;
        do {
            k++;
            if (k % 2 == 1) {
                gap = 8 * (2 << k) - 6 * (2 << ((k + 1) / 2)) + 1;
            } else {
                gap = 9 * (2 << k) - 9 * (2 << (k / 2)) + 1;
            }
        } while (gap < data.length);

        while (k >= 0) {
            if (k % 2 == 1) {
                gap = 8 * (2 << k) - 6 * (2 << ((k + 1) / 2)) + 1;
            } else {
                gap = 9 * (2 << k) - 9 * (2 << (k / 2)) + 1;
            }
            sortByGap(data, gap);
            k--;
        }
    }

    /**
     * By Gonnet & Baeza-Yates, 1991
     *
     * @param data 待排序数组
     */
    public void gb91(int[] data) {
        if (!valid(data)) {
            return;
        }
        int gap = data.length * 5 / 11;
        while (gap > 1) {
            sortByGap(data, gap);
            gap *= 5 / 11;
        }
        sortByGap(data, 1);
    }

    /**
     * By Tokuda, 1992
     *
     * @param data 待排序数组
     */
    public void to92(int[] data) {
        if (!valid(data)) {
            return;
        }
        int k = 1;
        while (((9 << k) - (4 << k)) / (5 * (4 << (k - 1))) < data.length) {
            k++;
        }
        while (k > 0) {
            sortByGap(data, ((9 << k) - (4 << k)) / (5 * (4 << (k - 1))));
            k--;
        }
    }

    /**
     * By Ciura, 2001
     * @param data 待排序数组
     */
    public void ci01(int[] data) {
        if (!valid(data)) {
            return;
        }
        int[] gap = new int[]{1, 4, 10, 23, 57, 132, 301, 701, 1750};
        for (int i = gap.length - 1; i >= 0; i--) {
            if (gap[i] < data.length) {
                sortByGap(data, gap[i]);
            }
        }
    }
}
