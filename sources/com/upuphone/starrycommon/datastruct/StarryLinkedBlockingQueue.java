package com.upuphone.starrycommon.datastruct;

import com.upuphone.starrycommon.datastruct.AbstractOrderProvider;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class StarryLinkedBlockingQueue<E extends AbstractOrderProvider> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    public static final int TYPE_HIGH = 1;
    public static final int TYPE_NORMAL = 0;
    private static final long serialVersionUID = -6903933977591709199L;
    private final int capacity;
    private final AtomicInteger count;
    transient Node<E> head;
    transient Node<E> headHigh;
    private transient Node<E> last;
    private transient Node<E> lastHigh;
    private final Condition notEmpty;
    private final Condition notFull;
    private final ReentrantLock putLock;
    private final ReentrantLock takeLock;

    public class Itr implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        public Node f6483a;
        public Node b;
        public AbstractOrderProvider c;

        public Itr() {
            StarryLinkedBlockingQueue.this.fullyLock();
            try {
                Node node = StarryLinkedBlockingQueue.this.head.b;
                this.f6483a = node;
                if (node != null) {
                    this.c = (AbstractOrderProvider) node.f6484a;
                }
            } finally {
                StarryLinkedBlockingQueue.this.fullyUnlock();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0018 A[Catch:{ all -> 0x0016 }] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0021 A[Catch:{ all -> 0x0016 }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0026 A[Catch:{ all -> 0x0016 }] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[Catch:{ all -> 0x0016 }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.upuphone.starrycommon.datastruct.AbstractOrderProvider next() {
            /*
                r2 = this;
                com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue r0 = com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue.this
                r0.fullyLock()
                com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue$Node r0 = r2.f6483a     // Catch:{ all -> 0x0016 }
                if (r0 == 0) goto L_0x0033
                r2.b = r0     // Catch:{ all -> 0x0016 }
            L_0x000b:
                com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue$Node r1 = r0.b     // Catch:{ all -> 0x0016 }
                if (r1 != r0) goto L_0x0018
                com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue r0 = com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue.this     // Catch:{ all -> 0x0016 }
                com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue$Node<E> r0 = r0.head     // Catch:{ all -> 0x0016 }
                com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue$Node r0 = r0.b     // Catch:{ all -> 0x0016 }
                goto L_0x0019
            L_0x0016:
                r0 = move-exception
                goto L_0x0039
            L_0x0018:
                r0 = r1
            L_0x0019:
                if (r0 == 0) goto L_0x001f
                java.lang.Object r1 = r0.f6484a     // Catch:{ all -> 0x0016 }
                if (r1 == 0) goto L_0x000b
            L_0x001f:
                if (r0 == 0) goto L_0x0026
                java.lang.Object r1 = r0.f6484a     // Catch:{ all -> 0x0016 }
                com.upuphone.starrycommon.datastruct.AbstractOrderProvider r1 = (com.upuphone.starrycommon.datastruct.AbstractOrderProvider) r1     // Catch:{ all -> 0x0016 }
                goto L_0x0027
            L_0x0026:
                r1 = 0
            L_0x0027:
                r2.f6483a = r0     // Catch:{ all -> 0x0016 }
                com.upuphone.starrycommon.datastruct.AbstractOrderProvider r0 = r2.c     // Catch:{ all -> 0x0016 }
                r2.c = r1     // Catch:{ all -> 0x0016 }
                com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue r2 = com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue.this
                r2.fullyUnlock()
                return r0
            L_0x0033:
                java.util.NoSuchElementException r0 = new java.util.NoSuchElementException     // Catch:{ all -> 0x0016 }
                r0.<init>()     // Catch:{ all -> 0x0016 }
                throw r0     // Catch:{ all -> 0x0016 }
            L_0x0039:
                com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue r2 = com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue.this
                r2.fullyUnlock()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue.Itr.next():com.upuphone.starrycommon.datastruct.AbstractOrderProvider");
        }

        public boolean hasNext() {
            return this.f6483a != null;
        }

        public void remove() {
            if (this.b != null) {
                StarryLinkedBlockingQueue.this.fullyLock();
                try {
                    Node<E> node = this.b;
                    this.b = null;
                    Node<E> node2 = StarryLinkedBlockingQueue.this.head;
                    Node<E> node3 = node2.b;
                    while (true) {
                        Node<E> node4 = node3;
                        Node<E> node5 = node2;
                        node2 = node4;
                        if (node2 == null) {
                            break;
                        } else if (node2 == node) {
                            StarryLinkedBlockingQueue.this.unlink(node2, node5);
                            break;
                        } else {
                            node3 = node2.b;
                        }
                    }
                } finally {
                    StarryLinkedBlockingQueue.this.fullyUnlock();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public static class Node<E> {

        /* renamed from: a  reason: collision with root package name */
        public Object f6484a;
        public Node b;

        public Node(Object obj) {
            this.f6484a = obj;
        }
    }

    public StarryLinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    private E dequeue() {
        Node<E> node = this.headHigh;
        Node<E> node2 = node.b;
        if (node2 != null) {
            node.b = node;
            this.headHigh = node2;
            E e = (AbstractOrderProvider) node2.f6484a;
            node2.f6484a = null;
            return e;
        }
        Node<E> node3 = this.head;
        Node<E> node4 = node3.b;
        node3.b = node3;
        this.head = node4;
        E e2 = (AbstractOrderProvider) node4.f6484a;
        node4.f6484a = null;
        return e2;
    }

    private void enqueue(Node<E> node) {
        if (((AbstractOrderProvider) node.f6484a).f6482a == 1) {
            this.lastHigh.b = node;
            this.lastHigh = node;
            return;
        }
        this.last.b = node;
        this.last = node;
    }

    private void signalNotEmpty() {
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            this.notEmpty.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void signalNotFull() {
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            this.notFull.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void clear() {
        fullyLock();
        try {
            Node<E> node = this.head;
            while (true) {
                Node<E> node2 = node.b;
                if (node2 == null) {
                    break;
                }
                node.b = node;
                node2.f6484a = null;
                node = node2;
            }
            this.head = this.last;
            Node<E> node3 = this.headHigh;
            while (true) {
                Node<E> node4 = node3.b;
                if (node4 == null) {
                    break;
                }
                node3.b = node3;
                node4.f6484a = null;
                node3 = node4;
            }
            this.headHigh = this.lastHigh;
            if (this.count.getAndSet(0) == this.capacity) {
                this.notFull.signal();
            }
            fullyUnlock();
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            Node<E> node = this.head;
            do {
                node = node.b;
                if (node == null) {
                    Node<E> node2 = this.headHigh;
                    do {
                        node2 = node2.b;
                        if (node2 == null) {
                            fullyUnlock();
                            return false;
                        }
                    } while (!obj.equals(node2.f6484a));
                    fullyUnlock();
                    return true;
                }
            } while (!obj.equals(node.f6484a));
            return true;
        } finally {
            fullyUnlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return 0;
    }

    public void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    public void fullyUnlock() {
        this.takeLock.unlock();
        this.putLock.unlock();
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    public int remainingCapacity() {
        return this.capacity - this.count.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        r1 = r6.headHigh;
        r2 = r1.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        r5 = r2;
        r2 = r1;
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        if (r1 == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (r7.equals(r1.f6484a) == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        unlink(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        fullyUnlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2 = r1.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        fullyUnlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0043, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r6.fullyLock()
            com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue$Node<E> r1 = r6.head     // Catch:{ all -> 0x0020 }
            com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue$Node r2 = r1.b     // Catch:{ all -> 0x0020 }
        L_0x000b:
            r5 = r2
            r2 = r1
            r1 = r5
            r3 = 1
            if (r1 == 0) goto L_0x0025
            java.lang.Object r4 = r1.f6484a     // Catch:{ all -> 0x0020 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x0020 }
            if (r4 == 0) goto L_0x0022
            r6.unlink(r1, r2)     // Catch:{ all -> 0x0020 }
            r6.fullyUnlock()
            return r3
        L_0x0020:
            r7 = move-exception
            goto L_0x0044
        L_0x0022:
            com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue$Node r2 = r1.b     // Catch:{ all -> 0x0020 }
            goto L_0x000b
        L_0x0025:
            com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue$Node<E> r1 = r6.headHigh     // Catch:{ all -> 0x0020 }
            com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue$Node r2 = r1.b     // Catch:{ all -> 0x0020 }
        L_0x0029:
            r5 = r2
            r2 = r1
            r1 = r5
            if (r1 == 0) goto L_0x0040
            java.lang.Object r4 = r1.f6484a     // Catch:{ all -> 0x0020 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x0020 }
            if (r4 == 0) goto L_0x003d
            r6.unlink(r1, r2)     // Catch:{ all -> 0x0020 }
            r6.fullyUnlock()
            return r3
        L_0x003d:
            com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue$Node r2 = r1.b     // Catch:{ all -> 0x0020 }
            goto L_0x0029
        L_0x0040:
            r6.fullyUnlock()
            return r0
        L_0x0044:
            r6.fullyUnlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrycommon.datastruct.StarryLinkedBlockingQueue.remove(java.lang.Object):boolean");
    }

    public int size() {
        return this.count.get();
    }

    public Object[] toArray() {
        fullyLock();
        try {
            Object[] objArr = new Object[this.count.get()];
            Node node = this.head.b;
            int i = 0;
            while (node != null) {
                objArr[i] = node.f6484a;
                node = node.b;
                i++;
            }
            Node node2 = this.headHigh.b;
            while (node2 != null) {
                int i2 = i + 1;
                objArr[i] = node2.f6484a;
                node2 = node2.b;
                i = i2;
            }
            fullyUnlock();
            return objArr;
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    public void unlink(Node<E> node, Node<E> node2) {
        node.f6484a = null;
        node2.b = node.b;
        if (this.last == node) {
            this.last = node2;
        } else if (this.lastHigh == node) {
            this.lastHigh = node;
        }
        if (this.count.getAndDecrement() == this.capacity) {
            this.notFull.signal();
        }
    }

    public StarryLinkedBlockingQueue(int i) {
        this.count = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.takeLock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.putLock = reentrantLock2;
        this.notFull = reentrantLock2.newCondition();
        if (i > 0) {
            this.capacity = i;
            Node<E> node = new Node<>((Object) null);
            this.head = node;
            this.last = node;
            Node<E> node2 = new Node<>((Object) null);
            this.headHigh = node2;
            this.lastHigh = node2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int drainTo(Collection<? super E> collection, int i) {
        return 0;
    }

    public E peek() {
        E e = null;
        if (this.count.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            if (this.count.get() > 0) {
                Node node = this.head.b;
                e = (AbstractOrderProvider) (node != null ? node.f6484a : this.headHigh.f6484a);
            }
            return e;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void put(E e) throws InterruptedException {
        e.getClass();
        Node node = new Node(e);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.capacity) {
            try {
                this.notFull.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        enqueue(node);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.capacity) {
            this.notFull.signal();
        }
        reentrantLock.unlock();
        if (andIncrement == 0) {
            signalNotEmpty();
        }
    }

    public E take() throws InterruptedException {
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.notEmpty.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E dequeue = dequeue();
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return dequeue;
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        e.getClass();
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.capacity) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        enqueue(new Node(e));
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.capacity) {
            this.notFull.signal();
        }
        reentrantLock.unlock();
        if (andIncrement != 0) {
            return true;
        }
        signalNotEmpty();
        return true;
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E dequeue = dequeue();
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return dequeue;
    }

    public <T> T[] toArray(T[] tArr) {
        fullyLock();
        try {
            int i = this.count.get();
            if (tArr.length < i) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            Node node = this.head.b;
            int i2 = 0;
            while (node != null) {
                tArr[i2] = node.f6484a;
                node = node.b;
                i2++;
            }
            Node node2 = this.headHigh.b;
            while (node2 != null) {
                tArr[i2] = node2.f6484a;
                node2 = node2.b;
                i2++;
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            fullyUnlock();
            return tArr;
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    public StarryLinkedBlockingQueue(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            Iterator<? extends E> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                AbstractOrderProvider abstractOrderProvider = (AbstractOrderProvider) it.next();
                if (abstractOrderProvider == null) {
                    throw new NullPointerException();
                } else if (i != this.capacity) {
                    enqueue(new Node(abstractOrderProvider));
                    i++;
                } else {
                    throw new IllegalStateException("Queue full");
                }
            }
            this.count.set(i);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public E poll() {
        int i;
        AtomicInteger atomicInteger = this.count;
        E e = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                e = dequeue();
                i = atomicInteger.getAndDecrement();
                if (i > 1) {
                    this.notEmpty.signal();
                }
            } else {
                i = -1;
            }
            reentrantLock.unlock();
            if (i == this.capacity) {
                signalNotFull();
            }
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean offer(E e) {
        int i;
        e.getClass();
        AtomicInteger atomicInteger = this.count;
        if (atomicInteger.get() == this.capacity) {
            return false;
        }
        Node node = new Node(e);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.capacity) {
                enqueue(node);
                i = atomicInteger.getAndIncrement();
                if (i + 1 < this.capacity) {
                    this.notFull.signal();
                }
            } else {
                i = -1;
            }
            if (i == 0) {
                signalNotEmpty();
            }
            if (i >= 0) {
                return true;
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }
}
