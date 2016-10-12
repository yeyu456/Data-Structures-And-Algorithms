package com.algorithms.random;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Test with LCG
 * 线性同余方法测试
 */
public class LCGTest {

    @Test
    public void random() throws Exception {
        int size = 2000000;
        LCG lcg = new LCG();
        Set<Long> set = new HashSet<>();
        //Parameters come from 'Numerical Recipes'
        lcg.setMod(2L << 32);
        lcg.setMultiplier(1664525L);
        lcg.setIncrement(1013904223L);
        lcg.setSeed(0L);
        for (int j = 0; j < size; j++) {
            set.add(lcg.random());
        }
        Assert.assertEquals(set.size(), size);
    }

}