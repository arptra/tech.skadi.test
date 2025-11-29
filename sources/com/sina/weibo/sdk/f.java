package com.sina.weibo.sdk;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class f {
    public static final int b;
    public static final int c;
    public static final a d = new a();

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f9976a;

    public class a implements Comparator<Runnable> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Runnable runnable = (Runnable) obj;
            Runnable runnable2 = (Runnable) obj2;
            return 0;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b = availableProcessors + 1;
        c = (availableProcessors * 2) + 1;
    }

    public f() {
        if (this.f9976a == null) {
            this.f9976a = new ThreadPoolExecutor(b, c, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(5, d));
        }
    }
}
