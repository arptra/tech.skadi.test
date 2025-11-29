package io.netty.channel.group;

import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class CombinedIterator<E> implements Iterator<E> {
    private Iterator<E> currentIterator;
    private final Iterator<E> i1;
    private final Iterator<E> i2;

    public CombinedIterator(Iterator<E> it, Iterator<E> it2) {
        this.i1 = (Iterator) ObjectUtil.checkNotNull(it, "i1");
        this.i2 = (Iterator) ObjectUtil.checkNotNull(it2, "i2");
        this.currentIterator = it;
    }

    public boolean hasNext() {
        while (!this.currentIterator.hasNext()) {
            if (this.currentIterator != this.i1) {
                return false;
            }
            this.currentIterator = this.i2;
        }
        return true;
    }

    public E next() {
        while (true) {
            try {
                return this.currentIterator.next();
            } catch (NoSuchElementException e) {
                if (this.currentIterator == this.i1) {
                    this.currentIterator = this.i2;
                } else {
                    throw e;
                }
            }
        }
    }

    public void remove() {
        this.currentIterator.remove();
    }
}
