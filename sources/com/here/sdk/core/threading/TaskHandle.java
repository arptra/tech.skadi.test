package com.here.sdk.core.threading;

public interface TaskHandle {
    boolean cancel();

    boolean isCancelled();

    boolean isFinished();
}
