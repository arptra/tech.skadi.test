package com.upuphone.starrycommon.threads;

import com.upuphone.starrycommon.utils.StarryCastLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class SingleExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeUnit f6493a = TimeUnit.SECONDS;
    public static final BlockingQueue b = new LinkedBlockingQueue();

    public static class SingleThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            long currentTimeMillis = System.currentTimeMillis();
            StarryCastLog.a("sz_thread_single: new thread -ts-" + currentTimeMillis);
            try {
                return new Thread(runnable, "SZ_Thread_SINGLE #ts-" + currentTimeMillis);
            } catch (Exception e) {
                StarryCastLog.a("SZ_Thread_SINGLE create error" + e.getMessage());
                return null;
            }
        }
    }
}
