package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.util.Iterator;

public class MpscArrayQueue<E> extends MpscArrayQueueL3Pad<E> {
    public MpscArrayQueue(int i) {
        super(i);
    }

    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return super.currentConsumerIndex();
    }

    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return super.currentProducerIndex();
    }

    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        } else if (i >= 0) {
            if (i == 0) {
                return 0;
            }
            E[] eArr = this.buffer;
            long j = this.mask;
            long lpConsumerIndex = lpConsumerIndex();
            for (int i2 = 0; i2 < i; i2++) {
                long j2 = ((long) i2) + lpConsumerIndex;
                long calcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(j2, j);
                Object lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
                if (lvRefElement == null) {
                    return i2;
                }
                UnsafeRefArrayAccess.spRefElement(eArr, calcCircularRefElementOffset, null);
                soConsumerIndex(j2 + 1);
                consumer.accept(lvRefElement);
            }
            return i;
        } else {
            throw new IllegalArgumentException("limit is negative: " + i);
        }
    }

    public final int failFastOffer(E e) {
        if (e != null) {
            long j = this.mask;
            long j2 = j + 1;
            long lvProducerIndex = lvProducerIndex();
            if (lvProducerIndex >= lvProducerLimit()) {
                long lvConsumerIndex = lvConsumerIndex() + j2;
                if (lvProducerIndex >= lvConsumerIndex) {
                    return 1;
                }
                soProducerLimit(lvConsumerIndex);
            }
            if (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
                return -1;
            }
            UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(lvProducerIndex, j), e);
            return 0;
        }
        throw null;
    }

    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        long lvProducerIndex;
        int min;
        int i2 = i;
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        } else if (i2 >= 0) {
            if (i2 == 0) {
                return 0;
            }
            long j = this.mask;
            long j2 = 1 + j;
            long lvProducerLimit = lvProducerLimit();
            do {
                lvProducerIndex = lvProducerIndex();
                long j3 = lvProducerLimit - lvProducerIndex;
                if (j3 <= 0) {
                    lvProducerLimit = lvConsumerIndex() + j2;
                    j3 = lvProducerLimit - lvProducerIndex;
                    if (j3 <= 0) {
                        return 0;
                    }
                    soProducerLimit(lvProducerLimit);
                }
                min = Math.min((int) j3, i2);
            } while (!casProducerIndex(lvProducerIndex, ((long) min) + lvProducerIndex));
            E[] eArr = this.buffer;
            for (int i3 = 0; i3 < min; i3++) {
                UnsafeRefArrayAccess.soRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(((long) i3) + lvProducerIndex, j), supplier.get());
            }
            return min;
        } else {
            throw new IllegalArgumentException("limit is negative:" + i2);
        }
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public boolean offer(E e) {
        long lvProducerIndex;
        if (e != null) {
            long j = this.mask;
            long lvProducerLimit = lvProducerLimit();
            do {
                lvProducerIndex = lvProducerIndex();
                if (lvProducerIndex >= lvProducerLimit) {
                    lvProducerLimit = lvConsumerIndex() + j + 1;
                    if (lvProducerIndex >= lvProducerLimit) {
                        return false;
                    }
                    soProducerLimit(lvProducerLimit);
                }
            } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
            UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(lvProducerIndex, j), e);
            return true;
        }
        throw null;
    }

    public boolean offerIfBelowThreshold(E e, int i) {
        long lvProducerIndex;
        E e2 = e;
        if (e2 != null) {
            long j = this.mask;
            long j2 = j + 1;
            long lvProducerLimit = lvProducerLimit();
            do {
                lvProducerIndex = lvProducerIndex();
                long j3 = (long) i;
                if (j2 - (lvProducerLimit - lvProducerIndex) >= j3) {
                    long lvConsumerIndex = lvConsumerIndex();
                    if (lvProducerIndex - lvConsumerIndex >= j3) {
                        return false;
                    }
                    lvProducerLimit = lvConsumerIndex + j2;
                    soProducerLimit(lvProducerLimit);
                }
            } while (!casProducerIndex(lvProducerIndex, lvProducerIndex + 1));
            UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(lvProducerIndex, j), e2);
            return true;
        }
        throw null;
    }

    public E peek() {
        E[] eArr = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        long calcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex, this.mask);
        E lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
        if (lvRefElement != null) {
            return lvRefElement;
        }
        if (lpConsumerIndex == lvProducerIndex()) {
            return null;
        }
        do {
            lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
        } while (lvRefElement == null);
        return lvRefElement;
    }

    public E poll() {
        long lpConsumerIndex = lpConsumerIndex();
        long calcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex, this.mask);
        E[] eArr = this.buffer;
        E lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
        if (lvRefElement != null) {
            UnsafeRefArrayAccess.spRefElement(eArr, calcCircularRefElementOffset, null);
            soConsumerIndex(lpConsumerIndex + 1);
        } else if (lpConsumerIndex == lvProducerIndex()) {
            return null;
        } else {
            do {
                lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
            } while (lvRefElement == null);
        }
        UnsafeRefArrayAccess.spRefElement(eArr, calcCircularRefElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return lvRefElement;
    }

    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    public E relaxedPeek() {
        return UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex(), this.mask));
    }

    public E relaxedPoll() {
        E[] eArr = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        long calcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex, this.mask);
        E lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, calcCircularRefElementOffset);
        if (lvRefElement == null) {
            return null;
        }
        UnsafeRefArrayAccess.spRefElement(eArr, calcCircularRefElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return lvRefElement;
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
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
