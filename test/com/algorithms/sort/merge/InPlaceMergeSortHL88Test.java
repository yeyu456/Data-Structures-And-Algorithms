package com.algorithms.sort.merge;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yuye on 2016/10/30.
 */
public class InPlaceMergeSortHL88Test {


    @Test
    public void sort() throws Exception {
        InPlaceMergeSortHL88 test = new InPlaceMergeSortHL88();
        test.sort(new int[]{1,2,3,4,5,6,7,8,9});
    }

}