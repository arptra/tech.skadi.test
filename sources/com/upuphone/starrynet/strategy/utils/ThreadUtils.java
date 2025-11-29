package com.upuphone.starrynet.strategy.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadUtils {
    private static final int CORE_SIZE;
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static ScheduledExecutorService poolService;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        CORE_SIZE = availableProcessors;
        poolService = Executors.newScheduledThreadPool(availableProcessors);
    }

    public static void runOnUIThread(Runnable runnable) {
        mainHandler.post(runnable);
    }

    public static void runOnUIThreadDelay(Runnable runnable, long j) {
        mainHandler.postDelayed(runnable, j);
    }

    public static void runOnWorkerThread(Runnable runnable) {
        poolService.execute(runnable);
    }

    public static void runOnWorkerThreadDelay(Runnable runnable, long j) {
        poolService.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
