package com.upuphone.starrycommon.threads;

import com.upuphone.starrycommon.utils.StarryCastLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class IoExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6490a;
    public static final int b;
    public static final int c;
    public static final TimeUnit d = TimeUnit.SECONDS;
    public static final BlockingQueue e = new LinkedBlockingQueue();

    public static class IoThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            long currentTimeMillis = System.currentTimeMillis();
            StarryCastLog.a("sz_thread_io: new thread -ts-" + currentTimeMillis);
            try {
                return new Thread(runnable, "SZ_Thread_IO #ts-" + currentTimeMillis);
            } catch (Exception e) {
                StarryCastLog.a("SZ_Thread_IO create error" + e.getMessage());
                return null;
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f6490a = availableProcessors;
        b = Math.max(2, Math.min(availableProcessors - 1, 4));
        c = (availableProcessors * 2) + 1;
    }
}
