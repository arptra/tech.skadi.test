package io.netty.handler.codec.http2;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ServerChannel;
import io.netty.handler.codec.http2.Http2FrameCodec;
import io.netty.handler.codec.http2.Http2FrameStreamEvent;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.net.ssl.SSLException;

public final class Http2MultiplexHandler extends Http2ChannelDuplexHandler {
    static final ChannelFutureListener CHILD_CHANNEL_REGISTRATION_LISTENER = new ChannelFutureListener() {
        public void operationComplete(ChannelFuture channelFuture) {
            Http2MultiplexHandler.registerDone(channelFuture);
        }
    };
    /* access modifiers changed from: private */
    public volatile ChannelHandlerContext ctx;
    private int idCount;
    private final ChannelHandler inboundStreamHandler;
    /* access modifiers changed from: private */
    public boolean parentReadInProgress;
    /* access modifiers changed from: private */
    public final Queue<AbstractHttp2StreamChannel> readCompletePendingQueue;
    private final ChannelHandler upgradeStreamHandler;

    /* renamed from: io.netty.handler.codec.http2.Http2MultiplexHandler$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.netty.handler.codec.http2.Http2Stream$State[] r0 = io.netty.handler.codec.http2.Http2Stream.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = r0
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.HALF_CLOSED_LOCAL     // Catch:{ NoSuchFieldError -> 0x0012 }
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
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.OPEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.http2.Http2Stream$State r1 = io.netty.handler.codec.http2.Http2Stream.State.CLOSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.Http2MultiplexHandler.AnonymousClass4.<clinit>():void");
        }
    }

    public final class Http2MultiplexHandlerStreamChannel extends AbstractHttp2StreamChannel {
        public Http2MultiplexHandlerStreamChannel(Http2FrameCodec.DefaultHttp2FrameStream defaultHttp2FrameStream, ChannelHandler channelHandler) {
            super(defaultHttp2FrameStream, Http2MultiplexHandler.access$004(Http2MultiplexHandler.this), channelHandler);
        }

        public void addChannelToReadCompletePendingQueue() {
            while (!Http2MultiplexHandler.this.readCompletePendingQueue.offer(this)) {
                Http2MultiplexHandler.this.processPendingReadCompleteQueue();
            }
        }

        public boolean isParentReadInProgress() {
            return Http2MultiplexHandler.this.parentReadInProgress;
        }

        public ChannelHandlerContext parentContext() {
            return Http2MultiplexHandler.this.ctx;
        }
    }

    public Http2MultiplexHandler(ChannelHandler channelHandler) {
        this(channelHandler, (ChannelHandler) null);
    }

    public static /* synthetic */ int access$004(Http2MultiplexHandler http2MultiplexHandler) {
        int i = http2MultiplexHandler.idCount + 1;
        http2MultiplexHandler.idCount = i;
        return i;
    }

    private static boolean isServer(ChannelHandlerContext channelHandlerContext) {
        return channelHandlerContext.channel().parent() instanceof ServerChannel;
    }

    private void onHttp2GoAwayFrame(ChannelHandlerContext channelHandlerContext, final Http2GoAwayFrame http2GoAwayFrame) {
        if (http2GoAwayFrame.lastStreamId() != Integer.MAX_VALUE) {
            try {
                final boolean isServer = isServer(channelHandlerContext);
                forEachActiveStream(new Http2FrameStreamVisitor() {
                    public boolean visit(Http2FrameStream http2FrameStream) {
                        int id = http2FrameStream.id();
                        if (id <= http2GoAwayFrame.lastStreamId() || !Http2CodecUtil.isStreamIdValid(id, isServer)) {
                            return true;
                        }
                        ((AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStream).attachment).pipeline().fireUserEventTriggered(http2GoAwayFrame.retainedDuplicate());
                        return true;
                    }
                });
            } catch (Http2Exception e) {
                channelHandlerContext.fireExceptionCaught(e);
                channelHandlerContext.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public void processPendingReadCompleteQueue() {
        this.parentReadInProgress = true;
        AbstractHttp2StreamChannel poll = this.readCompletePendingQueue.poll();
        if (poll != null) {
            do {
                try {
                    poll.fireChildReadComplete();
                    poll = this.readCompletePendingQueue.poll();
                } finally {
                    this.parentReadInProgress = false;
                    this.readCompletePendingQueue.clear();
                    this.ctx.flush();
                }
            } while (poll != null);
            return;
        }
        this.parentReadInProgress = false;
    }

    public static void registerDone(ChannelFuture channelFuture) {
        if (!channelFuture.isSuccess()) {
            Channel channel = channelFuture.channel();
            if (channel.isRegistered()) {
                channel.close();
            } else {
                channel.unsafe().closeForcibly();
            }
        }
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        this.parentReadInProgress = true;
        if (!(obj instanceof Http2StreamFrame)) {
            if (obj instanceof Http2GoAwayFrame) {
                onHttp2GoAwayFrame(channelHandlerContext, (Http2GoAwayFrame) obj);
            }
            channelHandlerContext.fireChannelRead(obj);
        } else if (!(obj instanceof Http2WindowUpdateFrame)) {
            Http2StreamFrame http2StreamFrame = (Http2StreamFrame) obj;
            AbstractHttp2StreamChannel abstractHttp2StreamChannel = (AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2StreamFrame.stream()).attachment;
            if (obj instanceof Http2ResetFrame) {
                abstractHttp2StreamChannel.pipeline().fireUserEventTriggered(obj);
            } else {
                abstractHttp2StreamChannel.fireChildRead(http2StreamFrame);
            }
        }
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        processPendingReadCompleteQueue();
        channelHandlerContext.fireChannelReadComplete();
    }

    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isWritable()) {
            forEachActiveStream(AbstractHttp2StreamChannel.WRITABLE_VISITOR);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, final Throwable th) throws Exception {
        if (th instanceof Http2FrameStreamException) {
            AbstractHttp2StreamChannel abstractHttp2StreamChannel = (AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) ((Http2FrameStreamException) th).stream()).attachment;
            try {
                abstractHttp2StreamChannel.pipeline().fireExceptionCaught(th.getCause());
            } finally {
                abstractHttp2StreamChannel.unsafe().closeForcibly();
            }
        } else {
            if (th.getCause() instanceof SSLException) {
                forEachActiveStream(new Http2FrameStreamVisitor() {
                    public boolean visit(Http2FrameStream http2FrameStream) {
                        ((AbstractHttp2StreamChannel) ((Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStream).attachment).pipeline().fireExceptionCaught(th);
                        return true;
                    }
                });
            }
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    public void handlerAdded0(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.executor() == channelHandlerContext.channel().eventLoop()) {
            this.ctx = channelHandlerContext;
            return;
        }
        throw new IllegalStateException("EventExecutor must be EventLoop of Channel");
    }

    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) {
        this.readCompletePendingQueue.clear();
    }

    public Http2StreamChannel newOutboundStream() {
        return new Http2MultiplexHandlerStreamChannel((Http2FrameCodec.DefaultHttp2FrameStream) newStream(), (ChannelHandler) null);
    }

    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        Http2MultiplexHandlerStreamChannel http2MultiplexHandlerStreamChannel;
        AbstractHttp2StreamChannel abstractHttp2StreamChannel;
        if (obj instanceof Http2FrameStreamEvent) {
            Http2FrameStreamEvent http2FrameStreamEvent = (Http2FrameStreamEvent) obj;
            Http2FrameCodec.DefaultHttp2FrameStream defaultHttp2FrameStream = (Http2FrameCodec.DefaultHttp2FrameStream) http2FrameStreamEvent.stream();
            if (http2FrameStreamEvent.type() == Http2FrameStreamEvent.Type.State) {
                int i = AnonymousClass4.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[defaultHttp2FrameStream.state().ordinal()];
                if (i != 1) {
                    if (!(i == 2 || i == 3)) {
                        if (i == 4 && (abstractHttp2StreamChannel = (AbstractHttp2StreamChannel) defaultHttp2FrameStream.attachment) != null) {
                            abstractHttp2StreamChannel.streamClosed();
                            return;
                        }
                        return;
                    }
                } else if (defaultHttp2FrameStream.id() != 1) {
                    return;
                }
                if (defaultHttp2FrameStream.attachment == null) {
                    if (defaultHttp2FrameStream.id() != 1 || isServer(channelHandlerContext)) {
                        http2MultiplexHandlerStreamChannel = new Http2MultiplexHandlerStreamChannel(defaultHttp2FrameStream, this.inboundStreamHandler);
                    } else if (this.upgradeStreamHandler != null) {
                        http2MultiplexHandlerStreamChannel = new Http2MultiplexHandlerStreamChannel(defaultHttp2FrameStream, this.upgradeStreamHandler);
                        http2MultiplexHandlerStreamChannel.closeOutbound();
                    } else {
                        throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Client is misconfigured for upgrade requests", new Object[0]);
                    }
                    ChannelFuture register = channelHandlerContext.channel().eventLoop().register((Channel) http2MultiplexHandlerStreamChannel);
                    if (register.isDone()) {
                        registerDone(register);
                    } else {
                        register.addListener(CHILD_CHANNEL_REGISTRATION_LISTENER);
                    }
                }
            }
        } else {
            channelHandlerContext.fireUserEventTriggered(obj);
        }
    }

    public Http2MultiplexHandler(ChannelHandler channelHandler, ChannelHandler channelHandler2) {
        this.readCompletePendingQueue = new MaxCapacityQueue(new ArrayDeque(8), 100);
        this.inboundStreamHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "inboundStreamHandler");
        this.upgradeStreamHandler = channelHandler2;
    }
}
