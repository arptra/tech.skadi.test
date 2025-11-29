package io.netty.handler.traffic;

import com.alibaba.fastjson.asm.Opcodes;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicLong;

public class TrafficCounter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) TrafficCounter.class);
    final AtomicLong checkInterval = new AtomicLong(1000);
    private final AtomicLong cumulativeReadBytes = new AtomicLong();
    private final AtomicLong cumulativeWrittenBytes = new AtomicLong();
    private final AtomicLong currentReadBytes = new AtomicLong();
    private final AtomicLong currentWrittenBytes = new AtomicLong();
    final ScheduledExecutorService executor;
    private long lastCumulativeTime;
    private volatile long lastReadBytes;
    private long lastReadThroughput;
    private volatile long lastReadingTime;
    final AtomicLong lastTime = new AtomicLong();
    private long lastWriteThroughput;
    private volatile long lastWritingTime;
    private volatile long lastWrittenBytes;
    Runnable monitor;
    volatile boolean monitorActive;
    final String name;
    private long readingTime;
    private long realWriteThroughput;
    private final AtomicLong realWrittenBytes = new AtomicLong();
    volatile ScheduledFuture<?> scheduledFuture;
    final AbstractTrafficShapingHandler trafficShapingHandler;
    private long writingTime;

    public final class TrafficMonitoringTask implements Runnable {
        private TrafficMonitoringTask() {
        }

        public void run() {
            if (TrafficCounter.this.monitorActive) {
                TrafficCounter.this.resetAccounting(TrafficCounter.milliSecondFromNano());
                TrafficCounter trafficCounter = TrafficCounter.this;
                AbstractTrafficShapingHandler abstractTrafficShapingHandler = trafficCounter.trafficShapingHandler;
                if (abstractTrafficShapingHandler != null) {
                    abstractTrafficShapingHandler.doAccounting(trafficCounter);
                }
            }
        }
    }

    public TrafficCounter(ScheduledExecutorService scheduledExecutorService, String str, long j) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.trafficShapingHandler = null;
        this.executor = scheduledExecutorService;
        init(j);
    }

    private void init(long j) {
        this.lastCumulativeTime = System.currentTimeMillis();
        long milliSecondFromNano = milliSecondFromNano();
        this.writingTime = milliSecondFromNano;
        this.readingTime = milliSecondFromNano;
        this.lastWritingTime = milliSecondFromNano;
        this.lastReadingTime = this.writingTime;
        configure(j);
    }

    public static long milliSecondFromNano() {
        return System.nanoTime() / 1000000;
    }

    public void bytesRealWriteFlowControl(long j) {
        this.realWrittenBytes.addAndGet(j);
    }

    public void bytesRecvFlowControl(long j) {
        this.currentReadBytes.addAndGet(j);
        this.cumulativeReadBytes.addAndGet(j);
    }

    public void bytesWriteFlowControl(long j) {
        this.currentWrittenBytes.addAndGet(j);
        this.cumulativeWrittenBytes.addAndGet(j);
    }

    public long checkInterval() {
        return this.checkInterval.get();
    }

    public void configure(long j) {
        long j2 = (j / 10) * 10;
        if (this.checkInterval.getAndSet(j2) == j2) {
            return;
        }
        if (j2 <= 0) {
            stop();
            this.lastTime.set(milliSecondFromNano());
            return;
        }
        stop();
        start();
    }

    public long cumulativeReadBytes() {
        return this.cumulativeReadBytes.get();
    }

    public long cumulativeWrittenBytes() {
        return this.cumulativeWrittenBytes.get();
    }

    public long currentReadBytes() {
        return this.currentReadBytes.get();
    }

    public long currentWrittenBytes() {
        return this.currentWrittenBytes.get();
    }

    public long getRealWriteThroughput() {
        return this.realWriteThroughput;
    }

    public AtomicLong getRealWrittenBytes() {
        return this.realWrittenBytes;
    }

    public long lastCumulativeTime() {
        return this.lastCumulativeTime;
    }

    public long lastReadBytes() {
        return this.lastReadBytes;
    }

    public long lastReadThroughput() {
        return this.lastReadThroughput;
    }

    public long lastTime() {
        return this.lastTime.get();
    }

    public long lastWriteThroughput() {
        return this.lastWriteThroughput;
    }

    public long lastWrittenBytes() {
        return this.lastWrittenBytes;
    }

    public String name() {
        return this.name;
    }

    @Deprecated
    public long readTimeToWait(long j, long j2, long j3) {
        return readTimeToWait(j, j2, j3, milliSecondFromNano());
    }

    public synchronized void resetAccounting(long j) {
        try {
            long andSet = j - this.lastTime.getAndSet(j);
            if (andSet != 0) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled() && andSet > (checkInterval() << 1)) {
                    internalLogger.debug("Acct schedule not ok: " + andSet + " > 2*" + checkInterval() + " from " + this.name);
                }
                this.lastReadBytes = this.currentReadBytes.getAndSet(0);
                this.lastWrittenBytes = this.currentWrittenBytes.getAndSet(0);
                this.lastReadThroughput = (this.lastReadBytes * 1000) / andSet;
                this.lastWriteThroughput = (this.lastWrittenBytes * 1000) / andSet;
                this.realWriteThroughput = (this.realWrittenBytes.getAndSet(0) * 1000) / andSet;
                this.lastWritingTime = Math.max(this.lastWritingTime, this.writingTime);
                this.lastReadingTime = Math.max(this.lastReadingTime, this.readingTime);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void resetCumulativeTime() {
        this.lastCumulativeTime = System.currentTimeMillis();
        this.cumulativeReadBytes.set(0);
        this.cumulativeWrittenBytes.set(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void start() {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.monitorActive     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r8)
            return
        L_0x0007:
            java.util.concurrent.atomic.AtomicLong r0 = r8.lastTime     // Catch:{ all -> 0x0038 }
            long r1 = milliSecondFromNano()     // Catch:{ all -> 0x0038 }
            r0.set(r1)     // Catch:{ all -> 0x0038 }
            java.util.concurrent.atomic.AtomicLong r0 = r8.checkInterval     // Catch:{ all -> 0x0038 }
            long r5 = r0.get()     // Catch:{ all -> 0x0038 }
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x003a
            java.util.concurrent.ScheduledExecutorService r0 = r8.executor     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x003a
            r0 = 1
            r8.monitorActive = r0     // Catch:{ all -> 0x0038 }
            io.netty.handler.traffic.TrafficCounter$TrafficMonitoringTask r2 = new io.netty.handler.traffic.TrafficCounter$TrafficMonitoringTask     // Catch:{ all -> 0x0038 }
            r0 = 0
            r2.<init>()     // Catch:{ all -> 0x0038 }
            r8.monitor = r2     // Catch:{ all -> 0x0038 }
            java.util.concurrent.ScheduledExecutorService r1 = r8.executor     // Catch:{ all -> 0x0038 }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0038 }
            r3 = 0
            java.util.concurrent.ScheduledFuture r0 = r1.scheduleAtFixedRate(r2, r3, r5, r7)     // Catch:{ all -> 0x0038 }
            r8.scheduledFuture = r0     // Catch:{ all -> 0x0038 }
            goto L_0x003a
        L_0x0038:
            r0 = move-exception
            goto L_0x003c
        L_0x003a:
            monitor-exit(r8)
            return
        L_0x003c:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.traffic.TrafficCounter.start():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void stop() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.monitorActive     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 0
            r2.monitorActive = r0     // Catch:{ all -> 0x0019 }
            long r0 = milliSecondFromNano()     // Catch:{ all -> 0x0019 }
            r2.resetAccounting(r0)     // Catch:{ all -> 0x0019 }
            io.netty.handler.traffic.AbstractTrafficShapingHandler r0 = r2.trafficShapingHandler     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x001b
            r0.doAccounting(r2)     // Catch:{ all -> 0x0019 }
            goto L_0x001b
        L_0x0019:
            r0 = move-exception
            goto L_0x0027
        L_0x001b:
            java.util.concurrent.ScheduledFuture<?> r0 = r2.scheduledFuture     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0025
            java.util.concurrent.ScheduledFuture<?> r0 = r2.scheduledFuture     // Catch:{ all -> 0x0019 }
            r1 = 1
            r0.cancel(r1)     // Catch:{ all -> 0x0019 }
        L_0x0025:
            monitor-exit(r2)
            return
        L_0x0027:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.traffic.TrafficCounter.stop():void");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Opcodes.IF_ACMPEQ);
        sb.append("Monitor ");
        sb.append(this.name);
        sb.append(" Current Speed Read: ");
        sb.append(this.lastReadThroughput >> 10);
        sb.append(" KB/s, ");
        sb.append("Asked Write: ");
        sb.append(this.lastWriteThroughput >> 10);
        sb.append(" KB/s, ");
        sb.append("Real Write: ");
        sb.append(this.realWriteThroughput >> 10);
        sb.append(" KB/s, ");
        sb.append("Current Read: ");
        sb.append(this.currentReadBytes.get() >> 10);
        sb.append(" KB, ");
        sb.append("Current asked Write: ");
        sb.append(this.currentWrittenBytes.get() >> 10);
        sb.append(" KB, ");
        sb.append("Current real Write: ");
        sb.append(this.realWrittenBytes.get() >> 10);
        sb.append(" KB");
        return sb.toString();
    }

    @Deprecated
    public long writeTimeToWait(long j, long j2, long j3) {
        return writeTimeToWait(j, j2, j3, milliSecondFromNano());
    }

    public long readTimeToWait(long j, long j2, long j3, long j4) {
        long j5;
        long j6;
        long j7 = j4;
        bytesRecvFlowControl(j);
        if (j == 0 || j2 == 0) {
            return 0;
        }
        long j8 = this.lastTime.get();
        long j9 = this.currentReadBytes.get();
        long j10 = this.readingTime;
        long j11 = j7 - j8;
        long j12 = this.lastReadBytes;
        long max = Math.max(this.lastReadingTime - j8, 0);
        if (j11 > 10) {
            long j13 = j10;
            long j14 = (((1000 * j9) / j2) - j11) + max;
            if (j14 > 10) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Time: " + j14 + ':' + j9 + ':' + j11 + ':' + max);
                }
                if (j14 > j3) {
                    j6 = j13;
                    if ((j7 + j14) - j6 > j3) {
                        j14 = j3;
                    }
                } else {
                    j6 = j13;
                }
                this.readingTime = Math.max(j6, j7 + j14);
                return j14;
            }
            this.readingTime = Math.max(j13, j7);
            return 0;
        }
        long j15 = j9 + j12;
        long j16 = j11 + this.checkInterval.get();
        long j17 = j10;
        long j18 = (((1000 * j15) / j2) - j16) + max;
        if (j18 > 10) {
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("Time: " + j18 + ':' + j15 + ':' + j16 + ':' + max);
            }
            if (j18 > j3) {
                j5 = j17;
                if ((j7 + j18) - j5 > j3) {
                    j18 = j3;
                }
            } else {
                j5 = j17;
            }
            this.readingTime = Math.max(j5, j7 + j18);
            return j18;
        }
        this.readingTime = Math.max(j17, j7);
        return 0;
    }

    public long writeTimeToWait(long j, long j2, long j3, long j4) {
        long j5 = j4;
        bytesWriteFlowControl(j);
        if (j == 0 || j2 == 0) {
            return 0;
        }
        long j6 = this.lastTime.get();
        long j7 = this.currentWrittenBytes.get();
        long j8 = this.lastWrittenBytes;
        long j9 = this.writingTime;
        long max = Math.max(this.lastWritingTime - j6, 0);
        long j10 = j5 - j6;
        if (j10 > 10) {
            long j11 = (((1000 * j7) / j2) - j10) + max;
            if (j11 > 10) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Time: " + j11 + ':' + j7 + ':' + j10 + ':' + max);
                }
                if (j11 > j3 && (j5 + j11) - j9 > j3) {
                    j11 = j3;
                }
                this.writingTime = Math.max(j9, j5 + j11);
                return j11;
            }
            this.writingTime = Math.max(j9, j5);
            return 0;
        }
        long j12 = j7 + j8;
        long j13 = j10 + this.checkInterval.get();
        long j14 = (((1000 * j12) / j2) - j13) + max;
        if (j14 > 10) {
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("Time: " + j14 + ':' + j12 + ':' + j13 + ':' + max);
            }
            if (j14 > j3 && (j5 + j14) - j9 > j3) {
                j14 = j3;
            }
            this.writingTime = Math.max(j9, j5 + j14);
            return j14;
        }
        this.writingTime = Math.max(j9, j5);
        return 0;
    }

    public TrafficCounter(AbstractTrafficShapingHandler abstractTrafficShapingHandler, ScheduledExecutorService scheduledExecutorService, String str, long j) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.trafficShapingHandler = (AbstractTrafficShapingHandler) ObjectUtil.checkNotNullWithIAE(abstractTrafficShapingHandler, "trafficShapingHandler");
        this.executor = scheduledExecutorService;
        init(j);
    }
}
