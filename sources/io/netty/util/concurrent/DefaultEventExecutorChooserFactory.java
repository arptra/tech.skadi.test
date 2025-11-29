package io.netty.util.concurrent;

import io.netty.util.concurrent.EventExecutorChooserFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class DefaultEventExecutorChooserFactory implements EventExecutorChooserFactory {
    public static final DefaultEventExecutorChooserFactory INSTANCE = new DefaultEventExecutorChooserFactory();

    public static final class GenericEventExecutorChooser implements EventExecutorChooserFactory.EventExecutorChooser {
        private final EventExecutor[] executors;
        private final AtomicLong idx = new AtomicLong();

        public GenericEventExecutorChooser(EventExecutor[] eventExecutorArr) {
            this.executors = eventExecutorArr;
        }

        public EventExecutor next() {
            return this.executors[(int) Math.abs(this.idx.getAndIncrement() % ((long) this.executors.length))];
        }
    }

    public static final class PowerOfTwoEventExecutorChooser implements EventExecutorChooserFactory.EventExecutorChooser {
        private final EventExecutor[] executors;
        private final AtomicInteger idx = new AtomicInteger();

        public PowerOfTwoEventExecutorChooser(EventExecutor[] eventExecutorArr) {
            this.executors = eventExecutorArr;
        }

        public EventExecutor next() {
            return this.executors[(this.executors.length - 1) & this.idx.getAndIncrement()];
        }
    }

    private DefaultEventExecutorChooserFactory() {
    }

    private static boolean isPowerOfTwo(int i) {
        return ((-i) & i) == i;
    }

    public EventExecutorChooserFactory.EventExecutorChooser newChooser(EventExecutor[] eventExecutorArr) {
        return isPowerOfTwo(eventExecutorArr.length) ? new PowerOfTwoEventExecutorChooser(eventExecutorArr) : new GenericEventExecutorChooser(eventExecutorArr);
    }
}
