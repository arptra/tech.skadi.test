package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;

public class SpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public SpscLinkedQueue() {
        LinkedQueueNode newNode = newNode();
        spProducerNode(newNode);
        spConsumerNode(newNode);
        newNode.soNext((LinkedQueueNode) null);
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
            LinkedQueueNode newNode = newNode(e);
            LinkedQueueNode lpProducerNode = lpProducerNode();
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
            LinkedQueueNode newNode = newNode(supplier.get());
            int i2 = 1;
            LinkedQueueNode linkedQueueNode = newNode;
            while (i2 < i) {
                LinkedQueueNode newNode2 = newNode(supplier.get());
                linkedQueueNode.spNext(newNode2);
                i2++;
                linkedQueueNode = newNode2;
            }
            LinkedQueueNode lpProducerNode = lpProducerNode();
            soProducerNode(linkedQueueNode);
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
