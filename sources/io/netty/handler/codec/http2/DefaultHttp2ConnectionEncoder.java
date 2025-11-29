package io.netty.handler.codec.http2;

import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.CoalescingBufferQueue;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.handler.codec.http2.Http2RemoteFlowController;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;

public class DefaultHttp2ConnectionEncoder implements Http2ConnectionEncoder, Http2SettingsReceivedConsumer {
    /* access modifiers changed from: private */
    public final Http2Connection connection;
    /* access modifiers changed from: private */
    public final Http2FrameWriter frameWriter;
    /* access modifiers changed from: private */
    public Http2LifecycleManager lifecycleManager;
    private final Queue<Http2Settings> outstandingLocalSettingsQueue = new ArrayDeque(4);
    private Queue<Http2Settings> outstandingRemoteSettingsQueue;

    /* renamed from: io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.netty.handler.codec.http2.Http2Stream$State[] r0 = io.netty.handler.codec.http2.Http2Stream.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = r0
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.OPEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.HALF_CLOSED_REMOTE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.RESERVED_LOCAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder.AnonymousClass2.<clinit>():void");
        }
    }

    public abstract class FlowControlledBase implements Http2RemoteFlowController.FlowControlled, ChannelFutureListener {
        protected boolean endOfStream;
        protected int padding;
        protected ChannelPromise promise;
        protected final Http2Stream stream;

        public FlowControlledBase(Http2Stream http2Stream, int i, boolean z, ChannelPromise channelPromise) {
            ObjectUtil.checkPositiveOrZero(i, "padding");
            this.padding = i;
            this.endOfStream = z;
            this.stream = http2Stream;
            this.promise = channelPromise;
        }

        public void writeComplete() {
            if (this.endOfStream) {
                DefaultHttp2ConnectionEncoder.this.lifecycleManager.closeStreamLocal(this.stream, this.promise);
            }
        }

        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (!channelFuture.isSuccess()) {
                error(DefaultHttp2ConnectionEncoder.this.flowController().channelHandlerContext(), channelFuture.cause());
            }
        }
    }

    public final class FlowControlledData extends FlowControlledBase {
        private int dataSize;
        private final CoalescingBufferQueue queue;

        public FlowControlledData(Http2Stream http2Stream, ByteBuf byteBuf, int i, boolean z, ChannelPromise channelPromise) {
            super(http2Stream, i, z, channelPromise);
            CoalescingBufferQueue coalescingBufferQueue = new CoalescingBufferQueue(channelPromise.channel());
            this.queue = coalescingBufferQueue;
            coalescingBufferQueue.add(byteBuf, channelPromise);
            this.dataSize = coalescingBufferQueue.readableBytes();
        }

        public void error(ChannelHandlerContext channelHandlerContext, Throwable th) {
            this.queue.releaseAndFailAll(th);
            DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, th);
        }

        public boolean merge(ChannelHandlerContext channelHandlerContext, Http2RemoteFlowController.FlowControlled flowControlled) {
            if (FlowControlledData.class != flowControlled.getClass()) {
                return false;
            }
            FlowControlledData flowControlledData = (FlowControlledData) flowControlled;
            if (Integer.MAX_VALUE - flowControlledData.size() < size()) {
                return false;
            }
            flowControlledData.queue.copyTo(this.queue);
            this.dataSize = this.queue.readableBytes();
            this.padding = Math.max(this.padding, flowControlledData.padding);
            this.endOfStream = flowControlledData.endOfStream;
            return true;
        }

        public int size() {
            return this.dataSize + this.padding;
        }

        public void write(ChannelHandlerContext channelHandlerContext, int i) {
            int readableBytes = this.queue.readableBytes();
            boolean z = false;
            if (!this.endOfStream) {
                if (readableBytes == 0) {
                    if (this.queue.isEmpty()) {
                        this.dataSize = 0;
                        this.padding = 0;
                        return;
                    }
                    ChannelPromise addListener = channelHandlerContext.newPromise().addListener(this);
                    channelHandlerContext.write(this.queue.remove(0, addListener), addListener);
                    return;
                } else if (i == 0) {
                    return;
                }
            }
            int min = Math.min(readableBytes, i);
            ChannelPromise addListener2 = channelHandlerContext.newPromise().addListener(this);
            ByteBuf remove = this.queue.remove(min, addListener2);
            this.dataSize = this.queue.readableBytes();
            int min2 = Math.min(i - min, this.padding);
            this.padding -= min2;
            Http2FrameWriter frameWriter = DefaultHttp2ConnectionEncoder.this.frameWriter();
            int id = this.stream.id();
            if (this.endOfStream && size() == 0) {
                z = true;
            }
            frameWriter.writeData(channelHandlerContext, id, remove, min2, z, addListener2);
        }
    }

    public final class FlowControlledHeaders extends FlowControlledBase {
        private final boolean exclusive;
        private final boolean hasPriority;
        private final Http2Headers headers;
        private final int streamDependency;
        final /* synthetic */ DefaultHttp2ConnectionEncoder this$0;
        private final short weight;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public FlowControlledHeaders(io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder r8, io.netty.handler.codec.http2.Http2Stream r9, io.netty.handler.codec.http2.Http2Headers r10, boolean r11, int r12, short r13, boolean r14, int r15, boolean r16, io.netty.channel.ChannelPromise r17) {
            /*
                r7 = this;
                r6 = r7
                r1 = r8
                r6.this$0 = r1
                io.netty.channel.ChannelPromise r5 = r17.unvoid()
                r0 = r7
                r2 = r9
                r3 = r15
                r4 = r16
                r0.<init>(r2, r3, r4, r5)
                r0 = r10
                r6.headers = r0
                r0 = r11
                r6.hasPriority = r0
                r0 = r12
                r6.streamDependency = r0
                r0 = r13
                r6.weight = r0
                r0 = r14
                r6.exclusive = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder.FlowControlledHeaders.<init>(io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder, io.netty.handler.codec.http2.Http2Stream, io.netty.handler.codec.http2.Http2Headers, boolean, int, short, boolean, int, boolean, io.netty.channel.ChannelPromise):void");
        }

        public void error(ChannelHandlerContext channelHandlerContext, Throwable th) {
            if (channelHandlerContext != null) {
                this.this$0.lifecycleManager.onError(channelHandlerContext, true, th);
            }
            this.promise.tryFailure(th);
        }

        public boolean merge(ChannelHandlerContext channelHandlerContext, Http2RemoteFlowController.FlowControlled flowControlled) {
            return false;
        }

        public int size() {
            return 0;
        }

        public void write(ChannelHandlerContext channelHandlerContext, int i) {
            boolean access$200 = DefaultHttp2ConnectionEncoder.validateHeadersSentState(this.stream, this.headers, this.this$0.connection.isServer(), this.endOfStream);
            this.promise.addListener(this);
            if (DefaultHttp2ConnectionEncoder.sendHeaders(this.this$0.frameWriter, channelHandlerContext, this.stream.id(), this.headers, this.hasPriority, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise).cause() == null) {
                this.stream.headersSent(access$200);
            }
        }
    }

    public DefaultHttp2ConnectionEncoder(Http2Connection http2Connection, Http2FrameWriter http2FrameWriter) {
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        if (http2Connection.remote().flowController() == null) {
            http2Connection.remote().flowController(new DefaultHttp2RemoteFlowController(http2Connection));
        }
    }

    private void notifyLifecycleManagerOnError(ChannelFuture channelFuture, final ChannelHandlerContext channelHandlerContext) {
        channelFuture.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Throwable cause = channelFuture.cause();
                if (cause != null) {
                    DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(channelHandlerContext, true, cause);
                }
            }
        });
    }

    private Http2Stream requireStream(int i) {
        String str;
        Http2Stream stream = this.connection.stream(i);
        if (stream != null) {
            return stream;
        }
        if (this.connection.streamMayHaveExisted(i)) {
            str = "Stream no longer exists: " + i;
        } else {
            str = "Stream does not exist: " + i;
        }
        throw new IllegalArgumentException(str);
    }

    /* access modifiers changed from: private */
    public static ChannelFuture sendHeaders(Http2FrameWriter http2FrameWriter, ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, boolean z, int i2, short s, boolean z2, int i3, boolean z3, ChannelPromise channelPromise) {
        return z ? http2FrameWriter.writeHeaders(channelHandlerContext, i, http2Headers, i2, s, z2, i3, z3, channelPromise) : http2FrameWriter.writeHeaders(channelHandlerContext, i, http2Headers, i3, z3, channelPromise);
    }

    /* access modifiers changed from: private */
    public static boolean validateHeadersSentState(Http2Stream http2Stream, Http2Headers http2Headers, boolean z, boolean z2) {
        boolean z3 = z && HttpStatusClass.valueOf(http2Headers.status()) == HttpStatusClass.INFORMATIONAL;
        if (((!z3 && z2) || !http2Stream.isHeadersSent()) && !http2Stream.isTrailersSent()) {
            return z3;
        }
        throw new IllegalStateException("Stream " + http2Stream.id() + " sent too many headers EOS: " + z2);
    }

    private ChannelFuture writeHeaders0(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, boolean z, int i2, short s, boolean z2, int i3, boolean z3, ChannelPromise channelPromise) {
        ChannelHandlerContext channelHandlerContext2;
        Http2Stream http2Stream;
        ChannelHandlerContext channelHandlerContext3 = channelHandlerContext;
        int i4 = i;
        boolean z4 = z3;
        ChannelPromise channelPromise2 = channelPromise;
        try {
            Http2Stream stream = this.connection.stream(i4);
            if (stream == null) {
                stream = this.connection.local().createStream(i4, false);
            } else {
                int i5 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
                if (!(i5 == 1 || i5 == 2)) {
                    if (i5 == 3) {
                        stream.open(z4);
                    } else {
                        throw new IllegalStateException("Stream " + stream.id() + " in unexpected state " + stream.state());
                    }
                }
            }
            Http2Stream http2Stream2 = stream;
            Http2RemoteFlowController flowController = flowController();
            if (z4) {
                try {
                    if (flowController.hasFlowControlled(http2Stream2)) {
                        flowController.addFlowControlled(http2Stream2, new FlowControlledHeaders(this, http2Stream2, http2Headers, z, i2, s, z2, i3, true, channelPromise));
                        return channelPromise2;
                    }
                } catch (Throwable th) {
                    th = th;
                    channelHandlerContext2 = channelHandlerContext;
                    this.lifecycleManager.onError(channelHandlerContext2, true, th);
                    channelPromise2.tryFailure(th);
                    return channelPromise2;
                }
            }
            Http2Stream http2Stream3 = http2Stream2;
            channelPromise2 = channelPromise.unvoid();
            boolean validateHeadersSentState = validateHeadersSentState(http2Stream3, http2Headers, this.connection.isServer(), z4);
            ChannelFuture sendHeaders = sendHeaders(this.frameWriter, channelHandlerContext, i, http2Headers, z, i2, s, z2, i3, z3, channelPromise2);
            Throwable cause = sendHeaders.cause();
            if (cause == null) {
                http2Stream3.headersSent(validateHeadersSentState);
                if (!sendHeaders.isSuccess()) {
                    channelHandlerContext2 = channelHandlerContext;
                    http2Stream = http2Stream3;
                    try {
                        notifyLifecycleManagerOnError(sendHeaders, channelHandlerContext2);
                    } catch (Throwable th2) {
                        th = th2;
                        this.lifecycleManager.onError(channelHandlerContext2, true, th);
                        channelPromise2.tryFailure(th);
                        return channelPromise2;
                    }
                } else {
                    ChannelHandlerContext channelHandlerContext4 = channelHandlerContext;
                    http2Stream = http2Stream3;
                }
            } else {
                http2Stream = http2Stream3;
                this.lifecycleManager.onError(channelHandlerContext, true, cause);
            }
            if (z4) {
                this.lifecycleManager.closeStreamLocal(http2Stream, sendHeaders);
            }
            return sendHeaders;
        } catch (Http2Exception e) {
            if (this.connection.remote().mayHaveCreatedStream(i4)) {
                channelPromise2.tryFailure(new IllegalStateException("Stream no longer exists: " + i4, e));
                return channelPromise2;
            }
            throw e;
        } catch (Throwable th3) {
            th = th3;
            channelHandlerContext2 = channelHandlerContext3;
            this.lifecycleManager.onError(channelHandlerContext2, true, th);
            channelPromise2.tryFailure(th);
            return channelPromise2;
        }
    }

    public void close() {
        this.frameWriter.close();
    }

    public Http2FrameWriter.Configuration configuration() {
        return this.frameWriter.configuration();
    }

    public Http2Connection connection() {
        return this.connection;
    }

    public void consumeReceivedSettings(Http2Settings http2Settings) {
        if (this.outstandingRemoteSettingsQueue == null) {
            this.outstandingRemoteSettingsQueue = new ArrayDeque(2);
        }
        this.outstandingRemoteSettingsQueue.add(http2Settings);
    }

    public final Http2RemoteFlowController flowController() {
        return connection().remote().flowController();
    }

    public Http2FrameWriter frameWriter() {
        return this.frameWriter;
    }

    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = (Http2LifecycleManager) ObjectUtil.checkNotNull(http2LifecycleManager, "lifecycleManager");
    }

    public Http2Settings pollSentSettings() {
        return this.outstandingLocalSettingsQueue.poll();
    }

    public void remoteSettings(Http2Settings http2Settings) throws Http2Exception {
        Boolean pushEnabled = http2Settings.pushEnabled();
        Http2FrameWriter.Configuration configuration = configuration();
        Http2HeadersEncoder.Configuration headersConfiguration = configuration.headersConfiguration();
        Http2FrameSizePolicy frameSizePolicy = configuration.frameSizePolicy();
        if (pushEnabled != null) {
            if (this.connection.isServer() || !pushEnabled.booleanValue()) {
                this.connection.remote().allowPushTo(pushEnabled.booleanValue());
            } else {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Client received a value of ENABLE_PUSH specified to other than 0", new Object[0]);
            }
        }
        Long maxConcurrentStreams = http2Settings.maxConcurrentStreams();
        if (maxConcurrentStreams != null) {
            this.connection.local().maxActiveStreams((int) Math.min(maxConcurrentStreams.longValue(), UpdateOptions.SOURCE_ANY));
        }
        Long headerTableSize = http2Settings.headerTableSize();
        if (headerTableSize != null) {
            headersConfiguration.maxHeaderTableSize((long) ((int) Math.min(headerTableSize.longValue(), UpdateOptions.SOURCE_ANY)));
        }
        Long maxHeaderListSize = http2Settings.maxHeaderListSize();
        if (maxHeaderListSize != null) {
            headersConfiguration.maxHeaderListSize(maxHeaderListSize.longValue());
        }
        Integer maxFrameSize = http2Settings.maxFrameSize();
        if (maxFrameSize != null) {
            frameSizePolicy.maxFrameSize(maxFrameSize.intValue());
        }
        Integer initialWindowSize = http2Settings.initialWindowSize();
        if (initialWindowSize != null) {
            flowController().initialWindowSize(initialWindowSize.intValue());
        }
    }

    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z, ChannelPromise channelPromise) {
        ChannelPromise unvoid = channelPromise.unvoid();
        try {
            Http2Stream requireStream = requireStream(i);
            int i3 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[requireStream.state().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("Stream " + requireStream.id() + " in unexpected state " + requireStream.state());
                }
            }
            flowController().addFlowControlled(requireStream, new FlowControlledData(requireStream, byteBuf, i2, z, unvoid));
            return unvoid;
        } catch (Throwable th) {
            byteBuf.release();
            return unvoid.setFailure(th);
        }
    }

    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.frameWriter.writeFrame(channelHandlerContext, b, i, http2Flags, byteBuf, channelPromise);
    }

    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf, ChannelPromise channelPromise) {
        return this.lifecycleManager.goAway(channelHandlerContext, i, j, byteBuf, channelPromise);
    }

    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
        return writeHeaders0(channelHandlerContext, i, http2Headers, false, 0, 0, false, i2, z, channelPromise);
    }

    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z, long j, ChannelPromise channelPromise) {
        return this.frameWriter.writePing(channelHandlerContext, z, j, channelPromise);
    }

    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z, ChannelPromise channelPromise) {
        return this.frameWriter.writePriority(channelHandlerContext, i, i2, s, z, channelPromise);
    }

    public ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3, ChannelPromise channelPromise) {
        ChannelPromise channelPromise2;
        ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
        try {
            if (!this.connection.goAwayReceived()) {
                int i4 = i;
                Http2Stream requireStream = requireStream(i);
                this.connection.local().reservePushStream(i2, requireStream);
                channelPromise2 = channelPromise.unvoid();
                try {
                    ChannelFuture writePushPromise = this.frameWriter.writePushPromise(channelHandlerContext, i, i2, http2Headers, i3, channelPromise2);
                    Throwable cause = writePushPromise.cause();
                    if (cause == null) {
                        requireStream.pushPromiseSent();
                        if (!writePushPromise.isSuccess()) {
                            notifyLifecycleManagerOnError(writePushPromise, channelHandlerContext);
                        }
                    } else {
                        this.lifecycleManager.onError(channelHandlerContext, true, cause);
                    }
                    return writePushPromise;
                } catch (Throwable th) {
                    th = th;
                    this.lifecycleManager.onError(channelHandlerContext, true, th);
                    channelPromise2.tryFailure(th);
                    return channelPromise2;
                }
            } else {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Sending PUSH_PROMISE after GO_AWAY received.", new Object[0]);
            }
        } catch (Throwable th2) {
            th = th2;
            channelPromise2 = channelPromise;
            this.lifecycleManager.onError(channelHandlerContext, true, th);
            channelPromise2.tryFailure(th);
            return channelPromise2;
        }
    }

    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        return this.lifecycleManager.resetStream(channelHandlerContext, i, j, channelPromise);
    }

    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        this.outstandingLocalSettingsQueue.add(http2Settings);
        try {
            if (http2Settings.pushEnabled() != null) {
                if (this.connection.isServer()) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
                }
            }
            return this.frameWriter.writeSettings(channelHandlerContext, http2Settings, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        Queue<Http2Settings> queue = this.outstandingRemoteSettingsQueue;
        if (queue == null) {
            return this.frameWriter.writeSettingsAck(channelHandlerContext, channelPromise);
        }
        Http2Settings poll = queue.poll();
        if (poll == null) {
            return channelPromise.setFailure(new Http2Exception(Http2Error.INTERNAL_ERROR, "attempted to write a SETTINGS ACK with no  pending SETTINGS"));
        }
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        this.frameWriter.writeSettingsAck(channelHandlerContext, simpleChannelPromiseAggregator.newPromise());
        ChannelPromise newPromise = simpleChannelPromiseAggregator.newPromise();
        try {
            remoteSettings(poll);
            newPromise.setSuccess();
        } catch (Throwable th) {
            newPromise.setFailure(th);
            this.lifecycleManager.onError(channelHandlerContext, true, th);
        }
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i, int i2, ChannelPromise channelPromise) {
        return channelPromise.setFailure(new UnsupportedOperationException("Use the Http2[Inbound|Outbound]FlowController objects to control window sizes"));
    }

    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2, ChannelPromise channelPromise) {
        return writeHeaders0(channelHandlerContext, i, http2Headers, true, i2, s, z, i3, z2, channelPromise);
    }
}
