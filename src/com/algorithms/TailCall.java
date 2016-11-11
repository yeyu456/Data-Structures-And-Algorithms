package com.algorithms;

import java.util.stream.Stream;

/**
 * Functional Tail Recursive Optimazation In 'Functional Programming in Java' By Venkat Subramaniam
 * 函数式尾递归优化 - 《Functional Programming in Java》- Venkat Subramaniam
 */
@FunctionalInterface
public interface TailCall<T> {

    TailCall<T> apply();

    default boolean isComplete() {
        return false;
    }

    default T result() {
        throw new Error("No Implement.");
    }

    default T invoke() {
        return Stream.iterate(this, TailCall::apply)
                .filter(TailCall::isComplete)
                .findFirst()
                .get()
                .result();
    }
}
