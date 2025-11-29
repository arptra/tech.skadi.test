package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class MpscAtomicArrayQueue<E> extends MpscAtomicArrayQueueL3Pad<E> {
    public MpscAtomicArrayQueue(int i) {
        super(i);
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        } else if (i >= 0) {
            if (i == 0) {
                return 0;
            }
            AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
            int i2 = this.mask;
            long lpConsumerIndex = lpConsumerIndex();
            for (int i3 = 0; i3 < i; i3++) {
                long j = ((long) i3) + lpConsumerIndex;
                int calcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(j, (long) i2);
                E lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
                if (lvRefElement == null) {
                    return i3;
                }
                AtomicQueueUtil.spRefElement(atomicReferenceArray, calcCircularRefElementOffset, null);
                soConsumerIndex(j + 1);
                consumer.accept(lvRefElement);
            }
            return i;
        } else {
            throw new IllegalArgumentException("limit is negative: " + i);
        }
    }

    public final int failFastOffer(E e) {
        if (e != null) {
            int i = this.mask;
            long j = (long) (i + 1);
            long lvProducerIndex = lvProducerIndex();
            if (lvProducerIndex >= lvProducerLimit()) {
                long lvConsumerIndex = lvConsumerIndex() + j;
                if (lvProducerIndex >= lvConsumerIndex) {
                    return 1;
                }
                soProducerLimit(lvConsumerIndex);
            }
            if (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
                return -1;
            }
            AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lvProducerIndex, (long) i), e);
            return 0;
        }
        throw null;
    }

    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        long lvProducerIndex;
        int min;
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        } else if (i >= 0) {
            if (i == 0) {
                return 0;
            }
            int i2 = this.mask;
            long j = (long) (i2 + 1);
            long lvProducerLimit = lvProducerLimit();
            do {
                lvProducerIndex = lvProducerIndex();
                long j2 = lvProducerLimit - lvProducerIndex;
                if (j2 <= 0) {
                    lvProducerLimit = lvConsumerIndex() + j;
                    j2 = lvProducerLimit - lvProducerIndex;
                    if (j2 <= 0) {
                        return 0;
                    }
                    soProducerLimit(lvProducerLimit);
                }
                min = Math.min((int) j2, i);
            } while (!casProducerIndex(lvProducerIndex, ((long) min) + lvProducerIndex));
            AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
            for (int i3 = 0; i3 < min; i3++) {
                AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(((long) i3) + lvProducerIndex, (long) i2), supplier.get());
            }
            return min;
        } else {
            throw new IllegalArgumentException("limit is negative:" + i);
        }
    }

    public boolean offer(E e) {
        long lvProducerIndex;
        if (e != null) {
            int i = this.mask;
            long lvProducerLimit = lvProducerLimit();
            do {
                lvProducerIndex = lvProducerIndex();
                if (lvProducerIndex >= lvProducerLimit) {
                    lvProducerLimit = lvConsumerIndex() + ((long) i) + 1;
                    if (lvProducerIndex >= lvProducerLimit) {
                        return false;
                    }
                    soProducerLimit(lvProducerLimit);
                }
            } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
            AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lvProducerIndex, (long) i), e);
            return true;
        }
        throw null;
    }

    public boolean offerIfBelowThreshold(E e, int i) {
        long lvProducerIndex;
        if (e != null) {
            int i2 = this.mask;
            long j = (long) (i2 + 1);
            long lvProducerLimit = lvProducerLimit();
            do {
                lvProducerIndex = lvProducerIndex();
                long j2 = (long) i;
                if (j - (lvProducerLimit - lvProducerIndex) >= j2) {
                    long lvConsumerIndex = lvConsumerIndex();
                    if (lvProducerIndex - lvConsumerIndex >= j2) {
                        return false;
                    }
                    lvProducerLimit = lvConsumerIndex + j;
                    soProducerLimit(lvProducerLimit);
                }
            } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
            AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lvProducerIndex, (long) i2), e);
            return true;
        }
        throw null;
    }

    public E peek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        int calcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex, (long) this.mask);
        E lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
        if (lvRefElement != null) {
            return lvRefElement;
        }
        if (lpConsumerIndex == lvProducerIndex()) {
            return null;
        }
        do {
            lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
        } while (lvRefElement == null);
        return lvRefElement;
    }

    public E poll() {
        long lpConsumerIndex = lpConsumerIndex();
        int calcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex, (long) this.mask);
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        E lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
        if (lvRefElement != null) {
            AtomicQueueUtil.spRefElement(atomicReferenceArray, calcCircularRefElementOffset, null);
            soConsumerIndex(lpConsumerIndex + 1);
        } else if (lpConsumerIndex == lvProducerIndex()) {
            return null;
        } else {
            do {
                lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
            } while (lvRefElement == null);
        }
        AtomicQueueUtil.spRefElement(atomicReferenceArray, calcCircularRefElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return lvRefElement;
    }

    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    public E relaxedPeek() {
        return AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex(), (long) this.mask));
    }

    public E relaxedPoll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        int calcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex, (long) this.mask);
        E lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, calcCircularRefElementOffset);
        if (lvRefElement == null) {
            return null;
        }
        AtomicQueueUtil.spRefElement(atomicReferenceArray, calcCircularRefElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return lvRefElement;
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Deprecated
    public int weakOffer(E e) {
        return failFastOffer(e);
    }

    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }

    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return MessagePassingQueueUtil.fillBounded(this, supplier);
    }

    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }
}
