package com.upuphone.ar.transcribe.audio.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/transcribe/audio/thread/AudioThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "<init>", "()V", "Ljava/lang/Runnable;", "r", "Ljava/lang/Thread;", "newThread", "(Ljava/lang/Runnable;)Ljava/lang/Thread;", "Ljava/util/concurrent/atomic/AtomicInteger;", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "poolNumber", "Ljava/lang/ThreadGroup;", "b", "Ljava/lang/ThreadGroup;", "group", "c", "threadNumber", "", "d", "Ljava/lang/String;", "namePrefix", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AudioThreadFactory implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f6024a;
    public ThreadGroup b;
    public final AtomicInteger c = new AtomicInteger(1);
    public String d;

    public AudioThreadFactory() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        this.f6024a = atomicInteger;
        SecurityManager securityManager = System.getSecurityManager();
        this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        int andIncrement = atomicInteger.getAndIncrement();
        this.d = "pool-" + andIncrement + "-thread-";
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.b;
        String str = this.d;
        int andIncrement = this.c.getAndIncrement();
        Thread thread = new Thread(threadGroup, runnable, str + andIncrement, 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 10) {
            thread.setPriority(10);
        }
        return thread;
    }
}
