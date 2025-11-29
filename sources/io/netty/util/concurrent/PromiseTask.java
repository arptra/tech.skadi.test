package io.netty.util.concurrent;

import io.netty.util.internal.StringUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import org.eclipse.jetty.util.component.AbstractLifeCycle;

class PromiseTask<V> extends DefaultPromise<V> implements RunnableFuture<V> {
    private static final Runnable CANCELLED = new SentinelRunnable("CANCELLED");
    private static final Runnable COMPLETED = new SentinelRunnable("COMPLETED");
    private static final Runnable FAILED = new SentinelRunnable(AbstractLifeCycle.FAILED);
    private Object task;

    public static final class RunnableAdapter<T> implements Callable<T> {
        final T result;
        final Runnable task;

        public RunnableAdapter(Runnable runnable, T t) {
            this.task = runnable;
            this.result = t;
        }

        public T call() {
            this.task.run();
            return this.result;
        }

        public String toString() {
            return "Callable(task: " + this.task + ", result: " + this.result + ')';
        }
    }

    public static class SentinelRunnable implements Runnable {
        private final String name;

        public SentinelRunnable(String str) {
            this.name = str;
        }

        public void run() {
        }

        public String toString() {
            return this.name;
        }
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [io.netty.util.concurrent.PromiseTask$RunnableAdapter] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PromiseTask(io.netty.util.concurrent.EventExecutor r1, java.lang.Runnable r2, V r3) {
        /*
            r0 = this;
            r0.<init>(r1)
            if (r3 != 0) goto L_0x0006
            goto L_0x000c
        L_0x0006:
            io.netty.util.concurrent.PromiseTask$RunnableAdapter r1 = new io.netty.util.concurrent.PromiseTask$RunnableAdapter
            r1.<init>(r2, r3)
            r2 = r1
        L_0x000c:
            r0.task = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.PromiseTask.<init>(io.netty.util.concurrent.EventExecutor, java.lang.Runnable, java.lang.Object):void");
    }

    private boolean clearTaskAfterCompletion(boolean z, Runnable runnable) {
        if (z) {
            this.task = runnable;
        }
        return z;
    }

    public boolean cancel(boolean z) {
        return clearTaskAfterCompletion(super.cancel(z), CANCELLED);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public void run() {
        try {
            if (setUncancellableInternal()) {
                setSuccessInternal(runTask());
            }
        } catch (Throwable th) {
            setFailureInternal(th);
        }
    }

    public V runTask() throws Throwable {
        Object obj = this.task;
        if (obj instanceof Callable) {
            return ((Callable) obj).call();
        }
        ((Runnable) obj).run();
        return null;
    }

    public final Promise<V> setFailure(Throwable th) {
        throw new IllegalStateException();
    }

    public final Promise<V> setFailureInternal(Throwable th) {
        super.setFailure(th);
        clearTaskAfterCompletion(true, FAILED);
        return this;
    }

    public final Promise<V> setSuccess(V v) {
        throw new IllegalStateException();
    }

    public final Promise<V> setSuccessInternal(V v) {
        super.setSuccess(v);
        clearTaskAfterCompletion(true, COMPLETED);
        return this;
    }

    public final boolean setUncancellable() {
        throw new IllegalStateException();
    }

    public final boolean setUncancellableInternal() {
        return super.setUncancellable();
    }

    public StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, StringUtil.COMMA);
        stringBuilder.append(" task: ");
        stringBuilder.append(this.task);
        stringBuilder.append(')');
        return stringBuilder;
    }

    public final boolean tryFailure(Throwable th) {
        return false;
    }

    public final boolean tryFailureInternal(Throwable th) {
        return clearTaskAfterCompletion(super.tryFailure(th), FAILED);
    }

    public final boolean trySuccess(V v) {
        return false;
    }

    public final boolean trySuccessInternal(V v) {
        return clearTaskAfterCompletion(super.trySuccess(v), COMPLETED);
    }

    public PromiseTask(EventExecutor eventExecutor, Runnable runnable) {
        super(eventExecutor);
        this.task = runnable;
    }

    public PromiseTask(EventExecutor eventExecutor, Callable<V> callable) {
        super(eventExecutor);
        this.task = callable;
    }
}
