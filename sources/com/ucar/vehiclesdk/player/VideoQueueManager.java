package com.ucar.vehiclesdk.player;

import com.easy.logger.EasyLog;
import java.util.Deque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoQueueManager {

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue f5475a;
    public long b;
    public final Deque c;
    public final AtomicBoolean d;

    public void a() {
        this.f5475a.clear();
        this.d.set(false);
        this.b = 0;
    }

    public VideoBufferUnit b() {
        try {
            VideoBufferUnit videoBufferUnit = (VideoBufferUnit) this.f5475a.take();
            if (videoBufferUnit != null && videoBufferUnit.b()) {
                this.d.set(true);
            }
            return videoBufferUnit;
        } catch (InterruptedException e) {
            EasyLog.d("VideoQueueManager", "Get data from buffer queue error.", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c(com.ucar.vehiclesdk.player.VideoBufferUnit r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.nio.ByteBuffer r0 = r3.a()     // Catch:{ all -> 0x001f }
            int r0 = r0.capacity()     // Catch:{ all -> 0x001f }
            r1 = 524288(0x80000, float:7.34684E-40)
            if (r0 > r1) goto L_0x0021
            java.util.Deque r0 = r2.c     // Catch:{ all -> 0x001f }
            int r0 = r0.size()     // Catch:{ all -> 0x001f }
            r1 = 15
            if (r0 < r1) goto L_0x0018
            goto L_0x0021
        L_0x0018:
            java.util.Deque r0 = r2.c     // Catch:{ all -> 0x001f }
            r0.push(r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r2)
            return
        L_0x001f:
            r3 = move-exception
            goto L_0x0023
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.VideoQueueManager.c(com.ucar.vehiclesdk.player.VideoBufferUnit):void");
    }
}
