package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class ChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ArrayDeque<ToSend> messagesQueue = new ArrayDeque<>();
    private long queueSize;

    public static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final Object toSend;

        private ToSend(long j, Object obj, ChannelPromise channelPromise) {
            this.relativeTimeAction = j;
            this.toSend = obj;
            this.promise = channelPromise;
        }
    }

    public ChannelTrafficShapingHandler(long j, long j2, long j3, long j4) {
        super(j, j2, j3, j4);
    }

    /* access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext channelHandlerContext, long j) {
        synchronized (this) {
            try {
                ToSend pollFirst = this.messagesQueue.pollFirst();
                while (true) {
                    if (pollFirst != null) {
                        if (pollFirst.relativeTimeAction > j) {
                            this.messagesQueue.addFirst(pollFirst);
                            break;
                        }
                        long calculateSize = calculateSize(pollFirst.toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(calculateSize);
                        this.queueSize -= calculateSize;
                        channelHandlerContext.write(pollFirst.toSend, pollFirst.promise);
                        pollFirst = this.messagesQueue.pollFirst();
                    } else {
                        break;
                    }
                }
                if (this.messagesQueue.isEmpty()) {
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

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        EventExecutor executor = channelHandlerContext.executor();
        TrafficCounter trafficCounter = new TrafficCounter(this, executor, "ChannelTC" + channelHandlerContext.channel().hashCode(), this.checkInterval);
        setTrafficCounter(trafficCounter);
        trafficCounter.start();
        super.handlerAdded(channelHandlerContext);
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.trafficCounter.stop();
        synchronized (this) {
            try {
                if (channelHandlerContext.channel().isActive()) {
                    Iterator<ToSend> it = this.messagesQueue.iterator();
                    while (it.hasNext()) {
                        ToSend next = it.next();
                        long calculateSize = calculateSize(next.toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(calculateSize);
                        this.queueSize -= calculateSize;
                        channelHandlerContext.write(next.toSend, next.promise);
                    }
                } else {
                    Iterator<ToSend> it2 = this.messagesQueue.iterator();
                    while (it2.hasNext()) {
                        Object obj = it2.next().toSend;
                        if (obj instanceof ByteBuf) {
                            ((ByteBuf) obj).release();
                        }
                    }
                }
                this.messagesQueue.clear();
            } finally {
                while (true) {
                }
            }
        }
        releaseWriteSuspended(channelHandlerContext);
        releaseReadSuspended(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    public long queueSize() {
        return this.queueSize;
    }

    public void submitWrite(ChannelHandlerContext channelHandlerContext, Object obj, long j, long j2, long j3, ChannelPromise channelPromise) {
        final ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
        long j4 = j;
        long j5 = j2;
        synchronized (this) {
            if (j5 == 0) {
                try {
                    if (this.messagesQueue.isEmpty()) {
                        this.trafficCounter.bytesRealWriteFlowControl(j4);
                        channelHandlerContext2.write(obj, channelPromise);
                        return;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            Object obj2 = obj;
            ChannelPromise channelPromise2 = channelPromise;
            ToSend toSend = new ToSend(j5 + j3, obj, channelPromise);
            this.messagesQueue.addLast(toSend);
            long j6 = this.queueSize + j4;
            this.queueSize = j6;
            ToSend toSend2 = toSend;
            checkWriteSuspend(channelHandlerContext, j2, j6);
            final long j7 = toSend2.relativeTimeAction;
            channelHandlerContext.executor().schedule((Runnable) new Runnable() {
                public void run() {
                    ChannelTrafficShapingHandler.this.sendAllValid(channelHandlerContext2, j7);
                }
            }, j5, TimeUnit.MILLISECONDS);
        }
    }

    public ChannelTrafficShapingHandler(long j, long j2, long j3) {
        super(j, j2, j3);
    }

    public ChannelTrafficShapingHandler(long j, long j2) {
        super(j, j2);
    }

    public ChannelTrafficShapingHandler(long j) {
        super(j);
    }
}
