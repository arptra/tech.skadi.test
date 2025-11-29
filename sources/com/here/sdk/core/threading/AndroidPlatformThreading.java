package com.here.sdk.core.threading;

public class AndroidPlatformThreading implements PlatformThreading {
    public TaskHandle postToMainThread(Runnable runnable, long j) {
        return MainThreadTaskRunner.post(runnable, j);
    }

    public TaskHandle runOnMainThread(Runnable runnable) {
        return MainThreadTaskRunner.run(runnable);
    }

    public TaskHandle postToMainThread(Runnable runnable) {
        return postToMainThread(runnable, 0);
    }
}
