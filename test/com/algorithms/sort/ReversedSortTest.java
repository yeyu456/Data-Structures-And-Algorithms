package com.algorithms.sort;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by yu on 2016/10/21.
 */
public class ReversedSortTest {

    private List<int[]> dataList = null;

    @BeforeClass
    public void init() {
        this.dataList = new ArrayList<>();
        this.dataList.add(getReversedData(1000));
        this.dataList.add(getReversedData(10000));
        this.dataList.add(getReversedData(100000));
    }

    @Test
    public void selectionSort() {
        long[] count = new long[this.dataList.size()];
        for (int[] data : this.dataList) {

        }
    }

    private int[] getReversedData(int size) {
        int[] data = new int[size];
        Random random = new Random();
        int min = 0;
        int gap = Integer.MAX_VALUE / 1000;
        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = random.nextInt((gap + 1)) + min;
            min += gap;
        }
        return data;
    }
}