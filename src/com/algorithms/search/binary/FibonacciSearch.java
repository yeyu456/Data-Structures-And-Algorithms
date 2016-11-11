package com.algorithms.search.binary;

import java.util.Arrays;

/**
 * Fibonacci Search Implement In Ascending Order Array With Distinct Numbers
 * 升序排列的无重复数字数组中，基于斐波那契的二分搜索实现
 */
public class FibonacciSearch {

    /**
     * 基于斐波那契的二分搜索实现
     * @param data 数据集
     * @param num 查找数值
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    public static int search(int[] data, int num) {
        //In case of last element not being checked
        //防止最后一个元素没被检查到
        if (data[data.length-1] == num) {
            return data.length - 1;
        }



        //Find the two bigest fibonacci number
        //找出最大两个斐波那契数
        int k1 = 1; //F_k-1
        int k2 = 1; //F_k
        while (k2 < data.length) {
            int tmp = k2;
            k2 = k1 + k2;
            k1 = tmp;
        }

        //start index of checking range
        //检查的起始位置
        int i = -1;

        //check range[i, i+F_k]
        while(k2 > 1) {
            int k0 = k2 - k1; //(F_k-2)
            int index = i + k0;

            //In case of array out of bound
            //防止超出数组大小
            if (index > data.length - 1) {
                index = data.length - 1;
            }

            //Check i+(F_k-2)
            if (data[index] == num) {
                return index;

                //Check range [i, i+(F_k-2)]
            }  else if (data[index] > num) {
                k2 = k0;
                k1 -= k0;

                //Check range [i+(F_k-2), i+(F_k-2)+(F_k-1)]
            } else {
                k2 = k1;
                k1 = k0;
                i += k0;
            }
        }
        return -1;
    }
}
