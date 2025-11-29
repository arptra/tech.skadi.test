package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableLongBinaryOperator<E extends Throwable> {
    long applyAsLong(long j, long j2) throws Throwable;
}
