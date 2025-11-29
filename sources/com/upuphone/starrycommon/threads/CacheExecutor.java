package com.upuphone.starrycommon.threads;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class CacheExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static ThreadPoolExecutor f6488a;

    public static ThreadPoolExecutor a() {
        if (f6488a == null) {
            synchronized (CacheExecutor.class) {
                try {
                    if (f6488a == null) {
                        f6488a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6488a;
    }
}
