package io.netty.handler.codec.http2;

import com.here.posclient.UpdateOptions;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2RemoteFlowController;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.Deque;

public class DefaultHttp2RemoteFlowController implements Http2RemoteFlowController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MIN_WRITABLE_CHUNK = 32768;
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultHttp2RemoteFlowController.class);
    /* access modifiers changed from: private */
    public final Http2Connection connection;
    /* access modifiers changed from: private */
    public final FlowState connectionState;
    /* access modifiers changed from: private */
    public ChannelHandlerContext ctx;
    /* access modifiers changed from: private */
    public int initialWindowSize;
    /* access modifiers changed from: private */
    public WritabilityMonitor monitor;
    /* access modifiers changed from: private */
    public final Http2Connection.PropertyKey stateKey;
    /* access modifiers changed from: private */
    public final StreamByteDistributor streamByteDistributor;

    public final class FlowState implements StreamByteDistributor.StreamState {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean cancelled;
        private boolean markedWritable;
        private long pendingBytes;
        private final Deque<Http2RemoteFlowController.FlowControlled> pendingWriteQueue = new ArrayDeque(2);
        /* access modifiers changed from: private */
        public final Http2Stream stream;
        private int window;
        private boolean writing;

        public FlowState(Http2Stream http2Stream) {
            this.stream = http2Stream;
        }

        private void decrementFlowControlWindow(int i) {
            int i2 = -i;
            try {
                DefaultHttp2RemoteFlowController.this.connectionState.incrementStreamWindow(i2);
                incrementStreamWindow(i2);
            } catch (Http2Exception e) {
                throw new IllegalStateException("Invalid window state when writing frame: " + e.getMessage(), e);
            }
        }

        private void decrementPendingBytes(int i, boolean z) {
            incrementPendingBytes(-i, z);
        }

        private void enqueueFrameWithoutMerge(Http2RemoteFlowController.FlowControlled flowControlled) {
            this.pendingWriteQueue.offer(flowControlled);
            incrementPendingBytes(flowControlled.size(), true);
        }

        private void incrementPendingBytes(int i, boolean z) {
            this.pendingBytes += (long) i;
            DefaultHttp2RemoteFlowController.this.monitor.incrementPendingBytes(i);
            if (z) {
                DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
            }
        }

        private Http2RemoteFlowController.FlowControlled peek() {
            return this.pendingWriteQueue.peek();
        }

        private int writableWindow() {
            return Math.min(this.window, DefaultHttp2RemoteFlowController.this.connectionWindowSize());
        }

        private void writeError(Http2RemoteFlowController.FlowControlled flowControlled, Http2Exception http2Exception) {
            decrementPendingBytes(flowControlled.size(), true);
            flowControlled.error(DefaultHttp2RemoteFlowController.this.ctx, http2Exception);
        }

        public void cancel(Http2Error http2Error, Throwable th) {
            this.cancelled = true;
            if (!this.writing) {
                Http2RemoteFlowController.FlowControlled poll = this.pendingWriteQueue.poll();
                if (poll != null) {
                    Http2Exception streamError = Http2Exception.streamError(this.stream.id(), http2Error, th, "Stream closed before write could take place", new Object[0]);
                    do {
                        writeError(poll, streamError);
                        poll = this.pendingWriteQueue.poll();
                    } while (poll != null);
                }
                DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
                DefaultHttp2RemoteFlowController.this.monitor.stateCancelled(this);
            }
        }

        public void enqueueFrame(Http2RemoteFlowController.FlowControlled flowControlled) {
            Http2RemoteFlowController.FlowControlled peekLast = this.pendingWriteQueue.peekLast();
            if (peekLast == null) {
                enqueueFrameWithoutMerge(flowControlled);
                return;
            }
            int size = peekLast.size();
            if (peekLast.merge(DefaultHttp2RemoteFlowController.this.ctx, flowControlled)) {
                incrementPendingBytes(peekLast.size() - size, true);
            } else {
                enqueueFrameWithoutMerge(flowControlled);
            }
        }

        public boolean hasFrame() {
            return !this.pendingWriteQueue.isEmpty();
        }

        public int incrementStreamWindow(int i) throws Http2Exception {
            if (i <= 0 || Integer.MAX_VALUE - i >= this.window) {
                this.window += i;
                DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
                return this.window;
            }
            throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Window size overflow for stream: %d", Integer.valueOf(this.stream.id()));
        }

        public boolean isWritable() {
            return ((long) windowSize()) > pendingBytes() && !this.cancelled;
        }

        public boolean markedWritability() {
            return this.markedWritable;
        }

        public long pendingBytes() {
            return this.pendingBytes;
        }

        public Http2Stream stream() {
            return this.stream;
        }

        public int windowSize() {
            return this.window;
        }

        /* JADX WARNING: Removed duplicated region for block: B:39:0x008f A[DONT_GENERATE] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int writeAllocatedBytes(int r9) {
            /*
                r8 = this;
                r0 = 1
                r1 = 0
                r2 = 0
                r8.writing = r0     // Catch:{ all -> 0x007e }
                r3 = r9
                r4 = r1
            L_0x0007:
                boolean r5 = r8.cancelled     // Catch:{ all -> 0x0022 }
                if (r5 != 0) goto L_0x0055
                io.netty.handler.codec.http2.Http2RemoteFlowController$FlowControlled r5 = r8.peek()     // Catch:{ all -> 0x0022 }
                if (r5 == 0) goto L_0x0055
                int r6 = r8.writableWindow()     // Catch:{ all -> 0x0022 }
                int r6 = java.lang.Math.min(r3, r6)     // Catch:{ all -> 0x0022 }
                if (r6 > 0) goto L_0x0024
                int r7 = r5.size()     // Catch:{ all -> 0x0022 }
                if (r7 <= 0) goto L_0x0024
                goto L_0x0055
            L_0x0022:
                r4 = move-exception
                goto L_0x0080
            L_0x0024:
                int r4 = r5.size()     // Catch:{ all -> 0x0022 }
                io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController r7 = io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.this     // Catch:{ all -> 0x0044 }
                io.netty.channel.ChannelHandlerContext r7 = r7.ctx     // Catch:{ all -> 0x0044 }
                int r6 = java.lang.Math.max(r1, r6)     // Catch:{ all -> 0x0044 }
                r5.write(r7, r6)     // Catch:{ all -> 0x0044 }
                int r6 = r5.size()     // Catch:{ all -> 0x0044 }
                if (r6 != 0) goto L_0x0046
                java.util.Deque<io.netty.handler.codec.http2.Http2RemoteFlowController$FlowControlled> r6 = r8.pendingWriteQueue     // Catch:{ all -> 0x0044 }
                r6.remove()     // Catch:{ all -> 0x0044 }
                r5.writeComplete()     // Catch:{ all -> 0x0044 }
                goto L_0x0046
            L_0x0044:
                r6 = move-exception
                goto L_0x004e
            L_0x0046:
                int r5 = r5.size()     // Catch:{ all -> 0x0022 }
                int r4 = r4 - r5
                int r3 = r3 - r4
                r4 = r0
                goto L_0x0007
            L_0x004e:
                int r5 = r5.size()     // Catch:{ all -> 0x0022 }
                int r4 = r4 - r5
                int r3 = r3 - r4
                throw r6     // Catch:{ all -> 0x0022 }
            L_0x0055:
                if (r4 != 0) goto L_0x006b
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r9 = r8.cancelled
                if (r9 == 0) goto L_0x0069
                io.netty.handler.codec.http2.Http2Error r9 = io.netty.handler.codec.http2.Http2Error.INTERNAL_ERROR
                r8.cancel(r9, r2)
            L_0x0069:
                r8 = -1
                return r8
            L_0x006b:
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r0 = r8.cancelled
                if (r0 == 0) goto L_0x0094
                io.netty.handler.codec.http2.Http2Error r0 = io.netty.handler.codec.http2.Http2Error.INTERNAL_ERROR
                r8.cancel(r0, r2)
                goto L_0x0094
            L_0x007e:
                r4 = move-exception
                r3 = r9
            L_0x0080:
                r8.cancelled = r0     // Catch:{ all -> 0x0095 }
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r0 = r8.cancelled
                if (r0 == 0) goto L_0x0094
                io.netty.handler.codec.http2.Http2Error r0 = io.netty.handler.codec.http2.Http2Error.INTERNAL_ERROR
                r8.cancel(r0, r4)
            L_0x0094:
                return r9
            L_0x0095:
                r0 = move-exception
                r8.writing = r1
                int r9 = r9 - r3
                r8.decrementPendingBytes(r9, r1)
                r8.decrementFlowControlWindow(r9)
                boolean r9 = r8.cancelled
                if (r9 == 0) goto L_0x00a8
                io.netty.handler.codec.http2.Http2Error r9 = io.netty.handler.codec.http2.Http2Error.INTERNAL_ERROR
                r8.cancel(r9, r2)
            L_0x00a8:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.FlowState.writeAllocatedBytes(int):int");
        }

        public void markedWritability(boolean z) {
            this.markedWritable = z;
        }

        public void windowSize(int i) {
            this.window = i;
        }
    }

    public final class ListenerWritabilityMonitor extends WritabilityMonitor implements Http2StreamVisitor {
        private final Http2RemoteFlowController.Listener listener;

        public ListenerWritabilityMonitor(Http2RemoteFlowController.Listener listener2) {
            super();
            this.listener = listener2;
        }

        private void checkAllWritabilityChanged() throws Http2Exception {
            DefaultHttp2RemoteFlowController.this.connectionState.markedWritability(isWritableConnection());
            DefaultHttp2RemoteFlowController.this.connection.forEachActiveStream(this);
        }

        private void checkConnectionThenStreamWritabilityChanged(FlowState flowState) throws Http2Exception {
            if (isWritableConnection() != DefaultHttp2RemoteFlowController.this.connectionState.markedWritability()) {
                checkAllWritabilityChanged();
            } else if (isWritable(flowState) != flowState.markedWritability()) {
                notifyWritabilityChanged(flowState);
            }
        }

        private void checkStateWritability(FlowState flowState) throws Http2Exception {
            if (isWritable(flowState) == flowState.markedWritability()) {
                return;
            }
            if (flowState == DefaultHttp2RemoteFlowController.this.connectionState) {
                checkAllWritabilityChanged();
            } else {
                notifyWritabilityChanged(flowState);
            }
        }

        private void notifyWritabilityChanged(FlowState flowState) {
            flowState.markedWritability(!flowState.markedWritability());
            try {
                this.listener.writabilityChanged(flowState.stream);
            } catch (Throwable th) {
                DefaultHttp2RemoteFlowController.logger.error("Caught Throwable from listener.writabilityChanged", th);
            }
        }

        public void channelWritabilityChange() throws Http2Exception {
            if (DefaultHttp2RemoteFlowController.this.connectionState.markedWritability() != DefaultHttp2RemoteFlowController.this.isChannelWritable()) {
                checkAllWritabilityChanged();
            }
        }

        public void enqueueFrame(FlowState flowState, Http2RemoteFlowController.FlowControlled flowControlled) throws Http2Exception {
            super.enqueueFrame(flowState, flowControlled);
            checkConnectionThenStreamWritabilityChanged(flowState);
        }

        public void incrementWindowSize(FlowState flowState, int i) throws Http2Exception {
            super.incrementWindowSize(flowState, i);
            checkStateWritability(flowState);
        }

        public void initialWindowSize(int i) throws Http2Exception {
            super.initialWindowSize(i);
            if (isWritableConnection()) {
                checkAllWritabilityChanged();
            }
        }

        public void stateCancelled(FlowState flowState) {
            try {
                checkConnectionThenStreamWritabilityChanged(flowState);
            } catch (Http2Exception e) {
                throw new RuntimeException("Caught unexpected exception from checkAllWritabilityChanged", e);
            }
        }

        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            FlowState access$100 = DefaultHttp2RemoteFlowController.this.state(http2Stream);
            if (isWritable(access$100) == access$100.markedWritability()) {
                return true;
            }
            notifyWritabilityChanged(access$100);
            return true;
        }

        public void windowSize(FlowState flowState, int i) {
            super.windowSize(flowState, i);
            try {
                checkStateWritability(flowState);
            } catch (Http2Exception e) {
                throw new RuntimeException("Caught unexpected exception from window", e);
            }
        }
    }

    public class WritabilityMonitor implements StreamByteDistributor.Writer {
        private boolean inWritePendingBytes;
        private long totalPendingBytes;

        private WritabilityMonitor() {
        }

        public void channelWritabilityChange() throws Http2Exception {
        }

        public void enqueueFrame(FlowState flowState, Http2RemoteFlowController.FlowControlled flowControlled) throws Http2Exception {
            flowState.enqueueFrame(flowControlled);
        }

        public final void incrementPendingBytes(int i) {
            this.totalPendingBytes += (long) i;
        }

        public void incrementWindowSize(FlowState flowState, int i) throws Http2Exception {
            flowState.incrementStreamWindow(i);
        }

        public void initialWindowSize(int i) throws Http2Exception {
            ObjectUtil.checkPositiveOrZero(i, "newWindowSize");
            final int access$200 = i - DefaultHttp2RemoteFlowController.this.initialWindowSize;
            int unused = DefaultHttp2RemoteFlowController.this.initialWindowSize = i;
            DefaultHttp2RemoteFlowController.this.connection.forEachActiveStream(new Http2StreamVisitor() {
                public boolean visit(Http2Stream http2Stream) throws Http2Exception {
                    DefaultHttp2RemoteFlowController.this.state(http2Stream).incrementStreamWindow(access$200);
                    return true;
                }
            });
            if (access$200 > 0 && DefaultHttp2RemoteFlowController.this.isChannelWritable()) {
                writePendingBytes();
            }
        }

        public final boolean isWritable(FlowState flowState) {
            return isWritableConnection() && flowState.isWritable();
        }

        public final boolean isWritableConnection() {
            return ((long) DefaultHttp2RemoteFlowController.this.connectionState.windowSize()) - this.totalPendingBytes > 0 && DefaultHttp2RemoteFlowController.this.isChannelWritable();
        }

        public void stateCancelled(FlowState flowState) {
        }

        public void windowSize(FlowState flowState, int i) {
            flowState.windowSize(i);
        }

        public final void write(Http2Stream http2Stream, int i) {
            DefaultHttp2RemoteFlowController.this.state(http2Stream).writeAllocatedBytes(i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x000f A[Catch:{ all -> 0x002c }, LOOP:0: B:6:0x000f->B:11:0x0029, LOOP_START, PHI: r1 
          PHI: (r1v3 int) = (r1v2 int), (r1v6 int) binds: [B:5:?, B:11:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void writePendingBytes() throws io.netty.handler.codec.http2.Http2Exception {
            /*
                r3 = this;
                boolean r0 = r3.inWritePendingBytes
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                r0 = 1
                r3.inWritePendingBytes = r0
                r0 = 0
                io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController r1 = io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.this     // Catch:{ all -> 0x002c }
                int r1 = r1.writableBytes()     // Catch:{ all -> 0x002c }
            L_0x000f:
                io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController r2 = io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.this     // Catch:{ all -> 0x002c }
                io.netty.handler.codec.http2.StreamByteDistributor r2 = r2.streamByteDistributor     // Catch:{ all -> 0x002c }
                boolean r1 = r2.distribute(r1, r3)     // Catch:{ all -> 0x002c }
                if (r1 == 0) goto L_0x002e
                io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController r1 = io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.this     // Catch:{ all -> 0x002c }
                int r1 = r1.writableBytes()     // Catch:{ all -> 0x002c }
                if (r1 <= 0) goto L_0x002e
                io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController r2 = io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.this     // Catch:{ all -> 0x002c }
                boolean r2 = r2.isChannelWritable0()     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x000f
                goto L_0x002e
            L_0x002c:
                r1 = move-exception
                goto L_0x0031
            L_0x002e:
                r3.inWritePendingBytes = r0
                return
            L_0x0031:
                r3.inWritePendingBytes = r0
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController.WritabilityMonitor.writePendingBytes():void");
        }
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection) {
        this(http2Connection, (Http2RemoteFlowController.Listener) null);
    }

    /* access modifiers changed from: private */
    public int connectionWindowSize() {
        return this.connectionState.windowSize();
    }

    /* access modifiers changed from: private */
    public boolean isChannelWritable() {
        return this.ctx != null && isChannelWritable0();
    }

    /* access modifiers changed from: private */
    public boolean isChannelWritable0() {
        return this.ctx.channel().isWritable();
    }

    private int maxUsableChannelBytes() {
        int min = (int) Math.min(UpdateOptions.SOURCE_ANY, this.ctx.channel().bytesBeforeUnwritable());
        return Math.min(this.connectionState.windowSize(), min > 0 ? Math.max(min, minUsableChannelBytes()) : 0);
    }

    private int minUsableChannelBytes() {
        return Math.max(this.ctx.channel().config().getWriteBufferLowWaterMark(), 32768);
    }

    /* access modifiers changed from: private */
    public FlowState state(Http2Stream http2Stream) {
        return (FlowState) http2Stream.getProperty(this.stateKey);
    }

    /* access modifiers changed from: private */
    public int writableBytes() {
        return Math.min(connectionWindowSize(), maxUsableChannelBytes());
    }

    public void addFlowControlled(Http2Stream http2Stream, Http2RemoteFlowController.FlowControlled flowControlled) {
        ObjectUtil.checkNotNull(flowControlled, "frame");
        try {
            this.monitor.enqueueFrame(state(http2Stream), flowControlled);
        } catch (Throwable th) {
            flowControlled.error(this.ctx, th);
        }
    }

    public void channelHandlerContext(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
        this.ctx = (ChannelHandlerContext) ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
        channelWritabilityChanged();
        if (isChannelWritable()) {
            writePendingBytes();
        }
    }

    public void channelWritabilityChanged() throws Http2Exception {
        this.monitor.channelWritabilityChange();
    }

    public boolean hasFlowControlled(Http2Stream http2Stream) {
        return state(http2Stream).hasFrame();
    }

    public void incrementWindowSize(Http2Stream http2Stream, int i) throws Http2Exception {
        this.monitor.incrementWindowSize(state(http2Stream), i);
    }

    public void initialWindowSize(int i) throws Http2Exception {
        this.monitor.initialWindowSize(i);
    }

    public boolean isWritable(Http2Stream http2Stream) {
        return this.monitor.isWritable(state(http2Stream));
    }

    public void listener(Http2RemoteFlowController.Listener listener) {
        this.monitor = listener == null ? new WritabilityMonitor() : new ListenerWritabilityMonitor(listener);
    }

    public void updateDependencyTree(int i, int i2, short s, boolean z) {
        this.streamByteDistributor.updateDependencyTree(i, i2, s, z);
    }

    public int windowSize(Http2Stream http2Stream) {
        return state(http2Stream).windowSize();
    }

    public void writePendingBytes() throws Http2Exception {
        this.monitor.writePendingBytes();
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection, StreamByteDistributor streamByteDistributor2) {
        this(http2Connection, streamByteDistributor2, (Http2RemoteFlowController.Listener) null);
    }

    public int initialWindowSize() {
        return this.initialWindowSize;
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection, Http2RemoteFlowController.Listener listener) {
        this(http2Connection, new WeightedFairQueueByteDistributor(http2Connection), listener);
    }

    public DefaultHttp2RemoteFlowController(Http2Connection http2Connection, StreamByteDistributor streamByteDistributor2, Http2RemoteFlowController.Listener listener) {
        this.initialWindowSize = 65535;
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.streamByteDistributor = (StreamByteDistributor) ObjectUtil.checkNotNull(streamByteDistributor2, "streamWriteDistributor");
        Http2Connection.PropertyKey newKey = http2Connection.newKey();
        this.stateKey = newKey;
        FlowState flowState = new FlowState(http2Connection.connectionStream());
        this.connectionState = flowState;
        http2Connection.connectionStream().setProperty(newKey, flowState);
        listener(listener);
        this.monitor.windowSize(flowState, this.initialWindowSize);
        http2Connection.addListener(new Http2ConnectionAdapter() {
            public void onStreamActive(Http2Stream http2Stream) {
                DefaultHttp2RemoteFlowController.this.monitor.windowSize(DefaultHttp2RemoteFlowController.this.state(http2Stream), DefaultHttp2RemoteFlowController.this.initialWindowSize);
            }

            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(DefaultHttp2RemoteFlowController.this.stateKey, new FlowState(http2Stream));
            }

            public void onStreamClosed(Http2Stream http2Stream) {
                DefaultHttp2RemoteFlowController.this.state(http2Stream).cancel(Http2Error.STREAM_CLOSED, (Throwable) null);
            }

            public void onStreamHalfClosed(Http2Stream http2Stream) {
                if (Http2Stream.State.HALF_CLOSED_LOCAL == http2Stream.state()) {
                    DefaultHttp2RemoteFlowController.this.state(http2Stream).cancel(Http2Error.STREAM_CLOSED, (Throwable) null);
                }
            }
        });
    }

    public ChannelHandlerContext channelHandlerContext() {
        return this.ctx;
    }
}
