package com.algorithms.random.lcg;

/**
 * Pseudo Random Number Generate Algorithm - Linear Congruential Generator(aka LCG)
 * 伪随机数生成算法-线性同余
 */
public class LCG {

    private long seed;
    private long mod;
    private long multiplier;
    private long increment;

    public LCG() {
        //DRAND48 LCG Parameters
        //Ref http://random.mat.sbg.ac.at/results/karl/server/node5.html#SECTION00052000000000000000
        this.mod = 2L << 48;
        this.multiplier = 25214903917L;
        this.increment = 11;
    }

    /**
     * 设置随机种子
     *
     * @param seed 随机种子
     */
    public void setSeed(long seed) {
        this.seed = seed;
    }

    public void setMod(long mod) {
        this.mod = mod;
    }

    public void setMultiplier(long multiplier) {
        this.multiplier = multiplier;
    }

    public void setIncrement(long increment) {
        this.increment = increment;
    }

    /**
     * 生成随机数
     *
     * @return 随机数
     */
    public long random() {
        this.seed = (this.multiplier * this.seed + this.increment) % this.mod;
        return this.seed;
    }
}
