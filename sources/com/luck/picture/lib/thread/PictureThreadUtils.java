package com.luck.picture.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class PictureThreadUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f9459a = new Handler(Looper.getMainLooper());
    public static final Map b = new HashMap();
    public static final Map c = new ConcurrentHashMap();
    public static final int d = Runtime.getRuntime().availableProcessors();
    public static final Timer e = new Timer();
    public static Executor f;

    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        /* access modifiers changed from: private */
        public volatile ThreadPoolExecutor4Util mPool;

        public LinkedBlockingQueue4Util() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        public boolean offer(@NonNull Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        public LinkedBlockingQueue4Util(boolean z) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z) {
                this.mCapacity = 0;
            }
        }

        public LinkedBlockingQueue4Util(int i) {
            this.mCapacity = i;
        }
    }

    public static abstract class SimpleTask<T> extends Task<T> {
        public void i() {
            Log.e("ThreadUtils", "onCancel: " + Thread.currentThread());
        }

        public void k(Throwable th) {
            Log.e("ThreadUtils", "onFail: ", th);
        }
    }

    public static class SyncValue<T> {
    }

    public static abstract class Task<T> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f9462a = new AtomicInteger(0);
        public volatile boolean b;
        public volatile Thread c;
        public Timer d;
        public long e;
        public OnTimeoutListener f;
        public Executor g;

        public interface OnTimeoutListener {
            void onTimeout();
        }

        public void d() {
            e(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            if (r4 == false) goto L_0x0022;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            if (r3.c == null) goto L_0x0022;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
            r3.c.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
            g().execute(new com.luck.picture.lib.thread.PictureThreadUtils.Task.AnonymousClass5(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e(boolean r4) {
            /*
                r3 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r3.f9462a
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.f9462a     // Catch:{ all -> 0x000e }
                int r1 = r1.get()     // Catch:{ all -> 0x000e }
                r2 = 1
                if (r1 <= r2) goto L_0x0010
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                return
            L_0x000e:
                r3 = move-exception
                goto L_0x002f
            L_0x0010:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.f9462a     // Catch:{ all -> 0x000e }
                r2 = 4
                r1.set(r2)     // Catch:{ all -> 0x000e }
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                if (r4 == 0) goto L_0x0022
                java.lang.Thread r4 = r3.c
                if (r4 == 0) goto L_0x0022
                java.lang.Thread r4 = r3.c
                r4.interrupt()
            L_0x0022:
                java.util.concurrent.Executor r4 = r3.g()
                com.luck.picture.lib.thread.PictureThreadUtils$Task$5 r0 = new com.luck.picture.lib.thread.PictureThreadUtils$Task$5
                r0.<init>()
                r4.execute(r0)
                return
            L_0x002f:
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.thread.PictureThreadUtils.Task.e(boolean):void");
        }

        public abstract Object f();

        public final Executor g() {
            Executor executor = this.g;
            return executor == null ? PictureThreadUtils.i() : executor;
        }

        public boolean h() {
            return this.f9462a.get() > 1;
        }

        public abstract void i();

        public void j() {
            PictureThreadUtils.c.remove(this);
            Timer timer = this.d;
            if (timer != null) {
                timer.cancel();
                this.d = null;
                this.f = null;
            }
        }

        public abstract void k(Throwable th);

        public abstract void l(Object obj);

        public final void m(boolean z) {
            this.b = z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
            if (r3.c == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            r3.c.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void n() {
            /*
                r3 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r3.f9462a
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.f9462a     // Catch:{ all -> 0x000e }
                int r1 = r1.get()     // Catch:{ all -> 0x000e }
                r2 = 1
                if (r1 <= r2) goto L_0x0010
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                return
            L_0x000e:
                r3 = move-exception
                goto L_0x0021
            L_0x0010:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.f9462a     // Catch:{ all -> 0x000e }
                r2 = 6
                r1.set(r2)     // Catch:{ all -> 0x000e }
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                java.lang.Thread r0 = r3.c
                if (r0 == 0) goto L_0x0020
                java.lang.Thread r3 = r3.c
                r3.interrupt()
            L_0x0020:
                return
            L_0x0021:
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.thread.PictureThreadUtils.Task.n():void");
        }

        public void run() {
            if (this.b) {
                if (this.c == null) {
                    if (this.f9462a.compareAndSet(0, 1)) {
                        this.c = Thread.currentThread();
                        if (this.f != null) {
                            Log.w("ThreadUtils", "Scheduled task doesn't support timeout.");
                        }
                    } else {
                        return;
                    }
                } else if (this.f9462a.get() != 1) {
                    return;
                }
            } else if (this.f9462a.compareAndSet(0, 1)) {
                this.c = Thread.currentThread();
                if (this.f != null) {
                    Timer timer = new Timer();
                    this.d = timer;
                    timer.schedule(new TimerTask() {
                        public void run() {
                            if (!Task.this.h() && Task.this.f != null) {
                                Task.this.n();
                                Task.this.f.onTimeout();
                                Task.this.j();
                            }
                        }
                    }, this.e);
                }
            } else {
                return;
            }
            try {
                final Object f2 = f();
                if (this.b) {
                    if (this.f9462a.get() == 1) {
                        g().execute(new Runnable() {
                            public void run() {
                                Task.this.l(f2);
                            }
                        });
                    }
                } else if (this.f9462a.compareAndSet(1, 3)) {
                    g().execute(new Runnable() {
                        public void run() {
                            Task.this.l(f2);
                            Task.this.j();
                        }
                    });
                }
            } catch (InterruptedException unused) {
                this.f9462a.compareAndSet(4, 5);
            } catch (Throwable th) {
                if (this.f9462a.compareAndSet(1, 2)) {
                    g().execute(new Runnable() {
                        public void run() {
                            Task.this.k(th);
                            Task.this.j();
                        }
                    });
                }
            }
        }
    }

    public static final class ThreadPoolExecutor4Util extends ThreadPoolExecutor {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f9468a = new AtomicInteger();
        public LinkedBlockingQueue4Util b;

        public ThreadPoolExecutor4Util(int i, int i2, long j, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, linkedBlockingQueue4Util, threadFactory);
            ThreadPoolExecutor4Util unused = linkedBlockingQueue4Util.mPool = this;
            this.b = linkedBlockingQueue4Util;
        }

        public static ExecutorService b(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            if (i3 == -8) {
                return new ThreadPoolExecutor4Util(PictureThreadUtils.d + 1, (PictureThreadUtils.d * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i4));
            } else if (i3 == -4) {
                return new ThreadPoolExecutor4Util((PictureThreadUtils.d * 2) + 1, (PictureThreadUtils.d * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i4));
            } else {
                if (i3 == -2) {
                    return new ThreadPoolExecutor4Util(0, 128, 60, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i4));
                } else if (i3 == -1) {
                    return new ThreadPoolExecutor4Util(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i4));
                } else {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    LinkedBlockingQueue4Util linkedBlockingQueue4Util = new LinkedBlockingQueue4Util();
                    return new ThreadPoolExecutor4Util(i, i, 0, timeUnit, linkedBlockingQueue4Util, new UtilsThreadFactory("fixed(" + i3 + ")", i4));
                }
            }
        }

        public void afterExecute(Runnable runnable, Throwable th) {
            this.f9468a.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        public void execute(Runnable runnable) {
            if (!isShutdown()) {
                this.f9468a.incrementAndGet();
                try {
                    super.execute(runnable);
                } catch (RejectedExecutionException unused) {
                    Log.e("ThreadUtils", "This will not happen!");
                    this.b.offer(runnable);
                } catch (Throwable unused2) {
                    this.f9468a.decrementAndGet();
                }
            }
        }
    }

    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        public UtilsThreadFactory(String str, int i) {
            this(str, i, false);
        }

        public Thread newThread(@NonNull Runnable runnable) {
            AnonymousClass1 r0 = new Thread(runnable, this.namePrefix + getAndIncrement()) {
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable th) {
                        Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                    }
                }
            };
            r0.setDaemon(this.isDaemon);
            r0.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    System.out.println(th);
                }
            });
            r0.setPriority(this.priority);
            return r0;
        }

        public UtilsThreadFactory(String str, int i, boolean z) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i;
            this.isDaemon = z;
        }
    }

    public static void d(Task task) {
        if (task != null) {
            task.d();
        }
    }

    public static void e(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor4Util) {
            for (Map.Entry entry : c.entrySet()) {
                if (entry.getValue() == executorService) {
                    d((Task) entry.getKey());
                }
            }
            return;
        }
        Log.e("ThreadUtils", "The executorService is not ThreadUtils's pool.");
    }

    public static void f(ExecutorService executorService, Task task) {
        g(executorService, task, 0, 0, (TimeUnit) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r7 != 0) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        if (r5 != 0) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        r3.execute(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        e.schedule(new com.luck.picture.lib.thread.PictureThreadUtils.AnonymousClass1(), r9.toMillis(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        com.luck.picture.lib.thread.PictureThreadUtils.Task.a(r4, true);
        e.scheduleAtFixedRate(new com.luck.picture.lib.thread.PictureThreadUtils.AnonymousClass2(), r9.toMillis(r5), r9.toMillis(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(final java.util.concurrent.ExecutorService r3, final com.luck.picture.lib.thread.PictureThreadUtils.Task r4, long r5, long r7, java.util.concurrent.TimeUnit r9) {
        /*
            java.util.Map r0 = c
            monitor-enter(r0)
            java.lang.Object r1 = r0.get(r4)     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x0014
            java.lang.String r3 = "ThreadUtils"
            java.lang.String r4 = "Task can only be executed once."
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x0012 }
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return
        L_0x0012:
            r3 = move-exception
            goto L_0x004d
        L_0x0014:
            r0.put(r4, r3)     // Catch:{ all -> 0x0012 }
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            r0 = 0
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x0035
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x0026
            r3.execute(r4)
            goto L_0x004c
        L_0x0026:
            com.luck.picture.lib.thread.PictureThreadUtils$1 r7 = new com.luck.picture.lib.thread.PictureThreadUtils$1
            r7.<init>(r3, r4)
            java.util.Timer r3 = e
            long r4 = r9.toMillis(r5)
            r3.schedule(r7, r4)
            goto L_0x004c
        L_0x0035:
            r0 = 1
            r4.m(r0)
            com.luck.picture.lib.thread.PictureThreadUtils$2 r0 = new com.luck.picture.lib.thread.PictureThreadUtils$2
            r0.<init>(r3, r4)
            java.util.Timer r3 = e
            long r5 = r9.toMillis(r5)
            long r7 = r9.toMillis(r7)
            r4 = r0
            r3.scheduleAtFixedRate(r4, r5, r7)
        L_0x004c:
            return
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.thread.PictureThreadUtils.g(java.util.concurrent.ExecutorService, com.luck.picture.lib.thread.PictureThreadUtils$Task, long, long, java.util.concurrent.TimeUnit):void");
    }

    public static void h(Task task) {
        f(k(-4), task);
    }

    public static Executor i() {
        if (f == null) {
            f = new Executor() {
                public void execute(Runnable runnable) {
                    PictureThreadUtils.n(runnable);
                }
            };
        }
        return f;
    }

    public static ExecutorService j() {
        return k(-4);
    }

    public static ExecutorService k(int i) {
        return l(i, 5);
    }

    public static ExecutorService l(int i, int i2) {
        ExecutorService executorService;
        Map map = b;
        synchronized (map) {
            try {
                Map map2 = (Map) map.get(Integer.valueOf(i));
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorService = ThreadPoolExecutor4Util.b(i, i2);
                    concurrentHashMap.put(Integer.valueOf(i2), executorService);
                    map.put(Integer.valueOf(i), concurrentHashMap);
                } else {
                    executorService = (ExecutorService) map2.get(Integer.valueOf(i2));
                    if (executorService == null) {
                        executorService = ThreadPoolExecutor4Util.b(i, i2);
                        map2.put(Integer.valueOf(i2), executorService);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    public static boolean m() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void n(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f9459a.post(runnable);
        }
    }
}
