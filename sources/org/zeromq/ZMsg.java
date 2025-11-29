package org.zeromq;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import org.zeromq.ZMQ;

public class ZMsg implements Iterable<ZFrame>, Deque<ZFrame> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque f3503a = new ArrayDeque();

    public static ZMsg x(ZMQ.Socket socket) {
        return y(socket, 0);
    }

    public static ZMsg y(ZMQ.Socket socket, int i) {
        ZFrame g;
        if (socket != null) {
            ZMsg zMsg = new ZMsg();
            do {
                g = ZFrame.g(socket, i);
                if (g == null) {
                    zMsg.f();
                    return null;
                }
                zMsg.add(g);
            } while (g.f());
            return zMsg;
        }
        throw new IllegalArgumentException("socket is null");
    }

    public static ZMsg z(ZMQ.Socket socket, boolean z) {
        return y(socket, z ^ true ? 1 : 0);
    }

    /* renamed from: A */
    public ZFrame remove() {
        return (ZFrame) this.f3503a.remove();
    }

    /* renamed from: B */
    public ZFrame removeFirst() {
        return (ZFrame) this.f3503a.pollFirst();
    }

    /* renamed from: C */
    public ZFrame removeLast() {
        return (ZFrame) this.f3503a.pollLast();
    }

    public boolean D(ZMQ.Socket socket) {
        return E(socket, true);
    }

    public boolean E(ZMQ.Socket socket, boolean z) {
        if (socket != null) {
            boolean z2 = true;
            if (this.f3503a.size() == 0) {
                return true;
            }
            Iterator it = this.f3503a.iterator();
            while (it.hasNext()) {
                z2 = ((ZFrame) it.next()).i(socket, it.hasNext() ? 2 : 0);
                if (!z2) {
                    break;
                }
            }
            if (z) {
                f();
            }
            return z2;
        }
        throw new IllegalArgumentException("socket is null");
    }

    public boolean a(String str) {
        return add(new ZFrame(str));
    }

    public boolean addAll(Collection collection) {
        return this.f3503a.addAll(collection);
    }

    /* renamed from: b */
    public boolean add(ZFrame zFrame) {
        return this.f3503a.add(zFrame);
    }

    public boolean c(byte[] bArr) {
        return add(new ZFrame(bArr));
    }

    public void clear() {
        this.f3503a.clear();
    }

    public boolean contains(Object obj) {
        return this.f3503a.contains(obj);
    }

    public boolean containsAll(Collection collection) {
        return this.f3503a.containsAll(collection);
    }

    /* renamed from: d */
    public void addFirst(ZFrame zFrame) {
        this.f3503a.addFirst(zFrame);
    }

    public Iterator descendingIterator() {
        return this.f3503a.descendingIterator();
    }

    /* renamed from: e */
    public void addLast(ZFrame zFrame) {
        this.f3503a.addLast(zFrame);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Iterator it = this.f3503a.iterator();
        Iterator it2 = ((ZMsg) obj).f3503a.iterator();
        while (it.hasNext() && it2.hasNext()) {
            ZFrame zFrame = (ZFrame) it.next();
            ZFrame zFrame2 = (ZFrame) it2.next();
            if (zFrame == null) {
                if (zFrame2 == null) {
                }
            } else if (!zFrame.equals(zFrame2)) {
            }
            return false;
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public void f() {
        Iterator it = this.f3503a.iterator();
        while (it.hasNext()) {
            ((ZFrame) it.next()).a();
        }
        this.f3503a.clear();
    }

    public ZMsg h() {
        if (this.f3503a.isEmpty()) {
            return null;
        }
        ZMsg zMsg = new ZMsg();
        Iterator it = this.f3503a.iterator();
        while (it.hasNext()) {
            zMsg.add(((ZFrame) it.next()).b());
        }
        return zMsg;
    }

    public int hashCode() {
        if (this.f3503a.isEmpty()) {
            return 0;
        }
        Iterator it = this.f3503a.iterator();
        int i = 1;
        while (it.hasNext()) {
            ZFrame zFrame = (ZFrame) it.next();
            i = (i * 31) + (zFrame == null ? 0 : zFrame.hashCode());
        }
        return i;
    }

    /* renamed from: i */
    public ZFrame element() {
        return (ZFrame) this.f3503a.element();
    }

    public boolean isEmpty() {
        return this.f3503a.isEmpty();
    }

    public Iterator iterator() {
        return this.f3503a.iterator();
    }

    /* renamed from: j */
    public ZFrame getFirst() {
        return (ZFrame) this.f3503a.peekFirst();
    }

    /* renamed from: k */
    public ZFrame getLast() {
        return (ZFrame) this.f3503a.peekLast();
    }

    /* renamed from: l */
    public boolean offer(ZFrame zFrame) {
        return this.f3503a.offer(zFrame);
    }

    /* renamed from: m */
    public boolean offerFirst(ZFrame zFrame) {
        return this.f3503a.offerFirst(zFrame);
    }

    /* renamed from: n */
    public boolean offerLast(ZFrame zFrame) {
        return this.f3503a.offerLast(zFrame);
    }

    /* renamed from: o */
    public ZFrame peek() {
        return (ZFrame) this.f3503a.peek();
    }

    /* renamed from: p */
    public ZFrame peekFirst() {
        return (ZFrame) this.f3503a.peekFirst();
    }

    /* renamed from: q */
    public ZFrame peekLast() {
        return (ZFrame) this.f3503a.peekLast();
    }

    /* renamed from: r */
    public ZFrame poll() {
        return (ZFrame) this.f3503a.poll();
    }

    public boolean removeAll(Collection collection) {
        return this.f3503a.removeAll(collection);
    }

    public boolean removeFirstOccurrence(Object obj) {
        return this.f3503a.removeFirstOccurrence(obj);
    }

    public boolean removeLastOccurrence(Object obj) {
        return this.f3503a.removeLastOccurrence(obj);
    }

    public boolean retainAll(Collection collection) {
        return this.f3503a.retainAll(collection);
    }

    /* renamed from: s */
    public ZFrame pollFirst() {
        return (ZFrame) this.f3503a.pollFirst();
    }

    public int size() {
        return this.f3503a.size();
    }

    /* renamed from: t */
    public ZFrame pollLast() {
        return (ZFrame) this.f3503a.pollLast();
    }

    public Object[] toArray() {
        return this.f3503a.toArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        Iterator it = this.f3503a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    /* renamed from: u */
    public ZFrame pop() {
        return (ZFrame) this.f3503a.poll();
    }

    public String v() {
        ZFrame u = pop();
        if (u == null) {
            return null;
        }
        return u.toString();
    }

    /* renamed from: w */
    public void push(ZFrame zFrame) {
        this.f3503a.push(zFrame);
    }

    public boolean remove(Object obj) {
        return this.f3503a.remove(obj);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f3503a.toArray(objArr);
    }
}
