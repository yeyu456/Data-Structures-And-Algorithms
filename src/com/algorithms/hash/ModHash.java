package com.algorithms.hash;

/**
 * Division Method Hash Implement
 * 除留余数法的哈希实现
 */
public class ModHash {

    /**
     * 获取散列值
     * @param value 数值
     * @param M 被除数
     * @return 散列值
     */
    public static int hash(int value, int M) {
        return value % M ;
    }
}
