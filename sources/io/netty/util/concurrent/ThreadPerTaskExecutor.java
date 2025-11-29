package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public final class ThreadPerTaskExecutor implements Executor {
    private final ThreadFactory threadFactory;

    public ThreadPerTaskExecutor(ThreadFactory threadFactory2) {
        this.threadFactory = (ThreadFactory) ObjectUtil.checkNotNull(threadFactory2, "threadFactory");
    }

    public void execute(Runnable runnable) {
        this.threadFactory.newThread(runnable).start();
    }
}
