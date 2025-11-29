package io.netty.channel;

import com.honey.account.i.a;
import io.netty.channel.Channel;
import io.netty.channel.MessageSizeEstimator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultChannelPipeline implements ChannelPipeline {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicReferenceFieldUpdater<DefaultChannelPipeline, MessageSizeEstimator.Handle> ESTIMATOR;
    /* access modifiers changed from: private */
    public static final String HEAD_NAME = generateName0(HeadContext.class);
    /* access modifiers changed from: private */
    public static final String TAIL_NAME = generateName0(TailContext.class);
    static final InternalLogger logger;
    private static final FastThreadLocal<Map<Class<?>, String>> nameCaches = new FastThreadLocal<Map<Class<?>, String>>() {
        public Map<Class<?>, String> initialValue() {
            return new WeakHashMap();
        }
    };
    /* access modifiers changed from: private */
    public final Channel channel;
    private Map<EventExecutorGroup, EventExecutor> childExecutors;
    private volatile MessageSizeEstimator.Handle estimatorHandle;
    private boolean firstRegistration = true;
    final AbstractChannelHandlerContext head;
    private PendingHandlerCallback pendingHandlerCallbackHead;
    private boolean registered;
    private final ChannelFuture succeededFuture;
    final AbstractChannelHandlerContext tail;
    private final boolean touch = ResourceLeakDetector.isEnabled();
    private final VoidChannelPromise voidPromise;

    public final class HeadContext extends AbstractChannelHandlerContext implements ChannelOutboundHandler, ChannelInboundHandler {
        private final Channel.Unsafe unsafe;

        public HeadContext(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline, (EventExecutor) null, DefaultChannelPipeline.HEAD_NAME, HeadContext.class);
            this.unsafe = defaultChannelPipeline.channel().unsafe();
            setAddComplete();
        }

        private void readIfIsAutoRead() {
            if (DefaultChannelPipeline.this.channel.config().isAutoRead()) {
                DefaultChannelPipeline.this.channel.read();
            }
        }

        public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) {
            this.unsafe.bind(socketAddress, channelPromise);
        }

        public void channelActive(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.fireChannelActive();
            readIfIsAutoRead();
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.fireChannelInactive();
        }

        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            channelHandlerContext.fireChannelRead(obj);
        }

        public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.fireChannelReadComplete();
            readIfIsAutoRead();
        }

        public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
            DefaultChannelPipeline.this.invokeHandlerAddedIfNeeded();
            channelHandlerContext.fireChannelRegistered();
        }

        public void channelUnregistered(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.fireChannelUnregistered();
            if (!DefaultChannelPipeline.this.channel.isOpen()) {
                DefaultChannelPipeline.this.destroy();
            }
        }

        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.fireChannelWritabilityChanged();
        }

        public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.unsafe.close(channelPromise);
        }

        public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            this.unsafe.connect(socketAddress, socketAddress2, channelPromise);
        }

        public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.unsafe.deregister(channelPromise);
        }

        public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.unsafe.disconnect(channelPromise);
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            channelHandlerContext.fireExceptionCaught(th);
        }

        public void flush(ChannelHandlerContext channelHandlerContext) {
            this.unsafe.flush();
        }

        public ChannelHandler handler() {
            return this;
        }

        public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        }

        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        }

        public void read(ChannelHandlerContext channelHandlerContext) {
            this.unsafe.beginRead();
        }

        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
            channelHandlerContext.fireUserEventTriggered(obj);
        }

        public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
            this.unsafe.write(obj, channelPromise);
        }
    }

    public final class PendingHandlerAddedTask extends PendingHandlerCallback {
        public PendingHandlerAddedTask(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            super(abstractChannelHandlerContext);
        }

        public void execute() {
            EventExecutor executor = this.ctx.executor();
            if (executor.inEventLoop()) {
                DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
                return;
            }
            try {
                executor.execute(this);
            } catch (RejectedExecutionException e) {
                if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                    DefaultChannelPipeline.logger.warn("Can't invoke handlerAdded() as the EventExecutor {} rejected it, removing handler {}.", executor, this.ctx.name(), e);
                }
                DefaultChannelPipeline.this.atomicRemoveFromHandlerList(this.ctx);
                this.ctx.setRemoved();
            }
        }

        public void run() {
            DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
        }
    }

    public static abstract class PendingHandlerCallback implements Runnable {
        final AbstractChannelHandlerContext ctx;
        PendingHandlerCallback next;

        public PendingHandlerCallback(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            this.ctx = abstractChannelHandlerContext;
        }

        public abstract void execute();
    }

    public final class PendingHandlerRemovedTask extends PendingHandlerCallback {
        public PendingHandlerRemovedTask(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            super(abstractChannelHandlerContext);
        }

        public void execute() {
            EventExecutor executor = this.ctx.executor();
            if (executor.inEventLoop()) {
                DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
                return;
            }
            try {
                executor.execute(this);
            } catch (RejectedExecutionException e) {
                if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                    DefaultChannelPipeline.logger.warn("Can't invoke handlerRemoved() as the EventExecutor {} rejected it, removing handler {}.", executor, this.ctx.name(), e);
                }
                this.ctx.setRemoved();
            }
        }

        public void run() {
            DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
        }
    }

    public final class TailContext extends AbstractChannelHandlerContext implements ChannelInboundHandler {
        public TailContext(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline, (EventExecutor) null, DefaultChannelPipeline.TAIL_NAME, TailContext.class);
            setAddComplete();
        }

        public void channelActive(ChannelHandlerContext channelHandlerContext) {
            DefaultChannelPipeline.this.onUnhandledInboundChannelActive();
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) {
            DefaultChannelPipeline.this.onUnhandledInboundChannelInactive();
        }

        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            DefaultChannelPipeline.this.onUnhandledInboundMessage(channelHandlerContext, obj);
        }

        public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
            DefaultChannelPipeline.this.onUnhandledInboundChannelReadComplete();
        }

        public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        }

        public void channelUnregistered(ChannelHandlerContext channelHandlerContext) {
        }

        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
            DefaultChannelPipeline.this.onUnhandledChannelWritabilityChanged();
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            DefaultChannelPipeline.this.onUnhandledInboundException(th);
        }

        public ChannelHandler handler() {
            return this;
        }

        public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        }

        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        }

        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
            DefaultChannelPipeline.this.onUnhandledInboundUserEventTriggered(obj);
        }
    }

    static {
        Class<DefaultChannelPipeline> cls = DefaultChannelPipeline.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        ESTIMATOR = AtomicReferenceFieldUpdater.newUpdater(cls, MessageSizeEstimator.Handle.class, "estimatorHandle");
    }

    public DefaultChannelPipeline(Channel channel2) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel2, "channel");
        this.succeededFuture = new SucceededChannelFuture(channel2, (EventExecutor) null);
        this.voidPromise = new VoidChannelPromise(channel2, true);
        TailContext tailContext = new TailContext(this);
        this.tail = tailContext;
        HeadContext headContext = new HeadContext(this);
        this.head = headContext;
        headContext.next = tailContext;
        tailContext.prev = headContext;
    }

    private static void addAfter0(AbstractChannelHandlerContext abstractChannelHandlerContext, AbstractChannelHandlerContext abstractChannelHandlerContext2) {
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext.next;
        abstractChannelHandlerContext.next.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext2;
    }

    private static void addBefore0(AbstractChannelHandlerContext abstractChannelHandlerContext, AbstractChannelHandlerContext abstractChannelHandlerContext2) {
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext.prev;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext;
        abstractChannelHandlerContext.prev.next = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext2;
    }

    private void addFirst0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.head.next;
        abstractChannelHandlerContext.prev = this.head;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext2;
        this.head.next = abstractChannelHandlerContext;
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext;
    }

    private void addLast0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail.prev;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.next = this.tail;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext;
        this.tail.prev = abstractChannelHandlerContext;
    }

    /* access modifiers changed from: private */
    public synchronized void atomicRemoveFromHandlerList(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = abstractChannelHandlerContext.prev;
        AbstractChannelHandlerContext abstractChannelHandlerContext3 = abstractChannelHandlerContext.next;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext3;
        abstractChannelHandlerContext3.prev = abstractChannelHandlerContext2;
    }

    /* access modifiers changed from: private */
    public void callHandlerAdded0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        try {
            abstractChannelHandlerContext.callHandlerAdded();
        } catch (Throwable th) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("Failed to remove a handler: " + abstractChannelHandlerContext.name(), th);
            }
            fireExceptionCaught((Throwable) new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerAdded() has thrown an exception; also failed to remove.", th));
        }
    }

    private void callHandlerAddedForAllHandlers() {
        PendingHandlerCallback pendingHandlerCallback;
        synchronized (this) {
            this.registered = true;
            this.pendingHandlerCallbackHead = null;
        }
        for (pendingHandlerCallback = this.pendingHandlerCallbackHead; pendingHandlerCallback != null; pendingHandlerCallback = pendingHandlerCallback.next) {
            pendingHandlerCallback.execute();
        }
    }

    private void callHandlerAddedInEventLoop(final AbstractChannelHandlerContext abstractChannelHandlerContext, EventExecutor eventExecutor) {
        abstractChannelHandlerContext.setAddPending();
        eventExecutor.execute(new Runnable() {
            public void run() {
                DefaultChannelPipeline.this.callHandlerAdded0(abstractChannelHandlerContext);
            }
        });
    }

    private void callHandlerCallbackLater(AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z) {
        PendingHandlerCallback pendingHandlerAddedTask = z ? new PendingHandlerAddedTask(abstractChannelHandlerContext) : new PendingHandlerRemovedTask(abstractChannelHandlerContext);
        PendingHandlerCallback pendingHandlerCallback = this.pendingHandlerCallbackHead;
        if (pendingHandlerCallback == null) {
            this.pendingHandlerCallbackHead = pendingHandlerAddedTask;
            return;
        }
        while (true) {
            PendingHandlerCallback pendingHandlerCallback2 = pendingHandlerCallback.next;
            if (pendingHandlerCallback2 != null) {
                pendingHandlerCallback = pendingHandlerCallback2;
            } else {
                pendingHandlerCallback.next = pendingHandlerAddedTask;
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void callHandlerRemoved0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        try {
            abstractChannelHandlerContext.callHandlerRemoved();
        } catch (Throwable th) {
            fireExceptionCaught((Throwable) new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerRemoved() has thrown an exception.", th));
        }
    }

    private void checkDuplicateName(String str) {
        if (context0(str) != null) {
            throw new IllegalArgumentException("Duplicate handler name: " + str);
        }
    }

    private static void checkMultiplicity(ChannelHandler channelHandler) {
        if (channelHandler instanceof ChannelHandlerAdapter) {
            ChannelHandlerAdapter channelHandlerAdapter = (ChannelHandlerAdapter) channelHandler;
            if (channelHandlerAdapter.isSharable() || !channelHandlerAdapter.added) {
                channelHandlerAdapter.added = true;
                return;
            }
            throw new ChannelPipelineException(channelHandlerAdapter.getClass().getName() + " is not a @Sharable handler, so can't be added or removed multiple times.");
        }
    }

    private EventExecutor childExecutor(EventExecutorGroup eventExecutorGroup) {
        if (eventExecutorGroup == null) {
            return null;
        }
        Boolean bool = (Boolean) this.channel.config().getOption(ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP);
        if (bool != null && !bool.booleanValue()) {
            return eventExecutorGroup.next();
        }
        Map map = this.childExecutors;
        if (map == null) {
            map = new IdentityHashMap(4);
            this.childExecutors = map;
        }
        EventExecutor eventExecutor = (EventExecutor) map.get(eventExecutorGroup);
        if (eventExecutor != null) {
            return eventExecutor;
        }
        EventExecutor next = eventExecutorGroup.next();
        map.put(eventExecutorGroup, next);
        return next;
    }

    private AbstractChannelHandlerContext context0(String str) {
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != this.tail; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            if (abstractChannelHandlerContext.name().equals(str)) {
                return abstractChannelHandlerContext;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public synchronized void destroy() {
        destroyUp(this.head.next, false);
    }

    /* access modifiers changed from: private */
    public void destroyDown(Thread thread, final AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.head;
        while (abstractChannelHandlerContext != abstractChannelHandlerContext2) {
            EventExecutor executor = abstractChannelHandlerContext.executor();
            if (z || executor.inEventLoop(thread)) {
                atomicRemoveFromHandlerList(abstractChannelHandlerContext);
                callHandlerRemoved0(abstractChannelHandlerContext);
                abstractChannelHandlerContext = abstractChannelHandlerContext.prev;
                z = false;
            } else {
                executor.execute(new Runnable() {
                    public void run() {
                        DefaultChannelPipeline.this.destroyDown(Thread.currentThread(), abstractChannelHandlerContext, true);
                    }
                });
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void destroyUp(final AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z) {
        Thread currentThread = Thread.currentThread();
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail;
        while (abstractChannelHandlerContext != abstractChannelHandlerContext2) {
            EventExecutor executor = abstractChannelHandlerContext.executor();
            if (z || executor.inEventLoop(currentThread)) {
                abstractChannelHandlerContext = abstractChannelHandlerContext.next;
                z = false;
            } else {
                executor.execute(new Runnable() {
                    public void run() {
                        DefaultChannelPipeline.this.destroyUp(abstractChannelHandlerContext, true);
                    }
                });
                return;
            }
        }
        destroyDown(currentThread, abstractChannelHandlerContext2.prev, z);
    }

    private String filterName(String str, ChannelHandler channelHandler) {
        if (str == null) {
            return generateName(channelHandler);
        }
        checkDuplicateName(str);
        return str;
    }

    private String generateName(ChannelHandler channelHandler) {
        Map map = nameCaches.get();
        Class<?> cls = channelHandler.getClass();
        String str = (String) map.get(cls);
        if (str == null) {
            str = generateName0(cls);
            map.put(cls, str);
        }
        if (context0(str) != null) {
            int i = 1;
            String substring = str.substring(0, str.length() - 1);
            while (true) {
                str = substring + i;
                if (context0(str) == null) {
                    break;
                }
                i++;
            }
        }
        return str;
    }

    private static String generateName0(Class<?> cls) {
        return StringUtil.simpleClassName(cls) + "#0";
    }

    private AbstractChannelHandlerContext getContextOrDie(String str) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) context(str);
        if (abstractChannelHandlerContext != null) {
            return abstractChannelHandlerContext;
        }
        throw new NoSuchElementException(str);
    }

    private AbstractChannelHandlerContext newContext(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler) {
        return new DefaultChannelHandlerContext(this, childExecutor(eventExecutorGroup), str, channelHandler);
    }

    private static void replace0(AbstractChannelHandlerContext abstractChannelHandlerContext, AbstractChannelHandlerContext abstractChannelHandlerContext2) {
        AbstractChannelHandlerContext abstractChannelHandlerContext3 = abstractChannelHandlerContext.prev;
        AbstractChannelHandlerContext abstractChannelHandlerContext4 = abstractChannelHandlerContext.next;
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext3;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext4;
        abstractChannelHandlerContext3.next = abstractChannelHandlerContext2;
        abstractChannelHandlerContext4.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext2;
    }

    public final ChannelPipeline addAfter(String str, String str2, ChannelHandler channelHandler) {
        return addAfter((EventExecutorGroup) null, str, str2, channelHandler);
    }

    public final ChannelPipeline addBefore(String str, String str2, ChannelHandler channelHandler) {
        return addBefore((EventExecutorGroup) null, str, str2, channelHandler);
    }

    public final ChannelPipeline addFirst(String str, ChannelHandler channelHandler) {
        return addFirst((EventExecutorGroup) null, str, channelHandler);
    }

    public final ChannelPipeline addLast(String str, ChannelHandler channelHandler) {
        return addLast((EventExecutorGroup) null, str, channelHandler);
    }

    public final ChannelFuture bind(SocketAddress socketAddress) {
        return this.tail.bind(socketAddress);
    }

    public final Channel channel() {
        return this.channel;
    }

    public final ChannelFuture close() {
        return this.tail.close();
    }

    public final ChannelFuture connect(SocketAddress socketAddress) {
        return this.tail.connect(socketAddress);
    }

    public final ChannelHandlerContext context(String str) {
        return context0((String) ObjectUtil.checkNotNull(str, "name"));
    }

    public void decrementPendingOutboundBytes(long j) {
        ChannelOutboundBuffer outboundBuffer = this.channel.unsafe().outboundBuffer();
        if (outboundBuffer != null) {
            outboundBuffer.decrementPendingOutboundBytes(j);
        }
    }

    public final ChannelFuture deregister() {
        return this.tail.deregister();
    }

    public final ChannelFuture disconnect() {
        return this.tail.disconnect();
    }

    public final MessageSizeEstimator.Handle estimatorHandle() {
        MessageSizeEstimator.Handle handle = this.estimatorHandle;
        if (handle != null) {
            return handle;
        }
        MessageSizeEstimator.Handle newHandle = this.channel.config().getMessageSizeEstimator().newHandle();
        return !a.a(ESTIMATOR, this, (Object) null, newHandle) ? this.estimatorHandle : newHandle;
    }

    public final ChannelHandler first() {
        ChannelHandlerContext firstContext = firstContext();
        if (firstContext == null) {
            return null;
        }
        return firstContext.handler();
    }

    public final ChannelHandlerContext firstContext() {
        if (this.head.next == this.tail) {
            return null;
        }
        return this.head.next;
    }

    public final ChannelHandler get(String str) {
        ChannelHandlerContext context = context(str);
        if (context == null) {
            return null;
        }
        return context.handler();
    }

    public void incrementPendingOutboundBytes(long j) {
        ChannelOutboundBuffer outboundBuffer = this.channel.unsafe().outboundBuffer();
        if (outboundBuffer != null) {
            outboundBuffer.incrementPendingOutboundBytes(j);
        }
    }

    public final void invokeHandlerAddedIfNeeded() {
        if (this.firstRegistration) {
            this.firstRegistration = false;
            callHandlerAddedForAllHandlers();
        }
    }

    public final Iterator<Map.Entry<String, ChannelHandler>> iterator() {
        return toMap().entrySet().iterator();
    }

    public final ChannelHandler last() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.tail.prev;
        if (abstractChannelHandlerContext == this.head) {
            return null;
        }
        return abstractChannelHandlerContext.handler();
    }

    public final ChannelHandlerContext lastContext() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.tail.prev;
        if (abstractChannelHandlerContext == this.head) {
            return null;
        }
        return abstractChannelHandlerContext;
    }

    public final List<String> names() {
        ArrayList arrayList = new ArrayList();
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            arrayList.add(abstractChannelHandlerContext.name());
        }
        return arrayList;
    }

    public final ChannelFuture newFailedFuture(Throwable th) {
        return new FailedChannelFuture(this.channel, (EventExecutor) null, th);
    }

    public final ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(this.channel);
    }

    public final ChannelPromise newPromise() {
        return new DefaultChannelPromise(this.channel);
    }

    public final ChannelFuture newSucceededFuture() {
        return this.succeededFuture;
    }

    public void onUnhandledChannelWritabilityChanged() {
    }

    public void onUnhandledInboundChannelActive() {
    }

    public void onUnhandledInboundChannelInactive() {
    }

    public void onUnhandledInboundChannelReadComplete() {
    }

    public void onUnhandledInboundException(Throwable th) {
        try {
            logger.warn("An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.", th);
        } finally {
            ReferenceCountUtil.release(th);
        }
    }

    public void onUnhandledInboundMessage(Object obj) {
        try {
            logger.debug("Discarded inbound message {} that reached at the tail of the pipeline. Please check your pipeline configuration.", obj);
        } finally {
            ReferenceCountUtil.release(obj);
        }
    }

    public void onUnhandledInboundUserEventTriggered(Object obj) {
        ReferenceCountUtil.release(obj);
    }

    public final ChannelPipeline remove(ChannelHandler channelHandler) {
        remove(getContextOrDie(channelHandler));
        return this;
    }

    public final ChannelHandler removeFirst() {
        if (this.head.next != this.tail) {
            return remove(this.head.next).handler();
        }
        throw new NoSuchElementException();
    }

    public final <T extends ChannelHandler> T removeIfExists(String str) {
        return removeIfExists(context(str));
    }

    public final ChannelHandler removeLast() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next;
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail;
        if (abstractChannelHandlerContext != abstractChannelHandlerContext2) {
            return remove(abstractChannelHandlerContext2.prev).handler();
        }
        throw new NoSuchElementException();
    }

    public final ChannelPipeline replace(ChannelHandler channelHandler, String str, ChannelHandler channelHandler2) {
        replace(getContextOrDie(channelHandler), str, channelHandler2);
        return this;
    }

    public final Map<String, ChannelHandler> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != this.tail; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            linkedHashMap.put(abstractChannelHandlerContext.name(), abstractChannelHandlerContext.handler());
        }
        return linkedHashMap;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName((Object) this));
        sb.append('{');
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next;
        while (abstractChannelHandlerContext != this.tail) {
            sb.append('(');
            sb.append(abstractChannelHandlerContext.name());
            sb.append(" = ");
            sb.append(abstractChannelHandlerContext.handler().getClass().getName());
            sb.append(')');
            abstractChannelHandlerContext = abstractChannelHandlerContext.next;
            if (abstractChannelHandlerContext == this.tail) {
                break;
            }
            sb.append(", ");
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object touch(Object obj, AbstractChannelHandlerContext abstractChannelHandlerContext) {
        return this.touch ? ReferenceCountUtil.touch(obj, abstractChannelHandlerContext) : obj;
    }

    public final ChannelPromise voidPromise() {
        return this.voidPromise;
    }

    public final ChannelFuture write(Object obj) {
        return this.tail.write(obj);
    }

    public final ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        return this.tail.writeAndFlush(obj, channelPromise);
    }

    public final ChannelPipeline addAfter(EventExecutorGroup eventExecutorGroup, String str, String str2, ChannelHandler channelHandler) {
        synchronized (this) {
            try {
                checkMultiplicity(channelHandler);
                String filterName = filterName(str2, channelHandler);
                AbstractChannelHandlerContext contextOrDie = getContextOrDie(str);
                AbstractChannelHandlerContext newContext = newContext(eventExecutorGroup, filterName, channelHandler);
                addAfter0(contextOrDie, newContext);
                if (!this.registered) {
                    newContext.setAddPending();
                    callHandlerCallbackLater(newContext, true);
                    return this;
                }
                EventExecutor executor = newContext.executor();
                if (!executor.inEventLoop()) {
                    callHandlerAddedInEventLoop(newContext, executor);
                    return this;
                }
                callHandlerAdded0(newContext);
                return this;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final ChannelPipeline addBefore(EventExecutorGroup eventExecutorGroup, String str, String str2, ChannelHandler channelHandler) {
        synchronized (this) {
            try {
                checkMultiplicity(channelHandler);
                String filterName = filterName(str2, channelHandler);
                AbstractChannelHandlerContext contextOrDie = getContextOrDie(str);
                AbstractChannelHandlerContext newContext = newContext(eventExecutorGroup, filterName, channelHandler);
                addBefore0(contextOrDie, newContext);
                if (!this.registered) {
                    newContext.setAddPending();
                    callHandlerCallbackLater(newContext, true);
                    return this;
                }
                EventExecutor executor = newContext.executor();
                if (!executor.inEventLoop()) {
                    callHandlerAddedInEventLoop(newContext, executor);
                    return this;
                }
                callHandlerAdded0(newContext);
                return this;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final ChannelPipeline addFirst(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler) {
        synchronized (this) {
            try {
                checkMultiplicity(channelHandler);
                AbstractChannelHandlerContext newContext = newContext(eventExecutorGroup, filterName(str, channelHandler), channelHandler);
                addFirst0(newContext);
                if (!this.registered) {
                    newContext.setAddPending();
                    callHandlerCallbackLater(newContext, true);
                    return this;
                }
                EventExecutor executor = newContext.executor();
                if (!executor.inEventLoop()) {
                    callHandlerAddedInEventLoop(newContext, executor);
                    return this;
                }
                callHandlerAdded0(newContext);
                return this;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler) {
        synchronized (this) {
            try {
                checkMultiplicity(channelHandler);
                AbstractChannelHandlerContext newContext = newContext(eventExecutorGroup, filterName(str, channelHandler), channelHandler);
                addLast0(newContext);
                if (!this.registered) {
                    newContext.setAddPending();
                    callHandlerCallbackLater(newContext, true);
                    return this;
                }
                EventExecutor executor = newContext.executor();
                if (!executor.inEventLoop()) {
                    callHandlerAddedInEventLoop(newContext, executor);
                    return this;
                }
                callHandlerAdded0(newContext);
                return this;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.tail.bind(socketAddress, channelPromise);
    }

    public final ChannelFuture close(ChannelPromise channelPromise) {
        return this.tail.close(channelPromise);
    }

    public final ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return this.tail.connect(socketAddress, socketAddress2);
    }

    public final ChannelHandlerContext context(ChannelHandler channelHandler) {
        ObjectUtil.checkNotNull(channelHandler, "handler");
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            if (abstractChannelHandlerContext.handler() == channelHandler) {
                return abstractChannelHandlerContext;
            }
        }
        return null;
    }

    public final ChannelFuture deregister(ChannelPromise channelPromise) {
        return this.tail.deregister(channelPromise);
    }

    public final ChannelFuture disconnect(ChannelPromise channelPromise) {
        return this.tail.disconnect(channelPromise);
    }

    public final ChannelPipeline fireChannelActive() {
        AbstractChannelHandlerContext.invokeChannelActive(this.head);
        return this;
    }

    public final ChannelPipeline fireChannelInactive() {
        AbstractChannelHandlerContext.invokeChannelInactive(this.head);
        return this;
    }

    public final ChannelPipeline fireChannelRead(Object obj) {
        AbstractChannelHandlerContext.invokeChannelRead(this.head, obj);
        return this;
    }

    public final ChannelPipeline fireChannelReadComplete() {
        AbstractChannelHandlerContext.invokeChannelReadComplete(this.head);
        return this;
    }

    public final ChannelPipeline fireChannelRegistered() {
        AbstractChannelHandlerContext.invokeChannelRegistered(this.head);
        return this;
    }

    public final ChannelPipeline fireChannelUnregistered() {
        AbstractChannelHandlerContext.invokeChannelUnregistered(this.head);
        return this;
    }

    public final ChannelPipeline fireChannelWritabilityChanged() {
        AbstractChannelHandlerContext.invokeChannelWritabilityChanged(this.head);
        return this;
    }

    public final ChannelPipeline fireExceptionCaught(Throwable th) {
        AbstractChannelHandlerContext.invokeExceptionCaught(this.head, th);
        return this;
    }

    public final ChannelPipeline fireUserEventTriggered(Object obj) {
        AbstractChannelHandlerContext.invokeUserEventTriggered(this.head, obj);
        return this;
    }

    public final ChannelPipeline flush() {
        this.tail.flush();
        return this;
    }

    public final ChannelPipeline read() {
        this.tail.read();
        return this;
    }

    public final ChannelHandler remove(String str) {
        return remove(getContextOrDie(str)).handler();
    }

    public final <T extends ChannelHandler> T removeIfExists(Class<T> cls) {
        return removeIfExists(context((Class<? extends ChannelHandler>) cls));
    }

    public final ChannelHandler replace(String str, String str2, ChannelHandler channelHandler) {
        return replace(getContextOrDie(str), str2, channelHandler);
    }

    public final ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        return this.tail.write(obj, channelPromise);
    }

    public final ChannelFuture writeAndFlush(Object obj) {
        return this.tail.writeAndFlush(obj);
    }

    private AbstractChannelHandlerContext getContextOrDie(ChannelHandler channelHandler) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) context(channelHandler);
        if (abstractChannelHandlerContext != null) {
            return abstractChannelHandlerContext;
        }
        throw new NoSuchElementException(channelHandler.getClass().getName());
    }

    public final ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.tail.connect(socketAddress, channelPromise);
    }

    public final <T extends ChannelHandler> T get(Class<T> cls) {
        ChannelHandlerContext context = context((Class<? extends ChannelHandler>) cls);
        if (context == null) {
            return null;
        }
        return context.handler();
    }

    public final <T extends ChannelHandler> T remove(Class<T> cls) {
        return remove(getContextOrDie((Class<? extends ChannelHandler>) cls)).handler();
    }

    public final <T extends ChannelHandler> T removeIfExists(ChannelHandler channelHandler) {
        return removeIfExists(context(channelHandler));
    }

    public final <T extends ChannelHandler> T replace(Class<T> cls, String str, ChannelHandler channelHandler) {
        return replace(getContextOrDie((Class<? extends ChannelHandler>) cls), str, channelHandler);
    }

    private AbstractChannelHandlerContext remove(final AbstractChannelHandlerContext abstractChannelHandlerContext) {
        synchronized (this) {
            try {
                atomicRemoveFromHandlerList(abstractChannelHandlerContext);
                if (!this.registered) {
                    callHandlerCallbackLater(abstractChannelHandlerContext, false);
                    return abstractChannelHandlerContext;
                }
                EventExecutor executor = abstractChannelHandlerContext.executor();
                if (!executor.inEventLoop()) {
                    executor.execute(new Runnable() {
                        public void run() {
                            DefaultChannelPipeline.this.callHandlerRemoved0(abstractChannelHandlerContext);
                        }
                    });
                    return abstractChannelHandlerContext;
                }
                callHandlerRemoved0(abstractChannelHandlerContext);
                return abstractChannelHandlerContext;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private <T extends ChannelHandler> T removeIfExists(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext == null) {
            return null;
        }
        return remove((AbstractChannelHandlerContext) channelHandlerContext).handler();
    }

    private ChannelHandler replace(final AbstractChannelHandlerContext abstractChannelHandlerContext, String str, ChannelHandler channelHandler) {
        synchronized (this) {
            try {
                checkMultiplicity(channelHandler);
                if (str == null) {
                    str = generateName(channelHandler);
                } else if (!abstractChannelHandlerContext.name().equals(str)) {
                    checkDuplicateName(str);
                }
                final AbstractChannelHandlerContext newContext = newContext(abstractChannelHandlerContext.executor, str, channelHandler);
                replace0(abstractChannelHandlerContext, newContext);
                if (!this.registered) {
                    callHandlerCallbackLater(newContext, true);
                    callHandlerCallbackLater(abstractChannelHandlerContext, false);
                    ChannelHandler handler = abstractChannelHandlerContext.handler();
                    return handler;
                }
                EventExecutor executor = abstractChannelHandlerContext.executor();
                if (!executor.inEventLoop()) {
                    executor.execute(new Runnable() {
                        public void run() {
                            DefaultChannelPipeline.this.callHandlerAdded0(newContext);
                            DefaultChannelPipeline.this.callHandlerRemoved0(abstractChannelHandlerContext);
                        }
                    });
                    ChannelHandler handler2 = abstractChannelHandlerContext.handler();
                    return handler2;
                }
                callHandlerAdded0(newContext);
                callHandlerRemoved0(abstractChannelHandlerContext);
                return abstractChannelHandlerContext.handler();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        return this.tail.connect(socketAddress, socketAddress2, channelPromise);
    }

    public void onUnhandledInboundMessage(ChannelHandlerContext channelHandlerContext, Object obj) {
        onUnhandledInboundMessage(obj);
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("Discarded message pipeline : {}. Channel : {}.", channelHandlerContext.pipeline().names(), channelHandlerContext.channel());
        }
    }

    private AbstractChannelHandlerContext getContextOrDie(Class<? extends ChannelHandler> cls) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) context(cls);
        if (abstractChannelHandlerContext != null) {
            return abstractChannelHandlerContext;
        }
        throw new NoSuchElementException(cls.getName());
    }

    public final ChannelHandlerContext context(Class<? extends ChannelHandler> cls) {
        ObjectUtil.checkNotNull(cls, "handlerType");
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            if (cls.isAssignableFrom(abstractChannelHandlerContext.handler().getClass())) {
                return abstractChannelHandlerContext;
            }
        }
        return null;
    }

    public final ChannelPipeline addLast(ChannelHandler channelHandler) {
        return addLast((String) null, channelHandler);
    }

    public final ChannelPipeline addFirst(ChannelHandler channelHandler) {
        return addFirst((String) null, channelHandler);
    }

    public final ChannelPipeline addLast(ChannelHandler... channelHandlerArr) {
        return addLast((EventExecutorGroup) null, channelHandlerArr);
    }

    public final ChannelPipeline addFirst(ChannelHandler... channelHandlerArr) {
        return addFirst((EventExecutorGroup) null, channelHandlerArr);
    }

    public final ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup, ChannelHandler... channelHandlerArr) {
        ObjectUtil.checkNotNull(channelHandlerArr, "handlers");
        for (ChannelHandler channelHandler : channelHandlerArr) {
            if (channelHandler == null) {
                break;
            }
            addLast(eventExecutorGroup, (String) null, channelHandler);
        }
        return this;
    }

    public final ChannelPipeline addFirst(EventExecutorGroup eventExecutorGroup, ChannelHandler... channelHandlerArr) {
        ObjectUtil.checkNotNull(channelHandlerArr, "handlers");
        if (!(channelHandlerArr.length == 0 || channelHandlerArr[0] == null)) {
            int i = 1;
            while (i < channelHandlerArr.length && channelHandlerArr[i] != null) {
                i++;
            }
            for (int i2 = i - 1; i2 >= 0; i2--) {
                addFirst(eventExecutorGroup, (String) null, channelHandlerArr[i2]);
            }
        }
        return this;
    }
}
