package io.netty.util;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
public final class ThreadDeathWatcher {
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ThreadDeathWatcher.class);
    /* access modifiers changed from: private */
    public static final Queue<Entry> pendingEntries = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public static final AtomicBoolean started = new AtomicBoolean();
    static final ThreadFactory threadFactory;
    private static final Watcher watcher = new Watcher();
    private static volatile Thread watcherThread;

    public static final class Entry {
        final boolean isWatch;
        final Runnable task;
        final Thread thread;

        public Entry(Thread thread2, Runnable runnable, boolean z) {
            this.thread = thread2;
            this.task = runnable;
            this.isWatch = z;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.thread == entry.thread && this.task == entry.task;
        }

        public int hashCode() {
            return this.task.hashCode() ^ this.thread.hashCode();
        }
    }

    public static final class Watcher implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Entry> watchees;

        private Watcher() {
            this.watchees = new ArrayList();
        }

        private void fetchWatchees() {
            while (true) {
                Entry entry = (Entry) ThreadDeathWatcher.pendingEntries.poll();
                if (entry != null) {
                    if (entry.isWatch) {
                        this.watchees.add(entry);
                    } else {
                        this.watchees.remove(entry);
                    }
                } else {
                    return;
                }
            }
        }

        private void notifyWatchees() {
            List<Entry> list = this.watchees;
            int i = 0;
            while (i < list.size()) {
                Entry entry = list.get(i);
                if (!entry.thread.isAlive()) {
                    list.remove(i);
                    try {
                        entry.task.run();
                    } catch (Throwable th) {
                        ThreadDeathWatcher.logger.warn("Thread death watcher task raised an exception:", th);
                    }
                } else {
                    i++;
                }
            }
        }

        public void run() {
            while (true) {
                fetchWatchees();
                notifyWatchees();
                fetchWatchees();
                notifyWatchees();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException unused) {
                }
                if (this.watchees.isEmpty() && ThreadDeathWatcher.pendingEntries.isEmpty()) {
                    ThreadDeathWatcher.started.compareAndSet(true, false);
                    if (ThreadDeathWatcher.pendingEntries.isEmpty() || !ThreadDeathWatcher.started.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }
    }

    static {
        String str = SystemPropertyUtil.get("io.netty.serviceThreadPrefix");
        String str2 = "threadDeathWatcher";
        if (!StringUtil.isNullOrEmpty(str)) {
            str2 = str + str2;
        }
        threadFactory = new DefaultThreadFactory(str2, true, 1, (ThreadGroup) null);
    }

    private ThreadDeathWatcher() {
    }

    public static boolean awaitInactivity(long j, TimeUnit timeUnit) throws InterruptedException {
        ObjectUtil.checkNotNull(timeUnit, "unit");
        Thread thread = watcherThread;
        if (thread == null) {
            return true;
        }
        thread.join(timeUnit.toMillis(j));
        return !thread.isAlive();
    }

    private static void schedule(Thread thread, Runnable runnable, boolean z) {
        pendingEntries.add(new Entry(thread, runnable, z));
        if (started.compareAndSet(false, true)) {
            final Thread newThread = threadFactory.newThread(watcher);
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    newThread.setContextClassLoader((ClassLoader) null);
                    return null;
                }
            });
            newThread.start();
            watcherThread = newThread;
        }
    }

    public static void unwatch(Thread thread, Runnable runnable) {
        schedule((Thread) ObjectUtil.checkNotNull(thread, "thread"), (Runnable) ObjectUtil.checkNotNull(runnable, "task"), false);
    }

    public static void watch(Thread thread, Runnable runnable) {
        ObjectUtil.checkNotNull(thread, "thread");
        ObjectUtil.checkNotNull(runnable, "task");
        if (thread.isAlive()) {
            schedule(thread, runnable, true);
            return;
        }
        throw new IllegalArgumentException("thread must be alive.");
    }
}
