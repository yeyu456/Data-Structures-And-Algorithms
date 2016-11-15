package com.algorithms.search.binary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Fibonacci Search Test
 * 斐波那契搜索测试
 */
public class FibonacciSearchTest {
//
//    public int[] num;
//
//    @Before
//    public void init() {
//        int SIZE = 100000;
//        int MAX = 1000000;
//        this.num = new int[SIZE];
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < SIZE; i++) {
//            int n;
//            int min = -MAX;
//            if (i != 0) {
//                min = this.num[i - 1];
//            }
//            int max = MAX / SIZE * (i + 1);
//            do {
//                n = StdRandom.uniform(min, max);
//            } while (set.contains(n) || (i != 0 && n <= min));
//            set.add(n);
//            this.num[i] = n;
//        }
//    }
//
//    @Test(timeout = 1000)
//    public void search() throws Exception {
//        for(int i=0;i<this.num.length;i++) {
//            Assert.assertEquals(i, FibonacciSearch.search(this.num, this.num[i]));
//            int other = this.num[i]+1;
//            if (i+1 != this.num.length) {
//                while (other < this.num[i+1]) {
//                    Assert.assertEquals(-1, FibonacciSearch.search(this.num, other));
//                    other++;
//                }
//            }
//        }
//    }

}