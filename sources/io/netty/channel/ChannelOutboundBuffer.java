package io.netty.channel;

import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public final class ChannelOutboundBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.outboundBufferEntrySizeOverhead", 96);
    private static final FastThreadLocal<ByteBuffer[]> NIO_BUFFERS = new FastThreadLocal<ByteBuffer[]>() {
        public ByteBuffer[] initialValue() throws Exception {
            return new ByteBuffer[1024];
        }
    };
    private static final AtomicLongFieldUpdater<ChannelOutboundBuffer> TOTAL_PENDING_SIZE_UPDATER;
    private static final AtomicIntegerFieldUpdater<ChannelOutboundBuffer> UNWRITABLE_UPDATER;
    private static final InternalLogger logger;
    private final Channel channel;
    private volatile Runnable fireChannelWritabilityChangedTask;
    private int flushed;
    private Entry flushedEntry;
    private boolean inFail;
    private int nioBufferCount;
    private long nioBufferSize;
    private Entry tailEntry;
    private volatile long totalPendingSize;
    private Entry unflushedEntry;
    private volatile int unwritable;

    public static final class Entry {
        private static final ObjectPool<Entry> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<Entry>() {
            public Entry newObject(ObjectPool.Handle<Entry> handle) {
                return new Entry(handle);
            }
        });
        ByteBuffer buf;
        ByteBuffer[] bufs;
        boolean cancelled;
        int count;
        private final ObjectPool.Handle<Entry> handle;
        Object msg;
        Entry next;
        int pendingSize;
        long progress;
        ChannelPromise promise;
        long total;

        public static Entry newInstance(Object obj, int i, long j, ChannelPromise channelPromise) {
            Entry entry = RECYCLER.get();
            entry.msg = obj;
            entry.pendingSize = i + ChannelOutboundBuffer.CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD;
            entry.total = j;
            entry.promise = channelPromise;
            return entry;
        }

        public int cancel() {
            if (this.cancelled) {
                return 0;
            }
            this.cancelled = true;
            int i = this.pendingSize;
            ReferenceCountUtil.safeRelease(this.msg);
            this.msg = Unpooled.EMPTY_BUFFER;
            this.pendingSize = 0;
            this.total = 0;
            this.progress = 0;
            this.bufs = null;
            this.buf = null;
            return i;
        }

        public void recycle() {
            this.next = null;
            this.bufs = null;
            this.buf = null;
            this.msg = null;
            this.promise = null;
            this.progress = 0;
            this.total = 0;
            this.pendingSize = 0;
            this.count = -1;
            this.cancelled = false;
            this.handle.recycle(this);
        }

        public Entry recycleAndGetNext() {
            Entry entry = this.next;
            recycle();
            return entry;
        }

        private Entry(ObjectPool.Handle<Entry> handle2) {
            this.count = -1;
            this.handle = handle2;
        }
    }

    public interface MessageProcessor {
        boolean processMessage(Object obj) throws Exception;
    }

    static {
        Class<ChannelOutboundBuffer> cls = ChannelOutboundBuffer.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(cls, "totalPendingSize");
        UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(cls, "unwritable");
    }

    public ChannelOutboundBuffer(AbstractChannel abstractChannel) {
        this.channel = abstractChannel;
    }

    private void clearNioBuffers() {
        int i = this.nioBufferCount;
        if (i > 0) {
            this.nioBufferCount = 0;
            Arrays.fill((Object[]) NIO_BUFFERS.get(), 0, i, (Object) null);
        }
    }

    private void clearUserDefinedWritability(int i) {
        int i2;
        int i3;
        int writabilityMask = writabilityMask(i);
        do {
            i2 = this.unwritable;
            i3 = i2 | writabilityMask;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i2, i3));
        if (i2 == 0 && i3 != 0) {
            fireChannelWritabilityChanged(true);
        }
    }

    private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] byteBufferArr, int i, int i2) {
        int length = byteBufferArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i > length);
        ByteBuffer[] byteBufferArr2 = new ByteBuffer[length];
        System.arraycopy(byteBufferArr, 0, byteBufferArr2, 0, i2);
        return byteBufferArr2;
    }

    private void fireChannelWritabilityChanged(boolean z) {
        final ChannelPipeline pipeline = this.channel.pipeline();
        if (z) {
            Runnable runnable = this.fireChannelWritabilityChangedTask;
            if (runnable == null) {
                runnable = new Runnable() {
                    public void run() {
                        pipeline.fireChannelWritabilityChanged();
                    }
                };
                this.fireChannelWritabilityChangedTask = runnable;
            }
            this.channel.eventLoop().execute(runnable);
            return;
        }
        pipeline.fireChannelWritabilityChanged();
    }

    private boolean isFlushedEntry(Entry entry) {
        return (entry == null || entry == this.unflushedEntry) ? false : true;
    }

    private boolean remove0(Throwable th, boolean z) {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeFail(channelPromise, th);
            decrementPendingOutboundBytes((long) i, false, z);
        }
        entry.recycle();
        return true;
    }

    private void removeEntry(Entry entry) {
        int i = this.flushed - 1;
        this.flushed = i;
        if (i == 0) {
            this.flushedEntry = null;
            if (entry == this.tailEntry) {
                this.tailEntry = null;
                this.unflushedEntry = null;
                return;
            }
            return;
        }
        this.flushedEntry = entry.next;
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        PromiseNotificationUtil.tryFailure(channelPromise, th, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    private static void safeSuccess(ChannelPromise channelPromise) {
        PromiseNotificationUtil.trySuccess(channelPromise, null, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    private void setUnwritable(boolean z) {
        int i;
        do {
            i = this.unwritable;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, i | 1));
        if (i == 0) {
            fireChannelWritabilityChanged(z);
        }
    }

    private void setWritable(boolean z) {
        int i;
        int i2;
        do {
            i = this.unwritable;
            i2 = i & -2;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, i2));
        if (i != 0 && i2 == 0) {
            fireChannelWritabilityChanged(z);
        }
    }

    private static long total(Object obj) {
        if (obj instanceof ByteBuf) {
            return (long) ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).count();
        }
        if (obj instanceof ByteBufHolder) {
            return (long) ((ByteBufHolder) obj).content().readableBytes();
        }
        return -1;
    }

    private static int writabilityMask(int i) {
        if (i >= 1 && i <= 31) {
            return 1 << i;
        }
        throw new IllegalArgumentException("index: " + i + " (expected: 1~31)");
    }

    public void addFlush() {
        Entry entry = this.unflushedEntry;
        if (entry != null) {
            if (this.flushedEntry == null) {
                this.flushedEntry = entry;
            }
            do {
                this.flushed++;
                if (!entry.promise.setUncancellable()) {
                    decrementPendingOutboundBytes((long) entry.cancel(), false, true);
                }
                entry = entry.next;
            } while (entry != null);
            this.unflushedEntry = null;
        }
    }

    public void addMessage(Object obj, int i, ChannelPromise channelPromise) {
        Entry newInstance = Entry.newInstance(obj, i, total(obj), channelPromise);
        Entry entry = this.tailEntry;
        if (entry == null) {
            this.flushedEntry = null;
        } else {
            entry.next = newInstance;
        }
        this.tailEntry = newInstance;
        if (this.unflushedEntry == null) {
            this.unflushedEntry = newInstance;
        }
        incrementPendingOutboundBytes((long) newInstance.pendingSize, false);
    }

    public long bytesBeforeUnwritable() {
        long writeBufferHighWaterMark = ((long) this.channel.config().getWriteBufferHighWaterMark()) - this.totalPendingSize;
        if (writeBufferHighWaterMark <= 0) {
            return 0;
        }
        if (isWritable()) {
            return writeBufferHighWaterMark;
        }
        return 0;
    }

    public long bytesBeforeWritable() {
        long writeBufferLowWaterMark = this.totalPendingSize - ((long) this.channel.config().getWriteBufferLowWaterMark());
        if (writeBufferLowWaterMark <= 0) {
            return 0;
        }
        if (isWritable()) {
            return 0;
        }
        return writeBufferLowWaterMark;
    }

    public void close(final Throwable th, final boolean z) {
        if (this.inFail) {
            this.channel.eventLoop().execute(new Runnable() {
                public void run() {
                    ChannelOutboundBuffer.this.close(th, z);
                }
            });
            return;
        }
        this.inFail = true;
        if (!z && this.channel.isOpen()) {
            throw new IllegalStateException("close() must be invoked after the channel is closed.");
        } else if (isEmpty()) {
            try {
                for (Entry entry = this.unflushedEntry; entry != null; entry = entry.recycleAndGetNext()) {
                    TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, (long) (-entry.pendingSize));
                    if (!entry.cancelled) {
                        ReferenceCountUtil.safeRelease(entry.msg);
                        safeFail(entry.promise, th);
                    }
                }
                this.inFail = false;
                clearNioBuffers();
            } catch (Throwable th2) {
                this.inFail = false;
                throw th2;
            }
        } else {
            throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
        }
    }

    public Object current() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return null;
        }
        return entry.msg;
    }

    public long currentProgress() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return 0;
        }
        return entry.progress;
    }

    public void decrementPendingOutboundBytes(long j) {
        decrementPendingOutboundBytes(j, true, true);
    }

    public void failFlushed(Throwable th, boolean z) {
        if (!this.inFail) {
            boolean z2 = true;
            z2 = false;
            try {
                do {
                } while (remove0(th, z));
                this.inFail = z2;
            } finally {
                this.inFail = z2;
            }
        }
    }

    public void forEachFlushedMessage(MessageProcessor messageProcessor) throws Exception {
        ObjectUtil.checkNotNull(messageProcessor, "processor");
        Entry entry = this.flushedEntry;
        if (entry != null) {
            do {
                if (entry.cancelled || messageProcessor.processMessage(entry.msg)) {
                    entry = entry.next;
                } else {
                    return;
                }
            } while (isFlushedEntry(entry));
        }
    }

    public boolean getUserDefinedWritability(int i) {
        return (this.unwritable & writabilityMask(i)) == 0;
    }

    public void incrementPendingOutboundBytes(long j) {
        incrementPendingOutboundBytes(j, true);
    }

    public boolean isEmpty() {
        return this.flushed == 0;
    }

    public boolean isWritable() {
        return this.unwritable == 0;
    }

    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    public long nioBufferSize() {
        return this.nioBufferSize;
    }

    public ByteBuffer[] nioBuffers() {
        return nioBuffers(Integer.MAX_VALUE, UpdateOptions.SOURCE_ANY);
    }

    public void progress(long j) {
        Entry entry = this.flushedEntry;
        ChannelPromise channelPromise = entry.promise;
        long j2 = entry.progress + j;
        entry.progress = j2;
        if (channelPromise instanceof ChannelProgressivePromise) {
            ((ChannelProgressivePromise) channelPromise).tryProgress(j2, entry.total);
        }
    }

    @Deprecated
    public void recycle() {
    }

    public boolean remove() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeSuccess(channelPromise);
            decrementPendingOutboundBytes((long) i, false, true);
        }
        entry.recycle();
        return true;
    }

    public void removeBytes(long j) {
        while (true) {
            Object current = current();
            if (!(current instanceof ByteBuf)) {
                break;
            }
            ByteBuf byteBuf = (ByteBuf) current;
            int readerIndex = byteBuf.readerIndex();
            long writerIndex = (long) (byteBuf.writerIndex() - readerIndex);
            if (writerIndex <= j) {
                if (j != 0) {
                    progress(writerIndex);
                    j -= writerIndex;
                }
                remove();
            } else if (j != 0) {
                byteBuf.readerIndex(readerIndex + ((int) j));
                progress(j);
            }
        }
        clearNioBuffers();
    }

    public void setUserDefinedWritability(int i, boolean z) {
        if (z) {
            setUserDefinedWritability(i);
        } else {
            clearUserDefinedWritability(i);
        }
    }

    public int size() {
        return this.flushed;
    }

    public long totalPendingWriteBytes() {
        return this.totalPendingSize;
    }

    private void decrementPendingOutboundBytes(long j, boolean z, boolean z2) {
        if (j != 0) {
            long addAndGet = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -j);
            if (z2 && addAndGet < ((long) this.channel.config().getWriteBufferLowWaterMark())) {
                setWritable(z);
            }
        }
    }

    private void incrementPendingOutboundBytes(long j, boolean z) {
        if (j != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, j) > ((long) this.channel.config().getWriteBufferHighWaterMark())) {
            setUnwritable(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        r8 = (io.netty.buffer.ByteBuf) r8;
        r9 = r8.readerIndex();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.nio.ByteBuffer[] nioBuffers(int r16, long r17) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            io.netty.util.internal.InternalThreadLocalMap r2 = io.netty.util.internal.InternalThreadLocalMap.get()
            io.netty.util.concurrent.FastThreadLocal<java.nio.ByteBuffer[]> r3 = NIO_BUFFERS
            java.lang.Object r3 = r3.get(r2)
            java.nio.ByteBuffer[] r3 = (java.nio.ByteBuffer[]) r3
            io.netty.channel.ChannelOutboundBuffer$Entry r4 = r0.flushedEntry
            r5 = 0
            r7 = 0
        L_0x0014:
            boolean r8 = r15.isFlushedEntry(r4)
            if (r8 == 0) goto L_0x0076
            java.lang.Object r8 = r4.msg
            boolean r9 = r8 instanceof io.netty.buffer.ByteBuf
            if (r9 == 0) goto L_0x0076
            boolean r9 = r4.cancelled
            if (r9 != 0) goto L_0x0073
            io.netty.buffer.ByteBuf r8 = (io.netty.buffer.ByteBuf) r8
            int r9 = r8.readerIndex()
            int r10 = r8.writerIndex()
            int r10 = r10 - r9
            if (r10 <= 0) goto L_0x0073
            long r11 = (long) r10
            long r13 = r17 - r11
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 >= 0) goto L_0x003b
            if (r7 == 0) goto L_0x003b
            goto L_0x0076
        L_0x003b:
            long r5 = r5 + r11
            int r11 = r4.count
            r12 = -1
            if (r11 != r12) goto L_0x0047
            int r11 = r8.nioBufferCount()
            r4.count = r11
        L_0x0047:
            int r12 = r7 + r11
            int r12 = java.lang.Math.min(r1, r12)
            int r13 = r3.length
            if (r12 <= r13) goto L_0x0059
            java.nio.ByteBuffer[] r3 = expandNioBufferArray(r3, r12, r7)
            io.netty.util.concurrent.FastThreadLocal<java.nio.ByteBuffer[]> r12 = NIO_BUFFERS
            r12.set(r2, r3)
        L_0x0059:
            r12 = 1
            if (r11 != r12) goto L_0x006c
            java.nio.ByteBuffer r11 = r4.buf
            if (r11 != 0) goto L_0x0066
            java.nio.ByteBuffer r11 = r8.internalNioBuffer(r9, r10)
            r4.buf = r11
        L_0x0066:
            int r8 = r7 + 1
            r3[r7] = r11
            r7 = r8
            goto L_0x0070
        L_0x006c:
            int r7 = nioBuffers(r4, r8, r3, r7, r1)
        L_0x0070:
            if (r7 < r1) goto L_0x0073
            goto L_0x0076
        L_0x0073:
            io.netty.channel.ChannelOutboundBuffer$Entry r4 = r4.next
            goto L_0x0014
        L_0x0076:
            r0.nioBufferCount = r7
            r0.nioBufferSize = r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.ChannelOutboundBuffer.nioBuffers(int, long):java.nio.ByteBuffer[]");
    }

    private void setUserDefinedWritability(int i) {
        int i2;
        int i3;
        int i4 = ~writabilityMask(i);
        do {
            i2 = this.unwritable;
            i3 = i2 & i4;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i2, i3));
        if (i2 != 0 && i3 == 0) {
            fireChannelWritabilityChanged(true);
        }
    }

    public boolean remove(Throwable th) {
        return remove0(th, true);
    }

    public void close(ClosedChannelException closedChannelException) {
        close(closedChannelException, false);
    }

    private static int nioBuffers(Entry entry, ByteBuf byteBuf, ByteBuffer[] byteBufferArr, int i, int i2) {
        ByteBuffer byteBuffer;
        ByteBuffer[] byteBufferArr2 = entry.bufs;
        if (byteBufferArr2 == null) {
            byteBufferArr2 = byteBuf.nioBuffers();
            entry.bufs = byteBufferArr2;
        }
        int i3 = 0;
        while (i3 < byteBufferArr2.length && i < i2 && (byteBuffer = byteBufferArr2[i3]) != null) {
            if (byteBuffer.hasRemaining()) {
                byteBufferArr[i] = byteBuffer;
                i++;
            }
            i3++;
        }
        return i;
    }
}
