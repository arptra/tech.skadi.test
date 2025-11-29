package com.ucar.vehiclesdk.player;

import com.easy.logger.EasyLog;
import java.nio.ByteBuffer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AudioQueueManager {

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue f5469a = new LinkedBlockingQueue(512);
    public final String b;
    public long c = 0;
    public final Deque d = new LinkedList();
    public final AtomicInteger e = new AtomicInteger(0);
    public final Object f = new Object();

    public AudioQueueManager(String str) {
        this.b = "AudioQueueManager-" + str;
    }

    public void a() {
        this.f5469a.clear();
        this.c = 0;
        this.e.set(0);
    }

    public ByteBuffer b() {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) this.f5469a.take();
            this.e.getAndAdd(-byteBuffer.remaining());
            return byteBuffer;
        } catch (InterruptedException unused) {
            EasyLog.c(this.b, "Get data from buffer queue error.");
            return null;
        }
    }

    public ByteBuffer c(long j, TimeUnit timeUnit) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) this.f5469a.poll(j, timeUnit);
            if (byteBuffer != null) {
                this.e.getAndAdd(-byteBuffer.remaining());
            }
            return byteBuffer;
        } catch (InterruptedException unused) {
            EasyLog.c(this.b, "Get data from buffer queue error.");
            return null;
        }
    }

    public int d() {
        return this.e.get();
    }

    public int e() {
        return this.f5469a.size();
    }

    public boolean f() {
        return this.f5469a.isEmpty();
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void g(java.nio.ByteBuffer r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.c     // Catch:{ all -> 0x0011 }
            r2 = 1
            long r2 = r2 + r0
            r6.c = r2     // Catch:{ all -> 0x0011 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            r6.c = r2     // Catch:{ all -> 0x0011 }
            goto L_0x0014
        L_0x0011:
            r7 = move-exception
            goto L_0x011f
        L_0x0014:
            long r0 = r6.c     // Catch:{ InterruptedException -> 0x0030 }
            r4 = 100
            long r0 = r0 % r4
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0033
            java.util.concurrent.BlockingQueue r0 = r6.f5469a     // Catch:{ InterruptedException -> 0x0030 }
            int r0 = r0.size()     // Catch:{ InterruptedException -> 0x0030 }
            if (r0 <= 0) goto L_0x0059
            java.util.concurrent.BlockingQueue r0 = r6.f5469a     // Catch:{ InterruptedException -> 0x0030 }
            int r0 = r0.size()     // Catch:{ InterruptedException -> 0x0030 }
            int r0 = r0 % 5
            if (r0 != 0) goto L_0x0059
            goto L_0x0033
        L_0x0030:
            r7 = move-exception
            goto L_0x0116
        L_0x0033:
            java.lang.String r0 = r6.b     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0030 }
            r1.<init>()     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r2 = "buffer queue size: "
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0030 }
            java.util.concurrent.BlockingQueue r2 = r6.f5469a     // Catch:{ InterruptedException -> 0x0030 }
            int r2 = r2.size()     // Catch:{ InterruptedException -> 0x0030 }
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r2 = ", total: "
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0030 }
            long r2 = r6.c     // Catch:{ InterruptedException -> 0x0030 }
            r1.append(r2)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r1 = r1.toString()     // Catch:{ InterruptedException -> 0x0030 }
            com.easy.logger.EasyLog.h(r0, r1)     // Catch:{ InterruptedException -> 0x0030 }
        L_0x0059:
            int r0 = r7.remaining()     // Catch:{ InterruptedException -> 0x0030 }
            java.util.Deque r1 = r6.d     // Catch:{ InterruptedException -> 0x0030 }
            boolean r1 = r1.isEmpty()     // Catch:{ InterruptedException -> 0x0030 }
            if (r1 == 0) goto L_0x0084
            int r1 = r6.i(r0)     // Catch:{ InterruptedException -> 0x0030 }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r2 = r6.b     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0030 }
            r3.<init>()     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r4 = "allocate new buffer: "
            r3.append(r4)     // Catch:{ InterruptedException -> 0x0030 }
            r3.append(r0)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r3 = r3.toString()     // Catch:{ InterruptedException -> 0x0030 }
            com.easy.logger.EasyLog.a(r2, r3)     // Catch:{ InterruptedException -> 0x0030 }
            goto L_0x00ce
        L_0x0084:
            java.util.Deque r1 = r6.d     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.Object r1 = r1.pop()     // Catch:{ InterruptedException -> 0x0030 }
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1     // Catch:{ InterruptedException -> 0x0030 }
            int r2 = r1.capacity()     // Catch:{ InterruptedException -> 0x0030 }
            if (r2 >= r0) goto L_0x00ce
            int r2 = r6.i(r0)     // Catch:{ InterruptedException -> 0x0030 }
            r3 = 8192(0x2000, float:1.14794E-41)
            int r2 = java.lang.Math.min(r2, r3)     // Catch:{ InterruptedException -> 0x0030 }
            int r2 = java.lang.Math.max(r2, r0)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r3 = r6.b     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0030 }
            r4.<init>()     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r5 = "allocate new buffer: "
            r4.append(r5)     // Catch:{ InterruptedException -> 0x0030 }
            int r1 = r1.capacity()     // Catch:{ InterruptedException -> 0x0030 }
            r4.append(r1)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r1 = " < "
            r4.append(r1)     // Catch:{ InterruptedException -> 0x0030 }
            r4.append(r0)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r1 = ", alloc "
            r4.append(r1)     // Catch:{ InterruptedException -> 0x0030 }
            r4.append(r2)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r1 = r4.toString()     // Catch:{ InterruptedException -> 0x0030 }
            com.easy.logger.EasyLog.a(r3, r1)     // Catch:{ InterruptedException -> 0x0030 }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ InterruptedException -> 0x0030 }
        L_0x00ce:
            r1.clear()     // Catch:{ InterruptedException -> 0x0030 }
            r1.limit(r0)     // Catch:{ InterruptedException -> 0x0030 }
            r1.put(r7)     // Catch:{ InterruptedException -> 0x0030 }
            r1.flip()     // Catch:{ InterruptedException -> 0x0030 }
            java.util.concurrent.BlockingQueue r7 = r6.f5469a     // Catch:{ InterruptedException -> 0x0030 }
            r7.put(r1)     // Catch:{ InterruptedException -> 0x0030 }
            java.util.concurrent.BlockingQueue r7 = r6.f5469a     // Catch:{ InterruptedException -> 0x0030 }
            int r7 = r7.size()     // Catch:{ InterruptedException -> 0x0030 }
            r1 = 511(0x1ff, float:7.16E-43)
            if (r7 <= r1) goto L_0x0104
            java.util.concurrent.BlockingQueue r7 = r6.f5469a     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.Object r7 = r7.poll()     // Catch:{ InterruptedException -> 0x0030 }
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7     // Catch:{ InterruptedException -> 0x0030 }
            if (r7 == 0) goto L_0x00fd
            java.util.concurrent.atomic.AtomicInteger r1 = r6.e     // Catch:{ InterruptedException -> 0x0030 }
            int r7 = r7.remaining()     // Catch:{ InterruptedException -> 0x0030 }
            int r7 = -r7
            r1.addAndGet(r7)     // Catch:{ InterruptedException -> 0x0030 }
        L_0x00fd:
            java.lang.String r7 = r6.b     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.String r1 = "something wrong, the queue have too many buffer"
            com.easy.logger.EasyLog.c(r7, r1)     // Catch:{ InterruptedException -> 0x0030 }
        L_0x0104:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.e     // Catch:{ InterruptedException -> 0x0030 }
            r7.addAndGet(r0)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.Object r7 = r6.f     // Catch:{ InterruptedException -> 0x0030 }
            monitor-enter(r7)     // Catch:{ InterruptedException -> 0x0030 }
            java.lang.Object r0 = r6.f     // Catch:{ all -> 0x0113 }
            r0.notifyAll()     // Catch:{ all -> 0x0113 }
            monitor-exit(r7)     // Catch:{ all -> 0x0113 }
            goto L_0x011d
        L_0x0113:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0113 }
            throw r0     // Catch:{ InterruptedException -> 0x0030 }
        L_0x0116:
            java.lang.String r0 = r6.b     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = "Put data to buffer queue error."
            com.easy.logger.EasyLog.d(r0, r1, r7)     // Catch:{ all -> 0x0011 }
        L_0x011d:
            monitor-exit(r6)
            return
        L_0x011f:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.AudioQueueManager.g(java.nio.ByteBuffer):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void h(java.nio.ByteBuffer r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r3.capacity()     // Catch:{ all -> 0x001b }
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r0 > r1) goto L_0x001d
            java.util.Deque r0 = r2.d     // Catch:{ all -> 0x001b }
            int r0 = r0.size()     // Catch:{ all -> 0x001b }
            r1 = 30
            if (r0 < r1) goto L_0x0014
            goto L_0x001d
        L_0x0014:
            java.util.Deque r0 = r2.d     // Catch:{ all -> 0x001b }
            r0.push(r3)     // Catch:{ all -> 0x001b }
            monitor-exit(r2)
            return
        L_0x001b:
            r3 = move-exception
            goto L_0x001f
        L_0x001d:
            monitor-exit(r2)
            return
        L_0x001f:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.AudioQueueManager.h(java.nio.ByteBuffer):void");
    }

    public final int i(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        if (i7 < 0) {
            return 1;
        }
        return 1 + i7;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f
            monitor-enter(r0)
            java.lang.Object r3 = r3.f     // Catch:{ InterruptedException -> 0x000d }
            r1 = 100
            r3.wait(r1)     // Catch:{ InterruptedException -> 0x000d }
            goto L_0x000d
        L_0x000b:
            r3 = move-exception
            goto L_0x000f
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.AudioQueueManager.j():void");
    }
}
