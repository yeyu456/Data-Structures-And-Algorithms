package com.algorithms.random;

/**
 * Pseudo Random Number Generate Interface
 * 伪随机数生成接口
 */
public interface Random {

    void setSeed(long seed);

    long next();

    int nextInt();

    double nextDouble();

}
