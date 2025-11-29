package io.netty.channel.pool;

import com.honey.account.view.web.WebJs;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedChannelPool extends SimpleChannelPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public final long acquireTimeoutNanos;
    /* access modifiers changed from: private */
    public final AtomicInteger acquiredChannelCount;
    /* access modifiers changed from: private */
    public boolean closed;
    /* access modifiers changed from: private */
    public final EventExecutor executor;
    private final int maxConnections;
    private final int maxPendingAcquires;
    private int pendingAcquireCount;
    /* access modifiers changed from: private */
    public final Queue<AcquireTask> pendingAcquireQueue;
    private final Runnable timeoutTask;

    /* renamed from: io.netty.channel.pool.FixedChannelPool$7  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.netty.channel.pool.FixedChannelPool$AcquireTimeoutAction[] r0 = io.netty.channel.pool.FixedChannelPool.AcquireTimeoutAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction = r0
                io.netty.channel.pool.FixedChannelPool$AcquireTimeoutAction r1 = io.netty.channel.pool.FixedChannelPool.AcquireTimeoutAction.FAIL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.channel.pool.FixedChannelPool$AcquireTimeoutAction r1 = io.netty.channel.pool.FixedChannelPool.AcquireTimeoutAction.NEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.pool.FixedChannelPool.AnonymousClass7.<clinit>():void");
        }
    }

    public class AcquireListener implements FutureListener<Channel> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected boolean acquired;
        private final Promise<Channel> originalPromise;

        public AcquireListener(Promise<Channel> promise) {
            this.originalPromise = promise;
        }

        public void acquired() {
            if (!this.acquired) {
                FixedChannelPool.this.acquiredChannelCount.incrementAndGet();
                this.acquired = true;
            }
        }

        public void operationComplete(Future<Channel> future) throws Exception {
            try {
                if (FixedChannelPool.this.closed) {
                    if (future.isSuccess()) {
                        future.getNow().close();
                    }
                    this.originalPromise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
                } else if (future.isSuccess()) {
                    this.originalPromise.setSuccess(future.getNow());
                } else {
                    if (this.acquired) {
                        FixedChannelPool.this.decrementAndRunTaskQueue();
                    } else {
                        FixedChannelPool.this.runTaskQueue();
                    }
                    this.originalPromise.setFailure(future.cause());
                }
            } catch (Throwable th) {
                this.originalPromise.tryFailure(th);
            }
        }
    }

    public final class AcquireTask extends AcquireListener {
        final long expireNanoTime;
        final Promise<Channel> promise;
        ScheduledFuture<?> timeoutFuture;

        public AcquireTask(Promise<Channel> promise2) {
            super(promise2);
            this.expireNanoTime = System.nanoTime() + FixedChannelPool.this.acquireTimeoutNanos;
            this.promise = FixedChannelPool.this.executor.newPromise().addListener(this);
        }
    }

    public enum AcquireTimeoutAction {
        NEW,
        FAIL
    }

    public static final class AcquireTimeoutException extends TimeoutException {
        public Throwable fillInStackTrace() {
            return this;
        }

        private AcquireTimeoutException() {
            super("Acquire operation took longer then configured maximum time");
        }
    }

    public abstract class TimeoutTask implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private TimeoutTask() {
        }

        public abstract void onTimeout(AcquireTask acquireTask);

        public final void run() {
            long nanoTime = System.nanoTime();
            while (true) {
                AcquireTask acquireTask = (AcquireTask) FixedChannelPool.this.pendingAcquireQueue.peek();
                if (acquireTask != null && nanoTime - acquireTask.expireNanoTime >= 0) {
                    FixedChannelPool.this.pendingAcquireQueue.remove();
                    FixedChannelPool.access$906(FixedChannelPool.this);
                    onTimeout(acquireTask);
                } else {
                    return;
                }
            }
        }
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, int i) {
        this(bootstrap, channelPoolHandler, i, Integer.MAX_VALUE);
    }

    public static /* synthetic */ int access$906(FixedChannelPool fixedChannelPool) {
        int i = fixedChannelPool.pendingAcquireCount - 1;
        fixedChannelPool.pendingAcquireCount = i;
        return i;
    }

    /* access modifiers changed from: private */
    public void acquire0(Promise<Channel> promise) {
        try {
            if (this.closed) {
                promise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
            } else if (this.acquiredChannelCount.get() < this.maxConnections) {
                Promise newPromise = this.executor.newPromise();
                AcquireListener acquireListener = new AcquireListener(promise);
                acquireListener.acquired();
                newPromise.addListener(acquireListener);
                super.acquire(newPromise);
            } else if (this.pendingAcquireCount >= this.maxPendingAcquires) {
                tooManyOutstanding(promise);
            } else {
                AcquireTask acquireTask = new AcquireTask(promise);
                if (this.pendingAcquireQueue.offer(acquireTask)) {
                    this.pendingAcquireCount++;
                    Runnable runnable = this.timeoutTask;
                    if (runnable != null) {
                        acquireTask.timeoutFuture = this.executor.schedule(runnable, this.acquireTimeoutNanos, TimeUnit.NANOSECONDS);
                        return;
                    }
                    return;
                }
                tooManyOutstanding(promise);
            }
        } catch (Throwable th) {
            promise.tryFailure(th);
        }
    }

    /* access modifiers changed from: private */
    public Future<Void> close0() {
        if (this.closed) {
            return GlobalEventExecutor.INSTANCE.newSucceededFuture(null);
        }
        this.closed = true;
        while (true) {
            AcquireTask poll = this.pendingAcquireQueue.poll();
            if (poll == null) {
                this.acquiredChannelCount.set(0);
                this.pendingAcquireCount = 0;
                return GlobalEventExecutor.INSTANCE.submit(new Callable<Void>() {
                    public Void call() throws Exception {
                        FixedChannelPool.super.close();
                        return null;
                    }
                });
            }
            ScheduledFuture<?> scheduledFuture = poll.timeoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            poll.promise.setFailure(new ClosedChannelException());
        }
    }

    /* access modifiers changed from: private */
    public void decrementAndRunTaskQueue() {
        this.acquiredChannelCount.decrementAndGet();
        runTaskQueue();
    }

    /* access modifiers changed from: private */
    public void runTaskQueue() {
        AcquireTask poll;
        while (this.acquiredChannelCount.get() < this.maxConnections && (poll = this.pendingAcquireQueue.poll()) != null) {
            ScheduledFuture<?> scheduledFuture = poll.timeoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.pendingAcquireCount--;
            poll.acquired();
            super.acquire(poll.promise);
        }
    }

    private void tooManyOutstanding(Promise<?> promise) {
        promise.setFailure(new IllegalStateException("Too many outstanding acquire operations"));
    }

    public Future<Channel> acquire(final Promise<Channel> promise) {
        try {
            if (this.executor.inEventLoop()) {
                acquire0(promise);
            } else {
                this.executor.execute(new Runnable() {
                    public void run() {
                        FixedChannelPool.this.acquire0(promise);
                    }
                });
            }
        } catch (Throwable th) {
            promise.tryFailure(th);
        }
        return promise;
    }

    public int acquiredChannelCount() {
        return this.acquiredChannelCount.get();
    }

    public void close() {
        try {
            closeAsync().await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public Future<Void> closeAsync() {
        if (this.executor.inEventLoop()) {
            return close0();
        }
        final Promise newPromise = this.executor.newPromise();
        this.executor.execute(new Runnable() {
            public void run() {
                FixedChannelPool.this.close0().addListener(new FutureListener<Void>() {
                    public void operationComplete(Future<Void> future) throws Exception {
                        if (future.isSuccess()) {
                            newPromise.setSuccess(null);
                        } else {
                            newPromise.setFailure(future.cause());
                        }
                    }
                });
            }
        });
        return newPromise;
    }

    public Future<Void> release(final Channel channel, final Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        super.release(channel, this.executor.newPromise().addListener(new FutureListener<Void>() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            public void operationComplete(Future<Void> future) {
                try {
                    if (FixedChannelPool.this.closed) {
                        channel.close();
                        promise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
                    } else if (future.isSuccess()) {
                        FixedChannelPool.this.decrementAndRunTaskQueue();
                        promise.setSuccess(null);
                    } else {
                        if (!(future.cause() instanceof IllegalArgumentException)) {
                            FixedChannelPool.this.decrementAndRunTaskQueue();
                        }
                        promise.setFailure(future.cause());
                    }
                } catch (Throwable th) {
                    promise.tryFailure(th);
                }
            }
        }));
        return promise;
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, int i, int i2) {
        this(bootstrap, channelPoolHandler, ChannelHealthChecker.ACTIVE, (AcquireTimeoutAction) null, -1, i, i2);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j, int i, int i2) {
        this(bootstrap, channelPoolHandler, channelHealthChecker, acquireTimeoutAction, j, i, i2, true);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j, int i, int i2, boolean z) {
        this(bootstrap, channelPoolHandler, channelHealthChecker, acquireTimeoutAction, j, i, i2, z, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j, int i, int i2, boolean z, boolean z2) {
        super(bootstrap, channelPoolHandler, channelHealthChecker, z, z2);
        long j2 = j;
        int i3 = i;
        int i4 = i2;
        this.pendingAcquireQueue = new ArrayDeque();
        this.acquiredChannelCount = new AtomicInteger();
        ObjectUtil.checkPositive(i3, "maxConnections");
        ObjectUtil.checkPositive(i4, "maxPendingAcquires");
        if (acquireTimeoutAction == null && j2 == -1) {
            this.timeoutTask = null;
            this.acquireTimeoutNanos = -1;
        } else if (acquireTimeoutAction == null && j2 != -1) {
            throw new NullPointerException(WebJs.ACTION);
        } else if (acquireTimeoutAction == null || j2 >= 0) {
            this.acquireTimeoutNanos = TimeUnit.MILLISECONDS.toNanos(j2);
            int i5 = AnonymousClass7.$SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction[acquireTimeoutAction.ordinal()];
            if (i5 == 1) {
                this.timeoutTask = new TimeoutTask() {
                    public void onTimeout(AcquireTask acquireTask) {
                        acquireTask.promise.setFailure(new AcquireTimeoutException());
                    }
                };
            } else if (i5 == 2) {
                this.timeoutTask = new TimeoutTask() {
                    public void onTimeout(AcquireTask acquireTask) {
                        acquireTask.acquired();
                        Future unused = FixedChannelPool.super.acquire(acquireTask.promise);
                    }
                };
            } else {
                throw new Error();
            }
        } else {
            throw new IllegalArgumentException("acquireTimeoutMillis: " + j2 + " (expected: >= 0)");
        }
        this.executor = bootstrap.config().group().next();
        this.maxConnections = i3;
        this.maxPendingAcquires = i4;
    }
}
