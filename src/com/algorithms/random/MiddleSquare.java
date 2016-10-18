package com.algorithms.random;

/**
 * Pseudo Random Number Generate Algorithm - Middle Square Method
 * 伪随机数生成算法-平方取中方法
 */
public class MiddleSquare implements Random {

    private long seed;

    /**
     * 设置随机种子
     * @param seed 随机种子
     */
    @Override
    public void setSeed(long seed) {
        this.seed = seed;
    }

    @Override
    public long next() {
        long square = this.seed * this.seed;
        int m = String.valueOf(this.seed).length();
        String numStr = String.format("%0" + (m * 2) + "d", square);
        numStr = numStr.substring(m / 2, m / 2 + m);
        this.seed = Long.parseLong(numStr);
        return this.seed;
    }
}
