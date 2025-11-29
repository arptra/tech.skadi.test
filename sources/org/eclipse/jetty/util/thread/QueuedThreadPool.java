package org.eclipse.jetty.util.thread;

import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.MzContactsContract;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.jetty.util.BlockingArrayQueue;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ThreadPool;

public class QueuedThreadPool extends AbstractLifeCycle implements ThreadPool.SizedThreadPool, Executor, Dumpable {
    /* access modifiers changed from: private */
    public static final Logger LOG = Log.getLogger((Class<?>) QueuedThreadPool.class);
    private boolean _daemon;
    private boolean _detailedDump;
    /* access modifiers changed from: private */
    public BlockingQueue<Runnable> _jobs;
    private final Object _joinLock;
    /* access modifiers changed from: private */
    public final AtomicLong _lastShrink;
    /* access modifiers changed from: private */
    public int _maxIdleTimeMs;
    private int _maxQueued;
    private int _maxStopTime;
    private int _maxThreads;
    /* access modifiers changed from: private */
    public int _minThreads;
    private String _name;
    private int _priority;
    private Runnable _runnable;
    /* access modifiers changed from: private */
    public final ConcurrentHashSet<Thread> _threads;
    /* access modifiers changed from: private */
    public final AtomicInteger _threadsIdle;
    /* access modifiers changed from: private */
    public final AtomicInteger _threadsStarted;

    public QueuedThreadPool() {
        this._threadsStarted = new AtomicInteger();
        this._threadsIdle = new AtomicInteger();
        this._lastShrink = new AtomicLong();
        this._threads = new ConcurrentHashSet<>();
        this._joinLock = new Object();
        this._maxIdleTimeMs = 60000;
        this._maxThreads = DnsRecord.CLASS_NONE;
        this._minThreads = 8;
        this._maxQueued = -1;
        this._priority = 5;
        this._daemon = false;
        this._maxStopTime = 100;
        this._detailedDump = false;
        this._runnable = new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:56:0x0102, code lost:
                if (r2 == false) goto L_0x0104;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:70:0x0138, code lost:
                if (r2 != false) goto L_0x010d;
             */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x0130 A[Catch:{ all -> 0x0032 }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x013e  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r11 = this;
                    r0 = 0
                    org.eclipse.jetty.util.thread.QueuedThreadPool r1 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ InterruptedException -> 0x0123, Exception -> 0x011f, all -> 0x011b }
                    java.util.concurrent.BlockingQueue r1 = r1._jobs     // Catch:{ InterruptedException -> 0x0123, Exception -> 0x011f, all -> 0x011b }
                    java.lang.Object r1 = r1.poll()     // Catch:{ InterruptedException -> 0x0123, Exception -> 0x011f, all -> 0x011b }
                    java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ InterruptedException -> 0x0123, Exception -> 0x011f, all -> 0x011b }
                    r2 = r0
                L_0x000e:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r3 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    boolean r3 = r3.isRunning()     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    if (r3 == 0) goto L_0x0102
                L_0x0016:
                    if (r1 == 0) goto L_0x003b
                    org.eclipse.jetty.util.thread.QueuedThreadPool r3 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    boolean r3 = r3.isRunning()     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    if (r3 == 0) goto L_0x003b
                    org.eclipse.jetty.util.thread.QueuedThreadPool r3 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    r3.runJob(r1)     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    org.eclipse.jetty.util.thread.QueuedThreadPool r1 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    java.util.concurrent.BlockingQueue r1 = r1._jobs     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    java.lang.Object r1 = r1.poll()     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    goto L_0x0016
                L_0x0032:
                    r0 = move-exception
                    goto L_0x013c
                L_0x0035:
                    r0 = move-exception
                    goto L_0x0127
                L_0x0038:
                    r0 = move-exception
                    goto L_0x0131
                L_0x003b:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r3 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    java.util.concurrent.atomic.AtomicInteger r3 = r3._threadsIdle     // Catch:{ all -> 0x0063 }
                    r3.incrementAndGet()     // Catch:{ all -> 0x0063 }
                L_0x0044:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r3 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    boolean r3 = r3.isRunning()     // Catch:{ all -> 0x0063 }
                    if (r3 == 0) goto L_0x00ed
                    if (r1 != 0) goto L_0x00ed
                    org.eclipse.jetty.util.thread.QueuedThreadPool r1 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    int r1 = r1._maxIdleTimeMs     // Catch:{ all -> 0x0063 }
                    if (r1 > 0) goto L_0x0066
                    org.eclipse.jetty.util.thread.QueuedThreadPool r1 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    java.util.concurrent.BlockingQueue r1 = r1._jobs     // Catch:{ all -> 0x0063 }
                    java.lang.Object r1 = r1.take()     // Catch:{ all -> 0x0063 }
                    java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x0063 }
                    goto L_0x0044
                L_0x0063:
                    r0 = move-exception
                    goto L_0x00f8
                L_0x0066:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r1 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    java.util.concurrent.atomic.AtomicInteger r1 = r1._threadsStarted     // Catch:{ all -> 0x0063 }
                    int r1 = r1.get()     // Catch:{ all -> 0x0063 }
                    org.eclipse.jetty.util.thread.QueuedThreadPool r3 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    int r3 = r3._minThreads     // Catch:{ all -> 0x0063 }
                    if (r1 <= r3) goto L_0x00e5
                    org.eclipse.jetty.util.thread.QueuedThreadPool r3 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    java.util.concurrent.atomic.AtomicLong r3 = r3._lastShrink     // Catch:{ all -> 0x0063 }
                    long r3 = r3.get()     // Catch:{ all -> 0x0063 }
                    long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0063 }
                    r7 = 0
                    int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                    if (r7 == 0) goto L_0x0099
                    long r7 = r5 - r3
                    org.eclipse.jetty.util.thread.QueuedThreadPool r9 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    int r9 = r9._maxIdleTimeMs     // Catch:{ all -> 0x0063 }
                    long r9 = (long) r9     // Catch:{ all -> 0x0063 }
                    int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                    if (r7 <= 0) goto L_0x00e5
                L_0x0099:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r7 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    java.util.concurrent.atomic.AtomicLong r7 = r7._lastShrink     // Catch:{ all -> 0x0063 }
                    boolean r3 = r7.compareAndSet(r3, r5)     // Catch:{ all -> 0x0063 }
                    if (r3 == 0) goto L_0x00b5
                    org.eclipse.jetty.util.thread.QueuedThreadPool r3 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    java.util.concurrent.atomic.AtomicInteger r3 = r3._threadsStarted     // Catch:{ all -> 0x0063 }
                    int r4 = r1 + -1
                    boolean r1 = r3.compareAndSet(r1, r4)     // Catch:{ all -> 0x0063 }
                    if (r1 == 0) goto L_0x00b5
                    r1 = 1
                    goto L_0x00b6
                L_0x00b5:
                    r1 = r0
                L_0x00b6:
                    if (r1 == 0) goto L_0x00e4
                    org.eclipse.jetty.util.thread.QueuedThreadPool r0 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ InterruptedException -> 0x00e1, Exception -> 0x00de, all -> 0x00da }
                    java.util.concurrent.atomic.AtomicInteger r0 = r0._threadsIdle     // Catch:{ InterruptedException -> 0x00e1, Exception -> 0x00de, all -> 0x00da }
                    r0.decrementAndGet()     // Catch:{ InterruptedException -> 0x00e1, Exception -> 0x00de, all -> 0x00da }
                    if (r1 != 0) goto L_0x00cc
                    org.eclipse.jetty.util.thread.QueuedThreadPool r0 = org.eclipse.jetty.util.thread.QueuedThreadPool.this
                    java.util.concurrent.atomic.AtomicInteger r0 = r0._threadsStarted
                    r0.decrementAndGet()
                L_0x00cc:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r11 = org.eclipse.jetty.util.thread.QueuedThreadPool.this
                    org.eclipse.jetty.util.ConcurrentHashSet r11 = r11._threads
                    java.lang.Thread r0 = java.lang.Thread.currentThread()
                    r11.remove(r0)
                    return
                L_0x00da:
                    r0 = move-exception
                    r2 = r1
                    goto L_0x013c
                L_0x00de:
                    r0 = move-exception
                    r2 = r1
                    goto L_0x0127
                L_0x00e1:
                    r0 = move-exception
                    r2 = r1
                    goto L_0x0131
                L_0x00e4:
                    r2 = r1
                L_0x00e5:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r1 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ all -> 0x0063 }
                    java.lang.Runnable r1 = r1.idleJobPoll()     // Catch:{ all -> 0x0063 }
                    goto L_0x0044
                L_0x00ed:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r3 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    java.util.concurrent.atomic.AtomicInteger r3 = r3._threadsIdle     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    r3.decrementAndGet()     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    goto L_0x000e
                L_0x00f8:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r1 = org.eclipse.jetty.util.thread.QueuedThreadPool.this     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    java.util.concurrent.atomic.AtomicInteger r1 = r1._threadsIdle     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    r1.decrementAndGet()     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                    throw r0     // Catch:{ InterruptedException -> 0x0038, Exception -> 0x0035 }
                L_0x0102:
                    if (r2 != 0) goto L_0x010d
                L_0x0104:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r0 = org.eclipse.jetty.util.thread.QueuedThreadPool.this
                    java.util.concurrent.atomic.AtomicInteger r0 = r0._threadsStarted
                    r0.decrementAndGet()
                L_0x010d:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r11 = org.eclipse.jetty.util.thread.QueuedThreadPool.this
                    org.eclipse.jetty.util.ConcurrentHashSet r11 = r11._threads
                    java.lang.Thread r0 = java.lang.Thread.currentThread()
                    r11.remove(r0)
                    goto L_0x013b
                L_0x011b:
                    r1 = move-exception
                    r2 = r0
                    r0 = r1
                    goto L_0x013c
                L_0x011f:
                    r1 = move-exception
                    r2 = r0
                    r0 = r1
                    goto L_0x0127
                L_0x0123:
                    r1 = move-exception
                    r2 = r0
                    r0 = r1
                    goto L_0x0131
                L_0x0127:
                    org.eclipse.jetty.util.log.Logger r1 = org.eclipse.jetty.util.thread.QueuedThreadPool.LOG     // Catch:{ all -> 0x0032 }
                    r1.warn(r0)     // Catch:{ all -> 0x0032 }
                    if (r2 != 0) goto L_0x010d
                    goto L_0x0104
                L_0x0131:
                    org.eclipse.jetty.util.log.Logger r1 = org.eclipse.jetty.util.thread.QueuedThreadPool.LOG     // Catch:{ all -> 0x0032 }
                    r1.ignore(r0)     // Catch:{ all -> 0x0032 }
                    if (r2 != 0) goto L_0x010d
                    goto L_0x0104
                L_0x013b:
                    return
                L_0x013c:
                    if (r2 != 0) goto L_0x0147
                    org.eclipse.jetty.util.thread.QueuedThreadPool r1 = org.eclipse.jetty.util.thread.QueuedThreadPool.this
                    java.util.concurrent.atomic.AtomicInteger r1 = r1._threadsStarted
                    r1.decrementAndGet()
                L_0x0147:
                    org.eclipse.jetty.util.thread.QueuedThreadPool r11 = org.eclipse.jetty.util.thread.QueuedThreadPool.this
                    org.eclipse.jetty.util.ConcurrentHashSet r11 = r11._threads
                    java.lang.Thread r1 = java.lang.Thread.currentThread()
                    r11.remove(r1)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.thread.QueuedThreadPool.AnonymousClass3.run():void");
            }
        };
        this._name = "qtp" + super.hashCode();
    }

    /* access modifiers changed from: private */
    public Runnable idleJobPoll() throws InterruptedException {
        return this._jobs.poll((long) this._maxIdleTimeMs, TimeUnit.MILLISECONDS);
    }

    private boolean startThread(int i) {
        if (!this._threadsStarted.compareAndSet(i, i + 1)) {
            return false;
        }
        try {
            Thread newThread = newThread(this._runnable);
            newThread.setDaemon(this._daemon);
            newThread.setPriority(this._priority);
            newThread.setName(this._name + LunarCalendar.DATE_SEPARATOR + newThread.getId());
            this._threads.add(newThread);
            newThread.start();
            return true;
        } catch (Throwable th) {
            this._threadsStarted.decrementAndGet();
            throw th;
        }
    }

    public boolean dispatch(Runnable runnable) {
        int i;
        if (isRunning()) {
            int size = this._jobs.size();
            int idleThreads = getIdleThreads();
            if (this._jobs.offer(runnable)) {
                if ((idleThreads != 0 && size <= idleThreads) || (i = this._threadsStarted.get()) >= this._maxThreads) {
                    return true;
                }
                startThread(i);
                return true;
            }
        }
        LOG.debug("Dispatched {} to stopped {}", runnable, this);
        return false;
    }

    public void doStart() throws Exception {
        BlockingQueue<Runnable> blockingQueue;
        super.doStart();
        this._threadsStarted.set(0);
        if (this._jobs == null) {
            if (this._maxQueued > 0) {
                blockingQueue = new ArrayBlockingQueue<>(this._maxQueued);
            } else {
                int i = this._minThreads;
                blockingQueue = new BlockingArrayQueue<>(i, i);
            }
            this._jobs = blockingQueue;
        }
        int i2 = this._threadsStarted.get();
        while (isRunning() && i2 < this._minThreads) {
            startThread(i2);
            i2 = this._threadsStarted.get();
        }
    }

    public void doStop() throws Exception {
        super.doStop();
        long currentTimeMillis = System.currentTimeMillis();
        while (this._threadsStarted.get() > 0 && System.currentTimeMillis() - currentTimeMillis < ((long) (this._maxStopTime / 2))) {
            Thread.sleep(1);
        }
        this._jobs.clear();
        AnonymousClass1 r2 = new Runnable() {
            public void run() {
            }
        };
        int i = this._threadsIdle.get();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            this._jobs.offer(r2);
            i = i2;
        }
        Thread.yield();
        if (this._threadsStarted.get() > 0) {
            Iterator<Thread> it = this._threads.iterator();
            while (it.hasNext()) {
                it.next().interrupt();
            }
        }
        while (this._threadsStarted.get() > 0 && System.currentTimeMillis() - currentTimeMillis < ((long) this._maxStopTime)) {
            Thread.sleep(1);
        }
        Thread.yield();
        int size = this._threads.size();
        if (size > 0) {
            Logger logger = LOG;
            logger.warn(size + " threads could not be stopped", new Object[0]);
            if (size == 1 || logger.isDebugEnabled()) {
                Iterator<Thread> it2 = this._threads.iterator();
                while (it2.hasNext()) {
                    Thread next = it2.next();
                    LOG.info("Couldn't stop " + next, new Object[0]);
                    StackTraceElement[] stackTrace = next.getStackTrace();
                    int length = stackTrace.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        StackTraceElement stackTraceElement = stackTrace[i3];
                        LOG.info(" at " + stackTraceElement, new Object[0]);
                    }
                }
            }
        }
        synchronized (this._joinLock) {
            this._joinLock.notifyAll();
        }
    }

    public String dump() {
        return AggregateLifeCycle.dump((Dumpable) this);
    }

    public String dumpThread(long j) {
        Iterator<Thread> it = this._threads.iterator();
        while (it.hasNext()) {
            Thread next = it.next();
            if (next.getId() == j) {
                StringBuilder sb = new StringBuilder();
                sb.append(next.getId());
                sb.append(" ");
                sb.append(next.getName());
                sb.append(" ");
                sb.append(next.getState());
                sb.append(":\n");
                for (StackTraceElement stackTraceElement : next.getStackTrace()) {
                    sb.append("  at ");
                    sb.append(stackTraceElement.toString());
                    sb.append(10);
                }
                return sb.toString();
            }
        }
        return null;
    }

    public void execute(Runnable runnable) {
        if (!dispatch(runnable)) {
            throw new RejectedExecutionException();
        }
    }

    public int getIdleThreads() {
        return this._threadsIdle.get();
    }

    public int getMaxIdleTimeMs() {
        return this._maxIdleTimeMs;
    }

    public int getMaxQueued() {
        return this._maxQueued;
    }

    public int getMaxStopTimeMs() {
        return this._maxStopTime;
    }

    public int getMaxThreads() {
        return this._maxThreads;
    }

    public int getMinThreads() {
        return this._minThreads;
    }

    public String getName() {
        return this._name;
    }

    public BlockingQueue<Runnable> getQueue() {
        return this._jobs;
    }

    public int getThreads() {
        return this._threadsStarted.get();
    }

    public int getThreadsPriority() {
        return this._priority;
    }

    public boolean interruptThread(long j) {
        Iterator<Thread> it = this._threads.iterator();
        while (it.hasNext()) {
            Thread next = it.next();
            if (next.getId() == j) {
                next.interrupt();
                return true;
            }
        }
        return false;
    }

    public boolean isDaemon() {
        return this._daemon;
    }

    public boolean isDetailedDump() {
        return this._detailedDump;
    }

    public boolean isLowOnThreads() {
        return this._threadsStarted.get() == this._maxThreads && this._jobs.size() >= this._threadsIdle.get();
    }

    public void join() throws InterruptedException {
        synchronized (this._joinLock) {
            while (isRunning()) {
                try {
                    this._joinLock.wait();
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
        while (isStopping()) {
            Thread.sleep(1);
        }
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable);
    }

    public void runJob(Runnable runnable) {
        runnable.run();
    }

    public void setDaemon(boolean z) {
        this._daemon = z;
    }

    public void setDetailedDump(boolean z) {
        this._detailedDump = z;
    }

    public void setMaxIdleTimeMs(int i) {
        this._maxIdleTimeMs = i;
    }

    public void setMaxQueued(int i) {
        if (!isRunning()) {
            this._maxQueued = i;
            return;
        }
        throw new IllegalStateException("started");
    }

    public void setMaxStopTimeMs(int i) {
        this._maxStopTime = i;
    }

    public void setMaxThreads(int i) {
        this._maxThreads = i;
        if (this._minThreads > i) {
            this._minThreads = i;
        }
    }

    public void setMinThreads(int i) {
        this._minThreads = i;
        if (i > this._maxThreads) {
            this._maxThreads = i;
        }
        int i2 = this._threadsStarted.get();
        while (isStarted() && i2 < this._minThreads) {
            startThread(i2);
            i2 = this._threadsStarted.get();
        }
    }

    public void setName(String str) {
        if (!isRunning()) {
            this._name = str;
            return;
        }
        throw new IllegalStateException("started");
    }

    public void setThreadsPriority(int i) {
        this._priority = i;
    }

    @Deprecated
    public boolean stopThread(long j) {
        Iterator<Thread> it = this._threads.iterator();
        while (it.hasNext()) {
            Thread next = it.next();
            if (next.getId() == j) {
                next.stop();
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._name);
        sb.append("{");
        sb.append(getMinThreads());
        sb.append("<=");
        sb.append(getIdleThreads());
        sb.append("<=");
        sb.append(getThreads());
        sb.append("/");
        sb.append(getMaxThreads());
        sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        BlockingQueue<Runnable> blockingQueue = this._jobs;
        sb.append(blockingQueue == null ? -1 : blockingQueue.size());
        sb.append("}");
        return sb.toString();
    }

    public void dump(Appendable appendable, String str) throws IOException {
        final boolean z;
        ArrayList arrayList = new ArrayList(getMaxThreads());
        Iterator<Thread> it = this._threads.iterator();
        while (it.hasNext()) {
            final Thread next = it.next();
            final StackTraceElement[] stackTrace = next.getStackTrace();
            if (stackTrace != null) {
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if ("idleJobPoll".equals(stackTrace[i].getMethodName())) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            z = false;
            if (this._detailedDump) {
                arrayList.add(new Dumpable() {
                    public String dump() {
                        return null;
                    }

                    public void dump(Appendable appendable, String str) throws IOException {
                        appendable.append(String.valueOf(next.getId())).append(' ').append(next.getName()).append(' ').append(next.getState().toString()).append(z ? " IDLE" : "").append(10);
                        if (!z) {
                            AggregateLifeCycle.dump(appendable, str, Arrays.asList(stackTrace));
                        }
                    }
                });
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(next.getId());
                sb.append(" ");
                sb.append(next.getName());
                sb.append(" ");
                sb.append(next.getState());
                sb.append(" @ ");
                sb.append(stackTrace.length > 0 ? stackTrace[0] : "???");
                sb.append(z ? " IDLE" : "");
                arrayList.add(sb.toString());
            }
        }
        AggregateLifeCycle.dumpObject(appendable, this);
        AggregateLifeCycle.dump(appendable, str, arrayList);
    }

    public QueuedThreadPool(int i) {
        this();
        setMaxThreads(i);
    }

    public QueuedThreadPool(BlockingQueue<Runnable> blockingQueue) {
        this();
        this._jobs = blockingQueue;
        blockingQueue.clear();
    }
}
