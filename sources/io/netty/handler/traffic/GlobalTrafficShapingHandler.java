package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;

@ChannelHandler.Sharable
public class GlobalTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ConcurrentMap<Integer, PerChannel> channelQueues = PlatformDependent.newConcurrentHashMap();
    long maxGlobalWriteSize = 419430400;
    private final AtomicLong queuesSize = new AtomicLong();

    public static final class PerChannel {
        long lastReadTimestamp;
        long lastWriteTimestamp;
        ArrayDeque<ToSend> messagesQueue;
        long queueSize;

        private PerChannel() {
        }
    }

    public static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final long size;
        final Object toSend;

        private ToSend(long j, Object obj, long j2, ChannelPromise channelPromise) {
            this.relativeTimeAction = j;
            this.toSend = obj;
            this.size = j2;
            this.promise = channelPromise;
        }
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j, long j2, long j3, long j4) {
        super(j, j2, j3, j4);
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    private PerChannel getOrSetPerChannel(ChannelHandlerContext channelHandlerContext) {
        Integer valueOf = Integer.valueOf(channelHandlerContext.channel().hashCode());
        PerChannel perChannel = this.channelQueues.get(valueOf);
        if (perChannel != null) {
            return perChannel;
        }
        PerChannel perChannel2 = new PerChannel();
        perChannel2.messagesQueue = new ArrayDeque<>();
        perChannel2.queueSize = 0;
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        perChannel2.lastReadTimestamp = milliSecondFromNano;
        perChannel2.lastWriteTimestamp = milliSecondFromNano;
        this.channelQueues.put(valueOf, perChannel2);
        return perChannel2;
    }

    /* access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext channelHandlerContext, PerChannel perChannel, long j) {
        synchronized (perChannel) {
            try {
                ToSend pollFirst = perChannel.messagesQueue.pollFirst();
                while (true) {
                    if (pollFirst != null) {
                        if (pollFirst.relativeTimeAction > j) {
                            perChannel.messagesQueue.addFirst(pollFirst);
                            break;
                        }
                        long j2 = pollFirst.size;
                        this.trafficCounter.bytesRealWriteFlowControl(j2);
                        perChannel.queueSize -= j2;
                        this.queuesSize.addAndGet(-j2);
                        channelHandlerContext.write(pollFirst.toSend, pollFirst.promise);
                        perChannel.lastWriteTimestamp = j;
                        pollFirst = perChannel.messagesQueue.pollFirst();
                    } else {
                        break;
                    }
                }
                if (perChannel.messagesQueue.isEmpty()) {
                    releaseWriteSuspended(channelHandlerContext);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        channelHandlerContext.flush();
    }

    public long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j, long j2) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        return (perChannel == null || j <= this.maxTime || (j2 + j) - perChannel.lastReadTimestamp <= this.maxTime) ? j : this.maxTime;
    }

    public void createGlobalTrafficCounter(ScheduledExecutorService scheduledExecutorService) {
        TrafficCounter trafficCounter = new TrafficCounter(this, (ScheduledExecutorService) ObjectUtil.checkNotNull(scheduledExecutorService, "executor"), "GlobalTC", this.checkInterval);
        setTrafficCounter(trafficCounter);
        trafficCounter.start();
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        getOrSetPerChannel(channelHandlerContext);
        super.handlerAdded(channelHandlerContext);
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        Channel channel = channelHandlerContext.channel();
        PerChannel remove = this.channelQueues.remove(Integer.valueOf(channel.hashCode()));
        if (remove != null) {
            synchronized (remove) {
                try {
                    if (channel.isActive()) {
                        Iterator<ToSend> it = remove.messagesQueue.iterator();
                        while (it.hasNext()) {
                            ToSend next = it.next();
                            long calculateSize = calculateSize(next.toSend);
                            this.trafficCounter.bytesRealWriteFlowControl(calculateSize);
                            remove.queueSize -= calculateSize;
                            this.queuesSize.addAndGet(-calculateSize);
                            channelHandlerContext.write(next.toSend, next.promise);
                        }
                    } else {
                        this.queuesSize.addAndGet(-remove.queueSize);
                        Iterator<ToSend> it2 = remove.messagesQueue.iterator();
                        while (it2.hasNext()) {
                            Object obj = it2.next().toSend;
                            if (obj instanceof ByteBuf) {
                                ((ByteBuf) obj).release();
                            }
                        }
                    }
                    remove.messagesQueue.clear();
                } finally {
                }
            }
        }
        releaseWriteSuspended(channelHandlerContext);
        releaseReadSuspended(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    public void informReadOperation(ChannelHandlerContext channelHandlerContext, long j) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel != null) {
            perChannel.lastReadTimestamp = j;
        }
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public final void release() {
        this.trafficCounter.stop();
    }

    public void setMaxGlobalWriteSize(long j) {
        this.maxGlobalWriteSize = j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009c, code lost:
        if (r2 == false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009e, code lost:
        setUserDefinedWritability(r1, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a1, code lost:
        r20 = r17;
        r21 = r12;
        r22 = r2.relativeTimeAction;
        r17.executor().schedule((java.lang.Runnable) new io.netty.handler.traffic.GlobalTrafficShapingHandler.AnonymousClass1(r16), r13, java.util.concurrent.TimeUnit.MILLISECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bb, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void submitWrite(io.netty.channel.ChannelHandlerContext r17, java.lang.Object r18, long r19, long r21, long r23, io.netty.channel.ChannelPromise r25) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r10 = r19
            r2 = r23
            io.netty.channel.Channel r4 = r17.channel()
            int r4 = r4.hashCode()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.util.concurrent.ConcurrentMap<java.lang.Integer, io.netty.handler.traffic.GlobalTrafficShapingHandler$PerChannel> r5 = r0.channelQueues
            java.lang.Object r4 = r5.get(r4)
            io.netty.handler.traffic.GlobalTrafficShapingHandler$PerChannel r4 = (io.netty.handler.traffic.GlobalTrafficShapingHandler.PerChannel) r4
            if (r4 != 0) goto L_0x0022
            io.netty.handler.traffic.GlobalTrafficShapingHandler$PerChannel r4 = r16.getOrSetPerChannel(r17)
        L_0x0022:
            r12 = r4
            monitor-enter(r12)
            r4 = 0
            int r4 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0045
            java.util.ArrayDeque<io.netty.handler.traffic.GlobalTrafficShapingHandler$ToSend> r4 = r12.messagesQueue     // Catch:{ all -> 0x0042 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x0045
            io.netty.handler.traffic.TrafficCounter r0 = r0.trafficCounter     // Catch:{ all -> 0x0042 }
            r0.bytesRealWriteFlowControl(r10)     // Catch:{ all -> 0x0042 }
            r5 = r18
            r8 = r25
            r1.write(r5, r8)     // Catch:{ all -> 0x0042 }
            r12.lastWriteTimestamp = r2     // Catch:{ all -> 0x0042 }
            monitor-exit(r12)     // Catch:{ all -> 0x0042 }
            return
        L_0x0042:
            r0 = move-exception
            goto L_0x00bc
        L_0x0045:
            r5 = r18
            r8 = r25
            long r6 = r0.maxTime     // Catch:{ all -> 0x0042 }
            int r4 = (r21 > r6 ? 1 : (r21 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x005e
            long r6 = r2 + r21
            long r13 = r12.lastWriteTimestamp     // Catch:{ all -> 0x0042 }
            long r6 = r6 - r13
            long r13 = r0.maxTime     // Catch:{ all -> 0x0042 }
            int r4 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x005e
            long r6 = r0.maxTime     // Catch:{ all -> 0x0042 }
            r13 = r6
            goto L_0x0060
        L_0x005e:
            r13 = r21
        L_0x0060:
            io.netty.handler.traffic.GlobalTrafficShapingHandler$ToSend r15 = new io.netty.handler.traffic.GlobalTrafficShapingHandler$ToSend     // Catch:{ all -> 0x0042 }
            long r3 = r13 + r2
            r9 = 0
            r2 = r15
            r5 = r18
            r6 = r19
            r8 = r25
            r2.<init>(r3, r5, r6, r8)     // Catch:{ all -> 0x0042 }
            java.util.ArrayDeque<io.netty.handler.traffic.GlobalTrafficShapingHandler$ToSend> r2 = r12.messagesQueue     // Catch:{ all -> 0x0042 }
            r2.addLast(r15)     // Catch:{ all -> 0x0042 }
            long r2 = r12.queueSize     // Catch:{ all -> 0x0042 }
            long r2 = r2 + r10
            r12.queueSize = r2     // Catch:{ all -> 0x0042 }
            java.util.concurrent.atomic.AtomicLong r2 = r0.queuesSize     // Catch:{ all -> 0x0042 }
            r2.addAndGet(r10)     // Catch:{ all -> 0x0042 }
            long r2 = r12.queueSize     // Catch:{ all -> 0x0042 }
            r18 = r16
            r19 = r17
            r20 = r13
            r22 = r2
            r18.checkWriteSuspend(r19, r20, r22)     // Catch:{ all -> 0x0042 }
            java.util.concurrent.atomic.AtomicLong r2 = r0.queuesSize     // Catch:{ all -> 0x0042 }
            long r2 = r2.get()     // Catch:{ all -> 0x0042 }
            long r4 = r0.maxGlobalWriteSize     // Catch:{ all -> 0x0042 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r3 = 0
            if (r2 <= 0) goto L_0x009a
            r2 = 1
            goto L_0x009b
        L_0x009a:
            r2 = r3
        L_0x009b:
            monitor-exit(r12)     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x00a1
            r0.setUserDefinedWritability(r1, r3)
        L_0x00a1:
            long r2 = r15.relativeTimeAction
            io.netty.util.concurrent.EventExecutor r4 = r17.executor()
            io.netty.handler.traffic.GlobalTrafficShapingHandler$1 r5 = new io.netty.handler.traffic.GlobalTrafficShapingHandler$1
            r18 = r5
            r19 = r16
            r20 = r17
            r21 = r12
            r22 = r2
            r18.<init>(r20, r21, r22)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            r4.schedule((java.lang.Runnable) r5, (long) r13, (java.util.concurrent.TimeUnit) r0)
            return
        L_0x00bc:
            monitor-exit(r12)     // Catch:{ all -> 0x0042 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.traffic.GlobalTrafficShapingHandler.submitWrite(io.netty.channel.ChannelHandlerContext, java.lang.Object, long, long, long, io.netty.channel.ChannelPromise):void");
    }

    public int userDefinedWritabilityIndex() {
        return 2;
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j, long j2, long j3) {
        super(j, j2, j3);
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j, long j2) {
        super(j, j2);
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j) {
        super(j);
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(EventExecutor eventExecutor) {
        createGlobalTrafficCounter(eventExecutor);
    }
}
