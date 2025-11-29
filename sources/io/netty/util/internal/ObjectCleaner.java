package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObjectCleaner {
    /* access modifiers changed from: private */
    public static final AtomicBoolean CLEANER_RUNNING = new AtomicBoolean(false);
    private static final Runnable CLEANER_TASK = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                r5 = 0
                r0 = r5
            L_0x0002:
                java.util.Set r1 = io.netty.util.internal.ObjectCleaner.LIVE_SET
                boolean r1 = r1.isEmpty()
                r2 = 1
                if (r1 != 0) goto L_0x002b
                java.lang.ref.ReferenceQueue r1 = io.netty.util.internal.ObjectCleaner.REFERENCE_QUEUE     // Catch:{ InterruptedException -> 0x0029 }
                int r3 = io.netty.util.internal.ObjectCleaner.REFERENCE_QUEUE_POLL_TIMEOUT_MS     // Catch:{ InterruptedException -> 0x0029 }
                long r3 = (long) r3     // Catch:{ InterruptedException -> 0x0029 }
                java.lang.ref.Reference r1 = r1.remove(r3)     // Catch:{ InterruptedException -> 0x0029 }
                io.netty.util.internal.ObjectCleaner$AutomaticCleanerReference r1 = (io.netty.util.internal.ObjectCleaner.AutomaticCleanerReference) r1     // Catch:{ InterruptedException -> 0x0029 }
                if (r1 == 0) goto L_0x0002
                r1.cleanup()     // Catch:{ all -> 0x0021 }
            L_0x0021:
                java.util.Set r2 = io.netty.util.internal.ObjectCleaner.LIVE_SET
                r2.remove(r1)
                goto L_0x0002
            L_0x0029:
                r0 = r2
                goto L_0x0002
            L_0x002b:
                java.util.concurrent.atomic.AtomicBoolean r1 = io.netty.util.internal.ObjectCleaner.CLEANER_RUNNING
                r1.set(r5)
                java.util.Set r1 = io.netty.util.internal.ObjectCleaner.LIVE_SET
                boolean r1 = r1.isEmpty()
                if (r1 != 0) goto L_0x0046
                java.util.concurrent.atomic.AtomicBoolean r1 = io.netty.util.internal.ObjectCleaner.CLEANER_RUNNING
                boolean r1 = r1.compareAndSet(r5, r2)
                if (r1 != 0) goto L_0x0002
            L_0x0046:
                if (r0 == 0) goto L_0x004f
                java.lang.Thread r5 = java.lang.Thread.currentThread()
                r5.interrupt()
            L_0x004f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.ObjectCleaner.AnonymousClass1.run():void");
        }
    };
    static final String CLEANER_THREAD_NAME = (ObjectCleaner.class.getSimpleName() + "Thread");
    /* access modifiers changed from: private */
    public static final Set<AutomaticCleanerReference> LIVE_SET = new ConcurrentSet();
    /* access modifiers changed from: private */
    public static final ReferenceQueue<Object> REFERENCE_QUEUE = new ReferenceQueue<>();
    /* access modifiers changed from: private */
    public static final int REFERENCE_QUEUE_POLL_TIMEOUT_MS = Math.max(500, SystemPropertyUtil.getInt("io.netty.util.internal.ObjectCleaner.refQueuePollTimeout", 10000));

    public static final class AutomaticCleanerReference extends WeakReference<Object> {
        private final Runnable cleanupTask;

        public AutomaticCleanerReference(Object obj, Runnable runnable) {
            super(obj, ObjectCleaner.REFERENCE_QUEUE);
            this.cleanupTask = runnable;
        }

        public void cleanup() {
            this.cleanupTask.run();
        }

        public void clear() {
            ObjectCleaner.LIVE_SET.remove(this);
            super.clear();
        }

        public Thread get() {
            return null;
        }
    }

    private ObjectCleaner() {
    }

    public static int getLiveSetCount() {
        return LIVE_SET.size();
    }

    public static void register(Object obj, Runnable runnable) {
        LIVE_SET.add(new AutomaticCleanerReference(obj, (Runnable) ObjectUtil.checkNotNull(runnable, "cleanupTask")));
        if (CLEANER_RUNNING.compareAndSet(false, true)) {
            final FastThreadLocalThread fastThreadLocalThread = new FastThreadLocalThread(CLEANER_TASK);
            fastThreadLocalThread.setPriority(1);
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    fastThreadLocalThread.setContextClassLoader((ClassLoader) null);
                    return null;
                }
            });
            fastThreadLocalThread.setName(CLEANER_THREAD_NAME);
            fastThreadLocalThread.setDaemon(true);
            fastThreadLocalThread.start();
        }
    }
}
