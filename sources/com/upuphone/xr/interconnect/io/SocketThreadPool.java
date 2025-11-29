package com.upuphone.xr.interconnect.io;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class SocketThreadPool {
    private final ExecutorService mIOExecutors;
    private Object mLock;
    private Handler mMainHandler;

    public static class SocketThreadPoolHolder {
        public static final SocketThreadPool INSTANCE = new SocketThreadPool();

        private SocketThreadPoolHolder() {
        }
    }

    @NonNull
    public static SocketThreadPool getInstance() {
        return SocketThreadPoolHolder.INSTANCE;
    }

    public void executeOnDiskIo(Runnable runnable) {
        this.mIOExecutors.execute(runnable);
    }

    public void postToMainThread(Runnable runnable) {
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.post(runnable);
            return;
        }
        synchronized (this.mLock) {
            try {
                if (this.mMainHandler == null) {
                    this.mMainHandler = new Handler(Looper.getMainLooper());
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.mMainHandler.post(runnable);
    }

    private SocketThreadPool() {
        this.mIOExecutors = Executors.newCachedThreadPool(new ThreadFactory() {
            private static final String THREAD_NAME_STEM = "socket_thread_%d";
            private final AtomicInteger mThreadId = new AtomicInteger(0);

            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName(String.format(THREAD_NAME_STEM, new Object[]{Integer.valueOf(this.mThreadId.getAndIncrement())}));
                return thread;
            }
        });
        this.mLock = new Object();
    }
}
