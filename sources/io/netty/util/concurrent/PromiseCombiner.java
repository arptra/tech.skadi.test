package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

public final class PromiseCombiner {
    /* access modifiers changed from: private */
    public Promise<Void> aggregatePromise;
    /* access modifiers changed from: private */
    public Throwable cause;
    /* access modifiers changed from: private */
    public int doneCount;
    /* access modifiers changed from: private */
    public final EventExecutor executor;
    /* access modifiers changed from: private */
    public int expectedCount;
    private final GenericFutureListener<Future<?>> listener;

    @Deprecated
    public PromiseCombiner() {
        this(ImmediateEventExecutor.INSTANCE);
    }

    public static /* synthetic */ int access$204(PromiseCombiner promiseCombiner) {
        int i = promiseCombiner.doneCount + 1;
        promiseCombiner.doneCount = i;
        return i;
    }

    private void checkAddAllowed() {
        if (this.aggregatePromise != null) {
            throw new IllegalStateException("Adding promises is not allowed after finished adding");
        }
    }

    private void checkInEventLoop() {
        if (!this.executor.inEventLoop()) {
            throw new IllegalStateException("Must be called from EventExecutor thread");
        }
    }

    /* access modifiers changed from: private */
    public boolean tryPromise() {
        Throwable th = this.cause;
        Promise<Void> promise = this.aggregatePromise;
        return th == null ? promise.trySuccess(null) : promise.tryFailure(th);
    }

    @Deprecated
    public void add(Promise promise) {
        add((Future) promise);
    }

    @Deprecated
    public void addAll(Promise... promiseArr) {
        addAll((Future[]) promiseArr);
    }

    public void finish(Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "aggregatePromise");
        checkInEventLoop();
        if (this.aggregatePromise == null) {
            this.aggregatePromise = promise;
            if (this.doneCount == this.expectedCount) {
                tryPromise();
                return;
            }
            return;
        }
        throw new IllegalStateException("Already finished");
    }

    public PromiseCombiner(EventExecutor eventExecutor) {
        this.listener = new GenericFutureListener<Future<?>>() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            /* access modifiers changed from: private */
            public void operationComplete0(Future<?> future) {
                PromiseCombiner.access$204(PromiseCombiner.this);
                if (!future.isSuccess() && PromiseCombiner.this.cause == null) {
                    Throwable unused = PromiseCombiner.this.cause = future.cause();
                }
                if (PromiseCombiner.this.doneCount == PromiseCombiner.this.expectedCount && PromiseCombiner.this.aggregatePromise != null) {
                    boolean unused2 = PromiseCombiner.this.tryPromise();
                }
            }

            public void operationComplete(final Future<?> future) {
                if (PromiseCombiner.this.executor.inEventLoop()) {
                    operationComplete0(future);
                } else {
                    PromiseCombiner.this.executor.execute(new Runnable() {
                        public void run() {
                            AnonymousClass1.this.operationComplete0(future);
                        }
                    });
                }
            }
        };
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    public void add(Future future) {
        checkAddAllowed();
        checkInEventLoop();
        this.expectedCount++;
        future.addListener(this.listener);
    }

    public void addAll(Future... futureArr) {
        for (Future add : futureArr) {
            add(add);
        }
    }
}
