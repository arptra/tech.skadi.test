package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

public abstract class AbstractCoalescingBufferQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractCoalescingBufferQueue.class);
    private final ArrayDeque<Object> bufAndListenerPairs;
    private int readableBytes;
    private final PendingBytesTracker tracker;

    public AbstractCoalescingBufferQueue(Channel channel, int i) {
        this.bufAndListenerPairs = new ArrayDeque<>(i);
        this.tracker = channel == null ? null : PendingBytesTracker.newTracker(channel);
    }

    private void decrementReadableBytes(int i) {
        this.readableBytes -= i;
        PendingBytesTracker pendingBytesTracker = this.tracker;
        if (pendingBytesTracker != null) {
            pendingBytesTracker.decrementPendingOutboundBytes((long) i);
        }
    }

    private void incrementReadableBytes(int i) {
        int i2 = this.readableBytes;
        int i3 = i2 + i;
        if (i3 >= i2) {
            this.readableBytes = i3;
            PendingBytesTracker pendingBytesTracker = this.tracker;
            if (pendingBytesTracker != null) {
                pendingBytesTracker.incrementPendingOutboundBytes((long) i);
                return;
            }
            return;
        }
        throw new IllegalStateException("buffer queue length overflow: " + this.readableBytes + " + " + i);
    }

    private void releaseAndCompleteAll(ChannelFuture channelFuture) {
        Throwable th = null;
        while (true) {
            Object poll = this.bufAndListenerPairs.poll();
            if (poll == null) {
                break;
            }
            try {
                if (poll instanceof ByteBuf) {
                    ByteBuf byteBuf = (ByteBuf) poll;
                    decrementReadableBytes(byteBuf.readableBytes());
                    ReferenceCountUtil.safeRelease(byteBuf);
                } else {
                    ((ChannelFutureListener) poll).operationComplete(channelFuture);
                }
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    logger.info("Throwable being suppressed because Throwable {} is already pending", th, th2);
                }
            }
        }
        if (th != null) {
            throw new IllegalStateException(th);
        }
    }

    private static ChannelFutureListener toChannelFutureListener(ChannelPromise channelPromise) {
        if (channelPromise.isVoid()) {
            return null;
        }
        return new DelegatingChannelPromiseNotifier(channelPromise);
    }

    public final void add(ByteBuf byteBuf) {
        add(byteBuf, (ChannelFutureListener) null);
    }

    public final void addFirst(ByteBuf byteBuf, ChannelPromise channelPromise) {
        addFirst(byteBuf, toChannelFutureListener(channelPromise));
    }

    public abstract ByteBuf compose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);

    public ByteBuf composeFirst(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        return byteBuf;
    }

    public final ByteBuf composeIntoComposite(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
        CompositeByteBuf compositeBuffer = byteBufAllocator.compositeBuffer(size() + 2);
        try {
            compositeBuffer.addComponent(true, byteBuf);
            compositeBuffer.addComponent(true, byteBuf2);
        } catch (Throwable th) {
            compositeBuffer.release();
            ReferenceCountUtil.safeRelease(byteBuf2);
            PlatformDependent.throwException(th);
        }
        return compositeBuffer;
    }

    public final ByteBuf copyAndCompose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
        ByteBuf ioBuffer = byteBufAllocator.ioBuffer(byteBuf.readableBytes() + byteBuf2.readableBytes());
        try {
            ioBuffer.writeBytes(byteBuf).writeBytes(byteBuf2);
        } catch (Throwable th) {
            ioBuffer.release();
            ReferenceCountUtil.safeRelease(byteBuf2);
            PlatformDependent.throwException(th);
        }
        byteBuf.release();
        byteBuf2.release();
        return ioBuffer;
    }

    public final void copyTo(AbstractCoalescingBufferQueue abstractCoalescingBufferQueue) {
        abstractCoalescingBufferQueue.bufAndListenerPairs.addAll(this.bufAndListenerPairs);
        abstractCoalescingBufferQueue.incrementReadableBytes(this.readableBytes);
    }

    public final boolean isEmpty() {
        return this.bufAndListenerPairs.isEmpty();
    }

    public final int readableBytes() {
        return this.readableBytes;
    }

    public final void releaseAndFailAll(ChannelOutboundInvoker channelOutboundInvoker, Throwable th) {
        releaseAndCompleteAll(channelOutboundInvoker.newFailedFuture(th));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        r5.bufAndListenerPairs.addFirst(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r1 <= 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        r0 = r3.readRetainedSlice(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        if (r2 != null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r6 = composeFirst(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        r6 = compose(r6, r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r1 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final io.netty.buffer.ByteBuf remove(io.netty.buffer.ByteBufAllocator r6, int r7, io.netty.channel.ChannelPromise r8) {
        /*
            r5 = this;
            java.lang.String r0 = "bytes"
            io.netty.util.internal.ObjectUtil.checkPositiveOrZero((int) r7, (java.lang.String) r0)
            java.lang.String r0 = "aggregatePromise"
            io.netty.util.internal.ObjectUtil.checkNotNull(r8, r0)
            java.util.ArrayDeque<java.lang.Object> r0 = r5.bufAndListenerPairs
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0017
            io.netty.buffer.ByteBuf r5 = r5.removeEmptyValue()
            return r5
        L_0x0017:
            int r0 = r5.readableBytes
            int r7 = java.lang.Math.min(r7, r0)
            r0 = 0
            r1 = r7
            r2 = r0
        L_0x0020:
            java.util.ArrayDeque<java.lang.Object> r3 = r5.bufAndListenerPairs     // Catch:{ all -> 0x0033 }
            java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0033 }
            if (r3 != 0) goto L_0x0029
            goto L_0x0077
        L_0x0029:
            boolean r4 = r3 instanceof io.netty.channel.ChannelFutureListener     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x0035
            io.netty.channel.ChannelFutureListener r3 = (io.netty.channel.ChannelFutureListener) r3     // Catch:{ all -> 0x0033 }
            r8.addListener(r3)     // Catch:{ all -> 0x0033 }
            goto L_0x0020
        L_0x0033:
            r6 = move-exception
            goto L_0x006b
        L_0x0035:
            io.netty.buffer.ByteBuf r3 = (io.netty.buffer.ByteBuf) r3     // Catch:{ all -> 0x0033 }
            int r4 = r3.readableBytes()     // Catch:{ all -> 0x0057 }
            if (r4 <= r1) goto L_0x005a
            java.util.ArrayDeque<java.lang.Object> r0 = r5.bufAndListenerPairs     // Catch:{ all -> 0x0057 }
            r0.addFirst(r3)     // Catch:{ all -> 0x0057 }
            if (r1 <= 0) goto L_0x0077
            io.netty.buffer.ByteBuf r0 = r3.readRetainedSlice(r1)     // Catch:{ all -> 0x0057 }
            if (r2 != 0) goto L_0x0050
            io.netty.buffer.ByteBuf r6 = r5.composeFirst(r6, r0)     // Catch:{ all -> 0x0033 }
        L_0x004e:
            r2 = r6
            goto L_0x0055
        L_0x0050:
            io.netty.buffer.ByteBuf r6 = r5.compose(r6, r2, r0)     // Catch:{ all -> 0x0033 }
            goto L_0x004e
        L_0x0055:
            r1 = 0
            goto L_0x0077
        L_0x0057:
            r6 = move-exception
            r0 = r3
            goto L_0x006b
        L_0x005a:
            int r4 = r3.readableBytes()     // Catch:{ all -> 0x0057 }
            int r1 = r1 - r4
            if (r2 != 0) goto L_0x0066
            io.netty.buffer.ByteBuf r2 = r5.composeFirst(r6, r3)     // Catch:{ all -> 0x0057 }
            goto L_0x0020
        L_0x0066:
            io.netty.buffer.ByteBuf r2 = r5.compose(r6, r2, r3)     // Catch:{ all -> 0x0057 }
            goto L_0x0020
        L_0x006b:
            io.netty.util.ReferenceCountUtil.safeRelease(r0)
            io.netty.util.ReferenceCountUtil.safeRelease(r2)
            r8.setFailure(r6)
            io.netty.util.internal.PlatformDependent.throwException(r6)
        L_0x0077:
            int r7 = r7 - r1
            r5.decrementReadableBytes(r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.AbstractCoalescingBufferQueue.remove(io.netty.buffer.ByteBufAllocator, int, io.netty.channel.ChannelPromise):io.netty.buffer.ByteBuf");
    }

    public abstract ByteBuf removeEmptyValue();

    public final ByteBuf removeFirst(ChannelPromise channelPromise) {
        Object poll = this.bufAndListenerPairs.poll();
        if (poll == null) {
            return null;
        }
        ByteBuf byteBuf = (ByteBuf) poll;
        decrementReadableBytes(byteBuf.readableBytes());
        Object peek = this.bufAndListenerPairs.peek();
        if (peek instanceof ChannelFutureListener) {
            channelPromise.addListener((ChannelFutureListener) peek);
            this.bufAndListenerPairs.poll();
        }
        return byteBuf;
    }

    public final int size() {
        return this.bufAndListenerPairs.size();
    }

    public String toString() {
        return "bytes: " + this.readableBytes + " buffers: " + (size() >> 1);
    }

    public final void writeAndRemoveAll(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBuf = null;
        Throwable th = null;
        while (true) {
            Object poll = this.bufAndListenerPairs.poll();
            if (poll == null) {
                if (byteBuf == null) {
                    break;
                }
                try {
                    decrementReadableBytes(byteBuf.readableBytes());
                    channelHandlerContext.write(byteBuf, channelHandlerContext.voidPromise());
                    break;
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    } else {
                        logger.info("Throwable being suppressed because Throwable {} is already pending", th, th2);
                    }
                }
            } else if (poll instanceof ByteBuf) {
                if (byteBuf != null) {
                    decrementReadableBytes(byteBuf.readableBytes());
                    channelHandlerContext.write(byteBuf, channelHandlerContext.voidPromise());
                }
                byteBuf = (ByteBuf) poll;
            } else {
                if (poll instanceof ChannelPromise) {
                    decrementReadableBytes(byteBuf.readableBytes());
                    channelHandlerContext.write(byteBuf, (ChannelPromise) poll);
                } else {
                    decrementReadableBytes(byteBuf.readableBytes());
                    channelHandlerContext.write(byteBuf).addListener((ChannelFutureListener) poll);
                }
                byteBuf = null;
            }
        }
        if (th != null) {
            throw new IllegalStateException(th);
        }
    }

    private void addFirst(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.addFirst(channelFutureListener);
        }
        this.bufAndListenerPairs.addFirst(byteBuf);
        incrementReadableBytes(byteBuf.readableBytes());
    }

    public final void add(ByteBuf byteBuf, ChannelPromise channelPromise) {
        add(byteBuf, toChannelFutureListener(channelPromise));
    }

    public final void add(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        this.bufAndListenerPairs.add(byteBuf);
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.add(channelFutureListener);
        }
        incrementReadableBytes(byteBuf.readableBytes());
    }
}
