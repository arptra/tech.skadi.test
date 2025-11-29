package io.netty.handler.traffic;

import io.netty.handler.traffic.GlobalChannelTrafficShapingHandler;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.ScheduledExecutorService;

public class GlobalChannelTrafficCounter extends TrafficCounter {

    public static class MixedTrafficMonitoringTask implements Runnable {
        private final TrafficCounter counter;
        private final GlobalChannelTrafficShapingHandler trafficShapingHandler1;

        public MixedTrafficMonitoringTask(GlobalChannelTrafficShapingHandler globalChannelTrafficShapingHandler, TrafficCounter trafficCounter) {
            this.trafficShapingHandler1 = globalChannelTrafficShapingHandler;
            this.counter = trafficCounter;
        }

        public void run() {
            if (this.counter.monitorActive) {
                long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
                this.counter.resetAccounting(milliSecondFromNano);
                for (GlobalChannelTrafficShapingHandler.PerChannel perChannel : this.trafficShapingHandler1.channelQueues.values()) {
                    perChannel.channelTrafficCounter.resetAccounting(milliSecondFromNano);
                }
                this.trafficShapingHandler1.doAccounting(this.counter);
            }
        }
    }

    public GlobalChannelTrafficCounter(GlobalChannelTrafficShapingHandler globalChannelTrafficShapingHandler, ScheduledExecutorService scheduledExecutorService, String str, long j) {
        super(globalChannelTrafficShapingHandler, scheduledExecutorService, str, j);
        ObjectUtil.checkNotNullWithIAE(scheduledExecutorService, "executor");
    }

    public void resetCumulativeTime() {
        for (GlobalChannelTrafficShapingHandler.PerChannel perChannel : ((GlobalChannelTrafficShapingHandler) this.trafficShapingHandler).channelQueues.values()) {
            perChannel.channelTrafficCounter.resetCumulativeTime();
        }
        super.resetCumulativeTime();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void start() {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.monitorActive     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r8)
            return
        L_0x0007:
            java.util.concurrent.atomic.AtomicLong r0 = r8.lastTime     // Catch:{ all -> 0x0037 }
            long r1 = io.netty.handler.traffic.TrafficCounter.milliSecondFromNano()     // Catch:{ all -> 0x0037 }
            r0.set(r1)     // Catch:{ all -> 0x0037 }
            java.util.concurrent.atomic.AtomicLong r0 = r8.checkInterval     // Catch:{ all -> 0x0037 }
            long r5 = r0.get()     // Catch:{ all -> 0x0037 }
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0039
            r0 = 1
            r8.monitorActive = r0     // Catch:{ all -> 0x0037 }
            io.netty.handler.traffic.GlobalChannelTrafficCounter$MixedTrafficMonitoringTask r2 = new io.netty.handler.traffic.GlobalChannelTrafficCounter$MixedTrafficMonitoringTask     // Catch:{ all -> 0x0037 }
            io.netty.handler.traffic.AbstractTrafficShapingHandler r0 = r8.trafficShapingHandler     // Catch:{ all -> 0x0037 }
            io.netty.handler.traffic.GlobalChannelTrafficShapingHandler r0 = (io.netty.handler.traffic.GlobalChannelTrafficShapingHandler) r0     // Catch:{ all -> 0x0037 }
            r2.<init>(r0, r8)     // Catch:{ all -> 0x0037 }
            r8.monitor = r2     // Catch:{ all -> 0x0037 }
            java.util.concurrent.ScheduledExecutorService r1 = r8.executor     // Catch:{ all -> 0x0037 }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0037 }
            r3 = 0
            java.util.concurrent.ScheduledFuture r0 = r1.scheduleAtFixedRate(r2, r3, r5, r7)     // Catch:{ all -> 0x0037 }
            r8.scheduledFuture = r0     // Catch:{ all -> 0x0037 }
            goto L_0x0039
        L_0x0037:
            r0 = move-exception
            goto L_0x003b
        L_0x0039:
            monitor-exit(r8)
            return
        L_0x003b:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.traffic.GlobalChannelTrafficCounter.start():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void stop() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.monitorActive     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 0
            r2.monitorActive = r0     // Catch:{ all -> 0x0021 }
            long r0 = io.netty.handler.traffic.TrafficCounter.milliSecondFromNano()     // Catch:{ all -> 0x0021 }
            r2.resetAccounting(r0)     // Catch:{ all -> 0x0021 }
            io.netty.handler.traffic.AbstractTrafficShapingHandler r0 = r2.trafficShapingHandler     // Catch:{ all -> 0x0021 }
            r0.doAccounting(r2)     // Catch:{ all -> 0x0021 }
            java.util.concurrent.ScheduledFuture<?> r0 = r2.scheduledFuture     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0023
            java.util.concurrent.ScheduledFuture<?> r0 = r2.scheduledFuture     // Catch:{ all -> 0x0021 }
            r1 = 1
            r0.cancel(r1)     // Catch:{ all -> 0x0021 }
            goto L_0x0023
        L_0x0021:
            r0 = move-exception
            goto L_0x0025
        L_0x0023:
            monitor-exit(r2)
            return
        L_0x0025:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.traffic.GlobalChannelTrafficCounter.stop():void");
    }
}
