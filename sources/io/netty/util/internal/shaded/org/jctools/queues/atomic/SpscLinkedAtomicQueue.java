package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;

public class SpscLinkedAtomicQueue<E> extends BaseLinkedAtomicQueue<E> {
    public SpscLinkedAtomicQueue() {
        LinkedQueueAtomicNode newNode = newNode();
        spProducerNode(newNode);
        spConsumerNode(newNode);
        newNode.soNext((LinkedQueueAtomicNode) null);
    }

    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return super.drain(consumer);
    }

    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return MessagePassingQueueUtil.fillUnbounded(this, supplier);
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean offer(E e) {
        if (e != null) {
            LinkedQueueAtomicNode newNode = newNode(e);
            LinkedQueueAtomicNode lpProducerNode = lpProducerNode();
            soProducerNode(newNode);
            lpProducerNode.soNext(newNode);
            return true;
        }
        throw null;
    }

    public /* bridge */ /* synthetic */ Object peek() {
        return super.peek();
    }

    public /* bridge */ /* synthetic */ Object poll() {
        return super.poll();
    }

    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return super.relaxedOffer(obj);
    }

    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return super.relaxedPeek();
    }

    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return super.relaxedPoll();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return super.drain(consumer, i);
    }

    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        } else if (i < 0) {
            throw new IllegalArgumentException("limit is negative:" + i);
        } else if (i == 0) {
            return 0;
        } else {
            LinkedQueueAtomicNode newNode = newNode(supplier.get());
            int i2 = 1;
            LinkedQueueAtomicNode linkedQueueAtomicNode = newNode;
            while (i2 < i) {
                LinkedQueueAtomicNode newNode2 = newNode(supplier.get());
                linkedQueueAtomicNode.spNext(newNode2);
                i2++;
                linkedQueueAtomicNode = newNode2;
            }
            LinkedQueueAtomicNode lpProducerNode = lpProducerNode();
            soProducerNode(linkedQueueAtomicNode);
            lpProducerNode.soNext(newNode);
            return i;
        }
    }

    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.drain(consumer, waitStrategy, exitCondition);
    }

    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }
}
