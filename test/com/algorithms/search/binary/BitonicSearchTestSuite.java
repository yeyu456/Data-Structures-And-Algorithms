package com.algorithms.search.binary;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.HashSet;
import java.util.Set;

/**
 * Bitonic Array Search Test Suite
 * 双调数组搜索测试套件
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BitonicBruteForceSearch.class, BitonicBinarySearchTest.class})
public class BitonicSearchTestSuite {
//
//    public static int[] NUM;
//    public static int SEARCH_NUM;
//
//    @BeforeClass
//    public static void init() {
//        int SIZE = 1000000;
//        int MAX = 1000000000;
//        BitonicSearchTestSuite.NUM = new int[SIZE];
//
//        int MAX_INDEX = StdRandom.uniform(1, SIZE - 1);
//        Set<Integer> set = new HashSet<>();
//
//        //init increment part
//        //初始化递增部分
//        BitonicSearchTestSuite.initIncrementPart(set, MAX, MAX_INDEX);
//
//        //init max value
//        //初始化最大值
//        BitonicSearchTestSuite.NUM[MAX_INDEX] = MAX + 1;
//
//        //init decrement part
//        //初始化递减部分
//        BitonicSearchTestSuite.initDecrementPart(set, MAX, MAX_INDEX, SIZE);
//
//        //seach number
//        //搜索数值
//        int index = StdRandom.uniform(0, SIZE);
//        BitonicSearchTestSuite.SEARCH_NUM = BitonicSearchTestSuite.NUM[index];
//
//        //BitonicSearchTestSuite.debug();
//    }
//
//    private static void initIncrementPart(Set<Integer> set, int MAX, int MAX_INDEX) {
//        for (int i = 0; i < MAX_INDEX; i++) {
//            int n;
//            int min = -MAX;
//            if (i != 0) {
//                min = BitonicSearchTestSuite.NUM[i - 1];
//            }
//            int max = MAX / MAX_INDEX * (i + 1);
//            do {
//                n = StdRandom.uniform(min, max);
//            } while (set.contains(n) || (i != 0 && n <= min));
//            set.add(n);
//            BitonicSearchTestSuite.NUM[i] = n;
//        }
//    }
//
//    private static void initDecrementPart(Set<Integer> set, int MAX, int MAX_INDEX, int SIZE) {
//        for (int i = SIZE - 1; i > MAX_INDEX; i--) {
//            int n;
//            int min = -MAX;
//            if (i != SIZE - 1) {
//                min = BitonicSearchTestSuite.NUM[i + 1];
//            }
//            int max = MAX / (SIZE - MAX_INDEX) * (SIZE - i);
//            do {
//                n = StdRandom.uniform(min, max);
//            } while (set.contains(n) || (i != SIZE - 1 && n <= min));
//            set.add(n);
//            BitonicSearchTestSuite.NUM[i] = n;
//        }
//    }
//
//    private static void debug() {
//        System.out.println("search num:" + BitonicSearchTestSuite.SEARCH_NUM);
//        StringBuffer buff = new StringBuffer();
//        for(int i=0;i<BitonicSearchTestSuite.NUM.length;i++) {
//            buff.append(BitonicSearchTestSuite.NUM[i]).append(" ");
//            if (i % 10 == 0) {
//                buff.append("\n");
//            }
//        }
//        System.out.println(buff.toString());
//        System.out.flush();
//    }
}
