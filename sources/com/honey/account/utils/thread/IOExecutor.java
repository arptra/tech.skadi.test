package com.honey.account.utils.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/honey/account/utils/thread/IOExecutor;", "Ljava/util/concurrent/Executor;", "()V", "BLOCKING_COEFFICIENT", "", "DEFAULT_MAXIMUM_POOL_SIZE", "", "KEEP_ALIVE_TIME", "", "mThreadPool", "Ljava/util/concurrent/ThreadPoolExecutor;", "execute", "", "command", "Ljava/lang/Runnable;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IOExecutor implements Executor {
    private static final double BLOCKING_COEFFICIENT = 0.8d;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 10;
    @NotNull
    public static final IOExecutor INSTANCE = new IOExecutor();
    private static final long KEEP_ALIVE_TIME = 30;
    @NotNull
    private static final ThreadPoolExecutor mThreadPool;

    static {
        int availableProcessors = (int) (((double) Runtime.getRuntime().availableProcessors()) / 0.19999999999999996d);
        if (availableProcessors < 0) {
            availableProcessors = 10;
        }
        mThreadPool = new ThreadPoolExecutor(0, availableProcessors, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() {
            @NotNull
            private final AtomicInteger threadCount = new AtomicInteger(0);

            @NotNull
            public Thread newThread(@Nullable Runnable runnable) {
                if (this.threadCount.get() == Integer.MAX_VALUE) {
                    this.threadCount.set(0);
                }
                return new Thread(runnable, "IOTask#" + this.threadCount.incrementAndGet());
            }
        });
    }

    private IOExecutor() {
    }

    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        mThreadPool.execute(runnable);
    }
}
