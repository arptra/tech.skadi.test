package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import com.here.posclient.UpdateOptions;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.LongCompanionObject;

abstract class BaseMpscLinkedAtomicArrayQueue<E> extends BaseMpscLinkedAtomicArrayQueueColdProducerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final Object BUFFER_CONSUMED = new Object();
    private static final int CONTINUE_TO_P_INDEX_CAS = 0;
    /* access modifiers changed from: private */
    public static final Object JUMP = new Object();
    private static final int QUEUE_FULL = 2;
    private static final int QUEUE_RESIZE = 3;
    private static final int RETRY = 1;

    public static class WeakIterator<E> implements Iterator<E> {
        private AtomicReferenceArray<E> currentBuffer;
        private int mask;
        private E nextElement = getNext();
        private long nextIndex;
        private final long pIndex;

        public WeakIterator(AtomicReferenceArray<E> atomicReferenceArray, long j, long j2) {
            this.pIndex = j2 >> 1;
            this.nextIndex = j >> 1;
            setBuffer(atomicReferenceArray);
        }

        private E getNext() {
            while (true) {
                long j = this.nextIndex;
                if (j >= this.pIndex) {
                    break;
                }
                this.nextIndex = 1 + j;
                E lvRefElement = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(j, (long) this.mask));
                if (lvRefElement != null) {
                    if (lvRefElement == BaseMpscLinkedAtomicArrayQueue.JUMP) {
                        E lvRefElement2 = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcRefElementOffset((long) (this.mask + 1)));
                        if (lvRefElement2 == BaseMpscLinkedAtomicArrayQueue.BUFFER_CONSUMED || lvRefElement2 == null) {
                            break;
                        }
                        setBuffer((AtomicReferenceArray) lvRefElement2);
                        E lvRefElement3 = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(j, (long) this.mask));
                        if (lvRefElement3 != null) {
                            return lvRefElement3;
                        }
                    } else {
                        return lvRefElement;
                    }
                }
            }
            return null;
        }

        private void setBuffer(AtomicReferenceArray<E> atomicReferenceArray) {
            this.currentBuffer = atomicReferenceArray;
            this.mask = AtomicQueueUtil.length(atomicReferenceArray) - 2;
        }

        public boolean hasNext() {
            return this.nextElement != null;
        }

        public E next() {
            E e = this.nextElement;
            if (e != null) {
                this.nextElement = getNext();
                return e;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public BaseMpscLinkedAtomicArrayQueue(int i) {
        RangeUtil.checkGreaterThanOrEqual(i, 2, "initialCapacity");
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        long j = (long) ((roundToPowerOfTwo - 1) << 1);
        AtomicReferenceArray<E> allocateRefArray = AtomicQueueUtil.allocateRefArray(roundToPowerOfTwo + 1);
        this.producerBuffer = allocateRefArray;
        this.producerMask = j;
        this.consumerBuffer = allocateRefArray;
        this.consumerMask = j;
        soProducerLimit(j);
    }

    private E newBufferPeek(AtomicReferenceArray<E> atomicReferenceArray, long j) {
        E lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j, this.consumerMask));
        if (lvRefElement != null) {
            return lvRefElement;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(AtomicReferenceArray<E> atomicReferenceArray, long j) {
        int modifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j, this.consumerMask);
        E lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset);
        if (lvRefElement != null) {
            AtomicQueueUtil.soRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset, (Object) null);
            soConsumerIndex(j + 2);
            return lvRefElement;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private static int nextArrayOffset(long j) {
        return AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j + 2, LongCompanionObject.MAX_VALUE);
    }

    private AtomicReferenceArray<E> nextBuffer(AtomicReferenceArray<E> atomicReferenceArray, long j) {
        int nextArrayOffset = nextArrayOffset(j);
        AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray) AtomicQueueUtil.lvRefElement(atomicReferenceArray, nextArrayOffset);
        this.consumerBuffer = atomicReferenceArray2;
        this.consumerMask = (long) ((AtomicQueueUtil.length(atomicReferenceArray2) - 2) << 1);
        AtomicQueueUtil.soRefElement(atomicReferenceArray, nextArrayOffset, BUFFER_CONSUMED);
        return atomicReferenceArray2;
    }

    private int offerSlowPath(long j, long j2, long j3) {
        long lvConsumerIndex = lvConsumerIndex();
        long currentBufferCapacity = getCurrentBufferCapacity(j) + lvConsumerIndex;
        if (currentBufferCapacity > j2) {
            return !casProducerLimit(j3, currentBufferCapacity) ? 1 : 0;
        }
        if (availableInQueue(j2, lvConsumerIndex) <= 0) {
            return 2;
        }
        return casProducerIndex(j2, 1 + j2) ? 3 : 1;
    }

    private void resize(long j, AtomicReferenceArray<E> atomicReferenceArray, long j2, E e, MessagePassingQueue.Supplier<E> supplier) {
        int nextBufferSize = getNextBufferSize(atomicReferenceArray);
        try {
            AtomicReferenceArray<E> allocateRefArray = AtomicQueueUtil.allocateRefArray(nextBufferSize);
            this.producerBuffer = allocateRefArray;
            long j3 = (long) ((nextBufferSize - 2) << 1);
            this.producerMask = j3;
            int modifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j2, j);
            int modifiedCalcCircularRefElementOffset2 = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j2, j3);
            if (e == null) {
                e = supplier.get();
            }
            AtomicQueueUtil.soRefElement(allocateRefArray, modifiedCalcCircularRefElementOffset2, e);
            AtomicQueueUtil.soRefElement(atomicReferenceArray, nextArrayOffset(j), allocateRefArray);
            long availableInQueue = availableInQueue(j2, lvConsumerIndex());
            RangeUtil.checkPositive(availableInQueue, "availableInQueue");
            soProducerLimit(Math.min(j3, availableInQueue) + j2);
            soProducerIndex(j2 + 2);
            AtomicQueueUtil.soRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset, JUMP);
        } catch (OutOfMemoryError e2) {
            soProducerIndex(j2);
            throw e2;
        }
    }

    public abstract long availableInQueue(long j, long j2);

    public abstract int capacity();

    public long currentConsumerIndex() {
        return lvConsumerIndex() / 2;
    }

    public long currentProducerIndex() {
        return lvProducerIndex() / 2;
    }

    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        int capacity = capacity();
        long j = 0;
        do {
            int fill = fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if (fill == 0) {
                return (int) j;
            }
            j += (long) fill;
        } while (j <= ((long) capacity));
        return (int) j;
    }

    public abstract long getCurrentBufferCapacity(long j);

    public abstract int getNextBufferSize(AtomicReferenceArray<E> atomicReferenceArray);

    public boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }

    public Iterator<E> iterator() {
        return new WeakIterator(this.consumerBuffer, lvConsumerIndex(), lvProducerIndex());
    }

    public boolean offer(E e) {
        E e2 = e;
        if (e2 != null) {
            while (true) {
                long lvProducerLimit = lvProducerLimit();
                long lvProducerIndex = lvProducerIndex();
                if ((lvProducerIndex & 1) != 1) {
                    long j = this.producerMask;
                    AtomicReferenceArray<E> atomicReferenceArray = this.producerBuffer;
                    if (lvProducerLimit <= lvProducerIndex) {
                        int offerSlowPath = offerSlowPath(j, lvProducerIndex, lvProducerLimit);
                        if (offerSlowPath == 1) {
                            continue;
                        } else if (offerSlowPath == 2) {
                            return false;
                        } else {
                            if (offerSlowPath == 3) {
                                resize(j, atomicReferenceArray, lvProducerIndex, e, (MessagePassingQueue.Supplier) null);
                                return true;
                            }
                        }
                    }
                    if (casProducerIndex(lvProducerIndex, 2 + lvProducerIndex)) {
                        AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(lvProducerIndex, j), e2);
                        return true;
                    }
                }
            }
        } else {
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E peek() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicReferenceArray<E> r0 = r9.consumerBuffer
            long r1 = r9.lpConsumerIndex()
            long r3 = r9.consumerMask
            int r5 = io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.modifiedCalcCircularRefElementOffset(r1, r3)
            java.lang.Object r6 = io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r5)
            if (r6 != 0) goto L_0x0020
            long r7 = r9.lvProducerIndex()
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0020
        L_0x001a:
            java.lang.Object r6 = io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r5)
            if (r6 == 0) goto L_0x001a
        L_0x0020:
            java.lang.Object r5 = JUMP
            if (r6 != r5) goto L_0x002d
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r9.nextBuffer(r0, r3)
            java.lang.Object r9 = r9.newBufferPeek(r0, r1)
            return r9
        L_0x002d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.peek():java.lang.Object");
    }

    public E poll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        long j = this.consumerMask;
        int modifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(lpConsumerIndex, j);
        E lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset);
        if (lvRefElement == null) {
            if (lpConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset);
            } while (lvRefElement == null);
        }
        if (lvRefElement == JUMP) {
            return newBufferPoll(nextBuffer(atomicReferenceArray, j), lpConsumerIndex);
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset, (Object) null);
        soConsumerIndex(lpConsumerIndex + 2);
        return lvRefElement;
    }

    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    public E relaxedPeek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        long j = this.consumerMask;
        E lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(lpConsumerIndex, j));
        return lvRefElement == JUMP ? newBufferPeek(nextBuffer(atomicReferenceArray, j), lpConsumerIndex) : lvRefElement;
    }

    public E relaxedPoll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        long j = this.consumerMask;
        int modifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(lpConsumerIndex, j);
        E lvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset);
        if (lvRefElement == null) {
            return null;
        }
        if (lvRefElement == JUMP) {
            return newBufferPoll(nextBuffer(atomicReferenceArray, j), lpConsumerIndex);
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray, modifiedCalcCircularRefElementOffset, (Object) null);
        soConsumerIndex(lpConsumerIndex + 2);
        return lvRefElement;
    }

    public int size() {
        long lvProducerIndex;
        long lvConsumerIndex;
        long lvConsumerIndex2 = lvConsumerIndex();
        while (true) {
            lvProducerIndex = lvProducerIndex();
            lvConsumerIndex = lvConsumerIndex();
            if (lvConsumerIndex2 == lvConsumerIndex) {
                break;
            }
            lvConsumerIndex2 = lvConsumerIndex;
        }
        long j = (lvProducerIndex - lvConsumerIndex) >> 1;
        if (j > UpdateOptions.SOURCE_ANY) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public String toString() {
        return getClass().getName();
    }

    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        return MessagePassingQueueUtil.drain(this, consumer, i);
    }

    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }

    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        long j;
        int i2 = i;
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        } else if (i2 >= 0) {
            if (i2 == 0) {
                return 0;
            }
            while (true) {
                long lvProducerLimit = lvProducerLimit();
                long lvProducerIndex = lvProducerIndex();
                if ((lvProducerIndex & 1) != 1) {
                    long j2 = this.producerMask;
                    AtomicReferenceArray<E> atomicReferenceArray = this.producerBuffer;
                    long min = Math.min(lvProducerLimit, (((long) i2) * 2) + lvProducerIndex);
                    if (lvProducerIndex >= lvProducerLimit) {
                        long j3 = min;
                        int offerSlowPath = offerSlowPath(j2, lvProducerIndex, lvProducerLimit);
                        if (!(offerSlowPath == 0 || offerSlowPath == 1)) {
                            if (offerSlowPath == 2) {
                                return 0;
                            }
                            if (offerSlowPath != 3) {
                                j = j3;
                            } else {
                                resize(j2, atomicReferenceArray, lvProducerIndex, (Object) null, supplier);
                                return 1;
                            }
                        }
                    } else {
                        j = min;
                    }
                    if (casProducerIndex(lvProducerIndex, j)) {
                        int i3 = (int) ((j - lvProducerIndex) / 2);
                        for (int i4 = 0; i4 < i3; i4++) {
                            AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset((((long) i4) * 2) + lvProducerIndex, j2), supplier.get());
                        }
                        return i3;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("limit is negative:" + i2);
        }
    }

    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }
}
