package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;

public final class MessagePassingQueueUtil {
    public static <E> int drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer, int i) {
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        } else if (i >= 0) {
            int i2 = 0;
            if (i == 0) {
                return 0;
            }
            while (i2 < i) {
                E relaxedPoll = messagePassingQueue.relaxedPoll();
                if (relaxedPoll == null) {
                    break;
                }
                consumer.accept(relaxedPoll);
                i2++;
            }
            return i2;
        } else {
            throw new IllegalArgumentException("limit is negative: " + i);
        }
    }

    public static <E> void fill(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        if (waitStrategy == null) {
            throw new IllegalArgumentException("waiter is null");
        } else if (exitCondition != null) {
            while (true) {
                int i = 0;
                while (true) {
                    if (!exitCondition.keepRunning()) {
                        return;
                    }
                    if (messagePassingQueue.fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                        i = waitStrategy.idle(i);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("exit condition is null");
        }
    }

    public static <E> int fillBounded(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier) {
        return fillInBatchesToLimit(messagePassingQueue, supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH, messagePassingQueue.capacity());
    }

    public static <E> int fillInBatchesToLimit(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier, int i, int i2) {
        long j = 0;
        do {
            int fill = messagePassingQueue.fill(supplier, i);
            if (fill == 0) {
                return (int) j;
            }
            j += (long) fill;
        } while (j <= ((long) i2));
        return (int) j;
    }

    public static <E> int fillUnbounded(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Supplier<E> supplier) {
        return fillInBatchesToLimit(messagePassingQueue, supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH, 4096);
    }

    public static <E> int drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer) {
        if (consumer != null) {
            int i = 0;
            while (true) {
                E relaxedPoll = messagePassingQueue.relaxedPoll();
                if (relaxedPoll == null) {
                    return i;
                }
                i++;
                consumer.accept(relaxedPoll);
            }
        } else {
            throw new IllegalArgumentException("c is null");
        }
    }

    public static <E> void drain(MessagePassingQueue<E> messagePassingQueue, MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        } else if (waitStrategy == null) {
            throw new IllegalArgumentException("wait is null");
        } else if (exitCondition != null) {
            while (true) {
                int i = 0;
                while (exitCondition.keepRunning()) {
                    E relaxedPoll = messagePassingQueue.relaxedPoll();
                    if (relaxedPoll == null) {
                        i = waitStrategy.idle(i);
                    } else {
                        consumer.accept(relaxedPoll);
                    }
                }
                return;
            }
        } else {
            throw new IllegalArgumentException("exit condition is null");
        }
    }
}
