package com.airbnb.epoxy;

import androidx.collection.LongSparseArray;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BoundViewHolders implements Iterable<EpoxyViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final LongSparseArray f2273a = new LongSparseArray();

    public class HolderIterator implements Iterator<EpoxyViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public int f2274a;

        public HolderIterator() {
            this.f2274a = 0;
        }

        /* renamed from: a */
        public EpoxyViewHolder next() {
            if (hasNext()) {
                LongSparseArray a2 = BoundViewHolders.this.f2273a;
                int i = this.f2274a;
                this.f2274a = i + 1;
                return (EpoxyViewHolder) a2.valueAt(i);
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.f2274a < BoundViewHolders.this.f2273a.size();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public void b(EpoxyViewHolder epoxyViewHolder) {
        this.f2273a.put(epoxyViewHolder.getItemId(), epoxyViewHolder);
    }

    public void c(EpoxyViewHolder epoxyViewHolder) {
        this.f2273a.remove(epoxyViewHolder.getItemId());
    }

    public Iterator iterator() {
        return new HolderIterator();
    }

    public int size() {
        return this.f2273a.size();
    }
}
