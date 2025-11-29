package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

public abstract class AbstractScheduledEventExecutor extends AbstractEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<ScheduledFutureTask<?>> SCHEDULED_FUTURE_TASK_COMPARATOR = new Comparator<ScheduledFutureTask<?>>() {
        public int compare(ScheduledFutureTask<?> scheduledFutureTask, ScheduledFutureTask<?> scheduledFutureTask2) {
            return scheduledFutureTask.compareTo((Delayed) scheduledFutureTask2);
        }
    };
    private static final long START_TIME = System.nanoTime();
    static final Runnable WAKEUP_TASK = new Runnable() {
        public void run() {
        }
    };
    long nextTaskId;
    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue;

    public AbstractScheduledEventExecutor() {
    }

    public static long deadlineNanos(long j, long j2) {
        long j3 = j + j2;
        return j3 < 0 ? LongCompanionObject.MAX_VALUE : j3;
    }

    public static long deadlineToDelayNanos(long j) {
        return ScheduledFutureTask.deadlineToDelayNanos(defaultCurrentTimeNanos(), j);
    }

    public static long defaultCurrentTimeNanos() {
        return System.nanoTime() - START_TIME;
    }

    public static long initialNanoTime() {
        return START_TIME;
    }

    private static boolean isNullOrEmpty(Queue<ScheduledFutureTask<?>> queue) {
        return queue == null || queue.isEmpty();
    }

    @Deprecated
    public static long nanoTime() {
        return defaultCurrentTimeNanos();
    }

    private void validateScheduled0(long j, TimeUnit timeUnit) {
        validateScheduled(j, timeUnit);
    }

    public boolean afterScheduledTaskSubmitted(long j) {
        return true;
    }

    public boolean beforeScheduledTaskSubmitted(long j) {
        return true;
    }

    public void cancelScheduledTasks() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (!isNullOrEmpty(priorityQueue)) {
            for (ScheduledFutureTask cancelWithoutRemove : (ScheduledFutureTask[]) priorityQueue.toArray(new ScheduledFutureTask[0])) {
                cancelWithoutRemove.cancelWithoutRemove(false);
            }
            priorityQueue.clearIgnoringIndexes();
        }
    }

    public long getCurrentTimeNanos() {
        return defaultCurrentTimeNanos();
    }

    public final boolean hasScheduledTasks() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        return peekScheduledTask != null && peekScheduledTask.deadlineNanos() <= getCurrentTimeNanos();
    }

    public final long nextScheduledTaskDeadlineNanos() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask != null) {
            return peekScheduledTask.deadlineNanos();
        }
        return -1;
    }

    public final long nextScheduledTaskNano() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask != null) {
            return peekScheduledTask.delayNanos();
        }
        return -1;
    }

    public final ScheduledFutureTask<?> peekScheduledTask() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (priorityQueue != null) {
            return (ScheduledFutureTask) priorityQueue.peek();
        }
        return null;
    }

    public final Runnable pollScheduledTask() {
        return pollScheduledTask(getCurrentTimeNanos());
    }

    public final void removeScheduled(ScheduledFutureTask<?> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().removeTyped(scheduledFutureTask);
        } else {
            lazyExecute(scheduledFutureTask);
        }
    }

    public final void scheduleFromEventLoop(ScheduledFutureTask<?> scheduledFutureTask) {
        PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue2 = scheduledTaskQueue();
        long j = this.nextTaskId + 1;
        this.nextTaskId = j;
        scheduledTaskQueue2.add(scheduledFutureTask.setId(j));
    }

    public PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue() {
        if (this.scheduledTaskQueue == null) {
            this.scheduledTaskQueue = new DefaultPriorityQueue(SCHEDULED_FUTURE_TASK_COMPARATOR, 11);
        }
        return this.scheduledTaskQueue;
    }

    @Deprecated
    public void validateScheduled(long j, TimeUnit timeUnit) {
    }

    public AbstractScheduledEventExecutor(EventExecutorGroup eventExecutorGroup) {
        super(eventExecutorGroup);
    }

    public final Runnable pollScheduledTask(long j) {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask == null || peekScheduledTask.deadlineNanos() - j > 0) {
            return null;
        }
        this.scheduledTaskQueue.remove();
        peekScheduledTask.setConsumed();
        return peekScheduledTask;
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", new Object[]{Long.valueOf(j)}));
        } else if (j2 > 0) {
            validateScheduled0(j, timeUnit);
            validateScheduled0(j2, timeUnit);
            return schedule(new ScheduledFutureTask(this, runnable, deadlineNanos(getCurrentTimeNanos(), timeUnit.toNanos(j)), timeUnit.toNanos(j2)));
        } else {
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", new Object[]{Long.valueOf(j2)}));
        }
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", new Object[]{Long.valueOf(j)}));
        } else if (j2 > 0) {
            validateScheduled0(j, timeUnit);
            validateScheduled0(j2, timeUnit);
            return schedule(new ScheduledFutureTask(this, runnable, deadlineNanos(getCurrentTimeNanos(), timeUnit.toNanos(j)), -timeUnit.toNanos(j2)));
        } else {
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", new Object[]{Long.valueOf(j2)}));
        }
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            j = 0;
        }
        validateScheduled0(j, timeUnit);
        return schedule(new ScheduledFutureTask(this, runnable, deadlineNanos(getCurrentTimeNanos(), timeUnit.toNanos(j))));
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(callable, "callable");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            j = 0;
        }
        validateScheduled0(j, timeUnit);
        return schedule(new ScheduledFutureTask(this, callable, deadlineNanos(getCurrentTimeNanos(), timeUnit.toNanos(j))));
    }

    private <V> ScheduledFuture<V> schedule(ScheduledFutureTask<V> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduleFromEventLoop(scheduledFutureTask);
        } else {
            long deadlineNanos = scheduledFutureTask.deadlineNanos();
            if (beforeScheduledTaskSubmitted(deadlineNanos)) {
                execute(scheduledFutureTask);
            } else {
                lazyExecute(scheduledFutureTask);
                if (afterScheduledTaskSubmitted(deadlineNanos)) {
                    execute(WAKEUP_TASK);
                }
            }
        }
        return scheduledFutureTask;
    }
}
