package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class GlideExecutor implements ExecutorService {
    public static final long b = TimeUnit.SECONDS.toMillis(10);
    public static volatile int c;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f2534a;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f2535a;
        public int b;
        public int c;
        public ThreadFactory d = new DefaultPriorityThreadFactory();
        public UncaughtThrowableStrategy e = UncaughtThrowableStrategy.d;
        public String f;
        public long g;

        public Builder(boolean z) {
            this.f2535a = z;
        }

        public GlideExecutor a() {
            if (!TextUtils.isEmpty(this.f)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.c, this.g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.d, this.f, this.e, this.f2535a));
                if (this.g != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new GlideExecutor(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f);
        }

        public Builder b(String str) {
            this.f = str;
            return this;
        }

        public Builder c(int i) {
            this.b = i;
            this.c = i;
            return this;
        }
    }

    public static final class DefaultPriorityThreadFactory implements ThreadFactory {
        public DefaultPriorityThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable) {
                public void run() {
                    Process.setThreadPriority(9);
                    super.run();
                }
            };
        }
    }

    public static final class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadFactory f2537a;
        public final String b;
        public final UncaughtThrowableStrategy c;
        public final boolean d;
        public final AtomicInteger e = new AtomicInteger();

        public DefaultThreadFactory(ThreadFactory threadFactory, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.f2537a = threadFactory;
            this.b = str;
            this.c = uncaughtThrowableStrategy;
            this.d = z;
        }

        public Thread newThread(final Runnable runnable) {
            Thread newThread = this.f2537a.newThread(new Runnable() {
                public void run() {
                    if (DefaultThreadFactory.this.d) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        DefaultThreadFactory.this.c.a(th);
                    }
                }
            });
            newThread.setName("glide-" + this.b + "-thread-" + this.e.getAndIncrement());
            return newThread;
        }
    }

    public interface UncaughtThrowableStrategy {

        /* renamed from: a  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f2539a = new UncaughtThrowableStrategy() {
            public void a(Throwable th) {
            }
        };
        public static final UncaughtThrowableStrategy b;
        public static final UncaughtThrowableStrategy c = new UncaughtThrowableStrategy() {
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };
        public static final UncaughtThrowableStrategy d;

        static {
            AnonymousClass2 r0 = new UncaughtThrowableStrategy() {
                public void a(Throwable th) {
                    if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                    }
                }
            };
            b = r0;
            d = r0;
        }

        void a(Throwable th);
    }

    public GlideExecutor(ExecutorService executorService) {
        this.f2534a = executorService;
    }

    public static int a() {
        return b() >= 4 ? 2 : 1;
    }

    public static int b() {
        if (c == 0) {
            c = Math.min(4, RuntimeCompat.a());
        }
        return c;
    }

    public static Builder c() {
        return new Builder(true).c(a()).b("animation");
    }

    public static GlideExecutor d() {
        return c().a();
    }

    public static Builder e() {
        return new Builder(true).c(1).b("disk-cache");
    }

    public static GlideExecutor f() {
        return e().a();
    }

    public static Builder g() {
        return new Builder(false).c(b()).b("source");
    }

    public static GlideExecutor h() {
        return g().a();
    }

    public static GlideExecutor j() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(new DefaultPriorityThreadFactory(), "source-unlimited", UncaughtThrowableStrategy.d, false)));
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f2534a.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f2534a.execute(runnable);
    }

    public List invokeAll(Collection collection) {
        return this.f2534a.invokeAll(collection);
    }

    public Object invokeAny(Collection collection) {
        return this.f2534a.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f2534a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f2534a.isTerminated();
    }

    public void shutdown() {
        this.f2534a.shutdown();
    }

    public List shutdownNow() {
        return this.f2534a.shutdownNow();
    }

    public Future submit(Runnable runnable) {
        return this.f2534a.submit(runnable);
    }

    public String toString() {
        return this.f2534a.toString();
    }

    public List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
        return this.f2534a.invokeAll(collection, j, timeUnit);
    }

    public Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
        return this.f2534a.invokeAny(collection, j, timeUnit);
    }

    public Future submit(Runnable runnable, Object obj) {
        return this.f2534a.submit(runnable, obj);
    }

    public Future submit(Callable callable) {
        return this.f2534a.submit(callable);
    }
}
