package io.netty.channel;

import com.upuphone.starrynet.payload.PayloadConstant;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakHint;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.OrderedEventExecutor;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

abstract class AbstractChannelHandlerContext implements ChannelHandlerContext, ResourceLeakHint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADD_COMPLETE = 2;
    private static final int ADD_PENDING = 1;
    private static final AtomicIntegerFieldUpdater<AbstractChannelHandlerContext> HANDLER_STATE_UPDATER;
    private static final int INIT = 0;
    private static final int REMOVE_COMPLETE = 3;
    private static final InternalLogger logger;
    private final int executionMask;
    final EventExecutor executor;
    private volatile int handlerState = 0;
    private Tasks invokeTasks;
    private final String name;
    volatile AbstractChannelHandlerContext next;
    private final boolean ordered;
    /* access modifiers changed from: private */
    public final DefaultChannelPipeline pipeline;
    volatile AbstractChannelHandlerContext prev;
    private ChannelFuture succeededFuture;

    public static final class Tasks {
        /* access modifiers changed from: private */
        public final Runnable invokeChannelReadCompleteTask = new Runnable() {
            public void run() {
                Tasks.this.next.invokeChannelReadComplete();
            }
        };
        /* access modifiers changed from: private */
        public final Runnable invokeChannelWritableStateChangedTask = new Runnable() {
            public void run() {
                Tasks.this.next.invokeChannelWritabilityChanged();
            }
        };
        /* access modifiers changed from: private */
        public final Runnable invokeFlushTask = new Runnable() {
            public void run() {
                Tasks.this.next.invokeFlush();
            }
        };
        /* access modifiers changed from: private */
        public final Runnable invokeReadTask = new Runnable() {
            public void run() {
                Tasks.this.next.invokeRead();
            }
        };
        /* access modifiers changed from: private */
        public final AbstractChannelHandlerContext next;

        public Tasks(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            this.next = abstractChannelHandlerContext;
        }
    }

    public static final class WriteTask implements Runnable {
        private static final boolean ESTIMATE_TASK_SIZE_ON_SUBMIT = SystemPropertyUtil.getBoolean("io.netty.transport.estimateSizeOnSubmit", true);
        private static final ObjectPool<WriteTask> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<WriteTask>() {
            public WriteTask newObject(ObjectPool.Handle<WriteTask> handle) {
                return new WriteTask(handle);
            }
        });
        private static final int WRITE_TASK_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.writeTaskSizeOverhead", 32);
        private AbstractChannelHandlerContext ctx;
        private final ObjectPool.Handle<WriteTask> handle;
        private Object msg;
        private ChannelPromise promise;
        private int size;

        private void decrementPendingOutboundBytes() {
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                this.ctx.pipeline.decrementPendingOutboundBytes((long) (this.size & Integer.MAX_VALUE));
            }
        }

        public static void init(WriteTask writeTask, AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise, boolean z) {
            writeTask.ctx = abstractChannelHandlerContext;
            writeTask.msg = obj;
            writeTask.promise = channelPromise;
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                writeTask.size = abstractChannelHandlerContext.pipeline.estimatorHandle().size(obj) + WRITE_TASK_OVERHEAD;
                abstractChannelHandlerContext.pipeline.incrementPendingOutboundBytes((long) writeTask.size);
            } else {
                writeTask.size = 0;
            }
            if (z) {
                writeTask.size |= Integer.MIN_VALUE;
            }
        }

        public static WriteTask newInstance(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise, boolean z) {
            WriteTask writeTask = RECYCLER.get();
            init(writeTask, abstractChannelHandlerContext, obj, channelPromise, z);
            return writeTask;
        }

        private void recycle() {
            this.ctx = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }

        public void cancel() {
            try {
                decrementPendingOutboundBytes();
            } finally {
                recycle();
            }
        }

        public void run() {
            try {
                decrementPendingOutboundBytes();
                if (this.size >= 0) {
                    this.ctx.invokeWrite(this.msg, this.promise);
                } else {
                    this.ctx.invokeWriteAndFlush(this.msg, this.promise);
                }
            } finally {
                recycle();
            }
        }

        private WriteTask(ObjectPool.Handle<? extends WriteTask> handle2) {
            this.handle = handle2;
        }
    }

    static {
        Class<AbstractChannelHandlerContext> cls = AbstractChannelHandlerContext.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        HANDLER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(cls, "handlerState");
    }

    public AbstractChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, EventExecutor eventExecutor, String str, Class<? extends ChannelHandler> cls) {
        boolean z = false;
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.pipeline = defaultChannelPipeline;
        this.executor = eventExecutor;
        this.executionMask = ChannelHandlerMask.mask(cls);
        this.ordered = (eventExecutor == null || (eventExecutor instanceof OrderedEventExecutor)) ? true : z;
    }

    private AbstractChannelHandlerContext findContextInbound(int i) {
        EventExecutor executor2 = executor();
        do {
            this = this.next;
        } while (skipContext(this, executor2, i, 510));
        return this;
    }

    private AbstractChannelHandlerContext findContextOutbound(int i) {
        EventExecutor executor2 = executor();
        do {
            this = this.prev;
        } while (skipContext(this, executor2, i, 130560));
        return this;
    }

    /* access modifiers changed from: private */
    public void invokeBind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).bind(this, socketAddress, channelPromise);
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
            }
        } else {
            bind(socketAddress, channelPromise);
        }
    }

    public static void invokeChannelActive(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor2 = abstractChannelHandlerContext.executor();
        if (executor2.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelActive();
        } else {
            executor2.execute(new Runnable(abstractChannelHandlerContext) {
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r1;
                }

                public void run() {
                    this.val$next.invokeChannelActive();
                }
            });
        }
    }

    public static void invokeChannelInactive(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor2 = abstractChannelHandlerContext.executor();
        if (executor2.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelInactive();
        } else {
            executor2.execute(new Runnable(abstractChannelHandlerContext) {
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r1;
                }

                public void run() {
                    this.val$next.invokeChannelInactive();
                }
            });
        }
    }

    public static void invokeChannelRead(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj) {
        final Object obj2 = abstractChannelHandlerContext.pipeline.touch(ObjectUtil.checkNotNull(obj, PayloadConstant.PARAMS_KEY_CALLBACK_MSG), abstractChannelHandlerContext);
        EventExecutor executor2 = abstractChannelHandlerContext.executor();
        if (executor2.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelRead(obj2);
        } else {
            executor2.execute(new Runnable(abstractChannelHandlerContext) {
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r1;
                }

                public void run() {
                    this.val$next.invokeChannelRead(obj2);
                }
            });
        }
    }

    public static void invokeChannelReadComplete(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor2 = abstractChannelHandlerContext.executor();
        if (executor2.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelReadComplete();
            return;
        }
        Tasks tasks = abstractChannelHandlerContext.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContext);
            abstractChannelHandlerContext.invokeTasks = tasks;
        }
        executor2.execute(tasks.invokeChannelReadCompleteTask);
    }

    public static void invokeChannelRegistered(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor2 = abstractChannelHandlerContext.executor();
        if (executor2.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelRegistered();
        } else {
            executor2.execute(new Runnable(abstractChannelHandlerContext) {
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r1;
                }

                public void run() {
                    this.val$next.invokeChannelRegistered();
                }
            });
        }
    }

    public static void invokeChannelUnregistered(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor2 = abstractChannelHandlerContext.executor();
        if (executor2.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelUnregistered();
        } else {
            executor2.execute(new Runnable(abstractChannelHandlerContext) {
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r1;
                }

                public void run() {
                    this.val$next.invokeChannelUnregistered();
                }
            });
        }
    }

    public static void invokeChannelWritabilityChanged(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor executor2 = abstractChannelHandlerContext.executor();
        if (executor2.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelWritabilityChanged();
            return;
        }
        Tasks tasks = abstractChannelHandlerContext.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContext);
            abstractChannelHandlerContext.invokeTasks = tasks;
        }
        executor2.execute(tasks.invokeChannelWritableStateChangedTask);
    }

    /* access modifiers changed from: private */
    public void invokeClose(ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).close(this, channelPromise);
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
            }
        } else {
            close(channelPromise);
        }
    }

    /* access modifiers changed from: private */
    public void invokeConnect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).connect(this, socketAddress, socketAddress2, channelPromise);
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
            }
        } else {
            connect(socketAddress, socketAddress2, channelPromise);
        }
    }

    /* access modifiers changed from: private */
    public void invokeDeregister(ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).deregister(this, channelPromise);
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
            }
        } else {
            deregister(channelPromise);
        }
    }

    /* access modifiers changed from: private */
    public void invokeDisconnect(ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).disconnect(this, channelPromise);
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
            }
        } else {
            disconnect(channelPromise);
        }
    }

    public static void invokeExceptionCaught(AbstractChannelHandlerContext abstractChannelHandlerContext, final Throwable th) {
        ObjectUtil.checkNotNull(th, "cause");
        EventExecutor executor2 = abstractChannelHandlerContext.executor();
        if (executor2.inEventLoop()) {
            abstractChannelHandlerContext.invokeExceptionCaught(th);
            return;
        }
        try {
            executor2.execute(new Runnable(abstractChannelHandlerContext) {
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r1;
                }

                public void run() {
                    this.val$next.invokeExceptionCaught(th);
                }
            });
        } catch (Throwable th2) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("Failed to submit an exceptionCaught() event.", th2);
                internalLogger.warn("The exceptionCaught() event that was failed to submit was:", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void invokeFlush() {
        if (invokeHandler()) {
            invokeFlush0();
        } else {
            flush();
        }
    }

    private void invokeFlush0() {
        try {
            ((ChannelOutboundHandler) handler()).flush(this);
        } catch (Throwable th) {
            invokeExceptionCaught(th);
        }
    }

    private boolean invokeHandler() {
        int i = this.handlerState;
        if (i != 2) {
            return !this.ordered && i == 1;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void invokeRead() {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).read(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            read();
        }
    }

    public static void invokeUserEventTriggered(AbstractChannelHandlerContext abstractChannelHandlerContext, final Object obj) {
        ObjectUtil.checkNotNull(obj, "event");
        EventExecutor executor2 = abstractChannelHandlerContext.executor();
        if (executor2.inEventLoop()) {
            abstractChannelHandlerContext.invokeUserEventTriggered(obj);
        } else {
            executor2.execute(new Runnable(abstractChannelHandlerContext) {
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r1;
                }

                public void run() {
                    this.val$next.invokeUserEventTriggered(obj);
                }
            });
        }
    }

    private void invokeWrite0(Object obj, ChannelPromise channelPromise) {
        try {
            ((ChannelOutboundHandler) handler()).write(this, obj, channelPromise);
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    private boolean isNotValidPromise(ChannelPromise channelPromise, boolean z) {
        ObjectUtil.checkNotNull(channelPromise, "promise");
        if (channelPromise.isDone()) {
            if (channelPromise.isCancelled()) {
                return true;
            }
            throw new IllegalArgumentException("promise already done: " + channelPromise);
        } else if (channelPromise.channel() != channel()) {
            throw new IllegalArgumentException(String.format("promise.channel does not match: %s (expected: %s)", new Object[]{channelPromise.channel(), channel()}));
        } else if (channelPromise.getClass() == DefaultChannelPromise.class) {
            return false;
        } else {
            if (!z && (channelPromise instanceof VoidChannelPromise)) {
                throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) VoidChannelPromise.class) + " not allowed for this operation");
            } else if (!(channelPromise instanceof AbstractChannel.CloseFuture)) {
                return false;
            } else {
                throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) AbstractChannel.CloseFuture.class) + " not allowed in a pipeline");
            }
        }
    }

    private static void notifyOutboundHandlerException(Throwable th, ChannelPromise channelPromise) {
        PromiseNotificationUtil.tryFailure(channelPromise, th, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    private static boolean safeExecute(EventExecutor eventExecutor, Runnable runnable, ChannelPromise channelPromise, Object obj, boolean z) {
        if (z) {
            try {
                if (eventExecutor instanceof AbstractEventExecutor) {
                    ((AbstractEventExecutor) eventExecutor).lazyExecute(runnable);
                    return true;
                }
            } catch (Throwable th) {
                channelPromise.setFailure(th);
                throw th;
            }
        }
        eventExecutor.execute(runnable);
        return true;
    }

    private static boolean skipContext(AbstractChannelHandlerContext abstractChannelHandlerContext, EventExecutor eventExecutor, int i, int i2) {
        return ((i2 | i) & abstractChannelHandlerContext.executionMask) == 0 || (abstractChannelHandlerContext.executor() == eventExecutor && (abstractChannelHandlerContext.executionMask & i) == 0);
    }

    public ByteBufAllocator alloc() {
        return channel().config().getAllocator();
    }

    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        return channel().attr(attributeKey);
    }

    public ChannelFuture bind(SocketAddress socketAddress) {
        return bind(socketAddress, newPromise());
    }

    public final void callHandlerAdded() throws Exception {
        if (setAddComplete()) {
            handler().handlerAdded(this);
        }
    }

    public final void callHandlerRemoved() throws Exception {
        try {
            if (this.handlerState == 2) {
                handler().handlerRemoved(this);
            }
        } finally {
            setRemoved();
        }
    }

    public Channel channel() {
        return this.pipeline.channel();
    }

    public ChannelFuture close() {
        return close(newPromise());
    }

    public ChannelFuture connect(SocketAddress socketAddress) {
        return connect(socketAddress, newPromise());
    }

    public ChannelFuture deregister() {
        return deregister(newPromise());
    }

    public ChannelFuture disconnect() {
        return disconnect(newPromise());
    }

    public EventExecutor executor() {
        EventExecutor eventExecutor = this.executor;
        return eventExecutor == null ? channel().eventLoop() : eventExecutor;
    }

    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        return channel().hasAttr(attributeKey);
    }

    public void invokeWrite(Object obj, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            invokeWrite0(obj, channelPromise);
        } else {
            write(obj, channelPromise);
        }
    }

    public void invokeWriteAndFlush(Object obj, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            invokeWrite0(obj, channelPromise);
            invokeFlush0();
            return;
        }
        writeAndFlush(obj, channelPromise);
    }

    public boolean isRemoved() {
        return this.handlerState == 3;
    }

    public String name() {
        return this.name;
    }

    public ChannelFuture newFailedFuture(Throwable th) {
        return new FailedChannelFuture(channel(), executor(), th);
    }

    public ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(channel(), executor());
    }

    public ChannelPromise newPromise() {
        return new DefaultChannelPromise(channel(), executor());
    }

    public ChannelFuture newSucceededFuture() {
        ChannelFuture channelFuture = this.succeededFuture;
        if (channelFuture != null) {
            return channelFuture;
        }
        SucceededChannelFuture succeededChannelFuture = new SucceededChannelFuture(channel(), executor());
        this.succeededFuture = succeededChannelFuture;
        return succeededChannelFuture;
    }

    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    public final boolean setAddComplete() {
        int i;
        do {
            i = this.handlerState;
            if (i == 3) {
                return false;
            }
        } while (!HANDLER_STATE_UPDATER.compareAndSet(this, i, 2));
        return true;
    }

    public final void setAddPending() {
        HANDLER_STATE_UPDATER.compareAndSet(this, 0, 1);
    }

    public final void setRemoved() {
        this.handlerState = 3;
    }

    public String toHintString() {
        return '\'' + this.name + "' will handle the message from this point.";
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ChannelHandlerContext.class) + '(' + this.name + ", " + channel() + ')';
    }

    public ChannelPromise voidPromise() {
        return channel().voidPromise();
    }

    public ChannelFuture write(Object obj) {
        return write(obj, newPromise());
    }

    public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        write(obj, true, channelPromise);
        return channelPromise;
    }

    public ChannelFuture bind(final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(socketAddress, "localAddress");
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(512);
        EventExecutor executor2 = findContextOutbound.executor();
        if (executor2.inEventLoop()) {
            findContextOutbound.invokeBind(socketAddress, channelPromise);
        } else {
            safeExecute(executor2, new Runnable() {
                public void run() {
                    findContextOutbound.invokeBind(socketAddress, channelPromise);
                }
            }, channelPromise, (Object) null, false);
        }
        return channelPromise;
    }

    public ChannelFuture close(final ChannelPromise channelPromise) {
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(4096);
        EventExecutor executor2 = findContextOutbound.executor();
        if (executor2.inEventLoop()) {
            findContextOutbound.invokeClose(channelPromise);
        } else {
            safeExecute(executor2, new Runnable() {
                public void run() {
                    findContextOutbound.invokeClose(channelPromise);
                }
            }, channelPromise, (Object) null, false);
        }
        return channelPromise;
    }

    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return connect(socketAddress, socketAddress2, newPromise());
    }

    public ChannelFuture deregister(final ChannelPromise channelPromise) {
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(8192);
        EventExecutor executor2 = findContextOutbound.executor();
        if (executor2.inEventLoop()) {
            findContextOutbound.invokeDeregister(channelPromise);
        } else {
            safeExecute(executor2, new Runnable() {
                public void run() {
                    findContextOutbound.invokeDeregister(channelPromise);
                }
            }, channelPromise, (Object) null, false);
        }
        return channelPromise;
    }

    public ChannelFuture disconnect(final ChannelPromise channelPromise) {
        if (!channel().metadata().hasDisconnect()) {
            return close(channelPromise);
        }
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(2048);
        EventExecutor executor2 = findContextOutbound.executor();
        if (executor2.inEventLoop()) {
            findContextOutbound.invokeDisconnect(channelPromise);
        } else {
            safeExecute(executor2, new Runnable() {
                public void run() {
                    findContextOutbound.invokeDisconnect(channelPromise);
                }
            }, channelPromise, (Object) null, false);
        }
        return channelPromise;
    }

    public ChannelHandlerContext fireChannelActive() {
        invokeChannelActive(findContextInbound(8));
        return this;
    }

    public ChannelHandlerContext fireChannelInactive() {
        invokeChannelInactive(findContextInbound(16));
        return this;
    }

    public ChannelHandlerContext fireChannelRead(Object obj) {
        invokeChannelRead(findContextInbound(32), obj);
        return this;
    }

    public ChannelHandlerContext fireChannelReadComplete() {
        invokeChannelReadComplete(findContextInbound(64));
        return this;
    }

    public ChannelHandlerContext fireChannelRegistered() {
        invokeChannelRegistered(findContextInbound(2));
        return this;
    }

    public ChannelHandlerContext fireChannelUnregistered() {
        invokeChannelUnregistered(findContextInbound(4));
        return this;
    }

    public ChannelHandlerContext fireChannelWritabilityChanged() {
        invokeChannelWritabilityChanged(findContextInbound(256));
        return this;
    }

    public ChannelHandlerContext fireExceptionCaught(Throwable th) {
        invokeExceptionCaught(findContextInbound(1), th);
        return this;
    }

    public ChannelHandlerContext fireUserEventTriggered(Object obj) {
        invokeUserEventTriggered(findContextInbound(128), obj);
        return this;
    }

    public ChannelHandlerContext flush() {
        AbstractChannelHandlerContext findContextOutbound = findContextOutbound(65536);
        EventExecutor executor2 = findContextOutbound.executor();
        if (executor2.inEventLoop()) {
            findContextOutbound.invokeFlush();
        } else {
            Tasks tasks = findContextOutbound.invokeTasks;
            if (tasks == null) {
                tasks = new Tasks(findContextOutbound);
                findContextOutbound.invokeTasks = tasks;
            }
            safeExecute(executor2, tasks.invokeFlushTask, channel().voidPromise(), (Object) null, false);
        }
        return this;
    }

    public ChannelHandlerContext read() {
        AbstractChannelHandlerContext findContextOutbound = findContextOutbound(16384);
        EventExecutor executor2 = findContextOutbound.executor();
        if (executor2.inEventLoop()) {
            findContextOutbound.invokeRead();
        } else {
            Tasks tasks = findContextOutbound.invokeTasks;
            if (tasks == null) {
                tasks = new Tasks(findContextOutbound);
                findContextOutbound.invokeTasks = tasks;
            }
            executor2.execute(tasks.invokeReadTask);
        }
        return this;
    }

    public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        write(obj, false, channelPromise);
        return channelPromise;
    }

    public ChannelFuture writeAndFlush(Object obj) {
        return writeAndFlush(obj, newPromise());
    }

    private void write(Object obj, boolean z, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(obj, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        try {
            if (isNotValidPromise(channelPromise, true)) {
                ReferenceCountUtil.release(obj);
                return;
            }
            AbstractChannelHandlerContext findContextOutbound = findContextOutbound(z ? 98304 : 32768);
            Object obj2 = this.pipeline.touch(obj, findContextOutbound);
            EventExecutor executor2 = findContextOutbound.executor();
            if (!executor2.inEventLoop()) {
                WriteTask newInstance = WriteTask.newInstance(findContextOutbound, obj2, channelPromise, z);
                if (!safeExecute(executor2, newInstance, channelPromise, obj2, !z)) {
                    newInstance.cancel();
                }
            } else if (z) {
                findContextOutbound.invokeWriteAndFlush(obj2, channelPromise);
            } else {
                findContextOutbound.invokeWrite(obj2, channelPromise);
            }
        } catch (RuntimeException e) {
            ReferenceCountUtil.release(obj);
            throw e;
        }
    }

    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return connect(socketAddress, (SocketAddress) null, channelPromise);
    }

    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(socketAddress, "remoteAddress");
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext findContextOutbound = findContextOutbound(1024);
        EventExecutor executor2 = findContextOutbound.executor();
        if (executor2.inEventLoop()) {
            findContextOutbound.invokeConnect(socketAddress, socketAddress2, channelPromise);
        } else {
            final SocketAddress socketAddress3 = socketAddress;
            final SocketAddress socketAddress4 = socketAddress2;
            final ChannelPromise channelPromise2 = channelPromise;
            safeExecute(executor2, new Runnable() {
                public void run() {
                    findContextOutbound.invokeConnect(socketAddress3, socketAddress4, channelPromise2);
                }
            }, channelPromise, (Object) null, false);
        }
        return channelPromise;
    }

    /* access modifiers changed from: private */
    public void invokeChannelActive() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelActive(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelActive();
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelInactive() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelInactive(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelInactive();
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelRegistered() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelRegistered(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelRegistered();
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelUnregistered() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelUnregistered(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelUnregistered();
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelRead(Object obj) {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelRead(this, obj);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelRead(obj);
        }
    }

    /* access modifiers changed from: private */
    public void invokeUserEventTriggered(Object obj) {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).userEventTriggered(this, obj);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireUserEventTriggered(obj);
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelReadComplete() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelReadComplete(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelReadComplete();
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelWritabilityChanged() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelWritabilityChanged(this);
            } catch (Throwable th) {
                invokeExceptionCaught(th);
            }
        } else {
            fireChannelWritabilityChanged();
        }
    }

    /* access modifiers changed from: private */
    public void invokeExceptionCaught(Throwable th) {
        if (invokeHandler()) {
            try {
                handler().exceptionCaught(this, th);
            } catch (Throwable th2) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(th2), th);
                } else if (internalLogger.isWarnEnabled()) {
                    internalLogger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                }
            }
        } else {
            fireExceptionCaught(th);
        }
    }
}
