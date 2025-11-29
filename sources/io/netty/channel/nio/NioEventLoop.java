package io.netty.channel.nio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.EventLoopException;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.util.IntSupplier;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReflectionUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public final class NioEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long AWAKE = -1;
    private static final int CLEANUP_INTERVAL = 256;
    private static final boolean DISABLE_KEY_SET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);
    private static final int MIN_PREMATURE_SELECTOR_RETURNS = 3;
    private static final long NONE = Long.MAX_VALUE;
    private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioEventLoop.class);
    private int cancelledKeys;
    private volatile int ioRatio = 50;
    private boolean needsToSelectAgain;
    private final AtomicLong nextWakeupNanos = new AtomicLong(-1);
    private final SelectorProvider provider;
    private final IntSupplier selectNowSupplier = new IntSupplier() {
        public int get() throws Exception {
            return NioEventLoop.this.selectNow();
        }
    };
    private final SelectStrategy selectStrategy;
    private SelectedSelectionKeySet selectedKeys;
    private Selector selector;
    private Selector unwrappedSelector;

    static {
        int i = 0;
        if (PlatformDependent.javaVersion() < 7 && SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
            try {
                AccessController.doPrivileged(new PrivilegedAction<Void>() {
                    public Void run() {
                        System.setProperty("sun.nio.ch.bugLevel", "");
                        return null;
                    }
                });
            } catch (SecurityException e) {
                logger.debug("Unable to get/set System Property: sun.nio.ch.bugLevel", (Throwable) e);
            }
        }
        int i2 = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 512);
        if (i2 >= 3) {
            i = i2;
        }
        SELECTOR_AUTO_REBUILD_THRESHOLD = i;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.noKeySetOptimization: {}", (Object) Boolean.valueOf(DISABLE_KEY_SET_OPTIMIZATION));
            internalLogger.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", (Object) Integer.valueOf(i));
        }
    }

    public NioEventLoop(NioEventLoopGroup nioEventLoopGroup, Executor executor, SelectorProvider selectorProvider, SelectStrategy selectStrategy2, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory, EventLoopTaskQueueFactory eventLoopTaskQueueFactory2) {
        super(nioEventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory2), rejectedExecutionHandler);
        this.provider = (SelectorProvider) ObjectUtil.checkNotNull(selectorProvider, "selectorProvider");
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy2, "selectStrategy");
        SelectorTuple openSelector = openSelector();
        this.selector = openSelector.selector;
        this.unwrappedSelector = openSelector.unwrappedSelector;
    }

    private void closeAll() {
        selectAgain();
        Set<SelectionKey> keys = this.selector.keys();
        ArrayList<AbstractNioChannel> arrayList = new ArrayList<>(keys.size());
        for (SelectionKey next : keys) {
            Object attachment = next.attachment();
            if (attachment instanceof AbstractNioChannel) {
                arrayList.add((AbstractNioChannel) attachment);
            } else {
                next.cancel();
                invokeChannelUnregistered((NioTask) attachment, next, (Throwable) null);
            }
        }
        for (AbstractNioChannel abstractNioChannel : arrayList) {
            abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
        }
    }

    private static void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException unused) {
        }
    }

    private static void invokeChannelUnregistered(NioTask<SelectableChannel> nioTask, SelectionKey selectionKey, Throwable th) {
        try {
            nioTask.channelUnregistered(selectionKey.channel(), th);
        } catch (Exception e) {
            logger.warn("Unexpected exception while running NioTask.channelUnregistered()", (Throwable) e);
        }
    }

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        if (eventLoopTaskQueueFactory == null) {
            return newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
        }
        return eventLoopTaskQueueFactory.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }

    private static Queue<Runnable> newTaskQueue0(int i) {
        return i == Integer.MAX_VALUE ? PlatformDependent.newMpscQueue() : PlatformDependent.newMpscQueue(i);
    }

    private SelectorTuple openSelector() {
        try {
            final AbstractSelector openSelector = this.provider.openSelector();
            if (DISABLE_KEY_SET_OPTIMIZATION) {
                return new SelectorTuple(openSelector);
            }
            Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() {
                public Object run() {
                    try {
                        return Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
                    } catch (Throwable th) {
                        return th;
                    }
                }
            });
            if (doPrivileged instanceof Class) {
                final Class cls = (Class) doPrivileged;
                if (cls.isAssignableFrom(openSelector.getClass())) {
                    final SelectedSelectionKeySet selectedSelectionKeySet = new SelectedSelectionKeySet();
                    Object doPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() {
                        public Object run() {
                            try {
                                Field declaredField = cls.getDeclaredField("selectedKeys");
                                Field declaredField2 = cls.getDeclaredField("publicSelectedKeys");
                                if (PlatformDependent.javaVersion() >= 9 && PlatformDependent.hasUnsafe()) {
                                    long objectFieldOffset = PlatformDependent.objectFieldOffset(declaredField);
                                    long objectFieldOffset2 = PlatformDependent.objectFieldOffset(declaredField2);
                                    if (!(objectFieldOffset == -1 || objectFieldOffset2 == -1)) {
                                        PlatformDependent.putObject(openSelector, objectFieldOffset, selectedSelectionKeySet);
                                        PlatformDependent.putObject(openSelector, objectFieldOffset2, selectedSelectionKeySet);
                                        return null;
                                    }
                                }
                                Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredField, true);
                                if (trySetAccessible != null) {
                                    return trySetAccessible;
                                }
                                Throwable trySetAccessible2 = ReflectionUtil.trySetAccessible(declaredField2, true);
                                if (trySetAccessible2 != null) {
                                    return trySetAccessible2;
                                }
                                declaredField.set(openSelector, selectedSelectionKeySet);
                                declaredField2.set(openSelector, selectedSelectionKeySet);
                                return null;
                            } catch (NoSuchFieldException e) {
                                e = e;
                                return e;
                            } catch (IllegalAccessException e2) {
                                e = e2;
                                return e;
                            }
                        }
                    });
                    if (doPrivileged2 instanceof Exception) {
                        this.selectedKeys = null;
                        logger.trace("failed to instrument a special java.util.Set into: {}", openSelector, (Exception) doPrivileged2);
                        return new SelectorTuple(openSelector);
                    }
                    this.selectedKeys = selectedSelectionKeySet;
                    logger.trace("instrumented a special java.util.Set into: {}", (Object) openSelector);
                    return new SelectorTuple(openSelector, new SelectedSelectionKeySetSelector(openSelector, selectedSelectionKeySet));
                }
            }
            if (doPrivileged instanceof Throwable) {
                logger.trace("failed to instrument a special java.util.Set into: {}", openSelector, (Throwable) doPrivileged);
            }
            return new SelectorTuple(openSelector);
        } catch (IOException e) {
            throw new ChannelException("failed to open a new selector", e);
        }
    }

    private void processSelectedKey(SelectionKey selectionKey, AbstractNioChannel abstractNioChannel) {
        AbstractNioChannel.NioUnsafe unsafe = abstractNioChannel.unsafe();
        if (!selectionKey.isValid()) {
            try {
                if (abstractNioChannel.eventLoop() == this) {
                    unsafe.close(unsafe.voidPromise());
                }
            } catch (Throwable unused) {
            }
        } else {
            try {
                int readyOps = selectionKey.readyOps();
                if ((readyOps & 8) != 0) {
                    selectionKey.interestOps(selectionKey.interestOps() & -9);
                    unsafe.finishConnect();
                }
                if ((readyOps & 4) != 0) {
                    abstractNioChannel.unsafe().forceFlush();
                }
                if ((readyOps & 17) != 0 || readyOps == 0) {
                    unsafe.read();
                }
            } catch (CancelledKeyException unused2) {
                unsafe.close(unsafe.voidPromise());
            }
        }
    }

    private void processSelectedKeys() {
        if (this.selectedKeys != null) {
            processSelectedKeysOptimized();
        } else {
            processSelectedKeysPlain(this.selector.selectedKeys());
        }
    }

    private void processSelectedKeysOptimized() {
        int i = 0;
        while (true) {
            SelectedSelectionKeySet selectedSelectionKeySet = this.selectedKeys;
            if (i < selectedSelectionKeySet.size) {
                SelectionKey[] selectionKeyArr = selectedSelectionKeySet.keys;
                SelectionKey selectionKey = selectionKeyArr[i];
                selectionKeyArr[i] = null;
                Object attachment = selectionKey.attachment();
                if (attachment instanceof AbstractNioChannel) {
                    processSelectedKey(selectionKey, (AbstractNioChannel) attachment);
                } else {
                    processSelectedKey(selectionKey, (NioTask<SelectableChannel>) (NioTask) attachment);
                }
                if (this.needsToSelectAgain) {
                    this.selectedKeys.reset(i + 1);
                    selectAgain();
                    i = -1;
                }
                i++;
            } else {
                return;
            }
        }
    }

    private void processSelectedKeysPlain(Set<SelectionKey> set) {
        if (!set.isEmpty()) {
            Iterator<SelectionKey> it = set.iterator();
            while (true) {
                SelectionKey next = it.next();
                Object attachment = next.attachment();
                it.remove();
                if (attachment instanceof AbstractNioChannel) {
                    processSelectedKey(next, (AbstractNioChannel) attachment);
                } else {
                    processSelectedKey(next, (NioTask<SelectableChannel>) (NioTask) attachment);
                }
                if (it.hasNext()) {
                    if (this.needsToSelectAgain) {
                        selectAgain();
                        Set<SelectionKey> selectedKeys2 = this.selector.selectedKeys();
                        if (!selectedKeys2.isEmpty()) {
                            it = selectedKeys2.iterator();
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void rebuildSelector0() {
        Selector selector2 = this.selector;
        if (selector2 != null) {
            try {
                SelectorTuple openSelector = openSelector();
                int i = 0;
                for (SelectionKey next : selector2.keys()) {
                    Object attachment = next.attachment();
                    try {
                        if (next.isValid()) {
                            if (next.channel().keyFor(openSelector.unwrappedSelector) == null) {
                                int interestOps = next.interestOps();
                                next.cancel();
                                SelectionKey register = next.channel().register(openSelector.unwrappedSelector, interestOps, attachment);
                                if (attachment instanceof AbstractNioChannel) {
                                    ((AbstractNioChannel) attachment).selectionKey = register;
                                }
                                i++;
                            }
                        }
                    } catch (Exception e) {
                        logger.warn("Failed to re-register a Channel to the new Selector.", (Throwable) e);
                        if (attachment instanceof AbstractNioChannel) {
                            AbstractNioChannel abstractNioChannel = (AbstractNioChannel) attachment;
                            abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
                        } else {
                            invokeChannelUnregistered((NioTask) attachment, next, e);
                        }
                    }
                }
                this.selector = openSelector.selector;
                this.unwrappedSelector = openSelector.unwrappedSelector;
                try {
                    selector2.close();
                } catch (Throwable th) {
                    if (logger.isWarnEnabled()) {
                        logger.warn("Failed to close the old Selector.", th);
                    }
                }
                InternalLogger internalLogger = logger;
                if (internalLogger.isInfoEnabled()) {
                    internalLogger.info("Migrated " + i + " channel(s) to the new Selector.");
                }
            } catch (Exception e2) {
                logger.warn("Failed to create a new Selector.", (Throwable) e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void register0(SelectableChannel selectableChannel, int i, NioTask<?> nioTask) {
        try {
            selectableChannel.register(this.unwrappedSelector, i, nioTask);
        } catch (Exception e) {
            throw new EventLoopException("failed to register a channel", e);
        }
    }

    private int select(long j) throws IOException {
        if (j == Long.MAX_VALUE) {
            return this.selector.select();
        }
        long deadlineToDelayNanos = AbstractScheduledEventExecutor.deadlineToDelayNanos(j + 995000) / 1000000;
        int i = (deadlineToDelayNanos > 0 ? 1 : (deadlineToDelayNanos == 0 ? 0 : -1));
        Selector selector2 = this.selector;
        return i <= 0 ? selector2.selectNow() : selector2.select(deadlineToDelayNanos);
    }

    private void selectAgain() {
        this.needsToSelectAgain = false;
        try {
            this.selector.selectNow();
        } catch (Throwable th) {
            logger.warn("Failed to update SelectionKeys.", th);
        }
    }

    private boolean unexpectedSelectorWakeup(int i) {
        if (Thread.interrupted()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop.");
            }
            return true;
        }
        int i2 = SELECTOR_AUTO_REBUILD_THRESHOLD;
        if (i2 <= 0 || i < i2) {
            return false;
        }
        logger.warn("Selector.select() returned prematurely {} times in a row; rebuilding Selector {}.", Integer.valueOf(i), this.selector);
        rebuildSelector();
        return true;
    }

    public boolean afterScheduledTaskSubmitted(long j) {
        return j < this.nextWakeupNanos.get();
    }

    public boolean beforeScheduledTaskSubmitted(long j) {
        return j < this.nextWakeupNanos.get();
    }

    public void cancel(SelectionKey selectionKey) {
        selectionKey.cancel();
        int i = this.cancelledKeys + 1;
        this.cancelledKeys = i;
        if (i >= 256) {
            this.cancelledKeys = 0;
            this.needsToSelectAgain = true;
        }
    }

    public void cleanup() {
        try {
            this.selector.close();
        } catch (IOException e) {
            logger.warn("Failed to close a selector.", (Throwable) e);
        }
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    public void rebuildSelector() {
        if (!inEventLoop()) {
            execute(new Runnable() {
                public void run() {
                    NioEventLoop.this.rebuildSelector0();
                }
            });
        } else {
            rebuildSelector0();
        }
    }

    public void register(final SelectableChannel selectableChannel, final int i, final NioTask<?> nioTask) {
        ObjectUtil.checkNotNull(selectableChannel, "ch");
        if (i == 0) {
            throw new IllegalArgumentException("interestOps must be non-zero.");
        } else if (((~selectableChannel.validOps()) & i) == 0) {
            ObjectUtil.checkNotNull(nioTask, "task");
            if (isShutdown()) {
                throw new IllegalStateException("event loop shut down");
            } else if (inEventLoop()) {
                register0(selectableChannel, i, nioTask);
            } else {
                try {
                    submit((Runnable) new Runnable() {
                        public void run() {
                            NioEventLoop.this.register0(selectableChannel, i, nioTask);
                        }
                    }).sync();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            throw new IllegalArgumentException("invalid interestOps: " + i + "(validOps: " + selectableChannel.validOps() + ')');
        }
    }

    public int registeredChannels() {
        return this.selector.keys().size() - this.cancelledKeys;
    }

    public Iterator<Channel> registeredChannelsIterator() {
        Set<SelectionKey> keys = this.selector.keys();
        return keys.isEmpty() ? SingleThreadEventLoop.ChannelsReadOnlyIterator.empty() : new Iterator<Channel>(keys) {
            boolean isDone;
            Channel next;
            final Iterator<SelectionKey> selectionKeyIterator;
            final /* synthetic */ Set val$keys;

            {
                this.val$keys = r2;
                this.selectionKeyIterator = ((Set) ObjectUtil.checkNotNull(r2, "selectionKeys")).iterator();
            }

            private Channel nextOrDone() {
                Iterator<SelectionKey> it = this.selectionKeyIterator;
                while (it.hasNext()) {
                    SelectionKey next2 = it.next();
                    if (next2.isValid()) {
                        Object attachment = next2.attachment();
                        if (attachment instanceof AbstractNioChannel) {
                            return (AbstractNioChannel) attachment;
                        }
                    }
                }
                this.isDone = true;
                return null;
            }

            public boolean hasNext() {
                if (this.isDone) {
                    return false;
                }
                if (this.next != null) {
                    return true;
                }
                Channel nextOrDone = nextOrDone();
                this.next = nextOrDone;
                return nextOrDone != null;
            }

            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            public Channel next() {
                if (!this.isDone) {
                    Channel channel = this.next;
                    if (channel == null && (channel = nextOrDone()) == null) {
                        throw new NoSuchElementException();
                    }
                    this.next = nextOrDone();
                    return channel;
                }
                throw new NoSuchElementException();
            }
        };
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x012a, code lost:
        closeAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0131, code lost:
        if (confirmShutdown() != false) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0133, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0143, code lost:
        r2.debug(java.nio.channels.CancelledKeyException.class.getSimpleName() + " raised by a Selector {} - JDK bug?", r9.selector, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0165, code lost:
        closeAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x016c, code lost:
        if (confirmShutdown() != false) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x016e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        runAllTasks();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006f, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0072, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0075, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0096, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0097, code lost:
        runAllTasks(((java.lang.System.nanoTime() - r5) * ((long) (100 - r4))) / ((long) r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a5, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b5, code lost:
        if (unexpectedSelectorWakeup(r3) != false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00eb, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00ec, code lost:
        r3 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00ef, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00f0, code lost:
        r3 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r2 != -1) goto L_0x0058;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x012a A[Catch:{ Error -> 0x0136, all -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0143 A[Catch:{ CancelledKeyException -> 0x011e, Error -> 0x0072, all -> 0x011b, all -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0165 A[Catch:{ Error -> 0x0172, all -> 0x016f }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0072 A[Catch:{ all -> 0x0096, all -> 0x006a, CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }, ExcHandler: Error (r0v2 'e' java.lang.Error A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:33:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            io.netty.channel.SelectStrategy r2 = r9.selectStrategy     // Catch:{ IOException -> 0x00f3 }
            io.netty.util.IntSupplier r3 = r9.selectNowSupplier     // Catch:{ IOException -> 0x00f3 }
            boolean r4 = r9.hasTasks()     // Catch:{ IOException -> 0x00f3 }
            int r2 = r2.calculateStrategy(r3, r4)     // Catch:{ IOException -> 0x00f3 }
            r3 = -3
            if (r2 == r3) goto L_0x0031
            r3 = -2
            if (r2 == r3) goto L_0x0018
            r3 = -1
            if (r2 == r3) goto L_0x0031
            goto L_0x0058
        L_0x0018:
            boolean r2 = r9.isShuttingDown()     // Catch:{ Error -> 0x002a, all -> 0x0028 }
            if (r2 == 0) goto L_0x0002
            r9.closeAll()     // Catch:{ Error -> 0x002a, all -> 0x0028 }
            boolean r2 = r9.confirmShutdown()     // Catch:{ Error -> 0x002a, all -> 0x0028 }
            if (r2 == 0) goto L_0x0002
            return
        L_0x0028:
            r2 = move-exception
            goto L_0x002c
        L_0x002a:
            r9 = move-exception
            goto L_0x0030
        L_0x002c:
            handleLoopException(r2)
            goto L_0x0002
        L_0x0030:
            throw r9
        L_0x0031:
            long r3 = r9.nextScheduledTaskDeadlineNanos()     // Catch:{ IOException -> 0x00f3 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0040
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0040:
            java.util.concurrent.atomic.AtomicLong r7 = r9.nextWakeupNanos     // Catch:{ IOException -> 0x00f3 }
            r7.set(r3)     // Catch:{ IOException -> 0x00f3 }
            boolean r7 = r9.hasTasks()     // Catch:{ all -> 0x0050 }
            if (r7 != 0) goto L_0x0053
            int r2 = r9.select(r3)     // Catch:{ all -> 0x0050 }
            goto L_0x0053
        L_0x0050:
            r2 = move-exception
            goto L_0x00f5
        L_0x0053:
            java.util.concurrent.atomic.AtomicLong r3 = r9.nextWakeupNanos     // Catch:{ IOException -> 0x00f3 }
            r3.lazySet(r5)     // Catch:{ IOException -> 0x00f3 }
        L_0x0058:
            int r3 = r1 + 1
            r9.cancelledKeys = r0     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            r9.needsToSelectAgain = r0     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            int r4 = r9.ioRatio     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            r5 = 100
            if (r4 != r5) goto L_0x007d
            if (r2 <= 0) goto L_0x0078
            r9.processSelectedKeys()     // Catch:{ all -> 0x006a }
            goto L_0x0078
        L_0x006a:
            r1 = move-exception
            r9.runAllTasks()     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            throw r1     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
        L_0x006f:
            r1 = move-exception
            goto L_0x0121
        L_0x0072:
            r0 = move-exception
            goto L_0x013a
        L_0x0075:
            r1 = move-exception
            goto L_0x013b
        L_0x0078:
            boolean r4 = r9.runAllTasks()     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            goto L_0x00ac
        L_0x007d:
            if (r2 <= 0) goto L_0x00a6
            long r5 = java.lang.System.nanoTime()     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            r9.processSelectedKeys()     // Catch:{ all -> 0x0096 }
            long r7 = java.lang.System.nanoTime()     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            long r7 = r7 - r5
            int r5 = 100 - r4
            long r5 = (long) r5     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            long r7 = r7 * r5
            long r4 = (long) r4     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            long r7 = r7 / r4
            boolean r4 = r9.runAllTasks(r7)     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            goto L_0x00ac
        L_0x0096:
            r1 = move-exception
            long r7 = java.lang.System.nanoTime()     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            long r7 = r7 - r5
            int r2 = 100 - r4
            long r5 = (long) r2     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            long r7 = r7 * r5
            long r4 = (long) r4     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            long r7 = r7 / r4
            r9.runAllTasks(r7)     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            throw r1     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
        L_0x00a6:
            r4 = 0
            boolean r4 = r9.runAllTasks(r4)     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
        L_0x00ac:
            if (r4 != 0) goto L_0x00b9
            if (r2 <= 0) goto L_0x00b1
            goto L_0x00b9
        L_0x00b1:
            boolean r1 = r9.unexpectedSelectorWakeup(r3)     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            if (r1 == 0) goto L_0x00d0
        L_0x00b7:
            r3 = r0
            goto L_0x00d0
        L_0x00b9:
            r2 = 3
            if (r3 <= r2) goto L_0x00b7
            io.netty.util.internal.logging.InternalLogger r2 = logger     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            boolean r4 = r2.isDebugEnabled()     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            if (r4 == 0) goto L_0x00b7
            java.lang.String r4 = "Selector.select() returned prematurely {} times in a row for Selector {}."
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            java.nio.channels.Selector r5 = r9.selector     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            r2.debug(r4, r1, r5)     // Catch:{ CancelledKeyException -> 0x0075, Error -> 0x0072, all -> 0x006f }
            goto L_0x00b7
        L_0x00d0:
            boolean r1 = r9.isShuttingDown()     // Catch:{ Error -> 0x00e2, all -> 0x00e0 }
            if (r1 == 0) goto L_0x00e7
            r9.closeAll()     // Catch:{ Error -> 0x00e2, all -> 0x00e0 }
            boolean r1 = r9.confirmShutdown()     // Catch:{ Error -> 0x00e2, all -> 0x00e0 }
            if (r1 == 0) goto L_0x00e7
            return
        L_0x00e0:
            r1 = move-exception
            goto L_0x00e4
        L_0x00e2:
            r9 = move-exception
            goto L_0x00ea
        L_0x00e4:
            handleLoopException(r1)
        L_0x00e7:
            r1 = r3
            goto L_0x0002
        L_0x00ea:
            throw r9
        L_0x00eb:
            r2 = move-exception
            r3 = r1
            r1 = r2
            goto L_0x0121
        L_0x00ef:
            r2 = move-exception
            r3 = r1
            r1 = r2
            goto L_0x013b
        L_0x00f3:
            r2 = move-exception
            goto L_0x00fb
        L_0x00f5:
            java.util.concurrent.atomic.AtomicLong r3 = r9.nextWakeupNanos     // Catch:{ IOException -> 0x00f3 }
            r3.lazySet(r5)     // Catch:{ IOException -> 0x00f3 }
            throw r2     // Catch:{ IOException -> 0x00f3 }
        L_0x00fb:
            r9.rebuildSelector0()     // Catch:{ CancelledKeyException -> 0x00ef, Error -> 0x0072, all -> 0x00eb }
            handleLoopException(r2)     // Catch:{ CancelledKeyException -> 0x011e, Error -> 0x0072, all -> 0x011b }
            boolean r1 = r9.isShuttingDown()     // Catch:{ Error -> 0x0113, all -> 0x0111 }
            if (r1 == 0) goto L_0x0001
            r9.closeAll()     // Catch:{ Error -> 0x0113, all -> 0x0111 }
            boolean r1 = r9.confirmShutdown()     // Catch:{ Error -> 0x0113, all -> 0x0111 }
            if (r1 == 0) goto L_0x0001
            return
        L_0x0111:
            r1 = move-exception
            goto L_0x0115
        L_0x0113:
            r9 = move-exception
            goto L_0x011a
        L_0x0115:
            handleLoopException(r1)
            goto L_0x0001
        L_0x011a:
            throw r9
        L_0x011b:
            r1 = move-exception
            r3 = r0
            goto L_0x0121
        L_0x011e:
            r1 = move-exception
            r3 = r0
            goto L_0x013b
        L_0x0121:
            handleLoopException(r1)     // Catch:{ all -> 0x0138 }
            boolean r1 = r9.isShuttingDown()     // Catch:{ Error -> 0x0136, all -> 0x0134 }
            if (r1 == 0) goto L_0x00e7
            r9.closeAll()     // Catch:{ Error -> 0x0136, all -> 0x0134 }
            boolean r1 = r9.confirmShutdown()     // Catch:{ Error -> 0x0136, all -> 0x0134 }
            if (r1 == 0) goto L_0x00e7
            return
        L_0x0134:
            r1 = move-exception
            goto L_0x00e4
        L_0x0136:
            r9 = move-exception
            throw r9
        L_0x0138:
            r0 = move-exception
            goto L_0x0174
        L_0x013a:
            throw r0     // Catch:{ all -> 0x0138 }
        L_0x013b:
            io.netty.util.internal.logging.InternalLogger r2 = logger     // Catch:{ all -> 0x0138 }
            boolean r4 = r2.isDebugEnabled()     // Catch:{ all -> 0x0138 }
            if (r4 == 0) goto L_0x015f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0138 }
            r4.<init>()     // Catch:{ all -> 0x0138 }
            java.lang.Class<java.nio.channels.CancelledKeyException> r5 = java.nio.channels.CancelledKeyException.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0138 }
            r4.append(r5)     // Catch:{ all -> 0x0138 }
            java.lang.String r5 = " raised by a Selector {} - JDK bug?"
            r4.append(r5)     // Catch:{ all -> 0x0138 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0138 }
            java.nio.channels.Selector r5 = r9.selector     // Catch:{ all -> 0x0138 }
            r2.debug(r4, r5, r1)     // Catch:{ all -> 0x0138 }
        L_0x015f:
            boolean r1 = r9.isShuttingDown()     // Catch:{ Error -> 0x0172, all -> 0x016f }
            if (r1 == 0) goto L_0x00e7
            r9.closeAll()     // Catch:{ Error -> 0x0172, all -> 0x016f }
            boolean r1 = r9.confirmShutdown()     // Catch:{ Error -> 0x0172, all -> 0x016f }
            if (r1 == 0) goto L_0x00e7
            return
        L_0x016f:
            r1 = move-exception
            goto L_0x00e4
        L_0x0172:
            r9 = move-exception
            throw r9
        L_0x0174:
            boolean r1 = r9.isShuttingDown()     // Catch:{ Error -> 0x0186, all -> 0x0184 }
            if (r1 == 0) goto L_0x018b
            r9.closeAll()     // Catch:{ Error -> 0x0186, all -> 0x0184 }
            boolean r9 = r9.confirmShutdown()     // Catch:{ Error -> 0x0186, all -> 0x0184 }
            if (r9 == 0) goto L_0x018b
            return
        L_0x0184:
            r9 = move-exception
            goto L_0x0188
        L_0x0186:
            r9 = move-exception
            goto L_0x018c
        L_0x0188:
            handleLoopException(r9)
        L_0x018b:
            throw r0
        L_0x018c:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.NioEventLoop.run():void");
    }

    public int selectNow() throws IOException {
        return this.selector.selectNow();
    }

    public SelectorProvider selectorProvider() {
        return this.provider;
    }

    public void setIoRatio(int i) {
        if (i <= 0 || i > 100) {
            throw new IllegalArgumentException("ioRatio: " + i + " (expected: 0 < ioRatio <= 100)");
        }
        this.ioRatio = i;
    }

    public Selector unwrappedSelector() {
        return this.unwrappedSelector;
    }

    public void wakeup(boolean z) {
        if (!z && this.nextWakeupNanos.getAndSet(-1) != -1) {
            this.selector.wakeup();
        }
    }

    public static final class SelectorTuple {
        final Selector selector;
        final Selector unwrappedSelector;

        public SelectorTuple(Selector selector2) {
            this.unwrappedSelector = selector2;
            this.selector = selector2;
        }

        public SelectorTuple(Selector selector2, Selector selector3) {
            this.unwrappedSelector = selector2;
            this.selector = selector3;
        }
    }

    public Queue<Runnable> newTaskQueue(int i) {
        return newTaskQueue0(i);
    }

    private static void processSelectedKey(SelectionKey selectionKey, NioTask<SelectableChannel> nioTask) {
        try {
            nioTask.channelReady(selectionKey.channel(), selectionKey);
            if (!selectionKey.isValid()) {
                invokeChannelUnregistered(nioTask, selectionKey, (Throwable) null);
            }
        } catch (Exception e) {
            selectionKey.cancel();
            invokeChannelUnregistered(nioTask, selectionKey, e);
        } catch (Throwable th) {
            selectionKey.cancel();
            invokeChannelUnregistered(nioTask, selectionKey, (Throwable) null);
            throw th;
        }
    }
}
