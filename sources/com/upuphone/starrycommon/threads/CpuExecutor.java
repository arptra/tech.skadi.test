package com.upuphone.starrycommon.threads;

import com.upuphone.starrycommon.utils.StarryCastLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class CpuExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6489a;
    public static final int b;
    public static final int c;
    public static final TimeUnit d = TimeUnit.SECONDS;
    public static final BlockingQueue e = new LinkedBlockingQueue();

    public static class CpuThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            long currentTimeMillis = System.currentTimeMillis();
            StarryCastLog.a("sz_thread_cpu: new thread -ts-" + currentTimeMillis);
            try {
                return new Thread(runnable, "SZ_Thread_CPU #ts-" + currentTimeMillis);
            } catch (Exception e) {
                StarryCastLog.a("SZ_Thread_CPU create error" + e.getMessage());
                return null;
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f6489a = availableProcessors;
        b = availableProcessors + 1;
        c = availableProcessors + 1;
    }
}
