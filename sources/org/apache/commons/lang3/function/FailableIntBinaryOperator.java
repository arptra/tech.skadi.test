package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableIntBinaryOperator<E extends Throwable> {
    int applyAsInt(int i, int i2) throws Throwable;
}
