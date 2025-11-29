package io.netty.handler.timeout;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

public class WriteTimeoutHandler extends ChannelOutboundHandlerAdapter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private boolean closed;
    private WriteTimeoutTask lastTask;
    private final long timeoutNanos;

    public final class WriteTimeoutTask implements Runnable, ChannelFutureListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        /* access modifiers changed from: private */
        public final ChannelHandlerContext ctx;
        WriteTimeoutTask next;
        WriteTimeoutTask prev;
        private final ChannelPromise promise;
        Future<?> scheduledFuture;

        public WriteTimeoutTask(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
        }

        public void run() {
            if (!this.promise.isDone()) {
                try {
                    WriteTimeoutHandler.this.writeTimedOut(this.ctx);
                } catch (Throwable th) {
                    this.ctx.fireExceptionCaught(th);
                }
            }
            WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
        }

        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            this.scheduledFuture.cancel(false);
            if (this.ctx.executor().inEventLoop()) {
                WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
            } else {
                this.ctx.executor().execute(this);
            }
        }
    }

    public WriteTimeoutHandler(int i) {
        this((long) i, TimeUnit.SECONDS);
    }

    private void addWriteTimeoutTask(WriteTimeoutTask writeTimeoutTask) {
        WriteTimeoutTask writeTimeoutTask2 = this.lastTask;
        if (writeTimeoutTask2 != null) {
            writeTimeoutTask2.next = writeTimeoutTask;
            writeTimeoutTask.prev = writeTimeoutTask2;
        }
        this.lastTask = writeTimeoutTask;
    }

    /* access modifiers changed from: private */
    public void removeWriteTimeoutTask(WriteTimeoutTask writeTimeoutTask) {
        WriteTimeoutTask writeTimeoutTask2 = this.lastTask;
        if (writeTimeoutTask == writeTimeoutTask2) {
            WriteTimeoutTask writeTimeoutTask3 = writeTimeoutTask2.prev;
            this.lastTask = writeTimeoutTask3;
            if (writeTimeoutTask3 != null) {
                writeTimeoutTask3.next = null;
            }
        } else {
            WriteTimeoutTask writeTimeoutTask4 = writeTimeoutTask.prev;
            if (writeTimeoutTask4 != null || writeTimeoutTask.next != null) {
                if (writeTimeoutTask4 == null) {
                    writeTimeoutTask.next.prev = null;
                } else {
                    writeTimeoutTask4.next = writeTimeoutTask.next;
                    writeTimeoutTask.next.prev = writeTimeoutTask4;
                }
            } else {
                return;
            }
        }
        writeTimeoutTask.prev = null;
        writeTimeoutTask.next = null;
    }

    private void scheduleTimeout(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        WriteTimeoutTask writeTimeoutTask = new WriteTimeoutTask(channelHandlerContext, channelPromise);
        ScheduledFuture<?> schedule = channelHandlerContext.executor().schedule((Runnable) writeTimeoutTask, this.timeoutNanos, TimeUnit.NANOSECONDS);
        writeTimeoutTask.scheduledFuture = schedule;
        if (!schedule.isDone()) {
            addWriteTimeoutTask(writeTimeoutTask);
            channelPromise.addListener(writeTimeoutTask);
        }
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        WriteTimeoutTask writeTimeoutTask = this.lastTask;
        this.lastTask = null;
        while (writeTimeoutTask != null) {
            writeTimeoutTask.scheduledFuture.cancel(false);
            WriteTimeoutTask writeTimeoutTask2 = writeTimeoutTask.prev;
            writeTimeoutTask.prev = null;
            writeTimeoutTask.next = null;
            writeTimeoutTask = writeTimeoutTask2;
        }
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.timeoutNanos > 0) {
            channelPromise = channelPromise.unvoid();
            scheduleTimeout(channelHandlerContext, channelPromise);
        }
        channelHandlerContext.write(obj, channelPromise);
    }

    public void writeTimedOut(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.closed) {
            channelHandlerContext.fireExceptionCaught(WriteTimeoutException.INSTANCE);
            channelHandlerContext.close();
            this.closed = true;
        }
    }

    public WriteTimeoutHandler(long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j <= 0) {
            this.timeoutNanos = 0;
        } else {
            this.timeoutNanos = Math.max(timeUnit.toNanos(j), MIN_TIMEOUT_NANOS);
        }
    }
}
