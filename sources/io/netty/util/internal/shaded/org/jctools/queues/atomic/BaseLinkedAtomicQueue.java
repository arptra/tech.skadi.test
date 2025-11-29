package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.Iterator;

abstract class BaseLinkedAtomicQueue<E> extends BaseLinkedAtomicQueuePad2<E> {
    public int capacity() {
        return -1;
    }

    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        } else if (i >= 0) {
            int i2 = 0;
            if (i == 0) {
                return 0;
            }
            LinkedQueueAtomicNode lpConsumerNode = lpConsumerNode();
            while (i2 < i) {
                LinkedQueueAtomicNode lvNext = lpConsumerNode.lvNext();
                if (lvNext == null) {
                    return i2;
                }
                consumer.accept(getSingleConsumerNodeValue(lpConsumerNode, lvNext));
                i2++;
                lpConsumerNode = lvNext;
            }
            return i;
        } else {
            throw new IllegalArgumentException("limit is negative: " + i);
        }
    }

    public E getSingleConsumerNodeValue(LinkedQueueAtomicNode<E> linkedQueueAtomicNode, LinkedQueueAtomicNode<E> linkedQueueAtomicNode2) {
        E andNullValue = linkedQueueAtomicNode2.getAndNullValue();
        linkedQueueAtomicNode.soNext(linkedQueueAtomicNode);
        spConsumerNode(linkedQueueAtomicNode2);
        return andNullValue;
    }

    public boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final LinkedQueueAtomicNode<E> newNode() {
        return new LinkedQueueAtomicNode<>();
    }

    public E peek() {
        LinkedQueueAtomicNode lpConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode lvNext = lpConsumerNode.lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        if (lpConsumerNode != lvProducerNode()) {
            return spinWaitForNextNode(lpConsumerNode).lpValue();
        }
        return null;
    }

    public E poll() {
        LinkedQueueAtomicNode lpConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode lvNext = lpConsumerNode.lvNext();
        if (lvNext != null) {
            return getSingleConsumerNodeValue(lpConsumerNode, lvNext);
        }
        if (lpConsumerNode != lvProducerNode()) {
            return getSingleConsumerNodeValue(lpConsumerNode, spinWaitForNextNode(lpConsumerNode));
        }
        return null;
    }

    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    public E relaxedPeek() {
        LinkedQueueAtomicNode lvNext = lpConsumerNode().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    public E relaxedPoll() {
        LinkedQueueAtomicNode lpConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode lvNext = lpConsumerNode.lvNext();
        if (lvNext != null) {
            return getSingleConsumerNodeValue(lpConsumerNode, lvNext);
        }
        return null;
    }

    public final int size() {
        LinkedQueueAtomicNode lvConsumerNode = lvConsumerNode();
        LinkedQueueAtomicNode lvProducerNode = lvProducerNode();
        int i = 0;
        while (lvConsumerNode != lvProducerNode && lvConsumerNode != null && i < Integer.MAX_VALUE) {
            LinkedQueueAtomicNode lvNext = lvConsumerNode.lvNext();
            if (lvNext == lvConsumerNode) {
                return i;
            }
            i++;
            lvConsumerNode = lvNext;
        }
        return i;
    }

    public LinkedQueueAtomicNode<E> spinWaitForNextNode(LinkedQueueAtomicNode<E> linkedQueueAtomicNode) {
        LinkedQueueAtomicNode<E> lvNext;
        do {
            lvNext = linkedQueueAtomicNode.lvNext();
        } while (lvNext == null);
        return lvNext;
    }

    public String toString() {
        return getClass().getName();
    }

    public final LinkedQueueAtomicNode<E> newNode(E e) {
        return new LinkedQueueAtomicNode<>(e);
    }

    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return MessagePassingQueueUtil.drain(this, consumer);
    }

    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }
}
