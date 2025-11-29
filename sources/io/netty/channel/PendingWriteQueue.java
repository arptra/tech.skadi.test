package io.netty.channel;

import com.upuphone.starrynet.payload.PayloadConstant;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class PendingWriteQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int PENDING_WRITE_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.pendingWriteSizeOverhead", 64);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PendingWriteQueue.class);
    private long bytes;
    private final EventExecutor executor;
    private PendingWrite head;
    private final ChannelOutboundInvoker invoker;
    private int size;
    private PendingWrite tail;
    private final PendingBytesTracker tracker;

    public static final class PendingWrite {
        private static final ObjectPool<PendingWrite> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PendingWrite>() {
            public PendingWrite newObject(ObjectPool.Handle<PendingWrite> handle) {
                return new PendingWrite(handle);
            }
        });
        private final ObjectPool.Handle<PendingWrite> handle;
        /* access modifiers changed from: private */
        public Object msg;
        /* access modifiers changed from: private */
        public PendingWrite next;
        /* access modifiers changed from: private */
        public ChannelPromise promise;
        /* access modifiers changed from: private */
        public long size;

        public static PendingWrite newInstance(Object obj, int i, ChannelPromise channelPromise) {
            PendingWrite pendingWrite = RECYCLER.get();
            pendingWrite.size = (long) i;
            pendingWrite.msg = obj;
            pendingWrite.promise = channelPromise;
            return pendingWrite;
        }

        /* access modifiers changed from: private */
        public void recycle() {
            this.size = 0;
            this.next = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }

        private PendingWrite(ObjectPool.Handle<PendingWrite> handle2) {
            this.handle = handle2;
        }
    }

    public PendingWriteQueue(ChannelHandlerContext channelHandlerContext) {
        this.tracker = PendingBytesTracker.newTracker(channelHandlerContext.channel());
        this.invoker = channelHandlerContext;
        this.executor = channelHandlerContext.executor();
    }

    private void assertEmpty() {
    }

    private void recycle(PendingWrite pendingWrite, boolean z) {
        PendingWrite access$000 = pendingWrite.next;
        long access$100 = pendingWrite.size;
        if (z) {
            if (access$000 == null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0;
            } else {
                this.head = access$000;
                this.size--;
                this.bytes -= access$100;
            }
        }
        pendingWrite.recycle();
        this.tracker.decrementPendingOutboundBytes(access$100);
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        if (!(channelPromise instanceof VoidChannelPromise) && !channelPromise.tryFailure(th)) {
            logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th);
        }
    }

    public void add(Object obj, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(obj, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        ObjectUtil.checkNotNull(channelPromise, "promise");
        int size2 = size(obj);
        PendingWrite newInstance = PendingWrite.newInstance(obj, size2, channelPromise);
        PendingWrite pendingWrite = this.tail;
        if (pendingWrite == null) {
            this.head = newInstance;
            this.tail = newInstance;
        } else {
            PendingWrite unused = pendingWrite.next = newInstance;
            this.tail = newInstance;
        }
        this.size++;
        this.bytes += (long) size2;
        this.tracker.incrementPendingOutboundBytes(newInstance.size);
    }

    public long bytes() {
        return this.bytes;
    }

    public Object current() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        return pendingWrite.msg;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public ChannelPromise remove() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        ChannelPromise access$300 = pendingWrite.promise;
        ReferenceCountUtil.safeRelease(pendingWrite.msg);
        recycle(pendingWrite, true);
        return access$300;
    }

    public void removeAndFail(Throwable th) {
        ObjectUtil.checkNotNull(th, "cause");
        PendingWrite pendingWrite = this.head;
        if (pendingWrite != null) {
            ReferenceCountUtil.safeRelease(pendingWrite.msg);
            safeFail(pendingWrite.promise, th);
            recycle(pendingWrite, true);
        }
    }

    public void removeAndFailAll(Throwable th) {
        ObjectUtil.checkNotNull(th, "cause");
        while (true) {
            PendingWrite pendingWrite = this.head;
            if (pendingWrite != null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0;
                while (pendingWrite != null) {
                    PendingWrite access$000 = pendingWrite.next;
                    ReferenceCountUtil.safeRelease(pendingWrite.msg);
                    ChannelPromise access$300 = pendingWrite.promise;
                    recycle(pendingWrite, false);
                    safeFail(access$300, th);
                    pendingWrite = access$000;
                }
            } else {
                assertEmpty();
                return;
            }
        }
    }

    public ChannelFuture removeAndWrite() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        Object access$200 = pendingWrite.msg;
        ChannelPromise access$300 = pendingWrite.promise;
        recycle(pendingWrite, true);
        return this.invoker.write(access$200, access$300);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046 A[EDGE_INSN: B:19:0x0046->B:15:0x0046 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0019 A[Catch:{ all -> 0x003d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.netty.channel.ChannelFuture removeAndWriteAll() {
        /*
            r8 = this;
            boolean r0 = r8.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            io.netty.channel.ChannelOutboundInvoker r0 = r8.invoker
            io.netty.channel.ChannelPromise r0 = r0.newPromise()
            io.netty.util.concurrent.PromiseCombiner r2 = new io.netty.util.concurrent.PromiseCombiner
            io.netty.util.concurrent.EventExecutor r3 = r8.executor
            r2.<init>(r3)
        L_0x0015:
            io.netty.channel.PendingWriteQueue$PendingWrite r3 = r8.head     // Catch:{ all -> 0x003d }
            if (r3 == 0) goto L_0x0046
            r8.tail = r1     // Catch:{ all -> 0x003d }
            r8.head = r1     // Catch:{ all -> 0x003d }
            r4 = 0
            r8.size = r4     // Catch:{ all -> 0x003d }
            r5 = 0
            r8.bytes = r5     // Catch:{ all -> 0x003d }
        L_0x0024:
            if (r3 == 0) goto L_0x0015
            io.netty.channel.PendingWriteQueue$PendingWrite r5 = r3.next     // Catch:{ all -> 0x003d }
            java.lang.Object r6 = r3.msg     // Catch:{ all -> 0x003d }
            io.netty.channel.ChannelPromise r7 = r3.promise     // Catch:{ all -> 0x003d }
            r8.recycle(r3, r4)     // Catch:{ all -> 0x003d }
            boolean r3 = r7 instanceof io.netty.channel.VoidChannelPromise     // Catch:{ all -> 0x003d }
            if (r3 != 0) goto L_0x003f
            r2.add((io.netty.util.concurrent.Promise) r7)     // Catch:{ all -> 0x003d }
            goto L_0x003f
        L_0x003d:
            r1 = move-exception
            goto L_0x004a
        L_0x003f:
            io.netty.channel.ChannelOutboundInvoker r3 = r8.invoker     // Catch:{ all -> 0x003d }
            r3.write(r6, r7)     // Catch:{ all -> 0x003d }
            r3 = r5
            goto L_0x0024
        L_0x0046:
            r2.finish(r0)     // Catch:{ all -> 0x003d }
            goto L_0x004d
        L_0x004a:
            r0.setFailure(r1)
        L_0x004d:
            r8.assertEmpty()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.PendingWriteQueue.removeAndWriteAll():io.netty.channel.ChannelFuture");
    }

    public int size() {
        return this.size;
    }

    private int size(Object obj) {
        int size2 = this.tracker.size(obj);
        if (size2 < 0) {
            size2 = 0;
        }
        return size2 + PENDING_WRITE_OVERHEAD;
    }

    public PendingWriteQueue(Channel channel) {
        this.tracker = PendingBytesTracker.newTracker(channel);
        this.invoker = channel;
        this.executor = channel.eventLoop();
    }
}
