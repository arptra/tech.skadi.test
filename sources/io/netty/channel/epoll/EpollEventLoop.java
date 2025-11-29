package io.netty.channel.epoll;

import com.here.posclient.UpdateOptions;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

class EpollEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long AWAKE = -1;
    private static final long EPOLL_WAIT_MILLIS_THRESHOLD = SystemPropertyUtil.getLong("io.netty.channel.epoll.epollWaitThreshold", 10);
    private static final long MAX_SCHEDULED_TIMERFD_NS = 999999999;
    private static final long NONE = Long.MAX_VALUE;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) EpollEventLoop.class);
    private final boolean allowGrowing;
    private final IntObjectMap<AbstractEpollChannel> channels = new IntObjectHashMap(4096);
    private NativeDatagramPacketArray datagramPacketArray;
    private final FileDescriptor epollFd;
    private final FileDescriptor eventFd;
    private final EpollEventArray events;
    private volatile int ioRatio = 50;
    private IovArray iovArray;
    private final AtomicLong nextWakeupNanos = new AtomicLong(-1);
    private boolean pendingWakeup;
    private final IntSupplier selectNowSupplier = new IntSupplier() {
        public int get() throws Exception {
            return EpollEventLoop.this.epollWaitNow();
        }
    };
    private final SelectStrategy selectStrategy;
    private final FileDescriptor timerFd;

    static {
        Epoll.ensureAvailability();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a2 A[SYNTHETIC, Splitter:B:32:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A[SYNTHETIC, Splitter:B:36:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac A[SYNTHETIC, Splitter:B:40:0x00ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EpollEventLoop(io.netty.channel.EventLoopGroup r9, java.util.concurrent.Executor r10, int r11, io.netty.channel.SelectStrategy r12, io.netty.util.concurrent.RejectedExecutionHandler r13, io.netty.channel.EventLoopTaskQueueFactory r14, io.netty.channel.EventLoopTaskQueueFactory r15) {
        /*
            r8 = this;
            java.util.Queue r4 = newTaskQueue((io.netty.channel.EventLoopTaskQueueFactory) r14)
            java.util.Queue r5 = newTaskQueue((io.netty.channel.EventLoopTaskQueueFactory) r15)
            r3 = 0
            r0 = r8
            r1 = r9
            r2 = r10
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            io.netty.util.collection.IntObjectHashMap r9 = new io.netty.util.collection.IntObjectHashMap
            r10 = 4096(0x1000, float:5.74E-42)
            r9.<init>(r10)
            r8.channels = r9
            io.netty.channel.epoll.EpollEventLoop$1 r9 = new io.netty.channel.epoll.EpollEventLoop$1
            r9.<init>()
            r8.selectNowSupplier = r9
            java.util.concurrent.atomic.AtomicLong r9 = new java.util.concurrent.atomic.AtomicLong
            r13 = -1
            r9.<init>(r13)
            r8.nextWakeupNanos = r9
            r9 = 50
            r8.ioRatio = r9
            java.lang.String r9 = "strategy"
            java.lang.Object r9 = io.netty.util.internal.ObjectUtil.checkNotNull(r12, r9)
            io.netty.channel.SelectStrategy r9 = (io.netty.channel.SelectStrategy) r9
            r8.selectStrategy = r9
            if (r11 != 0) goto L_0x0045
            r9 = 1
            r8.allowGrowing = r9
            io.netty.channel.epoll.EpollEventArray r9 = new io.netty.channel.epoll.EpollEventArray
            r9.<init>(r10)
            r8.events = r9
            goto L_0x004f
        L_0x0045:
            r9 = 0
            r8.allowGrowing = r9
            io.netty.channel.epoll.EpollEventArray r9 = new io.netty.channel.epoll.EpollEventArray
            r9.<init>(r11)
            r8.events = r9
        L_0x004f:
            r9 = 0
            io.netty.channel.unix.FileDescriptor r10 = io.netty.channel.epoll.Native.newEpollCreate()     // Catch:{ all -> 0x009d }
            r8.epollFd = r10     // Catch:{ all -> 0x0098 }
            io.netty.channel.unix.FileDescriptor r11 = io.netty.channel.epoll.Native.newEventFd()     // Catch:{ all -> 0x0098 }
            r8.eventFd = r11     // Catch:{ all -> 0x0081 }
            int r12 = r10.intValue()     // Catch:{ IOException -> 0x008f }
            int r13 = r11.intValue()     // Catch:{ IOException -> 0x008f }
            int r14 = io.netty.channel.epoll.Native.EPOLLIN     // Catch:{ IOException -> 0x008f }
            int r15 = io.netty.channel.epoll.Native.EPOLLET     // Catch:{ IOException -> 0x008f }
            r0 = r14 | r15
            io.netty.channel.epoll.Native.epollCtlAdd(r12, r13, r0)     // Catch:{ IOException -> 0x008f }
            io.netty.channel.unix.FileDescriptor r9 = io.netty.channel.epoll.Native.newTimerFd()     // Catch:{ all -> 0x0081 }
            r8.timerFd = r9     // Catch:{ all -> 0x0081 }
            int r8 = r10.intValue()     // Catch:{ IOException -> 0x0086 }
            int r12 = r9.intValue()     // Catch:{ IOException -> 0x0086 }
            r13 = r14 | r15
            io.netty.channel.epoll.Native.epollCtlAdd(r8, r12, r13)     // Catch:{ IOException -> 0x0086 }
            return
        L_0x0081:
            r8 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00a0
        L_0x0086:
            r8 = move-exception
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0081 }
            java.lang.String r13 = "Unable to add timerFd filedescriptor to epoll"
            r12.<init>(r13, r8)     // Catch:{ all -> 0x0081 }
            throw r12     // Catch:{ all -> 0x0081 }
        L_0x008f:
            r8 = move-exception
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0081 }
            java.lang.String r13 = "Unable to add eventFd filedescriptor to epoll"
            r12.<init>(r13, r8)     // Catch:{ all -> 0x0081 }
            throw r12     // Catch:{ all -> 0x0081 }
        L_0x0098:
            r8 = move-exception
            r11 = r9
            r9 = r10
            r10 = r11
            goto L_0x00a0
        L_0x009d:
            r8 = move-exception
            r10 = r9
            r11 = r10
        L_0x00a0:
            if (r9 == 0) goto L_0x00a5
            r9.close()     // Catch:{ Exception -> 0x00a5 }
        L_0x00a5:
            if (r11 == 0) goto L_0x00aa
            r11.close()     // Catch:{ Exception -> 0x00aa }
        L_0x00aa:
            if (r10 == 0) goto L_0x00af
            r10.close()     // Catch:{ Exception -> 0x00af }
        L_0x00af:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollEventLoop.<init>(io.netty.channel.EventLoopGroup, java.util.concurrent.Executor, int, io.netty.channel.SelectStrategy, io.netty.util.concurrent.RejectedExecutionHandler, io.netty.channel.EventLoopTaskQueueFactory, io.netty.channel.EventLoopTaskQueueFactory):void");
    }

    private void closeAll() {
        for (AbstractEpollChannel abstractEpollChannel : (AbstractEpollChannel[]) this.channels.values().toArray(new AbstractEpollChannel[0])) {
            abstractEpollChannel.unsafe().close(abstractEpollChannel.unsafe().voidPromise());
        }
    }

    private int epollBusyWait() throws IOException {
        return Native.epollBusyWait(this.epollFd, this.events);
    }

    private long epollWait(long j) throws IOException {
        if (j == Long.MAX_VALUE) {
            return Native.epollWait(this.epollFd, this.events, this.timerFd, Integer.MAX_VALUE, 0, EPOLL_WAIT_MILLIS_THRESHOLD);
        }
        long deadlineToDelayNanos = AbstractScheduledEventExecutor.deadlineToDelayNanos(j);
        int min = (int) Math.min(deadlineToDelayNanos / 1000000000, UpdateOptions.SOURCE_ANY);
        return Native.epollWait(this.epollFd, this.events, this.timerFd, min, (int) Math.min(deadlineToDelayNanos - (((long) min) * 1000000000), MAX_SCHEDULED_TIMERFD_NS), EPOLL_WAIT_MILLIS_THRESHOLD);
    }

    private int epollWaitNoTimerChange() throws IOException {
        return Native.epollWait(this.epollFd, this.events, false);
    }

    /* access modifiers changed from: private */
    public int epollWaitNow() throws IOException {
        return Native.epollWait(this.epollFd, this.events, true);
    }

    private int epollWaitTimeboxed() throws IOException {
        return Native.epollWait(this.epollFd, this.events, 1000);
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

    private boolean processReady(EpollEventArray epollEventArray, int i) {
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            int fd = epollEventArray.fd(i2);
            if (fd == this.eventFd.intValue()) {
                this.pendingWakeup = false;
            } else if (fd == this.timerFd.intValue()) {
                z = true;
            } else {
                long events2 = (long) epollEventArray.events(i2);
                AbstractEpollChannel abstractEpollChannel = this.channels.get(fd);
                if (abstractEpollChannel != null) {
                    AbstractEpollChannel.AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollChannel.AbstractEpollUnsafe) abstractEpollChannel.unsafe();
                    int i3 = Native.EPOLLERR;
                    if ((((long) (Native.EPOLLOUT | i3)) & events2) != 0) {
                        abstractEpollUnsafe.epollOutReady();
                    }
                    if ((((long) (i3 | Native.EPOLLIN)) & events2) != 0) {
                        abstractEpollUnsafe.epollInReady();
                    }
                    if ((events2 & ((long) Native.EPOLLRDHUP)) != 0) {
                        abstractEpollUnsafe.epollRdHupReady();
                    }
                } else {
                    try {
                        Native.epollCtlDel(this.epollFd.intValue(), fd);
                    } catch (IOException unused) {
                    }
                }
            }
        }
        return z;
    }

    public void add(AbstractEpollChannel abstractEpollChannel) throws IOException {
        int intValue = abstractEpollChannel.socket.intValue();
        Native.epollCtlAdd(this.epollFd.intValue(), intValue, abstractEpollChannel.flags);
        AbstractEpollChannel put = this.channels.put(intValue, abstractEpollChannel);
    }

    public boolean afterScheduledTaskSubmitted(long j) {
        return j < this.nextWakeupNanos.get();
    }

    public boolean beforeScheduledTaskSubmitted(long j) {
        return j < this.nextWakeupNanos.get();
    }

    public NativeDatagramPacketArray cleanDatagramPacketArray() {
        NativeDatagramPacketArray nativeDatagramPacketArray = this.datagramPacketArray;
        if (nativeDatagramPacketArray == null) {
            this.datagramPacketArray = new NativeDatagramPacketArray();
        } else {
            nativeDatagramPacketArray.clear();
        }
        return this.datagramPacketArray;
    }

    public IovArray cleanIovArray() {
        IovArray iovArray2 = this.iovArray;
        if (iovArray2 == null) {
            this.iovArray = new IovArray();
        } else {
            iovArray2.clear();
        }
        return this.iovArray;
    }

    public void cleanup() {
        while (true) {
            try {
                if (this.pendingWakeup) {
                    try {
                        int epollWaitTimeboxed = epollWaitTimeboxed();
                        if (epollWaitTimeboxed == 0) {
                            break;
                        }
                        int i = 0;
                        while (true) {
                            if (i >= epollWaitTimeboxed) {
                                break;
                            } else if (this.events.fd(i) == this.eventFd.intValue()) {
                                this.pendingWakeup = false;
                                break;
                            } else {
                                i++;
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException e) {
                logger.warn("Failed to close the event fd.", (Throwable) e);
            } catch (Throwable th) {
                IovArray iovArray2 = this.iovArray;
                if (iovArray2 != null) {
                    iovArray2.release();
                    this.iovArray = null;
                }
                NativeDatagramPacketArray nativeDatagramPacketArray = this.datagramPacketArray;
                if (nativeDatagramPacketArray != null) {
                    nativeDatagramPacketArray.release();
                    this.datagramPacketArray = null;
                }
                this.events.free();
                throw th;
            }
        }
        this.eventFd.close();
        try {
            this.timerFd.close();
        } catch (IOException e2) {
            logger.warn("Failed to close the timer fd.", (Throwable) e2);
        }
        try {
            this.epollFd.close();
        } catch (IOException e3) {
            logger.warn("Failed to close the epoll fd.", (Throwable) e3);
        }
        IovArray iovArray3 = this.iovArray;
        if (iovArray3 != null) {
            iovArray3.release();
            this.iovArray = null;
        }
        NativeDatagramPacketArray nativeDatagramPacketArray2 = this.datagramPacketArray;
        if (nativeDatagramPacketArray2 != null) {
            nativeDatagramPacketArray2.release();
            this.datagramPacketArray = null;
        }
        this.events.free();
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    public void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException unused) {
        }
    }

    public void modify(AbstractEpollChannel abstractEpollChannel) throws IOException {
        Native.epollCtlMod(this.epollFd.intValue(), abstractEpollChannel.socket.intValue(), abstractEpollChannel.flags);
    }

    public int registeredChannels() {
        return this.channels.size();
    }

    public Iterator<Channel> registeredChannelsIterator() {
        IntObjectMap<AbstractEpollChannel> intObjectMap = this.channels;
        return intObjectMap.isEmpty() ? SingleThreadEventLoop.ChannelsReadOnlyIterator.empty() : new SingleThreadEventLoop.ChannelsReadOnlyIterator(intObjectMap.values());
    }

    public void remove(AbstractEpollChannel abstractEpollChannel) throws IOException {
        int intValue = abstractEpollChannel.socket.intValue();
        AbstractEpollChannel remove = this.channels.remove(intValue);
        if (remove != null && remove != abstractEpollChannel) {
            this.channels.put(intValue, remove);
        } else if (abstractEpollChannel.isOpen()) {
            Native.epollCtlDel(this.epollFd.intValue(), intValue);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0145, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0146, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b3, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b7, code lost:
        handleLoopException(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0130, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0131, code lost:
        throw r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b3 A[ExcHandler: all (r4v0 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r2 
      PHI: (r2v3 long) = (r2v4 long), (r2v6 long), (r2v1 long) binds: [B:100:0x0135, B:91:0x0120, B:50:0x00a2] A[DONT_GENERATE, DONT_INLINE], Splitter:B:50:0x00a2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r2 = r0
        L_0x0006:
            io.netty.channel.SelectStrategy r4 = r12.selectStrategy     // Catch:{ Error -> 0x003e, all -> 0x003b }
            io.netty.util.IntSupplier r5 = r12.selectNowSupplier     // Catch:{ Error -> 0x003e, all -> 0x003b }
            boolean r6 = r12.hasTasks()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            int r4 = r4.calculateStrategy(r5, r6)     // Catch:{ Error -> 0x003e, all -> 0x003b }
            r5 = -3
            if (r4 == r5) goto L_0x00bd
            r5 = -2
            if (r4 == r5) goto L_0x00a2
            r5 = -1
            if (r4 == r5) goto L_0x001d
            goto L_0x00c1
        L_0x001d:
            boolean r5 = r12.pendingWakeup     // Catch:{ Error -> 0x003e, all -> 0x003b }
            if (r5 == 0) goto L_0x0041
            int r4 = r12.epollWaitTimeboxed()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            if (r4 == 0) goto L_0x0029
            goto L_0x00c1
        L_0x0029:
            io.netty.util.internal.logging.InternalLogger r5 = logger     // Catch:{ Error -> 0x003e, all -> 0x003b }
            java.lang.String r6 = "Missed eventfd write (not seen after > 1 second)"
            r5.warn((java.lang.String) r6)     // Catch:{ Error -> 0x003e, all -> 0x003b }
            r5 = 0
            r12.pendingWakeup = r5     // Catch:{ Error -> 0x003e, all -> 0x003b }
            boolean r5 = r12.hasTasks()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            if (r5 == 0) goto L_0x0041
            goto L_0x00c1
        L_0x003b:
            r4 = move-exception
            goto L_0x0132
        L_0x003e:
            r0 = move-exception
            goto L_0x0149
        L_0x0041:
            long r5 = r12.nextScheduledTaskDeadlineNanos()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x004c
            r5 = r0
        L_0x004c:
            java.util.concurrent.atomic.AtomicLong r9 = r12.nextWakeupNanos     // Catch:{ Error -> 0x003e, all -> 0x003b }
            r9.set(r5)     // Catch:{ Error -> 0x003e, all -> 0x003b }
            r9 = 1
            boolean r10 = r12.hasTasks()     // Catch:{ all -> 0x0061 }
            if (r10 != 0) goto L_0x0074
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0063
            int r4 = r12.epollWaitNoTimerChange()     // Catch:{ all -> 0x0061 }
            goto L_0x0074
        L_0x0061:
            r4 = move-exception
            goto L_0x008b
        L_0x0063:
            long r10 = r12.epollWait(r5)     // Catch:{ all -> 0x0061 }
            int r4 = io.netty.channel.epoll.Native.epollReady(r10)     // Catch:{ all -> 0x0061 }
            boolean r2 = io.netty.channel.epoll.Native.epollTimerWasUsed(r10)     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x0073
            r2 = r5
            goto L_0x0074
        L_0x0073:
            r2 = r0
        L_0x0074:
            java.util.concurrent.atomic.AtomicLong r5 = r12.nextWakeupNanos     // Catch:{ Error -> 0x003e, all -> 0x003b }
            long r5 = r5.get()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x0088
            java.util.concurrent.atomic.AtomicLong r5 = r12.nextWakeupNanos     // Catch:{ Error -> 0x003e, all -> 0x003b }
            long r5 = r5.getAndSet(r7)     // Catch:{ Error -> 0x003e, all -> 0x003b }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x00c1
        L_0x0088:
            r12.pendingWakeup = r9     // Catch:{ Error -> 0x003e, all -> 0x003b }
            goto L_0x00c1
        L_0x008b:
            java.util.concurrent.atomic.AtomicLong r5 = r12.nextWakeupNanos     // Catch:{ Error -> 0x003e, all -> 0x003b }
            long r5 = r5.get()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x009f
            java.util.concurrent.atomic.AtomicLong r5 = r12.nextWakeupNanos     // Catch:{ Error -> 0x003e, all -> 0x003b }
            long r5 = r5.getAndSet(r7)     // Catch:{ Error -> 0x003e, all -> 0x003b }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x00a1
        L_0x009f:
            r12.pendingWakeup = r9     // Catch:{ Error -> 0x003e, all -> 0x003b }
        L_0x00a1:
            throw r4     // Catch:{ Error -> 0x003e, all -> 0x003b }
        L_0x00a2:
            boolean r4 = r12.isShuttingDown()     // Catch:{ Error -> 0x00b5, all -> 0x00b3 }
            if (r4 == 0) goto L_0x0006
            r12.closeAll()     // Catch:{ Error -> 0x00b5, all -> 0x00b3 }
            boolean r4 = r12.confirmShutdown()     // Catch:{ Error -> 0x00b5, all -> 0x00b3 }
            if (r4 == 0) goto L_0x0006
            goto L_0x0159
        L_0x00b3:
            r4 = move-exception
            goto L_0x00b7
        L_0x00b5:
            r12 = move-exception
            goto L_0x00bc
        L_0x00b7:
            r12.handleLoopException(r4)
            goto L_0x0006
        L_0x00bc:
            throw r12
        L_0x00bd:
            int r4 = r12.epollBusyWait()     // Catch:{ Error -> 0x003e, all -> 0x003b }
        L_0x00c1:
            int r5 = r12.ioRatio     // Catch:{ Error -> 0x003e, all -> 0x003b }
            r6 = 100
            if (r5 != r6) goto L_0x00dc
            if (r4 <= 0) goto L_0x00d8
            io.netty.channel.epoll.EpollEventArray r5 = r12.events     // Catch:{ all -> 0x00d3 }
            boolean r5 = r12.processReady(r5, r4)     // Catch:{ all -> 0x00d3 }
            if (r5 == 0) goto L_0x00d8
            r2 = r0
            goto L_0x00d8
        L_0x00d3:
            r4 = move-exception
            r12.runAllTasks()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            throw r4     // Catch:{ Error -> 0x003e, all -> 0x003b }
        L_0x00d8:
            r12.runAllTasks()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            goto L_0x010f
        L_0x00dc:
            if (r4 <= 0) goto L_0x010a
            long r6 = java.lang.System.nanoTime()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            io.netty.channel.epoll.EpollEventArray r8 = r12.events     // Catch:{ all -> 0x00fa }
            boolean r8 = r12.processReady(r8, r4)     // Catch:{ all -> 0x00fa }
            if (r8 == 0) goto L_0x00eb
            r2 = r0
        L_0x00eb:
            long r8 = java.lang.System.nanoTime()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            long r8 = r8 - r6
            int r6 = 100 - r5
            long r6 = (long) r6     // Catch:{ Error -> 0x003e, all -> 0x003b }
            long r8 = r8 * r6
            long r5 = (long) r5     // Catch:{ Error -> 0x003e, all -> 0x003b }
            long r8 = r8 / r5
            r12.runAllTasks(r8)     // Catch:{ Error -> 0x003e, all -> 0x003b }
            goto L_0x010f
        L_0x00fa:
            r4 = move-exception
            long r8 = java.lang.System.nanoTime()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            long r8 = r8 - r6
            int r6 = 100 - r5
            long r6 = (long) r6     // Catch:{ Error -> 0x003e, all -> 0x003b }
            long r8 = r8 * r6
            long r5 = (long) r5     // Catch:{ Error -> 0x003e, all -> 0x003b }
            long r8 = r8 / r5
            r12.runAllTasks(r8)     // Catch:{ Error -> 0x003e, all -> 0x003b }
            throw r4     // Catch:{ Error -> 0x003e, all -> 0x003b }
        L_0x010a:
            r5 = 0
            r12.runAllTasks(r5)     // Catch:{ Error -> 0x003e, all -> 0x003b }
        L_0x010f:
            boolean r5 = r12.allowGrowing     // Catch:{ Error -> 0x003e, all -> 0x003b }
            if (r5 == 0) goto L_0x0120
            io.netty.channel.epoll.EpollEventArray r5 = r12.events     // Catch:{ Error -> 0x003e, all -> 0x003b }
            int r5 = r5.length()     // Catch:{ Error -> 0x003e, all -> 0x003b }
            if (r4 != r5) goto L_0x0120
            io.netty.channel.epoll.EpollEventArray r4 = r12.events     // Catch:{ Error -> 0x003e, all -> 0x003b }
            r4.increase()     // Catch:{ Error -> 0x003e, all -> 0x003b }
        L_0x0120:
            boolean r4 = r12.isShuttingDown()     // Catch:{ Error -> 0x0130, all -> 0x00b3 }
            if (r4 == 0) goto L_0x0006
            r12.closeAll()     // Catch:{ Error -> 0x0130, all -> 0x00b3 }
            boolean r4 = r12.confirmShutdown()     // Catch:{ Error -> 0x0130, all -> 0x00b3 }
            if (r4 == 0) goto L_0x0006
            goto L_0x0159
        L_0x0130:
            r12 = move-exception
            throw r12
        L_0x0132:
            r12.handleLoopException(r4)     // Catch:{ all -> 0x0147 }
            boolean r4 = r12.isShuttingDown()     // Catch:{ Error -> 0x0145, all -> 0x00b3 }
            if (r4 == 0) goto L_0x0006
            r12.closeAll()     // Catch:{ Error -> 0x0145, all -> 0x00b3 }
            boolean r4 = r12.confirmShutdown()     // Catch:{ Error -> 0x0145, all -> 0x00b3 }
            if (r4 == 0) goto L_0x0006
            goto L_0x0159
        L_0x0145:
            r12 = move-exception
            throw r12
        L_0x0147:
            r0 = move-exception
            goto L_0x014a
        L_0x0149:
            throw r0     // Catch:{ all -> 0x0147 }
        L_0x014a:
            boolean r1 = r12.isShuttingDown()     // Catch:{ Error -> 0x015c, all -> 0x015a }
            if (r1 == 0) goto L_0x0161
            r12.closeAll()     // Catch:{ Error -> 0x015c, all -> 0x015a }
            boolean r12 = r12.confirmShutdown()     // Catch:{ Error -> 0x015c, all -> 0x015a }
            if (r12 == 0) goto L_0x0161
        L_0x0159:
            return
        L_0x015a:
            r1 = move-exception
            goto L_0x015e
        L_0x015c:
            r12 = move-exception
            goto L_0x0162
        L_0x015e:
            r12.handleLoopException(r1)
        L_0x0161:
            throw r0
        L_0x0162:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollEventLoop.run():void");
    }

    public void setIoRatio(int i) {
        if (i <= 0 || i > 100) {
            throw new IllegalArgumentException("ioRatio: " + i + " (expected: 0 < ioRatio <= 100)");
        }
        this.ioRatio = i;
    }

    public void wakeup(boolean z) {
        if (!z && this.nextWakeupNanos.getAndSet(-1) != -1) {
            Native.eventFdWrite(this.eventFd.intValue(), 1);
        }
    }

    public Queue<Runnable> newTaskQueue(int i) {
        return newTaskQueue0(i);
    }
}
