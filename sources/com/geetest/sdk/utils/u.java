package com.geetest.sdk.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class u {
    public static volatile u b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final ThreadFactory f = new a();
    public static final BlockingQueue g = new LinkedBlockingQueue(128);

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f2972a;

    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f2973a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SenseBotTask #" + this.f2973a.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        c = availableProcessors;
        d = Math.max(2, Math.min(availableProcessors - 1, 4));
        e = (availableProcessors * 2) + 1;
    }

    public u() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(d, e, 30, TimeUnit.SECONDS, g, f);
        this.f2972a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static u a() {
        if (b == null) {
            synchronized (u.class) {
                try {
                    if (b == null) {
                        b = new u();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void b(Runnable runnable) {
        if (runnable != null) {
            try {
                this.f2972a.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
