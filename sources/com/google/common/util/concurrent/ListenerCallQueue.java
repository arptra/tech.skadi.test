package com.google.common.util.concurrent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
final class ListenerCallQueue<L> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    public interface Event<L> {
        void call(L l);
    }

    public static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        @GuardedBy("this")
        boolean isThreadScheduled;
        @GuardedBy("this")
        final Queue<Object> labelQueue = Queues.newArrayDeque();
        final L listener;
        @GuardedBy("this")
        final Queue<Event<L>> waitQueue = Queues.newArrayDeque();

        public PerListenerQueue(L l, Executor executor2) {
            this.listener = Preconditions.checkNotNull(l);
            this.executor = (Executor) Preconditions.checkNotNull(executor2);
        }

        public synchronized void add(Event<L> event, Object obj) {
            this.waitQueue.add(event);
            this.labelQueue.add(obj);
        }

        public void dispatch() {
            boolean z;
            synchronized (this) {
                try {
                    if (!this.isThreadScheduled) {
                        z = true;
                        this.isThreadScheduled = true;
                    } else {
                        z = false;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (z) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        Logger access$000 = ListenerCallQueue.logger;
                        Level level = Level.SEVERE;
                        String valueOf = String.valueOf(this.listener);
                        String valueOf2 = String.valueOf(this.executor);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 42 + valueOf2.length());
                        sb.append("Exception while running callbacks for ");
                        sb.append(valueOf);
                        sb.append(" on ");
                        sb.append(valueOf2);
                        access$000.log(level, sb.toString(), e);
                        throw e;
                    }
                }
            }
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void run() {
            /*
                r10 = this;
            L_0x0000:
                r0 = 0
                r1 = 1
                monitor-enter(r10)     // Catch:{ all -> 0x002b }
                boolean r2 = r10.isThreadScheduled     // Catch:{ all -> 0x001f }
                com.google.common.base.Preconditions.checkState(r2)     // Catch:{ all -> 0x001f }
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r2 = r10.waitQueue     // Catch:{ all -> 0x001f }
                java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x001f }
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch:{ all -> 0x001f }
                java.util.Queue<java.lang.Object> r3 = r10.labelQueue     // Catch:{ all -> 0x001f }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x001f }
                if (r2 != 0) goto L_0x0024
                r10.isThreadScheduled = r0     // Catch:{ all -> 0x001f }
                monitor-exit(r10)     // Catch:{ all -> 0x001c }
                return
            L_0x001c:
                r1 = move-exception
                r2 = r0
                goto L_0x0066
            L_0x001f:
                r2 = move-exception
                r9 = r2
                r2 = r1
                r1 = r9
                goto L_0x0066
            L_0x0024:
                monitor-exit(r10)     // Catch:{ all -> 0x001f }
                L r4 = r10.listener     // Catch:{ RuntimeException -> 0x002d }
                r2.call(r4)     // Catch:{ RuntimeException -> 0x002d }
                goto L_0x0000
            L_0x002b:
                r2 = move-exception
                goto L_0x006f
            L_0x002d:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.ListenerCallQueue.logger     // Catch:{ all -> 0x002b }
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x002b }
                L r6 = r10.listener     // Catch:{ all -> 0x002b }
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x002b }
                java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x002b }
                int r7 = r6.length()     // Catch:{ all -> 0x002b }
                int r7 = r7 + 37
                int r8 = r3.length()     // Catch:{ all -> 0x002b }
                int r7 = r7 + r8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
                r8.<init>(r7)     // Catch:{ all -> 0x002b }
                java.lang.String r7 = "Exception while executing callback: "
                r8.append(r7)     // Catch:{ all -> 0x002b }
                r8.append(r6)     // Catch:{ all -> 0x002b }
                java.lang.String r6 = " "
                r8.append(r6)     // Catch:{ all -> 0x002b }
                r8.append(r3)     // Catch:{ all -> 0x002b }
                java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x002b }
                r4.log(r5, r3, r2)     // Catch:{ all -> 0x002b }
                goto L_0x0000
            L_0x0066:
                monitor-exit(r10)     // Catch:{ all -> 0x006d }
                throw r1     // Catch:{ all -> 0x0068 }
            L_0x0068:
                r1 = move-exception
                r9 = r2
                r2 = r1
                r1 = r9
                goto L_0x006f
            L_0x006d:
                r1 = move-exception
                goto L_0x0066
            L_0x006f:
                if (r1 == 0) goto L_0x0079
                monitor-enter(r10)
                r10.isThreadScheduled = r0     // Catch:{ all -> 0x0076 }
                monitor-exit(r10)     // Catch:{ all -> 0x0076 }
                goto L_0x0079
            L_0x0076:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x0076 }
                throw r0
            L_0x0079:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        Preconditions.checkNotNull(event, "event");
        Preconditions.checkNotNull(obj, "label");
        synchronized (this.listeners) {
            try {
                for (PerListenerQueue<L> add : this.listeners) {
                    add.add(event, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addListener(L l, Executor executor) {
        Preconditions.checkNotNull(l, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue(l, executor));
    }

    public void dispatch() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).dispatch();
        }
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String str) {
        enqueueHelper(event, str);
    }
}
