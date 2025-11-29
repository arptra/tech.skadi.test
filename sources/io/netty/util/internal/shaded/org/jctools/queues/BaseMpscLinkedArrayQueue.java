package io.netty.util.internal.shaded.org.jctools.queues;

import com.here.posclient.UpdateOptions;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;

abstract class BaseMpscLinkedArrayQueue<E> extends BaseMpscLinkedArrayQueueColdProducerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
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
        private E[] currentBuffer;
        private int mask;
        private E nextElement = getNext();
        private long nextIndex;
        private final long pIndex;

        public WeakIterator(E[] eArr, long j, long j2) {
            this.pIndex = j2 >> 1;
            this.nextIndex = j >> 1;
            setBuffer(eArr);
        }

        private E getNext() {
            while (true) {
                long j = this.nextIndex;
                if (j >= this.pIndex) {
                    break;
                }
                this.nextIndex = 1 + j;
                E lvRefElement = UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(j, (long) this.mask));
                if (lvRefElement != null) {
                    if (lvRefElement == BaseMpscLinkedArrayQueue.JUMP) {
                        Object lvRefElement2 = UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcRefElementOffset((long) (this.mask + 1)));
                        if (lvRefElement2 == BaseMpscLinkedArrayQueue.BUFFER_CONSUMED || lvRefElement2 == null) {
                            break;
                        }
                        setBuffer((Object[]) lvRefElement2);
                        E lvRefElement3 = UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(j, (long) this.mask));
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

        private void setBuffer(E[] eArr) {
            this.currentBuffer = eArr;
            this.mask = LinkedArrayQueueUtil.length(eArr) - 2;
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

    public BaseMpscLinkedArrayQueue(int i) {
        RangeUtil.checkGreaterThanOrEqual(i, 2, "initialCapacity");
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        long j = (long) ((roundToPowerOfTwo - 1) << 1);
        E[] allocateRefArray = UnsafeRefArrayAccess.allocateRefArray(roundToPowerOfTwo + 1);
        this.producerBuffer = allocateRefArray;
        this.producerMask = j;
        this.consumerBuffer = allocateRefArray;
        this.consumerMask = j;
        soProducerLimit(j);
    }

    private E newBufferPeek(E[] eArr, long j) {
        E lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j, this.consumerMask));
        if (lvRefElement != null) {
            return lvRefElement;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(E[] eArr, long j) {
        long modifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j, this.consumerMask);
        E lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, modifiedCalcCircularRefElementOffset);
        if (lvRefElement != null) {
            UnsafeRefArrayAccess.soRefElement(eArr, modifiedCalcCircularRefElementOffset, null);
            soConsumerIndex(j + 2);
            return lvRefElement;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private static long nextArrayOffset(long j) {
        return LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j + 2, LongCompanionObject.MAX_VALUE);
    }

    private E[] nextBuffer(E[] eArr, long j) {
        long nextArrayOffset = nextArrayOffset(j);
        E[] eArr2 = (Object[]) UnsafeRefArrayAccess.lvRefElement(eArr, nextArrayOffset);
        this.consumerBuffer = eArr2;
        this.consumerMask = (long) ((LinkedArrayQueueUtil.length(eArr2) - 2) << 1);
        UnsafeRefArrayAccess.soRefElement(eArr, nextArrayOffset, BUFFER_CONSUMED);
        return eArr2;
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

    private void resize(long j, E[] eArr, long j2, E e, MessagePassingQueue.Supplier<E> supplier) {
        int nextBufferSize = getNextBufferSize(eArr);
        try {
            E[] allocateRefArray = UnsafeRefArrayAccess.allocateRefArray(nextBufferSize);
            this.producerBuffer = allocateRefArray;
            long j3 = (long) ((nextBufferSize - 2) << 1);
            this.producerMask = j3;
            long modifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j2, j);
            long modifiedCalcCircularRefElementOffset2 = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j2, j3);
            if (e == null) {
                e = supplier.get();
            }
            UnsafeRefArrayAccess.soRefElement(allocateRefArray, modifiedCalcCircularRefElementOffset2, e);
            UnsafeRefArrayAccess.soRefElement(eArr, nextArrayOffset(j), allocateRefArray);
            long availableInQueue = availableInQueue(j2, lvConsumerIndex());
            RangeUtil.checkPositive(availableInQueue, "availableInQueue");
            soProducerLimit(Math.min(j3, availableInQueue) + j2);
            soProducerIndex(j2 + 2);
            UnsafeRefArrayAccess.soRefElement(eArr, modifiedCalcCircularRefElementOffset, JUMP);
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

    public abstract int getNextBufferSize(E[] eArr);

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
                    E[] eArr = this.producerBuffer;
                    if (lvProducerLimit <= lvProducerIndex) {
                        int offerSlowPath = offerSlowPath(j, lvProducerIndex, lvProducerLimit);
                        if (offerSlowPath == 1) {
                            continue;
                        } else if (offerSlowPath == 2) {
                            return false;
                        } else {
                            if (offerSlowPath == 3) {
                                resize(j, eArr, lvProducerIndex, e, (MessagePassingQueue.Supplier) null);
                                return true;
                            }
                        }
                    }
                    if (casProducerIndex(lvProducerIndex, 2 + lvProducerIndex)) {
                        UnsafeRefArrayAccess.soRefElement(eArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(lvProducerIndex, j), e2);
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
            r10 = this;
            E[] r0 = r10.consumerBuffer
            long r1 = r10.lpConsumerIndex()
            long r3 = r10.consumerMask
            long r5 = io.netty.util.internal.shaded.org.jctools.queues.LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(r1, r3)
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r5)
            if (r7 != 0) goto L_0x0020
            long r8 = r10.lvProducerIndex()
            int r8 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x0020
        L_0x001a:
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r5)
            if (r7 == 0) goto L_0x001a
        L_0x0020:
            java.lang.Object r5 = JUMP
            if (r7 != r5) goto L_0x002d
            java.lang.Object[] r0 = r10.nextBuffer(r0, r3)
            java.lang.Object r10 = r10.newBufferPeek(r0, r1)
            return r10
        L_0x002d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.peek():java.lang.Object");
    }

    public E poll() {
        E[] eArr = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        long j = this.consumerMask;
        long modifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(lpConsumerIndex, j);
        E lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, modifiedCalcCircularRefElementOffset);
        if (lvRefElement == null) {
            if (lpConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, modifiedCalcCircularRefElementOffset);
            } while (lvRefElement == null);
        }
        if (lvRefElement == JUMP) {
            return newBufferPoll(nextBuffer(eArr, j), lpConsumerIndex);
        }
        UnsafeRefArrayAccess.soRefElement(eArr, modifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 2);
        return lvRefElement;
    }

    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    public E relaxedPeek() {
        E[] eArr = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        long j = this.consumerMask;
        E lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(lpConsumerIndex, j));
        return lvRefElement == JUMP ? newBufferPeek(nextBuffer(eArr, j), lpConsumerIndex) : lvRefElement;
    }

    public E relaxedPoll() {
        E[] eArr = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        long j = this.consumerMask;
        long modifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(lpConsumerIndex, j);
        E lvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, modifiedCalcCircularRefElementOffset);
        if (lvRefElement == null) {
            return null;
        }
        if (lvRefElement == JUMP) {
            return newBufferPoll(nextBuffer(eArr, j), lpConsumerIndex);
        }
        UnsafeRefArrayAccess.soRefElement(eArr, modifiedCalcCircularRefElementOffset, null);
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
                    E[] eArr = this.producerBuffer;
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
                                resize(j2, eArr, lvProducerIndex, (Object) null, supplier);
                                return 1;
                            }
                        }
                    } else {
                        j = min;
                    }
                    if (casProducerIndex(lvProducerIndex, j)) {
                        int i3 = (int) ((j - lvProducerIndex) / 2);
                        for (int i4 = 0; i4 < i3; i4++) {
                            UnsafeRefArrayAccess.soRefElement(eArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset((((long) i4) * 2) + lvProducerIndex, j2), supplier.get());
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
