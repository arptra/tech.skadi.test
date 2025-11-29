package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableSupplier<R, E extends Throwable> {
    R get() throws Throwable;
}
