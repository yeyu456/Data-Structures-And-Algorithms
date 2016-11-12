package com.algorithms.data;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Generate test data array
 * 构造测试数据数组
 */
public class DataRepository {

    public static int[] getRandomData(int size, int max) {
        Random random = new SecureRandom();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(max);
        }
        return data;
    }

    public static int[] getSortedData(final int size, final int max) {
        final int[] data = getRandomData(size, max);
        return Arrays.stream(data).parallel().sorted().toArray();
    }

    public static int[] getReveredData(int size, int max) {
        final int[] data = getSortedData(size, max);
        return IntStream.range(0, data.length)
                .map(i -> data[data.length - i - 1])
                .toArray();
    }

    public static int[] getPartialSortedData(int size, final int max, int maxSortedSize) {
        if (maxSortedSize >= size || maxSortedSize <= 1) {
            throw new IllegalArgumentException("Invalid sorted size");
        }
        int[] sortedSize = new int[];
        final int[] data = new int[size];
        IntStream.range(0, (size + sortedSize - 1)/ sortedSize).parallel().forEach(i -> {
            int low = i * sortedSize;
            int partSize = sortedSize;
            if (partSize + low > data.length) {
                partSize = data.length - low;
            }
            final int[] partial = getSortedData(partSize, max);
            IntStream.range(0, partial.length).parallel().forEach(j -> data[low + j] = partial[j]);
        });
        return data;
    }

    public static int[] getRepeatedData(int size, int max, int repeatedSize) {

    }
}
