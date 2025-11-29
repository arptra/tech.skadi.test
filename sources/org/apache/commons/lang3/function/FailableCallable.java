package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableCallable<R, E extends Throwable> {
    R call() throws Throwable;
}
