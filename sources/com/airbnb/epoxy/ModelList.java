package com.airbnb.epoxy;

import androidx.annotation.NonNull;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class ModelList extends ArrayList<EpoxyModel<?>> {
    private boolean notificationsPaused;
    private ModelListObserver observer;

    public class Itr implements Iterator<EpoxyModel<?>> {

        /* renamed from: a  reason: collision with root package name */
        public int f2308a;
        public int b;
        public int c;

        public Itr() {
            this.b = -1;
            this.c = ModelList.this.modCount;
        }

        public final void a() {
            if (ModelList.this.modCount != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        /* renamed from: b */
        public EpoxyModel next() {
            a();
            int i = this.f2308a;
            this.f2308a = i + 1;
            this.b = i;
            return (EpoxyModel) ModelList.this.get(i);
        }

        public boolean hasNext() {
            return this.f2308a != ModelList.this.size();
        }

        public void remove() {
            if (this.b >= 0) {
                a();
                try {
                    ModelList.this.remove(this.b);
                    this.f2308a = this.b;
                    this.b = -1;
                    this.c = ModelList.this.modCount;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public class ListItr extends Itr implements ListIterator<EpoxyModel<?>> {
        public ListItr(int i) {
            super();
            this.f2308a = i;
        }

        /* renamed from: c */
        public void add(EpoxyModel epoxyModel) {
            a();
            try {
                int i = this.f2308a;
                ModelList.this.add(i, (EpoxyModel<?>) epoxyModel);
                this.f2308a = i + 1;
                this.b = -1;
                this.c = ModelList.this.modCount;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }

        /* renamed from: d */
        public EpoxyModel previous() {
            a();
            int i = this.f2308a - 1;
            if (i >= 0) {
                this.f2308a = i;
                this.b = i;
                return (EpoxyModel) ModelList.this.get(i);
            }
            throw new NoSuchElementException();
        }

        /* renamed from: e */
        public void set(EpoxyModel epoxyModel) {
            if (this.b >= 0) {
                a();
                try {
                    ModelList.this.set(this.b, (EpoxyModel<?>) epoxyModel);
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean hasPrevious() {
            return this.f2308a != 0;
        }

        public int nextIndex() {
            return this.f2308a;
        }

        public int previousIndex() {
            return this.f2308a - 1;
        }
    }

    public interface ModelListObserver {
        void a(int i, int i2);

        void b(int i, int i2);
    }

    public ModelList(int i) {
        super(i);
    }

    private void notifyInsertion(int i, int i2) {
        ModelListObserver modelListObserver;
        if (!this.notificationsPaused && (modelListObserver = this.observer) != null) {
            modelListObserver.a(i, i2);
        }
    }

    private void notifyRemoval(int i, int i2) {
        ModelListObserver modelListObserver;
        if (!this.notificationsPaused && (modelListObserver = this.observer) != null) {
            modelListObserver.b(i, i2);
        }
    }

    public boolean addAll(Collection<? extends EpoxyModel<?>> collection) {
        notifyInsertion(size(), collection.size());
        return super.addAll(collection);
    }

    public void clear() {
        if (!isEmpty()) {
            notifyRemoval(0, size());
            super.clear();
        }
    }

    @NonNull
    public Iterator<EpoxyModel<?>> iterator() {
        return new Itr();
    }

    @NonNull
    public ListIterator<EpoxyModel<?>> listIterator() {
        return new ListItr(0);
    }

    public void pauseNotifications() {
        if (!this.notificationsPaused) {
            this.notificationsPaused = true;
            return;
        }
        throw new IllegalStateException("Notifications already paused");
    }

    public boolean removeAll(Collection<?> collection) {
        Iterator<EpoxyModel<?>> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public void removeRange(int i, int i2) {
        if (i != i2) {
            notifyRemoval(i, i2 - i);
            super.removeRange(i, i2);
        }
    }

    public void resumeNotifications() {
        if (this.notificationsPaused) {
            this.notificationsPaused = false;
            return;
        }
        throw new IllegalStateException("Notifications already resumed");
    }

    public boolean retainAll(Collection<?> collection) {
        Iterator<EpoxyModel<?>> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public void setObserver(ModelListObserver modelListObserver) {
        this.observer = modelListObserver;
    }

    @NonNull
    public List<EpoxyModel<?>> subList(int i, int i2) {
        if (i < 0 || i2 > size()) {
            throw new IndexOutOfBoundsException();
        } else if (i <= i2) {
            return new SubList(this, i, i2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public ModelList() {
    }

    @NonNull
    public ListIterator<EpoxyModel<?>> listIterator(int i) {
        return new ListItr(i);
    }

    public EpoxyModel<?> remove(int i) {
        notifyRemoval(i, 1);
        return (EpoxyModel) super.remove(i);
    }

    public EpoxyModel<?> set(int i, EpoxyModel<?> epoxyModel) {
        EpoxyModel<?> epoxyModel2 = (EpoxyModel) super.set(i, epoxyModel);
        if (epoxyModel2.D() != epoxyModel.D()) {
            notifyRemoval(i, 1);
            notifyInsertion(i, 1);
        }
        return epoxyModel2;
    }

    public boolean add(EpoxyModel<?> epoxyModel) {
        notifyInsertion(size(), 1);
        return super.add(epoxyModel);
    }

    public boolean addAll(int i, Collection<? extends EpoxyModel<?>> collection) {
        notifyInsertion(i, collection.size());
        return super.addAll(i, collection);
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        notifyRemoval(indexOf, 1);
        super.remove(indexOf);
        return true;
    }

    public void add(int i, EpoxyModel<?> epoxyModel) {
        notifyInsertion(i, 1);
        super.add(i, epoxyModel);
    }

    public static class SubList extends AbstractList<EpoxyModel<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final ModelList f2309a;
        public int b;
        public int c;

        public static final class SubListIterator implements ListIterator<EpoxyModel<?>> {

            /* renamed from: a  reason: collision with root package name */
            public final SubList f2310a;
            public final ListIterator b;
            public int c;
            public int d;

            public SubListIterator(ListIterator listIterator, SubList subList, int i, int i2) {
                this.b = listIterator;
                this.f2310a = subList;
                this.c = i;
                this.d = i + i2;
            }

            /* renamed from: a */
            public void add(EpoxyModel epoxyModel) {
                this.b.add(epoxyModel);
                this.f2310a.e(true);
                this.d++;
            }

            /* renamed from: b */
            public EpoxyModel next() {
                if (this.b.nextIndex() < this.d) {
                    return (EpoxyModel) this.b.next();
                }
                throw new NoSuchElementException();
            }

            /* renamed from: c */
            public EpoxyModel previous() {
                if (this.b.previousIndex() >= this.c) {
                    return (EpoxyModel) this.b.previous();
                }
                throw new NoSuchElementException();
            }

            /* renamed from: d */
            public void set(EpoxyModel epoxyModel) {
                this.b.set(epoxyModel);
            }

            public boolean hasNext() {
                return this.b.nextIndex() < this.d;
            }

            public boolean hasPrevious() {
                return this.b.previousIndex() >= this.c;
            }

            public int nextIndex() {
                return this.b.nextIndex() - this.c;
            }

            public int previousIndex() {
                int previousIndex = this.b.previousIndex();
                int i = this.c;
                if (previousIndex >= i) {
                    return previousIndex - i;
                }
                return -1;
            }

            public void remove() {
                this.b.remove();
                this.f2310a.e(false);
                this.d--;
            }
        }

        public SubList(ModelList modelList, int i, int i2) {
            this.f2309a = modelList;
            this.modCount = modelList.modCount;
            this.b = i;
            this.c = i2 - i;
        }

        /* renamed from: a */
        public void add(int i, EpoxyModel epoxyModel) {
            if (this.modCount != this.f2309a.modCount) {
                throw new ConcurrentModificationException();
            } else if (i < 0 || i > this.c) {
                throw new IndexOutOfBoundsException();
            } else {
                this.f2309a.add(i + this.b, (EpoxyModel<?>) epoxyModel);
                this.c++;
                this.modCount = this.f2309a.modCount;
            }
        }

        public boolean addAll(int i, Collection collection) {
            if (this.modCount != this.f2309a.modCount) {
                throw new ConcurrentModificationException();
            } else if (i < 0 || i > this.c) {
                throw new IndexOutOfBoundsException();
            } else {
                boolean addAll = this.f2309a.addAll(i + this.b, collection);
                if (addAll) {
                    this.c += collection.size();
                    this.modCount = this.f2309a.modCount;
                }
                return addAll;
            }
        }

        /* renamed from: b */
        public EpoxyModel get(int i) {
            if (this.modCount != this.f2309a.modCount) {
                throw new ConcurrentModificationException();
            } else if (i >= 0 && i < this.c) {
                return (EpoxyModel) this.f2309a.get(i + this.b);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        /* renamed from: c */
        public EpoxyModel remove(int i) {
            if (this.modCount != this.f2309a.modCount) {
                throw new ConcurrentModificationException();
            } else if (i < 0 || i >= this.c) {
                throw new IndexOutOfBoundsException();
            } else {
                EpoxyModel<?> remove = this.f2309a.remove(i + this.b);
                this.c--;
                this.modCount = this.f2309a.modCount;
                return remove;
            }
        }

        /* renamed from: d */
        public EpoxyModel set(int i, EpoxyModel epoxyModel) {
            if (this.modCount != this.f2309a.modCount) {
                throw new ConcurrentModificationException();
            } else if (i >= 0 && i < this.c) {
                return this.f2309a.set(i + this.b, (EpoxyModel<?>) epoxyModel);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public void e(boolean z) {
            if (z) {
                this.c++;
            } else {
                this.c--;
            }
            this.modCount = this.f2309a.modCount;
        }

        public Iterator iterator() {
            return listIterator(0);
        }

        public ListIterator listIterator(int i) {
            if (this.modCount != this.f2309a.modCount) {
                throw new ConcurrentModificationException();
            } else if (i >= 0 && i <= this.c) {
                return new SubListIterator(this.f2309a.listIterator(i + this.b), this, this.b, this.c);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public void removeRange(int i, int i2) {
            if (i == i2) {
                return;
            }
            if (this.modCount == this.f2309a.modCount) {
                ModelList modelList = this.f2309a;
                int i3 = this.b;
                modelList.removeRange(i + i3, i3 + i2);
                this.c -= i2 - i;
                this.modCount = this.f2309a.modCount;
                return;
            }
            throw new ConcurrentModificationException();
        }

        public int size() {
            if (this.modCount == this.f2309a.modCount) {
                return this.c;
            }
            throw new ConcurrentModificationException();
        }

        public boolean addAll(Collection collection) {
            if (this.modCount == this.f2309a.modCount) {
                boolean addAll = this.f2309a.addAll(this.b + this.c, collection);
                if (addAll) {
                    this.c += collection.size();
                    this.modCount = this.f2309a.modCount;
                }
                return addAll;
            }
            throw new ConcurrentModificationException();
        }
    }
}
