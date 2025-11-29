package io.netty.handler.codec.http2;

import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

public class DefaultHttp2LocalFlowController implements Http2LocalFlowController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float DEFAULT_WINDOW_UPDATE_RATIO = 0.5f;
    /* access modifiers changed from: private */
    public static final FlowState REDUCED_FLOW_STATE = new FlowState() {
        public boolean consumeBytes(int i) throws Http2Exception {
            return false;
        }

        public void endOfStream(boolean z) {
            throw new UnsupportedOperationException();
        }

        public void incrementFlowControlWindows(int i) throws Http2Exception {
        }

        public void incrementInitialStreamWindow(int i) {
        }

        public int initialWindowSize() {
            return 0;
        }

        public void receiveFlowControlledFrame(int i) throws Http2Exception {
            throw new UnsupportedOperationException();
        }

        public int unconsumedBytes() {
            return 0;
        }

        public void window(int i) {
            throw new UnsupportedOperationException();
        }

        public int windowSize() {
            return 0;
        }

        public float windowUpdateRatio() {
            throw new UnsupportedOperationException();
        }

        public boolean writeWindowUpdateIfNeeded() throws Http2Exception {
            throw new UnsupportedOperationException();
        }

        public void windowUpdateRatio(float f) {
            throw new UnsupportedOperationException();
        }
    };
    private final Http2Connection connection;
    /* access modifiers changed from: private */
    public ChannelHandlerContext ctx;
    /* access modifiers changed from: private */
    public Http2FrameWriter frameWriter;
    /* access modifiers changed from: private */
    public int initialWindowSize;
    /* access modifiers changed from: private */
    public final Http2Connection.PropertyKey stateKey;
    /* access modifiers changed from: private */
    public float windowUpdateRatio;

    public final class AutoRefillState extends DefaultState {
        public AutoRefillState(Http2Stream http2Stream, int i) {
            super(http2Stream, i);
        }

        public boolean consumeBytes(int i) throws Http2Exception {
            return false;
        }

        public void receiveFlowControlledFrame(int i) throws Http2Exception {
            super.receiveFlowControlledFrame(i);
            super.consumeBytes(i);
        }
    }

    public class DefaultState implements FlowState {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean endOfStream;
        private int initialStreamWindowSize;
        private int lowerBound;
        private int processedWindow;
        private final Http2Stream stream;
        private float streamWindowUpdateRatio;
        private int window;

        public DefaultState(Http2Stream http2Stream, int i) {
            this.stream = http2Stream;
            window(i);
            this.streamWindowUpdateRatio = DefaultHttp2LocalFlowController.this.windowUpdateRatio;
        }

        private void returnProcessedBytes(int i) throws Http2Exception {
            int i2 = this.processedWindow;
            if (i2 - i >= this.window) {
                this.processedWindow = i2 - i;
                return;
            }
            throw Http2Exception.streamError(this.stream.id(), Http2Error.INTERNAL_ERROR, "Attempting to return too many bytes for stream %d", Integer.valueOf(this.stream.id()));
        }

        private void writeWindowUpdate() throws Http2Exception {
            int i = this.initialStreamWindowSize - this.processedWindow;
            try {
                incrementFlowControlWindows(i);
                DefaultHttp2LocalFlowController.this.frameWriter.writeWindowUpdate(DefaultHttp2LocalFlowController.this.ctx, this.stream.id(), i, DefaultHttp2LocalFlowController.this.ctx.newPromise());
            } catch (Throwable th) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, th, "Attempting to return too many bytes for stream %d", Integer.valueOf(this.stream.id()));
            }
        }

        public boolean consumeBytes(int i) throws Http2Exception {
            returnProcessedBytes(i);
            return writeWindowUpdateIfNeeded();
        }

        public void endOfStream(boolean z) {
            this.endOfStream = z;
        }

        public void incrementFlowControlWindows(int i) throws Http2Exception {
            if (i <= 0 || this.window <= Integer.MAX_VALUE - i) {
                this.window += i;
                this.processedWindow += i;
                this.lowerBound = Math.min(i, 0);
                return;
            }
            throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window overflowed for stream: %d", Integer.valueOf(this.stream.id()));
        }

        public void incrementInitialStreamWindow(int i) {
            int min = (int) Math.min(UpdateOptions.SOURCE_ANY, Math.max(0, ((long) this.initialStreamWindowSize) + ((long) i)));
            int i2 = this.initialStreamWindowSize;
            this.initialStreamWindowSize = i2 + (min - i2);
        }

        public int initialWindowSize() {
            return this.initialStreamWindowSize;
        }

        public void receiveFlowControlledFrame(int i) throws Http2Exception {
            int i2 = this.window - i;
            this.window = i2;
            if (i2 < this.lowerBound) {
                throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window exceeded for stream: %d", Integer.valueOf(this.stream.id()));
            }
        }

        public int unconsumedBytes() {
            return this.processedWindow - this.window;
        }

        public void window(int i) {
            this.initialStreamWindowSize = i;
            this.processedWindow = i;
            this.window = i;
        }

        public int windowSize() {
            return this.window;
        }

        public float windowUpdateRatio() {
            return this.streamWindowUpdateRatio;
        }

        public boolean writeWindowUpdateIfNeeded() throws Http2Exception {
            if (this.endOfStream || this.initialStreamWindowSize <= 0 || DefaultHttp2LocalFlowController.isClosed(this.stream) || this.processedWindow > ((int) (((float) this.initialStreamWindowSize) * this.streamWindowUpdateRatio))) {
                return false;
            }
            writeWindowUpdate();
            return true;
        }

        public void windowUpdateRatio(float f) {
            this.streamWindowUpdateRatio = f;
        }
    }

    public interface FlowState {
        boolean consumeBytes(int i) throws Http2Exception;

        void endOfStream(boolean z);

        void incrementFlowControlWindows(int i) throws Http2Exception;

        void incrementInitialStreamWindow(int i);

        int initialWindowSize();

        void receiveFlowControlledFrame(int i) throws Http2Exception;

        int unconsumedBytes();

        void window(int i);

        int windowSize();

        float windowUpdateRatio();

        void windowUpdateRatio(float f);

        boolean writeWindowUpdateIfNeeded() throws Http2Exception;
    }

    public final class WindowUpdateVisitor implements Http2StreamVisitor {
        private Http2Exception.CompositeStreamException compositeException;
        private final int delta;

        public WindowUpdateVisitor(int i) {
            this.delta = i;
        }

        public void throwIfError() throws Http2Exception.CompositeStreamException {
            Http2Exception.CompositeStreamException compositeStreamException = this.compositeException;
            if (compositeStreamException != null) {
                throw compositeStreamException;
            }
        }

        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            try {
                FlowState access$300 = DefaultHttp2LocalFlowController.this.state(http2Stream);
                access$300.incrementFlowControlWindows(this.delta);
                access$300.incrementInitialStreamWindow(this.delta);
                return true;
            } catch (Http2Exception.StreamException e) {
                if (this.compositeException == null) {
                    this.compositeException = new Http2Exception.CompositeStreamException(e.error(), 4);
                }
                this.compositeException.add(e);
                return true;
            }
        }
    }

    public DefaultHttp2LocalFlowController(Http2Connection http2Connection) {
        this(http2Connection, 0.5f, false);
    }

    private static void checkValidRatio(float f) {
        double d = (double) f;
        if (Double.compare(d, 0.0d) <= 0 || Double.compare(d, 1.0d) >= 0) {
            throw new IllegalArgumentException("Invalid ratio: " + f);
        }
    }

    private FlowState connectionState() {
        return (FlowState) this.connection.connectionStream().getProperty(this.stateKey);
    }

    /* access modifiers changed from: private */
    public boolean consumeAllBytes(FlowState flowState, int i) throws Http2Exception {
        return connectionState().consumeBytes(i) | flowState.consumeBytes(i);
    }

    /* access modifiers changed from: private */
    public static boolean isClosed(Http2Stream http2Stream) {
        return http2Stream.state() == Http2Stream.State.CLOSED;
    }

    /* access modifiers changed from: private */
    public FlowState state(Http2Stream http2Stream) {
        return (FlowState) http2Stream.getProperty(this.stateKey);
    }

    public void channelHandlerContext(ChannelHandlerContext channelHandlerContext) {
        this.ctx = (ChannelHandlerContext) ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
    }

    public boolean consumeBytes(Http2Stream http2Stream, int i) throws Http2Exception {
        ObjectUtil.checkPositiveOrZero(i, "numBytes");
        if (i == 0 || http2Stream == null || isClosed(http2Stream)) {
            return false;
        }
        if (http2Stream.id() != 0) {
            return consumeAllBytes(state(http2Stream), i);
        }
        throw new UnsupportedOperationException("Returning bytes for the connection window is not supported");
    }

    public void incrementWindowSize(Http2Stream http2Stream, int i) throws Http2Exception {
        FlowState state = state(http2Stream);
        state.incrementInitialStreamWindow(i);
        state.writeWindowUpdateIfNeeded();
    }

    public void initialWindowSize(int i) throws Http2Exception {
        this.initialWindowSize = i;
        WindowUpdateVisitor windowUpdateVisitor = new WindowUpdateVisitor(i - this.initialWindowSize);
        this.connection.forEachActiveStream(windowUpdateVisitor);
        windowUpdateVisitor.throwIfError();
    }

    public void receiveFlowControlledFrame(Http2Stream http2Stream, ByteBuf byteBuf, int i, boolean z) throws Http2Exception {
        int readableBytes = byteBuf.readableBytes() + i;
        FlowState connectionState = connectionState();
        connectionState.receiveFlowControlledFrame(readableBytes);
        if (http2Stream != null && !isClosed(http2Stream)) {
            FlowState state = state(http2Stream);
            state.endOfStream(z);
            state.receiveFlowControlledFrame(readableBytes);
        } else if (readableBytes > 0) {
            connectionState.consumeBytes(readableBytes);
        }
    }

    public int unconsumedBytes(Http2Stream http2Stream) {
        return state(http2Stream).unconsumedBytes();
    }

    public int windowSize(Http2Stream http2Stream) {
        return state(http2Stream).windowSize();
    }

    public void windowUpdateRatio(float f) {
        checkValidRatio(f);
        this.windowUpdateRatio = f;
    }

    public DefaultHttp2LocalFlowController(Http2Connection http2Connection, float f, boolean z) {
        Object obj;
        this.initialWindowSize = 65535;
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        windowUpdateRatio(f);
        Http2Connection.PropertyKey newKey = http2Connection.newKey();
        this.stateKey = newKey;
        if (z) {
            obj = new AutoRefillState(http2Connection.connectionStream(), this.initialWindowSize);
        } else {
            obj = new DefaultState(http2Connection.connectionStream(), this.initialWindowSize);
        }
        http2Connection.connectionStream().setProperty(newKey, obj);
        http2Connection.addListener(new Http2ConnectionAdapter() {
            public void onStreamActive(Http2Stream http2Stream) {
                Http2Connection.PropertyKey access$000 = DefaultHttp2LocalFlowController.this.stateKey;
                DefaultHttp2LocalFlowController defaultHttp2LocalFlowController = DefaultHttp2LocalFlowController.this;
                http2Stream.setProperty(access$000, new DefaultState(http2Stream, defaultHttp2LocalFlowController.initialWindowSize));
            }

            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
            }

            public void onStreamClosed(Http2Stream http2Stream) {
                try {
                    FlowState access$300 = DefaultHttp2LocalFlowController.this.state(http2Stream);
                    int unconsumedBytes = access$300.unconsumedBytes();
                    if (DefaultHttp2LocalFlowController.this.ctx != null && unconsumedBytes > 0 && DefaultHttp2LocalFlowController.this.consumeAllBytes(access$300, unconsumedBytes)) {
                        DefaultHttp2LocalFlowController.this.ctx.flush();
                    }
                } catch (Http2Exception e) {
                    PlatformDependent.throwException(e);
                } catch (Throwable th) {
                    http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
                    throw th;
                }
                http2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
            }
        });
    }

    public DefaultHttp2LocalFlowController frameWriter(Http2FrameWriter http2FrameWriter) {
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        return this;
    }

    public float windowUpdateRatio() {
        return this.windowUpdateRatio;
    }

    public void windowUpdateRatio(Http2Stream http2Stream, float f) throws Http2Exception {
        checkValidRatio(f);
        FlowState state = state(http2Stream);
        state.windowUpdateRatio(f);
        state.writeWindowUpdateIfNeeded();
    }

    public int initialWindowSize() {
        return this.initialWindowSize;
    }

    public int initialWindowSize(Http2Stream http2Stream) {
        return state(http2Stream).initialWindowSize();
    }

    public float windowUpdateRatio(Http2Stream http2Stream) throws Http2Exception {
        return state(http2Stream).windowUpdateRatio();
    }
}
