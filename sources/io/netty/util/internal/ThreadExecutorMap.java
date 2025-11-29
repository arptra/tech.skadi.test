package io.netty.util.internal;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public final class ThreadExecutorMap {
    private static final FastThreadLocal<EventExecutor> mappings = new FastThreadLocal<>();

    private ThreadExecutorMap() {
    }

    public static Executor apply(final Executor executor, final EventExecutor eventExecutor) {
        ObjectUtil.checkNotNull(executor, "executor");
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        return new Executor() {
            public void execute(Runnable runnable) {
                executor.execute(ThreadExecutorMap.apply(runnable, eventExecutor));
            }
        };
    }

    public static EventExecutor currentExecutor() {
        return mappings.get();
    }

    /* access modifiers changed from: private */
    public static void setCurrentEventExecutor(EventExecutor eventExecutor) {
        mappings.set(eventExecutor);
    }

    public static Runnable apply(final Runnable runnable, final EventExecutor eventExecutor) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        return new Runnable() {
            public void run() {
                ThreadExecutorMap.setCurrentEventExecutor(eventExecutor);
                try {
                    runnable.run();
                } finally {
                    ThreadExecutorMap.setCurrentEventExecutor((EventExecutor) null);
                }
            }
        };
    }

    public static ThreadFactory apply(final ThreadFactory threadFactory, final EventExecutor eventExecutor) {
        ObjectUtil.checkNotNull(threadFactory, "command");
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return threadFactory.newThread(ThreadExecutorMap.apply(runnable, eventExecutor));
            }
        };
    }
}
