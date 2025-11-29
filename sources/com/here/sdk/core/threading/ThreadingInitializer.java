package com.here.sdk.core.threading;

public final class ThreadingInitializer {
    private ThreadingInitializer() {
    }

    public static void initialize() {
        Threading.setPlatformThreading(new AndroidPlatformThreading());
    }
}
