package com.algorithms.data;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Generate test data array
 * 构造测试数据数组
 */
public class DataRepository {

    /**
     * Generate random integer array with given size and max value
     * 根据提供的长度和最大值生成随机整数数组
     *
     * @param size 数组长度
     * @param max 最大值
     * @return 随机数组
     */
    public static int[] getRandomData(final int size, final int max) {
        Random random = new SecureRandom();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(max);
        }
        return data;
    }

    public static int[] getSortedData(final int size, final int max) {
        return Arrays.stream(getRandomData(size, max)).parallel().sorted().toArray();
    }

    public static int[] getReveredData(final int size, final int max) {
        final int[] data = getSortedData(size, max);
        return IntStream.range(0, data.length)
                .map(i -> data[data.length - i - 1])
                .toArray();
    }

    public static int[] getPartialSortedData(final int size, final int max, final int maxSortedSize) {
        return getPatternData(size, maxSortedSize, randomSize -> getSortedData(randomSize, max));
    }

    public static int[] getRepeatedData(int size, int max, int maxRepeatedSize) {
        Random random = new SecureRandom();

        int[] results = getPatternData(size, maxRepeatedSize, randomSize -> {
            int num = random.nextInt(max);
            return IntStream.range(0, randomSize)
                    .parallel()
                    .map(i -> num)
                    .toArray();
        });

        //get random repetead data array
        //生成随机分布的包含重复性数字的数组
        List<Integer> list = Arrays.stream(results)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(list, new SecureRandom());
        return list.stream().mapToInt(v -> v).toArray();
    }

    private static int[] getPatternData(int size, int maxPatternSize, IntFunction<int[]> patternFunc) {
        if (maxPatternSize >= size || maxPatternSize <= 1) {
            throw new IllegalArgumentException("Invalid pattern size");
        }
        int[] data = IntStream.range(0, (size + maxPatternSize - 1) / maxPatternSize)
                .parallel()
                .map(i -> getRandomSize(maxPatternSize))
                .mapToObj(patternFunc)
                .flatMapToInt(Arrays::stream)
                .toArray();

        //make sure the result array with given size
        //确保返回数组容量为提供的值
        if (data.length < size) {
            return arrayConcat(data, patternFunc.apply(size - data.length));

        } else {
            return data;
        }
    }

    private static int getRandomSize(final int maxSortedSize) {
        Random random = new SecureRandom();
        return random.nextInt(maxSortedSize - 2) + 2;
    }

    private static int[] arrayConcat(int[] a1, int[] a2) {
        int[] result = Arrays.copyOf(a1, a1.length + a2.length);
        System.arraycopy(a2, 0, result, a1.length, a2.length);
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(getRepeatedData(20, 1000, 10)).forEach(System.out::println);
    }
}
