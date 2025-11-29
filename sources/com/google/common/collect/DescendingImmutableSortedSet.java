package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
final class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    private final ImmutableSortedSet<E> forward;

    public DescendingImmutableSortedSet(ImmutableSortedSet<E> immutableSortedSet) {
        super(Ordering.from(immutableSortedSet.comparator()).reverse());
        this.forward = immutableSortedSet;
    }

    public E ceiling(E e) {
        return this.forward.floor(e);
    }

    public boolean contains(@NullableDecl Object obj) {
        return this.forward.contains(obj);
    }

    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> createDescendingSet() {
        throw new AssertionError("should never be called");
    }

    public E floor(E e) {
        return this.forward.ceiling(e);
    }

    public ImmutableSortedSet<E> headSetImpl(E e, boolean z) {
        return this.forward.tailSet(e, z).descendingSet();
    }

    public E higher(E e) {
        return this.forward.lower(e);
    }

    public int indexOf(@NullableDecl Object obj) {
        int indexOf = this.forward.indexOf(obj);
        return indexOf == -1 ? indexOf : (size() - 1) - indexOf;
    }

    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    public E lower(E e) {
        return this.forward.higher(e);
    }

    public int size() {
        return this.forward.size();
    }

    public ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2) {
        return this.forward.subSet(e2, z2, e, z).descendingSet();
    }

    public ImmutableSortedSet<E> tailSetImpl(E e, boolean z) {
        return this.forward.headSet(e, z).descendingSet();
    }

    @GwtIncompatible("NavigableSet")
    public UnmodifiableIterator<E> descendingIterator() {
        return this.forward.iterator();
    }

    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> descendingSet() {
        return this.forward;
    }

    public UnmodifiableIterator<E> iterator() {
        return this.forward.descendingIterator();
    }
}
