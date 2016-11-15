package com.algorithms.sort.exchange;

import java.util.Stack;

/**
 *  Qucik Sort Optimized With Stack
 *  快速排序优化 - 使用堆栈
 */
public class StackQuickSort extends QuickSort {

    @Override
    public long sort(int[] data) {
        long count = 0;
        if (!valid(data)) {
            return count;
        }
        shuffle(data);

        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{0, data.length - 1});
        do  {
            Integer[] bound = stack.pop();
            int low = bound[0];
            int hi = bound[1];
            while (low <= hi) {
                int pivot = partitionByPivot(low, hi, low, data);
                stack.push(new Integer[]{pivot + 1, hi});
                hi = pivot - 1;
                count++;
            }
        } while ((!stack.isEmpty()));
        return count;
    }
}
