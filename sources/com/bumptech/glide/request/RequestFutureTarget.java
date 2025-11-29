package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    public static final Waiter k = new Waiter();

    /* renamed from: a  reason: collision with root package name */
    public final int f2709a;
    public final int b;
    public final boolean c;
    public final Waiter d;
    public Object e;
    public Request f;
    public boolean g;
    public boolean h;
    public boolean i;
    public GlideException j;

    @VisibleForTesting
    public static class Waiter {
        public void a(Object obj) {
            obj.notifyAll();
        }

        public void b(Object obj, long j) {
            obj.wait(j);
        }
    }

    public void a(SizeReadyCallback sizeReadyCallback) {
    }

    public synchronized boolean b(GlideException glideException, Object obj, Target target, boolean z) {
        this.i = true;
        this.j = glideException;
        this.d.a(this);
        return false;
    }

    public synchronized Request c() {
        return this.f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r1 == null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDone()     // Catch:{ all -> 0x000a }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            r2 = 0
            return r2
        L_0x000a:
            r3 = move-exception
            goto L_0x0023
        L_0x000c:
            r0 = 1
            r2.g = r0     // Catch:{ all -> 0x000a }
            com.bumptech.glide.request.RequestFutureTarget$Waiter r1 = r2.d     // Catch:{ all -> 0x000a }
            r1.a(r2)     // Catch:{ all -> 0x000a }
            r1 = 0
            if (r3 == 0) goto L_0x001c
            com.bumptech.glide.request.Request r3 = r2.f     // Catch:{ all -> 0x000a }
            r2.f = r1     // Catch:{ all -> 0x000a }
            r1 = r3
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0022
            r1.clear()
        L_0x0022:
            return r0
        L_0x0023:
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.cancel(boolean):boolean");
    }

    public void d(Drawable drawable) {
    }

    public synchronized void e(Object obj, Transition transition) {
    }

    public synchronized boolean f(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
        this.h = true;
        this.e = obj;
        this.d.a(this);
        return false;
    }

    public void g(Drawable drawable) {
    }

    public Object get() {
        try {
            return k((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    public synchronized void h(Request request) {
        this.f = request;
    }

    public synchronized void i(Drawable drawable) {
    }

    public synchronized boolean isCancelled() {
        return this.g;
    }

    public synchronized boolean isDone() {
        return this.g || this.h || this.i;
    }

    public void j(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.d(this.f2709a, this.b);
    }

    public final synchronized Object k(Long l) {
        try {
            if (this.c && !isDone()) {
                Util.a();
            }
            if (this.g) {
                throw new CancellationException();
            } else if (this.i) {
                throw new ExecutionException(this.j);
            } else if (this.h) {
                return this.e;
            } else {
                if (l == null) {
                    this.d.b(this, 0);
                } else if (l.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.d.b(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                } else if (this.i) {
                    throw new ExecutionException(this.j);
                } else if (this.g) {
                    throw new CancellationException();
                } else if (this.h) {
                    return this.e;
                } else {
                    throw new TimeoutException();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public String toString() {
        Request request;
        String str;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            try {
                request = null;
                if (this.g) {
                    str = "CANCELLED";
                } else if (this.i) {
                    str = "FAILURE";
                } else if (this.h) {
                    str = "SUCCESS";
                } else {
                    str = "PENDING";
                    request = this.f;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (request != null) {
            return str2 + str + ", request=[" + request + "]]";
        }
        return str2 + str + "]";
    }

    public Object get(long j2, TimeUnit timeUnit) {
        return k(Long.valueOf(timeUnit.toMillis(j2)));
    }
}
