package io.netty.handler.timeout;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

public class IdleStateHandler extends ChannelDuplexHandler {
    private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    /* access modifiers changed from: private */
    public final long allIdleTimeNanos;
    /* access modifiers changed from: private */
    public Future<?> allIdleTimeout;
    /* access modifiers changed from: private */
    public boolean firstAllIdleEvent;
    /* access modifiers changed from: private */
    public boolean firstReaderIdleEvent;
    /* access modifiers changed from: private */
    public boolean firstWriterIdleEvent;
    private long lastChangeCheckTimeStamp;
    private long lastFlushProgress;
    private int lastMessageHashCode;
    private long lastPendingWriteBytes;
    /* access modifiers changed from: private */
    public long lastReadTime;
    /* access modifiers changed from: private */
    public long lastWriteTime;
    private final boolean observeOutput;
    /* access modifiers changed from: private */
    public final long readerIdleTimeNanos;
    /* access modifiers changed from: private */
    public Future<?> readerIdleTimeout;
    /* access modifiers changed from: private */
    public boolean reading;
    private byte state;
    private final ChannelFutureListener writeListener;
    /* access modifiers changed from: private */
    public final long writerIdleTimeNanos;
    /* access modifiers changed from: private */
    public Future<?> writerIdleTimeout;

    /* renamed from: io.netty.handler.timeout.IdleStateHandler$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$timeout$IdleState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.netty.handler.timeout.IdleState[] r0 = io.netty.handler.timeout.IdleState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$timeout$IdleState = r0
                io.netty.handler.timeout.IdleState r1 = io.netty.handler.timeout.IdleState.ALL_IDLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$timeout$IdleState     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.timeout.IdleState r1 = io.netty.handler.timeout.IdleState.READER_IDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$timeout$IdleState     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.timeout.IdleState r1 = io.netty.handler.timeout.IdleState.WRITER_IDLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.timeout.IdleStateHandler.AnonymousClass2.<clinit>():void");
        }
    }

    public static abstract class AbstractIdleTask implements Runnable {
        private final ChannelHandlerContext ctx;

        public AbstractIdleTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        public void run() {
            if (this.ctx.channel().isOpen()) {
                run(this.ctx);
            }
        }

        public abstract void run(ChannelHandlerContext channelHandlerContext);
    }

    public final class AllIdleTimeoutTask extends AbstractIdleTask {
        public AllIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        public void run(ChannelHandlerContext channelHandlerContext) {
            long access$1100 = IdleStateHandler.this.allIdleTimeNanos;
            if (!IdleStateHandler.this.reading) {
                access$1100 -= IdleStateHandler.this.ticksInNanos() - Math.max(IdleStateHandler.this.lastReadTime, IdleStateHandler.this.lastWriteTime);
            }
            long j = access$1100;
            if (j <= 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                Future unused = idleStateHandler.allIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, idleStateHandler.allIdleTimeNanos, TimeUnit.NANOSECONDS);
                boolean access$200 = IdleStateHandler.this.firstAllIdleEvent;
                boolean unused2 = IdleStateHandler.this.firstAllIdleEvent = false;
                try {
                    if (!IdleStateHandler.this.hasOutputChanged(channelHandlerContext, access$200)) {
                        IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.ALL_IDLE, access$200));
                    }
                } catch (Throwable th) {
                    channelHandlerContext.fireExceptionCaught(th);
                }
            } else {
                IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
                Future unused3 = idleStateHandler2.allIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, j, TimeUnit.NANOSECONDS);
            }
        }
    }

    public final class ReaderIdleTimeoutTask extends AbstractIdleTask {
        public ReaderIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        public void run(ChannelHandlerContext channelHandlerContext) {
            long access$300 = IdleStateHandler.this.readerIdleTimeNanos;
            if (!IdleStateHandler.this.reading) {
                access$300 -= IdleStateHandler.this.ticksInNanos() - IdleStateHandler.this.lastReadTime;
            }
            long j = access$300;
            if (j <= 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                Future unused = idleStateHandler.readerIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, idleStateHandler.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
                boolean access$700 = IdleStateHandler.this.firstReaderIdleEvent;
                boolean unused2 = IdleStateHandler.this.firstReaderIdleEvent = false;
                try {
                    IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.READER_IDLE, access$700));
                } catch (Throwable th) {
                    channelHandlerContext.fireExceptionCaught(th);
                }
            } else {
                IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
                Future unused3 = idleStateHandler2.readerIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, j, TimeUnit.NANOSECONDS);
            }
        }
    }

    public final class WriterIdleTimeoutTask extends AbstractIdleTask {
        public WriterIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        public void run(ChannelHandlerContext channelHandlerContext) {
            long access$800 = IdleStateHandler.this.writerIdleTimeNanos - (IdleStateHandler.this.ticksInNanos() - IdleStateHandler.this.lastWriteTime);
            if (access$800 <= 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                Future unused = idleStateHandler.writerIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, idleStateHandler.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
                boolean access$100 = IdleStateHandler.this.firstWriterIdleEvent;
                boolean unused2 = IdleStateHandler.this.firstWriterIdleEvent = false;
                try {
                    if (!IdleStateHandler.this.hasOutputChanged(channelHandlerContext, access$100)) {
                        IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.WRITER_IDLE, access$100));
                    }
                } catch (Throwable th) {
                    channelHandlerContext.fireExceptionCaught(th);
                }
            } else {
                IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
                Future unused3 = idleStateHandler2.writerIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, access$800, TimeUnit.NANOSECONDS);
            }
        }
    }

    public IdleStateHandler(int i, int i2, int i3) {
        this((long) i, (long) i2, (long) i3, TimeUnit.SECONDS);
    }

    private void destroy() {
        this.state = 2;
        Future<?> future = this.readerIdleTimeout;
        if (future != null) {
            future.cancel(false);
            this.readerIdleTimeout = null;
        }
        Future<?> future2 = this.writerIdleTimeout;
        if (future2 != null) {
            future2.cancel(false);
            this.writerIdleTimeout = null;
        }
        Future<?> future3 = this.allIdleTimeout;
        if (future3 != null) {
            future3.cancel(false);
            this.allIdleTimeout = null;
        }
    }

    /* access modifiers changed from: private */
    public boolean hasOutputChanged(ChannelHandlerContext channelHandlerContext, boolean z) {
        if (!this.observeOutput) {
            return false;
        }
        long j = this.lastChangeCheckTimeStamp;
        long j2 = this.lastWriteTime;
        if (j != j2) {
            this.lastChangeCheckTimeStamp = j2;
            if (!z) {
                return true;
            }
        }
        ChannelOutboundBuffer outboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer();
        if (outboundBuffer == null) {
            return false;
        }
        int identityHashCode = System.identityHashCode(outboundBuffer.current());
        long j3 = outboundBuffer.totalPendingWriteBytes();
        if (!(identityHashCode == this.lastMessageHashCode && j3 == this.lastPendingWriteBytes)) {
            this.lastMessageHashCode = identityHashCode;
            this.lastPendingWriteBytes = j3;
            if (!z) {
                return true;
            }
        }
        long currentProgress = outboundBuffer.currentProgress();
        if (currentProgress == this.lastFlushProgress) {
            return false;
        }
        this.lastFlushProgress = currentProgress;
        return !z;
    }

    private void initOutputChanged(ChannelHandlerContext channelHandlerContext) {
        ChannelOutboundBuffer outboundBuffer;
        if (this.observeOutput && (outboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer()) != null) {
            this.lastMessageHashCode = System.identityHashCode(outboundBuffer.current());
            this.lastPendingWriteBytes = outboundBuffer.totalPendingWriteBytes();
            this.lastFlushProgress = outboundBuffer.currentProgress();
        }
    }

    private void initialize(ChannelHandlerContext channelHandlerContext) {
        byte b = this.state;
        if (b != 1 && b != 2) {
            this.state = 1;
            initOutputChanged(channelHandlerContext);
            long ticksInNanos = ticksInNanos();
            this.lastWriteTime = ticksInNanos;
            this.lastReadTime = ticksInNanos;
            if (this.readerIdleTimeNanos > 0) {
                this.readerIdleTimeout = schedule(channelHandlerContext, new ReaderIdleTimeoutTask(channelHandlerContext), this.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
            }
            if (this.writerIdleTimeNanos > 0) {
                this.writerIdleTimeout = schedule(channelHandlerContext, new WriterIdleTimeoutTask(channelHandlerContext), this.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
            }
            if (this.allIdleTimeNanos > 0) {
                this.allIdleTimeout = schedule(channelHandlerContext, new AllIdleTimeoutTask(channelHandlerContext), this.allIdleTimeNanos, TimeUnit.NANOSECONDS);
            }
        }
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        initialize(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    public void channelIdle(ChannelHandlerContext channelHandlerContext, IdleStateEvent idleStateEvent) throws Exception {
        channelHandlerContext.fireUserEventTriggered(idleStateEvent);
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
        super.channelInactive(channelHandlerContext);
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) {
            this.reading = true;
            this.firstAllIdleEvent = true;
            this.firstReaderIdleEvent = true;
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if ((this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) && this.reading) {
            this.lastReadTime = ticksInNanos();
            this.reading = false;
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isActive()) {
            initialize(channelHandlerContext);
        }
        super.channelRegistered(channelHandlerContext);
    }

    public long getAllIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.allIdleTimeNanos);
    }

    public long getReaderIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.readerIdleTimeNanos);
    }

    public long getWriterIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.writerIdleTimeNanos);
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isActive() && channelHandlerContext.channel().isRegistered()) {
            initialize(channelHandlerContext);
        }
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
    }

    public IdleStateEvent newIdleStateEvent(IdleState idleState, boolean z) {
        int i = AnonymousClass2.$SwitchMap$io$netty$handler$timeout$IdleState[idleState.ordinal()];
        if (i == 1) {
            return z ? IdleStateEvent.FIRST_ALL_IDLE_STATE_EVENT : IdleStateEvent.ALL_IDLE_STATE_EVENT;
        }
        if (i == 2) {
            return z ? IdleStateEvent.FIRST_READER_IDLE_STATE_EVENT : IdleStateEvent.READER_IDLE_STATE_EVENT;
        }
        if (i == 3) {
            return z ? IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT : IdleStateEvent.WRITER_IDLE_STATE_EVENT;
        }
        throw new IllegalArgumentException("Unhandled: state=" + idleState + ", first=" + z);
    }

    public Future<?> schedule(ChannelHandlerContext channelHandlerContext, Runnable runnable, long j, TimeUnit timeUnit) {
        return channelHandlerContext.executor().schedule(runnable, j, timeUnit);
    }

    public long ticksInNanos() {
        return System.nanoTime();
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.writerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) {
            channelHandlerContext.write(obj, channelPromise.unvoid()).addListener(this.writeListener);
        } else {
            channelHandlerContext.write(obj, channelPromise);
        }
    }

    public IdleStateHandler(long j, long j2, long j3, TimeUnit timeUnit) {
        this(false, j, j2, j3, timeUnit);
    }

    public IdleStateHandler(boolean z, long j, long j2, long j3, TimeUnit timeUnit) {
        this.writeListener = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                long unused = idleStateHandler.lastWriteTime = idleStateHandler.ticksInNanos();
                IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
                boolean unused2 = idleStateHandler2.firstWriterIdleEvent = idleStateHandler2.firstAllIdleEvent = true;
            }
        };
        this.firstReaderIdleEvent = true;
        this.firstWriterIdleEvent = true;
        this.firstAllIdleEvent = true;
        ObjectUtil.checkNotNull(timeUnit, "unit");
        this.observeOutput = z;
        if (j <= 0) {
            this.readerIdleTimeNanos = 0;
        } else {
            this.readerIdleTimeNanos = Math.max(timeUnit.toNanos(j), MIN_TIMEOUT_NANOS);
        }
        if (j2 <= 0) {
            this.writerIdleTimeNanos = 0;
        } else {
            this.writerIdleTimeNanos = Math.max(timeUnit.toNanos(j2), MIN_TIMEOUT_NANOS);
        }
        if (j3 <= 0) {
            this.allIdleTimeNanos = 0;
        } else {
            this.allIdleTimeNanos = Math.max(timeUnit.toNanos(j3), MIN_TIMEOUT_NANOS);
        }
    }
}
