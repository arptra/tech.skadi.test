package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableShortSupplier<E extends Throwable> {
    short getAsShort() throws Throwable;
}
