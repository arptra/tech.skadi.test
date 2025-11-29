package com.xjsd.xr.sapp.asr.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/xjsd/xr/sapp/asr/thread/ThreadPollHelper;", "", "()V", "newHighPrioritySingleThreadExecutor", "Ljava/util/concurrent/ExecutorService;", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ThreadPollHelper {
    @NotNull
    public static final ThreadPollHelper INSTANCE = new ThreadPollHelper();

    private ThreadPollHelper() {
    }

    @NotNull
    public final ExecutorService newHighPrioritySingleThreadExecutor() {
        return new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new AudioThreadFactory());
    }
}
