package com.xjsd.xr.sapp.asr.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/xjsd/xr/sapp/asr/thread/AudioThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "()V", "group", "Ljava/lang/ThreadGroup;", "namePrefix", "", "poolNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNumber", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AudioThreadFactory implements ThreadFactory {
    @Nullable
    private ThreadGroup group;
    @Nullable
    private String namePrefix;
    @NotNull
    private final AtomicInteger poolNumber;
    @NotNull
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public AudioThreadFactory() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        this.poolNumber = atomicInteger;
        SecurityManager securityManager = System.getSecurityManager();
        this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = "pool-" + atomicInteger.getAndIncrement() + "-thread-";
    }

    @Nullable
    public Thread newThread(@Nullable Runnable runnable) {
        ThreadGroup threadGroup = this.group;
        Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 10) {
            thread.setPriority(10);
        }
        return thread;
    }
}
