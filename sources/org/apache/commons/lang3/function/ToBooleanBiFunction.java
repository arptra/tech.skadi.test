package org.apache.commons.lang3.function;

@FunctionalInterface
public interface ToBooleanBiFunction<T, U> {
    boolean applyAsBoolean(T t, U u);
}
