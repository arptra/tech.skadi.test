package io.netty.channel.nio;

import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class SelectedSelectionKeySet extends AbstractSet<SelectionKey> {
    SelectionKey[] keys = new SelectionKey[1024];
    int size;

    private void increaseCapacity() {
        SelectionKey[] selectionKeyArr = this.keys;
        SelectionKey[] selectionKeyArr2 = new SelectionKey[(selectionKeyArr.length << 1)];
        System.arraycopy(selectionKeyArr, 0, selectionKeyArr2, 0, this.size);
        this.keys = selectionKeyArr2;
    }

    public boolean contains(Object obj) {
        return false;
    }

    public Iterator<SelectionKey> iterator() {
        return new Iterator<SelectionKey>() {
            private int idx;

            public boolean hasNext() {
                return this.idx < SelectedSelectionKeySet.this.size;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public SelectionKey next() {
                if (hasNext()) {
                    SelectionKey[] selectionKeyArr = SelectedSelectionKeySet.this.keys;
                    int i = this.idx;
                    this.idx = i + 1;
                    return selectionKeyArr[i];
                }
                throw new NoSuchElementException();
            }
        };
    }

    public boolean remove(Object obj) {
        return false;
    }

    public void reset() {
        reset(0);
    }

    public int size() {
        return this.size;
    }

    public boolean add(SelectionKey selectionKey) {
        if (selectionKey == null) {
            return false;
        }
        SelectionKey[] selectionKeyArr = this.keys;
        int i = this.size;
        int i2 = i + 1;
        this.size = i2;
        selectionKeyArr[i] = selectionKey;
        if (i2 != selectionKeyArr.length) {
            return true;
        }
        increaseCapacity();
        return true;
    }

    public void reset(int i) {
        Arrays.fill(this.keys, i, this.size, (Object) null);
        this.size = 0;
    }
}
