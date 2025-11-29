package org.apache.commons.io.monitor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

public final class FileAlterationMonitor implements Runnable {
    private static final FileAlterationObserver[] EMPTY_ARRAY = new FileAlterationObserver[0];
    private final long interval;
    private final List<FileAlterationObserver> observers;
    private volatile boolean running;
    private Thread thread;
    private ThreadFactory threadFactory;

    public FileAlterationMonitor() {
        this(10000);
    }

    public void addObserver(FileAlterationObserver fileAlterationObserver) {
        if (fileAlterationObserver != null) {
            this.observers.add(fileAlterationObserver);
        }
    }

    public long getInterval() {
        return this.interval;
    }

    public Iterable<FileAlterationObserver> getObservers() {
        return this.observers;
    }

    public void removeObserver(FileAlterationObserver fileAlterationObserver) {
        if (fileAlterationObserver != null) {
            do {
            } while (this.observers.remove(fileAlterationObserver));
        }
    }

    public void run() {
        while (this.running) {
            for (FileAlterationObserver checkAndNotify : this.observers) {
                checkAndNotify.checkAndNotify();
            }
            if (this.running) {
                try {
                    Thread.sleep(this.interval);
                } catch (InterruptedException unused) {
                }
            } else {
                return;
            }
        }
    }

    public synchronized void setThreadFactory(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
    }

    public synchronized void start() throws Exception {
        try {
            if (!this.running) {
                for (FileAlterationObserver initialize : this.observers) {
                    initialize.initialize();
                }
                this.running = true;
                ThreadFactory threadFactory2 = this.threadFactory;
                if (threadFactory2 != null) {
                    this.thread = threadFactory2.newThread(this);
                } else {
                    this.thread = new Thread(this);
                }
                this.thread.start();
            } else {
                throw new IllegalStateException("Monitor is already running");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void stop() throws Exception {
        stop(this.interval);
    }

    public FileAlterationMonitor(long j) {
        this.observers = new CopyOnWriteArrayList();
        this.interval = j;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:4|5|6|8|9|10|(2:13|11)|21|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void stop(long r2) throws java.lang.Exception {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.running     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0034
            r0 = 0
            r1.running = r0     // Catch:{ all -> 0x0013 }
            java.lang.Thread r0 = r1.thread     // Catch:{ InterruptedException -> 0x0015 }
            r0.interrupt()     // Catch:{ InterruptedException -> 0x0015 }
            java.lang.Thread r0 = r1.thread     // Catch:{ InterruptedException -> 0x0015 }
            r0.join(r2)     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x001c
        L_0x0013:
            r2 = move-exception
            goto L_0x003c
        L_0x0015:
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0013 }
            r2.interrupt()     // Catch:{ all -> 0x0013 }
        L_0x001c:
            java.util.List<org.apache.commons.io.monitor.FileAlterationObserver> r2 = r1.observers     // Catch:{ all -> 0x0013 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0013 }
        L_0x0022:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0013 }
            if (r3 == 0) goto L_0x0032
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0013 }
            org.apache.commons.io.monitor.FileAlterationObserver r3 = (org.apache.commons.io.monitor.FileAlterationObserver) r3     // Catch:{ all -> 0x0013 }
            r3.destroy()     // Catch:{ all -> 0x0013 }
            goto L_0x0022
        L_0x0032:
            monitor-exit(r1)
            return
        L_0x0034:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0013 }
            java.lang.String r3 = "Monitor is not running"
            r2.<init>(r3)     // Catch:{ all -> 0x0013 }
            throw r2     // Catch:{ all -> 0x0013 }
        L_0x003c:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.monitor.FileAlterationMonitor.stop(long):void");
    }

    public FileAlterationMonitor(long j, Collection<FileAlterationObserver> collection) {
        this(j, (FileAlterationObserver[]) ((Collection) Optional.ofNullable(collection).orElse(Collections.emptyList())).toArray(EMPTY_ARRAY));
    }

    public FileAlterationMonitor(long j, FileAlterationObserver... fileAlterationObserverArr) {
        this(j);
        if (fileAlterationObserverArr != null) {
            for (FileAlterationObserver addObserver : fileAlterationObserverArr) {
                addObserver(addObserver);
            }
        }
    }
}
