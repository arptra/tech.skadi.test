package org.eclipse.jetty.util;

import java.util.AbstractList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<E> extends AbstractList<E> implements Queue<E> {
    public static final int DEFAULT_CAPACITY = 64;
    public static final int DEFAULT_GROWTH = 32;
    protected Object[] _elements;
    protected final int _growCapacity;
    protected final Object _lock;
    protected int _nextE;
    protected int _nextSlot;
    protected int _size;

    public ArrayQueue() {
        this(64, -1);
    }

    private E at(int i) {
        return this._elements[i];
    }

    private E dequeue() {
        E at = at(this._nextE);
        Object[] objArr = this._elements;
        int i = this._nextE;
        objArr[i] = null;
        this._size--;
        int i2 = i + 1;
        this._nextE = i2;
        if (i2 == objArr.length) {
            this._nextE = 0;
        }
        return at;
    }

    private boolean enqueue(E e) {
        if (this._size == this._elements.length && !grow()) {
            return false;
        }
        this._size++;
        Object[] objArr = this._elements;
        int i = this._nextSlot;
        int i2 = i + 1;
        this._nextSlot = i2;
        objArr[i] = e;
        if (i2 == objArr.length) {
            this._nextSlot = 0;
        }
        return true;
    }

    public boolean add(E e) {
        if (offer(e)) {
            return true;
        }
        throw new IllegalStateException("Full");
    }

    public void addUnsafe(E e) {
        if (!enqueue(e)) {
            throw new IllegalStateException("Full");
        }
    }

    public void clear() {
        synchronized (this._lock) {
            this._size = 0;
            this._nextE = 0;
            this._nextSlot = 0;
        }
    }

    public E element() {
        E at;
        synchronized (this._lock) {
            try {
                if (!isEmpty()) {
                    at = at(this._nextE);
                } else {
                    throw new NoSuchElementException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return at;
    }

    public E get(int i) {
        E unsafe;
        synchronized (this._lock) {
            if (i >= 0) {
                try {
                    if (i < this._size) {
                        unsafe = getUnsafe(i);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
        }
        return unsafe;
    }

    public int getCapacity() {
        int length;
        synchronized (this._lock) {
            length = this._elements.length;
        }
        return length;
    }

    public E getUnsafe(int i) {
        return at((this._nextE + i) % this._elements.length);
    }

    public boolean grow() {
        synchronized (this._lock) {
            try {
                int i = this._growCapacity;
                if (i <= 0) {
                    return false;
                }
                Object[] objArr = this._elements;
                Object[] objArr2 = new Object[(objArr.length + i)];
                int length = objArr.length;
                int i2 = this._nextE;
                int i3 = length - i2;
                if (i3 > 0) {
                    System.arraycopy(objArr, i2, objArr2, 0, i3);
                }
                if (this._nextE != 0) {
                    System.arraycopy(this._elements, 0, objArr2, i3, this._nextSlot);
                }
                this._elements = objArr2;
                this._nextE = 0;
                this._nextSlot = this._size;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isEmpty() {
        boolean z;
        synchronized (this._lock) {
            z = this._size == 0;
        }
        return z;
    }

    public boolean offer(E e) {
        boolean enqueue;
        synchronized (this._lock) {
            enqueue = enqueue(e);
        }
        return enqueue;
    }

    public E peek() {
        synchronized (this._lock) {
            try {
                if (isEmpty()) {
                    return null;
                }
                E at = at(this._nextE);
                return at;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public E poll() {
        synchronized (this._lock) {
            try {
                if (this._size == 0) {
                    return null;
                }
                E dequeue = dequeue();
                return dequeue;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public E remove() {
        E dequeue;
        synchronized (this._lock) {
            try {
                if (this._size != 0) {
                    dequeue = dequeue();
                } else {
                    throw new NoSuchElementException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dequeue;
    }

    public E set(int i, E e) {
        E at;
        synchronized (this._lock) {
            if (i >= 0) {
                try {
                    if (i < this._size) {
                        int i2 = this._nextE + i;
                        Object[] objArr = this._elements;
                        if (i2 >= objArr.length) {
                            i2 -= objArr.length;
                        }
                        at = at(i2);
                        this._elements[i2] = e;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
        }
        return at;
    }

    public int size() {
        int i;
        synchronized (this._lock) {
            i = this._size;
        }
        return i;
    }

    public ArrayQueue(int i) {
        this(i, -1);
    }

    public ArrayQueue(int i, int i2) {
        this(i, i2, (Object) null);
    }

    public void add(int i, E e) {
        synchronized (this._lock) {
            if (i >= 0) {
                try {
                    int i2 = this._size;
                    if (i <= i2) {
                        if (i2 == this._elements.length) {
                            if (!grow()) {
                                throw new IllegalStateException("Full");
                            }
                        }
                        int i3 = this._size;
                        if (i == i3) {
                            add(e);
                        } else {
                            int i4 = this._nextE + i;
                            Object[] objArr = this._elements;
                            if (i4 >= objArr.length) {
                                i4 -= objArr.length;
                            }
                            this._size = i3 + 1;
                            int i5 = this._nextSlot + 1;
                            this._nextSlot = i5;
                            if (i5 == objArr.length) {
                                this._nextSlot = 0;
                            }
                            int i6 = this._nextSlot;
                            if (i4 < i6) {
                                System.arraycopy(objArr, i4, objArr, i4 + 1, i6 - i4);
                                this._elements[i4] = e;
                            } else {
                                if (i6 > 0) {
                                    System.arraycopy(objArr, 0, objArr, 1, i6);
                                    Object[] objArr2 = this._elements;
                                    objArr2[0] = objArr2[objArr2.length - 1];
                                }
                                Object[] objArr3 = this._elements;
                                System.arraycopy(objArr3, i4, objArr3, i4 + 1, (objArr3.length - i4) - 1);
                                this._elements[i4] = e;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
        }
    }

    public ArrayQueue(int i, int i2, Object obj) {
        this._lock = obj == null ? this : obj;
        this._growCapacity = i2;
        this._elements = new Object[i];
    }

    public E remove(int i) {
        E at;
        synchronized (this._lock) {
            if (i >= 0) {
                try {
                    if (i < this._size) {
                        int length = (this._nextE + i) % this._elements.length;
                        at = at(length);
                        int i2 = this._nextSlot;
                        if (length < i2) {
                            Object[] objArr = this._elements;
                            System.arraycopy(objArr, length + 1, objArr, length, i2 - length);
                            this._nextSlot--;
                            this._size--;
                        } else {
                            Object[] objArr2 = this._elements;
                            System.arraycopy(objArr2, length + 1, objArr2, length, (objArr2.length - length) - 1);
                            int i3 = this._nextSlot;
                            if (i3 > 0) {
                                Object[] objArr3 = this._elements;
                                objArr3[objArr3.length - 1] = objArr3[0];
                                System.arraycopy(objArr3, 1, objArr3, 0, i3 - 1);
                                this._nextSlot--;
                            } else {
                                this._nextSlot = this._elements.length - 1;
                            }
                            this._size--;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IndexOutOfBoundsException("!(0<" + i + "<=" + this._size + ")");
        }
        return at;
    }
}
