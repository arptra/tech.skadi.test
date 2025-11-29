package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableRunnable<E extends Throwable> {
    void run() throws Throwable;
}
