package io.netty.handler.flush;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.Future;

public class FlushConsolidationHandler extends ChannelDuplexHandler {
    public static final int DEFAULT_EXPLICIT_FLUSH_AFTER_FLUSHES = 256;
    private final boolean consolidateWhenNoReadInProgress;
    /* access modifiers changed from: private */
    public ChannelHandlerContext ctx;
    private final int explicitFlushAfterFlushes;
    /* access modifiers changed from: private */
    public int flushPendingCount;
    private final Runnable flushTask;
    /* access modifiers changed from: private */
    public Future<?> nextScheduledFlush;
    /* access modifiers changed from: private */
    public boolean readInProgress;

    public FlushConsolidationHandler() {
        this(256, false);
    }

    private void cancelScheduledFlush() {
        Future<?> future = this.nextScheduledFlush;
        if (future != null) {
            future.cancel(false);
            this.nextScheduledFlush = null;
        }
    }

    private void flushIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (this.flushPendingCount > 0) {
            flushNow(channelHandlerContext);
        }
    }

    private void flushNow(ChannelHandlerContext channelHandlerContext) {
        cancelScheduledFlush();
        this.flushPendingCount = 0;
        channelHandlerContext.flush();
    }

    private void resetReadAndFlushIfNeeded(ChannelHandlerContext channelHandlerContext) {
        this.readInProgress = false;
        flushIfNeeded(channelHandlerContext);
    }

    private void scheduleFlush(ChannelHandlerContext channelHandlerContext) {
        if (this.nextScheduledFlush == null) {
            this.nextScheduledFlush = channelHandlerContext.channel().eventLoop().submit(this.flushTask);
        }
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        this.readInProgress = true;
        channelHandlerContext.fireChannelRead(obj);
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.fireChannelReadComplete();
    }

    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!channelHandlerContext.channel().isWritable()) {
            flushIfNeeded(channelHandlerContext);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.close(channelPromise);
    }

    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.disconnect(channelPromise);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.fireExceptionCaught(th);
    }

    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.readInProgress) {
            int i = this.flushPendingCount + 1;
            this.flushPendingCount = i;
            if (i == this.explicitFlushAfterFlushes) {
                flushNow(channelHandlerContext);
            }
        } else if (this.consolidateWhenNoReadInProgress) {
            int i2 = this.flushPendingCount + 1;
            this.flushPendingCount = i2;
            if (i2 == this.explicitFlushAfterFlushes) {
                flushNow(channelHandlerContext);
            } else {
                scheduleFlush(channelHandlerContext);
            }
        } else {
            flushNow(channelHandlerContext);
        }
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        flushIfNeeded(channelHandlerContext);
    }

    public FlushConsolidationHandler(int i) {
        this(i, false);
    }

    public FlushConsolidationHandler(int i, boolean z) {
        this.explicitFlushAfterFlushes = ObjectUtil.checkPositive(i, "explicitFlushAfterFlushes");
        this.consolidateWhenNoReadInProgress = z;
        this.flushTask = z ? new Runnable() {
            public void run() {
                if (FlushConsolidationHandler.this.flushPendingCount > 0 && !FlushConsolidationHandler.this.readInProgress) {
                    int unused = FlushConsolidationHandler.this.flushPendingCount = 0;
                    Future unused2 = FlushConsolidationHandler.this.nextScheduledFlush = null;
                    FlushConsolidationHandler.this.ctx.flush();
                }
            }
        } : null;
    }
}
