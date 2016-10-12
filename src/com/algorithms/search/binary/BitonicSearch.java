package com.algorithms.search.binary;

/**
 * Bitonic Array Search Implement
 * 双调数组查找实现
 */
public class BitonicSearch {

    /**
     * 暴力搜索实现
     * @param data 数据集
     * @param num 查找数值
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    public static int bruteForceSearch(int[] data, int num) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Invalid data array.");
        }

        for (int i=0;i<data.length;i++) {
            if (data[i] == num) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分搜索实现
     * @param data 数据集
     * @param num 查找数值
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    public static int binarySearch(int[] data, int num) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Invalid data array.");
        }

        int maxIndex = BitonicSearch.getMaxIndex(data);
        if (maxIndex == -1) {
            throw new IllegalArgumentException("Invalid bitonic data array.");

        } else if (num > data[maxIndex]) {
            return -1;

        } else if (num == data[maxIndex]) {
            return  maxIndex;

        } else {
            int index = searchIncrementPart(data, maxIndex, num);
            if (index == -1) {
                index = searchDecrementPart(data, maxIndex, num);
            }
            return index;
        }
    }

    /**
     * 找出双调数组中的最大数值的下标序号
     * @param data 数据集
     * @return (-1:找不到最大值;其他:最大数值的下标序号)
     */
    private static int getMaxIndex(int[] data) {
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] > data[mid - 1] &&
                    data[mid] > data[mid + 1]) {
                return mid;
            } else if (data[mid] < data[mid - 1]) {
                end = mid - 1;
            } else if (data[mid] < data[mid + 1]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 在双调数组递增部分查找
     * @param data 数据集
     * @param maxIndex 双调数组中的最大数值的下标序号
     * @param num 查找数值
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    private static int searchIncrementPart(int[] data, int maxIndex, int num) {
        int start = 0;
        int end = maxIndex - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] == num) {
                return mid;

            } else if (data[mid] > num) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 在双调数组递减部分查找
     * @param data 数据集
     * @param maxIndex 双调数组中的最大数值的下标序号
     * @param num 查找数值
     * @return (-1:查找数值不存在于数据集;其他:数值所在数据集的下标序号)
     */
    private static int searchDecrementPart(int[] data, int maxIndex, int num) {
        int start = maxIndex + 1;
        int end = data.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] == num) {
                return mid;

            } else if (data[mid] < num) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
