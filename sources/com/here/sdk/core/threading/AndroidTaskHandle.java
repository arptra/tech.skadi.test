package com.here.sdk.core.threading;

import java.util.concurrent.Future;

class AndroidTaskHandle implements TaskHandle {
    private final Future<?> mFuture;

    public AndroidTaskHandle(Future<?> future) {
        this.mFuture = future;
    }

    public boolean cancel() {
        return this.mFuture.cancel(false);
    }

    public boolean isCancelled() {
        return this.mFuture.isCancelled();
    }

    public boolean isFinished() {
        return this.mFuture.isDone();
    }
}
