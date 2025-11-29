package io.netty.channel.embedded;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class EmbeddedChannel extends AbstractChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ChannelHandler[] EMPTY_HANDLERS = new ChannelHandler[0];
    private static final SocketAddress LOCAL_ADDRESS = new EmbeddedSocketAddress();
    private static final ChannelMetadata METADATA_DISCONNECT = new ChannelMetadata(true);
    private static final ChannelMetadata METADATA_NO_DISCONNECT = new ChannelMetadata(false);
    private static final SocketAddress REMOTE_ADDRESS = new EmbeddedSocketAddress();
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) EmbeddedChannel.class);
    private final ChannelConfig config;
    private Queue<Object> inboundMessages;
    private Throwable lastException;
    private final EmbeddedEventLoop loop;
    private final ChannelMetadata metadata;
    private Queue<Object> outboundMessages;
    private final ChannelFutureListener recordExceptionListener;
    private State state;

    public final class EmbeddedChannelPipeline extends DefaultChannelPipeline {
        public EmbeddedChannelPipeline(EmbeddedChannel embeddedChannel) {
            super(embeddedChannel);
        }

        public void onUnhandledInboundException(Throwable th) {
            EmbeddedChannel.this.recordException(th);
        }

        public void onUnhandledInboundMessage(ChannelHandlerContext channelHandlerContext, Object obj) {
            EmbeddedChannel.this.handleInboundMessage(obj);
        }
    }

    public final class EmbeddedUnsafe extends AbstractChannel.AbstractUnsafe {
        final Channel.Unsafe wrapped;

        private EmbeddedUnsafe() {
            super();
            this.wrapped = new Channel.Unsafe() {
                public void beginRead() {
                    EmbeddedUnsafe.this.beginRead();
                    EmbeddedChannel.this.runPendingTasks();
                }

                public void bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.bind(socketAddress, channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                public void close(ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.close(channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                public void closeForcibly() {
                    EmbeddedUnsafe.this.closeForcibly();
                    EmbeddedChannel.this.runPendingTasks();
                }

                public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.connect(socketAddress, socketAddress2, channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                public void deregister(ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.deregister(channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                public void disconnect(ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.disconnect(channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                public void flush() {
                    EmbeddedUnsafe.this.flush();
                    EmbeddedChannel.this.runPendingTasks();
                }

                public SocketAddress localAddress() {
                    return EmbeddedUnsafe.this.localAddress();
                }

                public ChannelOutboundBuffer outboundBuffer() {
                    return EmbeddedUnsafe.this.outboundBuffer();
                }

                public RecvByteBufAllocator.Handle recvBufAllocHandle() {
                    return EmbeddedUnsafe.this.recvBufAllocHandle();
                }

                public void register(EventLoop eventLoop, ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.register(eventLoop, channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }

                public SocketAddress remoteAddress() {
                    return EmbeddedUnsafe.this.remoteAddress();
                }

                public ChannelPromise voidPromise() {
                    return EmbeddedUnsafe.this.voidPromise();
                }

                public void write(Object obj, ChannelPromise channelPromise) {
                    EmbeddedUnsafe.this.write(obj, channelPromise);
                    EmbeddedChannel.this.runPendingTasks();
                }
            };
        }

        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            safeSetSuccess(channelPromise);
        }
    }

    public enum State {
        OPEN,
        ACTIVE,
        CLOSED
    }

    public EmbeddedChannel() {
        this(EMPTY_HANDLERS);
    }

    private ChannelFuture checkException(ChannelPromise channelPromise) {
        Throwable th = this.lastException;
        if (th == null) {
            return channelPromise.setSuccess();
        }
        this.lastException = null;
        if (channelPromise.isVoid()) {
            PlatformDependent.throwException(th);
        }
        return channelPromise.setFailure(th);
    }

    private boolean checkOpen(boolean z) {
        if (isOpen()) {
            return true;
        }
        if (!z) {
            return false;
        }
        recordException((Throwable) new ClosedChannelException());
        return false;
    }

    private EmbeddedEventLoop embeddedEventLoop() {
        return isRegistered() ? (EmbeddedEventLoop) super.eventLoop() : this.loop;
    }

    private void finishPendingTasks(boolean z) {
        runPendingTasks();
        if (z) {
            embeddedEventLoop().cancelScheduledTasks();
        }
    }

    private void flushOutbound0() {
        runPendingTasks();
        flush();
    }

    private static boolean isNotEmpty(Queue<Object> queue) {
        return queue != null && !queue.isEmpty();
    }

    private static ChannelMetadata metadata(boolean z) {
        return z ? METADATA_DISCONNECT : METADATA_NO_DISCONNECT;
    }

    private static Object poll(Queue<Object> queue) {
        if (queue != null) {
            return queue.poll();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void recordException(ChannelFuture channelFuture) {
        if (!channelFuture.isSuccess()) {
            recordException(channelFuture.cause());
        }
    }

    private static boolean releaseAll(Queue<Object> queue) {
        if (!isNotEmpty(queue)) {
            return false;
        }
        while (true) {
            Object poll = queue.poll();
            if (poll == null) {
                return true;
            }
            ReferenceCountUtil.release(poll);
        }
    }

    private void setup(boolean z, final ChannelHandler... channelHandlerArr) {
        ObjectUtil.checkNotNull(channelHandlerArr, "handlers");
        pipeline().addLast(new ChannelInitializer<Channel>() {
            public void initChannel(Channel channel) throws Exception {
                ChannelPipeline pipeline = channel.pipeline();
                ChannelHandler[] channelHandlerArr = channelHandlerArr;
                int length = channelHandlerArr.length;
                int i = 0;
                while (i < length) {
                    ChannelHandler channelHandler = channelHandlerArr[i];
                    if (channelHandler != null) {
                        pipeline.addLast(channelHandler);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        });
        if (z) {
            this.loop.register((Channel) this);
        }
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        embeddedEventLoop().advanceTimeBy(timeUnit.toNanos(j));
    }

    public final ChannelFuture close() {
        return close(newPromise());
    }

    public ChannelConfig config() {
        return this.config;
    }

    public final ChannelFuture disconnect() {
        return disconnect(newPromise());
    }

    public void doBeginRead() throws Exception {
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
    }

    public void doClose() throws Exception {
        this.state = State.CLOSED;
    }

    public void doDisconnect() throws Exception {
        if (!this.metadata.hasDisconnect()) {
            doClose();
        }
    }

    public void doRegister() throws Exception {
        this.state = State.ACTIVE;
    }

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current != null) {
                ReferenceCountUtil.retain(current);
                handleOutboundMessage(current);
                channelOutboundBuffer.remove();
            } else {
                return;
            }
        }
    }

    public final void ensureOpen() {
        if (!checkOpen(true)) {
            checkException();
        }
    }

    public boolean finish() {
        return finish(false);
    }

    public boolean finishAndReleaseAll() {
        return finish(true);
    }

    public EmbeddedChannel flushInbound() {
        flushInbound(true, voidPromise());
        return this;
    }

    public EmbeddedChannel flushOutbound() {
        if (checkOpen(true)) {
            flushOutbound0();
        }
        checkException(voidPromise());
        return this;
    }

    public void freezeTime() {
        embeddedEventLoop().freezeTime();
    }

    public void handleInboundMessage(Object obj) {
        inboundMessages().add(obj);
    }

    public void handleOutboundMessage(Object obj) {
        outboundMessages().add(obj);
    }

    public boolean hasPendingTasks() {
        return embeddedEventLoop().hasPendingNormalTasks() || embeddedEventLoop().nextScheduledTask() == 0;
    }

    public Queue<Object> inboundMessages() {
        if (this.inboundMessages == null) {
            this.inboundMessages = new ArrayDeque();
        }
        return this.inboundMessages;
    }

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EmbeddedEventLoop;
    }

    public boolean isOpen() {
        return this.state != State.CLOSED;
    }

    @Deprecated
    public Queue<Object> lastInboundBuffer() {
        return inboundMessages();
    }

    @Deprecated
    public Queue<Object> lastOutboundBuffer() {
        return outboundMessages();
    }

    public SocketAddress localAddress0() {
        if (isActive()) {
            return LOCAL_ADDRESS;
        }
        return null;
    }

    public final DefaultChannelPipeline newChannelPipeline() {
        return new EmbeddedChannelPipeline(this);
    }

    public AbstractChannel.AbstractUnsafe newUnsafe() {
        return new EmbeddedUnsafe();
    }

    public Queue<Object> outboundMessages() {
        if (this.outboundMessages == null) {
            this.outboundMessages = new ArrayDeque();
        }
        return this.outboundMessages;
    }

    public <T> T readInbound() {
        T poll = poll(this.inboundMessages);
        if (poll != null) {
            ReferenceCountUtil.touch(poll, "Caller of readInbound() will handle the message from this point");
        }
        return poll;
    }

    public <T> T readOutbound() {
        T poll = poll(this.outboundMessages);
        if (poll != null) {
            ReferenceCountUtil.touch(poll, "Caller of readOutbound() will handle the message from this point.");
        }
        return poll;
    }

    public void register() throws Exception {
        Throwable cause = this.loop.register((Channel) this).cause();
        if (cause != null) {
            PlatformDependent.throwException(cause);
        }
    }

    public boolean releaseInbound() {
        return releaseAll(this.inboundMessages);
    }

    public boolean releaseOutbound() {
        return releaseAll(this.outboundMessages);
    }

    public SocketAddress remoteAddress0() {
        if (isActive()) {
            return REMOTE_ADDRESS;
        }
        return null;
    }

    public void runPendingTasks() {
        try {
            embeddedEventLoop().runTasks();
        } catch (Exception e) {
            recordException((Throwable) e);
        }
        try {
            embeddedEventLoop().runScheduledTasks();
        } catch (Exception e2) {
            recordException((Throwable) e2);
        }
    }

    public long runScheduledPendingTasks() {
        try {
            return embeddedEventLoop().runScheduledTasks();
        } catch (Exception e) {
            recordException((Throwable) e);
            return embeddedEventLoop().nextScheduledTask();
        }
    }

    public void unfreezeTime() {
        embeddedEventLoop().unfreezeTime();
    }

    public Channel.Unsafe unsafe() {
        return ((EmbeddedUnsafe) super.unsafe()).wrapped;
    }

    public boolean writeInbound(Object... objArr) {
        ensureOpen();
        if (objArr.length == 0) {
            return isNotEmpty(this.inboundMessages);
        }
        ChannelPipeline pipeline = pipeline();
        for (Object fireChannelRead : objArr) {
            pipeline.fireChannelRead(fireChannelRead);
        }
        flushInbound(false, voidPromise());
        return isNotEmpty(this.inboundMessages);
    }

    public ChannelFuture writeOneInbound(Object obj) {
        return writeOneInbound(obj, newPromise());
    }

    public ChannelFuture writeOneOutbound(Object obj) {
        return writeOneOutbound(obj, newPromise());
    }

    public boolean writeOutbound(Object... objArr) {
        ensureOpen();
        if (objArr.length == 0) {
            return isNotEmpty(this.outboundMessages);
        }
        RecyclableArrayList newInstance = RecyclableArrayList.newInstance(objArr.length);
        try {
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj = objArr[i];
                if (obj == null) {
                    break;
                }
                newInstance.add(write(obj));
                i++;
            }
            flushOutbound0();
            int size = newInstance.size();
            for (int i2 = 0; i2 < size; i2++) {
                ChannelFuture channelFuture = (ChannelFuture) newInstance.get(i2);
                if (channelFuture.isDone()) {
                    recordException(channelFuture);
                } else {
                    channelFuture.addListener(this.recordExceptionListener);
                }
            }
            checkException();
            boolean isNotEmpty = isNotEmpty(this.outboundMessages);
            newInstance.recycle();
            return isNotEmpty;
        } catch (Throwable th) {
            newInstance.recycle();
            throw th;
        }
    }

    public EmbeddedChannel(ChannelId channelId) {
        this(channelId, EMPTY_HANDLERS);
    }

    private boolean finish(boolean z) {
        close();
        try {
            checkException();
            return isNotEmpty(this.inboundMessages) || isNotEmpty(this.outboundMessages);
        } finally {
            if (z) {
                releaseAll(this.inboundMessages);
                releaseAll(this.outboundMessages);
            }
        }
    }

    private ChannelFuture flushInbound(boolean z, ChannelPromise channelPromise) {
        if (checkOpen(z)) {
            pipeline().fireChannelReadComplete();
            runPendingTasks();
        }
        return checkException(channelPromise);
    }

    public final ChannelFuture close(ChannelPromise channelPromise) {
        runPendingTasks();
        ChannelFuture close = super.close(channelPromise);
        finishPendingTasks(true);
        return close;
    }

    public final ChannelFuture disconnect(ChannelPromise channelPromise) {
        ChannelFuture disconnect = super.disconnect(channelPromise);
        finishPendingTasks(!this.metadata.hasDisconnect());
        return disconnect;
    }

    public ChannelMetadata metadata() {
        return this.metadata;
    }

    public ChannelFuture writeOneInbound(Object obj, ChannelPromise channelPromise) {
        if (checkOpen(true)) {
            pipeline().fireChannelRead(obj);
        }
        return checkException(channelPromise);
    }

    public ChannelFuture writeOneOutbound(Object obj, ChannelPromise channelPromise) {
        if (checkOpen(true)) {
            return write(obj, channelPromise);
        }
        return checkException(channelPromise);
    }

    public EmbeddedChannel(ChannelHandler... channelHandlerArr) {
        this(EmbeddedChannelId.INSTANCE, channelHandlerArr);
    }

    /* access modifiers changed from: private */
    public void recordException(Throwable th) {
        if (this.lastException == null) {
            this.lastException = th;
        } else {
            logger.warn("More than one exception was raised. Will report only the first one and log others.", th);
        }
    }

    public EmbeddedChannel(boolean z, ChannelHandler... channelHandlerArr) {
        this(EmbeddedChannelId.INSTANCE, z, channelHandlerArr);
    }

    public EmbeddedChannel(boolean z, boolean z2, ChannelHandler... channelHandlerArr) {
        this(EmbeddedChannelId.INSTANCE, z, z2, channelHandlerArr);
    }

    public EmbeddedChannel(ChannelId channelId, ChannelHandler... channelHandlerArr) {
        this(channelId, false, channelHandlerArr);
    }

    public EmbeddedChannel(ChannelId channelId, boolean z, ChannelHandler... channelHandlerArr) {
        this(channelId, true, z, channelHandlerArr);
    }

    public void checkException() {
        checkException(voidPromise());
    }

    public EmbeddedChannel(ChannelId channelId, boolean z, boolean z2, ChannelHandler... channelHandlerArr) {
        this((Channel) null, channelId, z, z2, channelHandlerArr);
    }

    public EmbeddedChannel(Channel channel, ChannelId channelId, boolean z, boolean z2, ChannelHandler... channelHandlerArr) {
        super(channel, channelId);
        this.loop = new EmbeddedEventLoop();
        this.recordExceptionListener = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                EmbeddedChannel.this.recordException(channelFuture);
            }
        };
        this.metadata = metadata(z2);
        this.config = new DefaultChannelConfig(this);
        setup(z, channelHandlerArr);
    }

    public EmbeddedChannel(ChannelId channelId, boolean z, ChannelConfig channelConfig, ChannelHandler... channelHandlerArr) {
        super((Channel) null, channelId);
        this.loop = new EmbeddedEventLoop();
        this.recordExceptionListener = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                EmbeddedChannel.this.recordException(channelFuture);
            }
        };
        this.metadata = metadata(z);
        this.config = (ChannelConfig) ObjectUtil.checkNotNull(channelConfig, "config");
        setup(true, channelHandlerArr);
    }
}
