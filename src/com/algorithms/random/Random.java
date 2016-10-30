package com.algorithms.random;

/**
 * Pseudo Random Number Generate Interface
 * 伪随机数生成接口
 */
public interface Random {


    /**
     * 设置随机种子
     * @param seed 随机种子
     */
    void setSeed(long seed);

    /**
     * 生成随机数
     * @return 随机数
     */
    long next();

    default int nextInt(int min, int max) {
        return new Long(next()).intValue() % (max - min) + min;
    }

    default double nextDouble(){
        return 0.0;
    }

}
