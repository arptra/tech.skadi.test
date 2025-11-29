package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import io.netty.util.internal.StringUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

final class ScheduledFutureTask<V> extends PromiseTask<V> implements ScheduledFuture<V>, PriorityQueueNode {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long deadlineNanos;
    private long id;
    private final long periodNanos;
    private int queueIndex = -1;

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Runnable runnable, long j) {
        super((EventExecutor) abstractScheduledEventExecutor, runnable);
        this.deadlineNanos = j;
        this.periodNanos = 0;
    }

    public static long deadlineToDelayNanos(long j, long j2) {
        if (j2 == 0) {
            return 0;
        }
        return Math.max(0, j2 - j);
    }

    private AbstractScheduledEventExecutor scheduledExecutor() {
        return (AbstractScheduledEventExecutor) executor();
    }

    private static long validatePeriod(long j) {
        if (j != 0) {
            return j;
        }
        throw new IllegalArgumentException("period: 0 (expected: != 0)");
    }

    public boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            scheduledExecutor().removeScheduled(this);
        }
        return cancel;
    }

    public boolean cancelWithoutRemove(boolean z) {
        return super.cancel(z);
    }

    public long deadlineNanos() {
        return this.deadlineNanos;
    }

    public long delayNanos() {
        return delayNanos(scheduledExecutor().getCurrentTimeNanos());
    }

    public EventExecutor executor() {
        return super.executor();
    }

    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(delayNanos(), TimeUnit.NANOSECONDS);
    }

    public int priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue) {
        return this.queueIndex;
    }

    public void run() {
        try {
            if (delayNanos() > 0) {
                if (isCancelled()) {
                    scheduledExecutor().scheduledTaskQueue().removeTyped(this);
                } else {
                    scheduledExecutor().scheduleFromEventLoop(this);
                }
            } else if (this.periodNanos == 0) {
                if (setUncancellableInternal()) {
                    setSuccessInternal(runTask());
                }
            } else if (!isCancelled()) {
                runTask();
                if (!executor().isShutdown()) {
                    long j = this.periodNanos;
                    if (j > 0) {
                        this.deadlineNanos += j;
                    } else {
                        this.deadlineNanos = scheduledExecutor().getCurrentTimeNanos() - this.periodNanos;
                    }
                    if (!isCancelled()) {
                        scheduledExecutor().scheduledTaskQueue().add(this);
                    }
                }
            }
        } catch (Throwable th) {
            setFailureInternal(th);
        }
    }

    public void setConsumed() {
        if (this.periodNanos == 0) {
            this.deadlineNanos = 0;
        }
    }

    public ScheduledFutureTask<V> setId(long j) {
        if (this.id == 0) {
            this.id = j;
        }
        return this;
    }

    public StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, StringUtil.COMMA);
        stringBuilder.append(" deadline: ");
        stringBuilder.append(this.deadlineNanos);
        stringBuilder.append(", period: ");
        stringBuilder.append(this.periodNanos);
        stringBuilder.append(')');
        return stringBuilder;
    }

    public int compareTo(Delayed delayed) {
        if (this == delayed) {
            return 0;
        }
        ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask) delayed;
        int i = ((deadlineNanos() - scheduledFutureTask.deadlineNanos()) > 0 ? 1 : ((deadlineNanos() - scheduledFutureTask.deadlineNanos()) == 0 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return (i <= 0 && this.id < scheduledFutureTask.id) ? -1 : 1;
    }

    public long delayNanos(long j) {
        return deadlineToDelayNanos(j, this.deadlineNanos);
    }

    public void priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue, int i) {
        this.queueIndex = i;
    }

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Runnable runnable, long j, long j2) {
        super((EventExecutor) abstractScheduledEventExecutor, runnable);
        this.deadlineNanos = j;
        this.periodNanos = validatePeriod(j2);
    }

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j, long j2) {
        super((EventExecutor) abstractScheduledEventExecutor, callable);
        this.deadlineNanos = j;
        this.periodNanos = validatePeriod(j2);
    }

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j) {
        super((EventExecutor) abstractScheduledEventExecutor, callable);
        this.deadlineNanos = j;
        this.periodNanos = 0;
    }
}
