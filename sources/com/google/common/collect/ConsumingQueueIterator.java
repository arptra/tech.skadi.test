package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

@GwtCompatible
class ConsumingQueueIterator<T> extends AbstractIterator<T> {
    private final Queue<T> queue;

    public ConsumingQueueIterator(T... tArr) {
        ArrayDeque arrayDeque = new ArrayDeque(tArr.length);
        this.queue = arrayDeque;
        Collections.addAll(arrayDeque, tArr);
    }

    public T computeNext() {
        return this.queue.isEmpty() ? endOfData() : this.queue.remove();
    }

    public ConsumingQueueIterator(Queue<T> queue2) {
        this.queue = (Queue) Preconditions.checkNotNull(queue2);
    }
}
