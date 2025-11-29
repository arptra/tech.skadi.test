package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableDoubleSupplier<E extends Throwable> {
    double getAsDouble() throws Throwable;
}
