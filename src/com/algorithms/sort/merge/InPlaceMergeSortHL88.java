package com.algorithms.sort.merge;

import com.algorithms.sort.Sort;

/**
 * Created by yuye on 2016/10/27.
 */
public class InPlaceMergeSortHL88 implements Sort {

    @Override
    public long sort(int[] data) {

        return  1;
    }

    private void getBuff(int[] data) {
        int blockSize = (int) Math.floor(Math.sqrt(data.length));
        int FStart = 0;
        int AEnd = data.length / 2;
        int BStart = AEnd + 1;

    }
}
