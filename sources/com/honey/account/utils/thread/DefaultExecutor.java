package com.honey.account.utils.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/honey/account/utils/thread/DefaultExecutor;", "Ljava/util/concurrent/Executor;", "()V", "mThreadPool", "Ljava/util/concurrent/ThreadPoolExecutor;", "execute", "", "command", "Ljava/lang/Runnable;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DefaultExecutor implements Executor {
    @NotNull
    public static final DefaultExecutor INSTANCE = new DefaultExecutor();
    @NotNull
    private static final ThreadPoolExecutor mThreadPool;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        mThreadPool = new ThreadPoolExecutor(availableProcessors, availableProcessors, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            @NotNull
            private final AtomicInteger threadCount = new AtomicInteger(0);

            @NotNull
            public Thread newThread(@Nullable Runnable runnable) {
                if (this.threadCount.get() == Integer.MAX_VALUE) {
                    this.threadCount.set(0);
                }
                return new Thread(runnable, "DefaultTask#" + this.threadCount.incrementAndGet());
            }
        });
    }

    private DefaultExecutor() {
    }

    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        mThreadPool.execute(runnable);
    }
}
