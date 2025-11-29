package io.netty.channel.kqueue;

import com.here.posclient.UpdateOptions;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

final class KQueueEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int KQUEUE_WAKE_UP_IDENT = 0;
    private static final AtomicIntegerFieldUpdater<KQueueEventLoop> WAKEN_UP_UPDATER;
    private static final InternalLogger logger;
    private final boolean allowGrowing;
    private final KQueueEventArray changeList;
    private final IntObjectMap<AbstractKQueueChannel> channels = new IntObjectHashMap(4096);
    private final KQueueEventArray eventList;
    private volatile int ioRatio = 50;
    private final IovArray iovArray = new IovArray();
    private final FileDescriptor kqueueFd;
    private final IntSupplier selectNowSupplier = new IntSupplier() {
        public int get() throws Exception {
            return KQueueEventLoop.this.kqueueWaitNow();
        }
    };
    private final SelectStrategy selectStrategy;
    private volatile int wakenUp;

    static {
        Class<KQueueEventLoop> cls = KQueueEventLoop.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        WAKEN_UP_UPDATER = AtomicIntegerFieldUpdater.newUpdater(cls, "wakenUp");
        KQueue.ensureAvailability();
    }

    public KQueueEventLoop(EventLoopGroup eventLoopGroup, Executor executor, int i, SelectStrategy selectStrategy2, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory, EventLoopTaskQueueFactory eventLoopTaskQueueFactory2) {
        super(eventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory2), rejectedExecutionHandler);
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy2, "strategy");
        FileDescriptor newKQueue = Native.newKQueue();
        this.kqueueFd = newKQueue;
        if (i == 0) {
            this.allowGrowing = true;
            i = 4096;
        } else {
            this.allowGrowing = false;
        }
        this.changeList = new KQueueEventArray(i);
        this.eventList = new KQueueEventArray(i);
        int keventAddUserEvent = Native.keventAddUserEvent(newKQueue.intValue(), 0);
        if (keventAddUserEvent < 0) {
            cleanup();
            throw new IllegalStateException("kevent failed to add user event with errno: " + (-keventAddUserEvent));
        }
    }

    private void closeAll() {
        try {
            kqueueWaitNow();
        } catch (IOException unused) {
        }
        for (AbstractKQueueChannel abstractKQueueChannel : (AbstractKQueueChannel[]) this.channels.values().toArray(new AbstractKQueueChannel[0])) {
            abstractKQueueChannel.unsafe().close(abstractKQueueChannel.unsafe().voidPromise());
        }
    }

    private static void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException unused) {
        }
    }

    private int kqueueWait(boolean z) throws IOException {
        if (z && hasTasks()) {
            return kqueueWaitNow();
        }
        long delayNanos = delayNanos(System.nanoTime());
        int min = (int) Math.min(delayNanos / 1000000000, UpdateOptions.SOURCE_ANY);
        return kqueueWait(min, (int) Math.min(delayNanos - (((long) min) * 1000000000), UpdateOptions.SOURCE_ANY));
    }

    /* access modifiers changed from: private */
    public int kqueueWaitNow() throws IOException {
        return kqueueWait(0, 0);
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

    private void processReady(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short filter = this.eventList.filter(i2);
            short flags = this.eventList.flags(i2);
            int fd = this.eventList.fd(i2);
            if (filter != Native.EVFILT_USER && (Native.EV_ERROR & flags) == 0) {
                AbstractKQueueChannel abstractKQueueChannel = this.channels.get(fd);
                if (abstractKQueueChannel == null) {
                    logger.warn("events[{}]=[{}, {}] had no channel!", Integer.valueOf(i2), Integer.valueOf(this.eventList.fd(i2)), Short.valueOf(filter));
                } else {
                    AbstractKQueueChannel.AbstractKQueueUnsafe abstractKQueueUnsafe = (AbstractKQueueChannel.AbstractKQueueUnsafe) abstractKQueueChannel.unsafe();
                    if (filter == Native.EVFILT_WRITE) {
                        abstractKQueueUnsafe.writeReady();
                    } else if (filter == Native.EVFILT_READ) {
                        abstractKQueueUnsafe.readReady(this.eventList.data(i2));
                    } else if (filter == Native.EVFILT_SOCK && (this.eventList.fflags(i2) & Native.NOTE_RDHUP) != 0) {
                        abstractKQueueUnsafe.readEOF();
                    }
                    if ((Native.EV_EOF & flags) != 0) {
                        abstractKQueueUnsafe.readEOF();
                    }
                }
            }
        }
    }

    public void add(AbstractKQueueChannel abstractKQueueChannel) {
        AbstractKQueueChannel put = this.channels.put(abstractKQueueChannel.fd().intValue(), abstractKQueueChannel);
    }

    public IovArray cleanArray() {
        this.iovArray.clear();
        return this.iovArray;
    }

    public void cleanup() {
        try {
            this.kqueueFd.close();
        } catch (IOException e) {
            logger.warn("Failed to close the kqueue fd.", (Throwable) e);
        } catch (Throwable th) {
            this.changeList.free();
            this.eventList.free();
            throw th;
        }
        this.changeList.free();
        this.eventList.free();
    }

    public void evSet(AbstractKQueueChannel abstractKQueueChannel, short s, short s2, int i) {
        this.changeList.evSet(abstractKQueueChannel, s, s2, i);
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    public int registeredChannels() {
        return this.channels.size();
    }

    public Iterator<Channel> registeredChannelsIterator() {
        IntObjectMap<AbstractKQueueChannel> intObjectMap = this.channels;
        return intObjectMap.isEmpty() ? SingleThreadEventLoop.ChannelsReadOnlyIterator.empty() : new SingleThreadEventLoop.ChannelsReadOnlyIterator(intObjectMap.values());
    }

    public void remove(AbstractKQueueChannel abstractKQueueChannel) throws Exception {
        int intValue = abstractKQueueChannel.fd().intValue();
        AbstractKQueueChannel remove = this.channels.remove(intValue);
        if (remove != null && remove != abstractKQueueChannel) {
            this.channels.put(intValue, remove);
        } else if (abstractKQueueChannel.isOpen()) {
            abstractKQueueChannel.unregisterFilters();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        handleLoopException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c1, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c2, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r0 != -1) goto L_0x004e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[ExcHandler: all (r0v5 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:8:0x0017] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
        L_0x0000:
            io.netty.channel.SelectStrategy r0 = r7.selectStrategy     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            io.netty.util.IntSupplier r1 = r7.selectNowSupplier     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            boolean r2 = r7.hasTasks()     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            int r0 = r0.calculateStrategy(r1, r2)     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            r1 = -3
            r2 = 0
            if (r0 == r1) goto L_0x0031
            r1 = -2
            if (r0 == r1) goto L_0x0017
            r1 = -1
            if (r0 == r1) goto L_0x0031
            goto L_0x004e
        L_0x0017:
            boolean r0 = r7.isShuttingDown()     // Catch:{ Error -> 0x002a, all -> 0x0028 }
            if (r0 == 0) goto L_0x0000
            r7.closeAll()     // Catch:{ Error -> 0x002a, all -> 0x0028 }
            boolean r0 = r7.confirmShutdown()     // Catch:{ Error -> 0x002a, all -> 0x0028 }
            if (r0 == 0) goto L_0x0000
            goto L_0x00d5
        L_0x0028:
            r0 = move-exception
            goto L_0x002c
        L_0x002a:
            r7 = move-exception
            goto L_0x0030
        L_0x002c:
            handleLoopException(r0)
            goto L_0x0000
        L_0x0030:
            throw r7
        L_0x0031:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater<io.netty.channel.kqueue.KQueueEventLoop> r0 = WAKEN_UP_UPDATER     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            int r0 = r0.getAndSet(r7, r2)     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            r1 = 1
            if (r0 != r1) goto L_0x003c
            r0 = r1
            goto L_0x003d
        L_0x003c:
            r0 = r2
        L_0x003d:
            int r0 = r7.kqueueWait(r0)     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            int r3 = r7.wakenUp     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            if (r3 != r1) goto L_0x004e
            r7.wakeup()     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            goto L_0x004e
        L_0x0049:
            r0 = move-exception
            goto L_0x00ae
        L_0x004b:
            r0 = move-exception
            goto L_0x00c5
        L_0x004e:
            int r1 = r7.ioRatio     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            r3 = 100
            if (r1 != r3) goto L_0x0063
            if (r0 <= 0) goto L_0x005f
            r7.processReady(r0)     // Catch:{ all -> 0x005a }
            goto L_0x005f
        L_0x005a:
            r0 = move-exception
            r7.runAllTasks()     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            throw r0     // Catch:{ Error -> 0x004b, all -> 0x0049 }
        L_0x005f:
            r7.runAllTasks()     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            goto L_0x008b
        L_0x0063:
            long r3 = java.lang.System.nanoTime()     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            if (r0 <= 0) goto L_0x007d
            r7.processReady(r0)     // Catch:{ all -> 0x006d }
            goto L_0x007d
        L_0x006d:
            r0 = move-exception
            long r5 = java.lang.System.nanoTime()     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            long r5 = r5 - r3
            int r2 = 100 - r1
            long r2 = (long) r2     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            long r5 = r5 * r2
            long r1 = (long) r1     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            long r5 = r5 / r1
            r7.runAllTasks(r5)     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            throw r0     // Catch:{ Error -> 0x004b, all -> 0x0049 }
        L_0x007d:
            long r5 = java.lang.System.nanoTime()     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            long r5 = r5 - r3
            int r3 = 100 - r1
            long r3 = (long) r3     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            long r5 = r5 * r3
            long r3 = (long) r1     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            long r5 = r5 / r3
            r7.runAllTasks(r5)     // Catch:{ Error -> 0x004b, all -> 0x0049 }
        L_0x008b:
            boolean r1 = r7.allowGrowing     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            if (r1 == 0) goto L_0x009c
            io.netty.channel.kqueue.KQueueEventArray r1 = r7.eventList     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            int r1 = r1.capacity()     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            if (r0 != r1) goto L_0x009c
            io.netty.channel.kqueue.KQueueEventArray r0 = r7.eventList     // Catch:{ Error -> 0x004b, all -> 0x0049 }
            r0.realloc(r2)     // Catch:{ Error -> 0x004b, all -> 0x0049 }
        L_0x009c:
            boolean r0 = r7.isShuttingDown()     // Catch:{ Error -> 0x00ac, all -> 0x0028 }
            if (r0 == 0) goto L_0x0000
            r7.closeAll()     // Catch:{ Error -> 0x00ac, all -> 0x0028 }
            boolean r0 = r7.confirmShutdown()     // Catch:{ Error -> 0x00ac, all -> 0x0028 }
            if (r0 == 0) goto L_0x0000
            goto L_0x00d5
        L_0x00ac:
            r7 = move-exception
            throw r7
        L_0x00ae:
            handleLoopException(r0)     // Catch:{ all -> 0x00c3 }
            boolean r0 = r7.isShuttingDown()     // Catch:{ Error -> 0x00c1, all -> 0x0028 }
            if (r0 == 0) goto L_0x0000
            r7.closeAll()     // Catch:{ Error -> 0x00c1, all -> 0x0028 }
            boolean r0 = r7.confirmShutdown()     // Catch:{ Error -> 0x00c1, all -> 0x0028 }
            if (r0 == 0) goto L_0x0000
            goto L_0x00d5
        L_0x00c1:
            r7 = move-exception
            throw r7
        L_0x00c3:
            r0 = move-exception
            goto L_0x00c6
        L_0x00c5:
            throw r0     // Catch:{ all -> 0x00c3 }
        L_0x00c6:
            boolean r1 = r7.isShuttingDown()     // Catch:{ Error -> 0x00d8, all -> 0x00d6 }
            if (r1 == 0) goto L_0x00dd
            r7.closeAll()     // Catch:{ Error -> 0x00d8, all -> 0x00d6 }
            boolean r7 = r7.confirmShutdown()     // Catch:{ Error -> 0x00d8, all -> 0x00d6 }
            if (r7 == 0) goto L_0x00dd
        L_0x00d5:
            return
        L_0x00d6:
            r7 = move-exception
            goto L_0x00da
        L_0x00d8:
            r7 = move-exception
            goto L_0x00de
        L_0x00da:
            handleLoopException(r7)
        L_0x00dd:
            throw r0
        L_0x00de:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueEventLoop.run():void");
    }

    public void setIoRatio(int i) {
        if (i <= 0 || i > 100) {
            throw new IllegalArgumentException("ioRatio: " + i + " (expected: 0 < ioRatio <= 100)");
        }
        this.ioRatio = i;
    }

    public void wakeup(boolean z) {
        if (!z && WAKEN_UP_UPDATER.compareAndSet(this, 0, 1)) {
            wakeup();
        }
    }

    private void wakeup() {
        Native.keventTriggerUserEvent(this.kqueueFd.intValue(), 0);
    }

    public Queue<Runnable> newTaskQueue(int i) {
        return newTaskQueue0(i);
    }

    private int kqueueWait(int i, int i2) throws IOException {
        int keventWait = Native.keventWait(this.kqueueFd.intValue(), this.changeList, this.eventList, i, i2);
        this.changeList.clear();
        return keventWait;
    }
}
