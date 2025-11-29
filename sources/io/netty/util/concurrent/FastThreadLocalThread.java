package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class FastThreadLocalThread extends Thread {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) FastThreadLocalThread.class);
    private final boolean cleanupFastThreadLocals = false;
    private InternalThreadLocalMap threadLocalMap;

    public FastThreadLocalThread() {
    }

    public final void setThreadLocalMap(InternalThreadLocalMap internalThreadLocalMap) {
        if (this != Thread.currentThread()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn((Throwable) new RuntimeException("It's not thread-safe to set 'threadLocalMap' which doesn't belong to the caller thread"));
            }
        }
        this.threadLocalMap = internalThreadLocalMap;
    }

    public final InternalThreadLocalMap threadLocalMap() {
        if (this != Thread.currentThread()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn((Throwable) new RuntimeException("It's not thread-safe to get 'threadLocalMap' which doesn't belong to the caller thread"));
            }
        }
        return this.threadLocalMap;
    }

    public boolean willCleanupFastThreadLocals() {
        return this.cleanupFastThreadLocals;
    }

    public static boolean willCleanupFastThreadLocals(Thread thread) {
        return (thread instanceof FastThreadLocalThread) && ((FastThreadLocalThread) thread).willCleanupFastThreadLocals();
    }

    public FastThreadLocalThread(Runnable runnable) {
        super(FastThreadLocalRunnable.wrap(runnable));
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable));
    }

    public FastThreadLocalThread(String str) {
        super(str);
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public FastThreadLocalThread(Runnable runnable, String str) {
        super(FastThreadLocalRunnable.wrap(runnable), str);
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable), str);
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable), str, j);
    }
}
