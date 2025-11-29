package com.xingin.xhssharesdk.a;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class w<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public static final /* synthetic */ int f = 0;

    /* renamed from: a  reason: collision with root package name */
    public final int f8147a;
    public List b;
    public Map c;
    public boolean d;
    public volatile d e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0030a f8148a = new C0030a();
        public static final b b = new b();

        /* renamed from: com.xingin.xhssharesdk.a.w$a$a  reason: collision with other inner class name */
        public static class C0030a implements Iterator<Object> {
            public final boolean hasNext() {
                return false;
            }

            public final Object next() {
                throw new NoSuchElementException();
            }

            public final void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public static class b implements Iterable<Object> {
            public final Iterator iterator() {
                return a.f8148a;
            }
        }
    }

    public class b implements Map.Entry<K, V>, Comparable<w<K, V>.b> {

        /* renamed from: a  reason: collision with root package name */
        public final Comparable f8149a;
        public Object b;

        public b(Comparable comparable, Object obj) {
            this.f8149a = comparable;
            this.b = obj;
        }

        public final int compareTo(Object obj) {
            return this.f8149a.compareTo(((b) obj).f8149a);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Comparable comparable = this.f8149a;
            Object key = entry.getKey();
            if (comparable == null ? key == null : comparable.equals(key)) {
                Object obj2 = this.b;
                Object value = entry.getValue();
                if (obj2 == null ? value == null : obj2.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        public final Object getKey() {
            return this.f8149a;
        }

        public final Object getValue() {
            return this.b;
        }

        public final int hashCode() {
            Comparable comparable = this.f8149a;
            int i = 0;
            int hashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.b;
            if (obj != null) {
                i = obj.hashCode();
            }
            return hashCode ^ i;
        }

        public final Object setValue(Object obj) {
            w wVar = w.this;
            int i = w.f;
            wVar.e();
            Object obj2 = this.b;
            this.b = obj;
            return obj2;
        }

        public final String toString() {
            return this.f8149a + "=" + this.b;
        }
    }

    public class c implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        public int f8150a = -1;
        public boolean b;
        public Iterator c;

        public c() {
        }

        public final boolean hasNext() {
            if (this.f8150a + 1 < w.this.b.size()) {
                return true;
            }
            if (this.c == null) {
                this.c = w.this.c.entrySet().iterator();
            }
            return this.c.hasNext();
        }

        public final Object next() {
            this.b = true;
            int i = this.f8150a + 1;
            this.f8150a = i;
            if (i < w.this.b.size()) {
                return (Map.Entry) w.this.b.get(this.f8150a);
            }
            if (this.c == null) {
                this.c = w.this.c.entrySet().iterator();
            }
            return (Map.Entry) this.c.next();
        }

        public final void remove() {
            if (this.b) {
                this.b = false;
                w wVar = w.this;
                int i = w.f;
                wVar.e();
                if (this.f8150a < w.this.b.size()) {
                    w wVar2 = w.this;
                    int i2 = this.f8150a;
                    this.f8150a = i2 - 1;
                    wVar2.e();
                    Object obj = ((b) wVar2.b.remove(i2)).b;
                    if (!wVar2.c.isEmpty()) {
                        wVar2.e();
                        if (wVar2.c.isEmpty() && !(wVar2.c instanceof TreeMap)) {
                            wVar2.c = new TreeMap();
                        }
                        Iterator it = ((SortedMap) wVar2.c).entrySet().iterator();
                        List list = wVar2.b;
                        Map.Entry entry = (Map.Entry) it.next();
                        list.add(new b((Comparable) entry.getKey(), entry.getValue()));
                        it.remove();
                        return;
                    }
                    return;
                }
                if (this.c == null) {
                    this.c = w.this.c.entrySet().iterator();
                }
                this.c.remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        public final boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            w.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public final void clear() {
            w.this.clear();
        }

        public final boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = w.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public final Iterator iterator() {
            return new c();
        }

        public final boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            w.this.remove(entry.getKey());
            return true;
        }

        public final int size() {
            return w.this.size();
        }
    }

    public w(int i) {
        this.f8147a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
    }

    public static v c(int i) {
        return new v(i);
    }

    public final int a(Comparable comparable) {
        int i;
        int size = this.b.size();
        int i2 = size - 1;
        if (i2 >= 0) {
            int compareTo = comparable.compareTo(((b) this.b.get(i2)).f8149a);
            if (compareTo > 0) {
                i = size + 1;
                return -i;
            } else if (compareTo == 0) {
                return i2;
            }
        }
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int compareTo2 = comparable.compareTo(((b) this.b.get(i4)).f8149a);
            if (compareTo2 < 0) {
                i2 = i4 - 1;
            } else if (compareTo2 <= 0) {
                return i4;
            } else {
                i3 = i4 + 1;
            }
        }
        i = i3 + 1;
        return -i;
    }

    public final void clear() {
        e();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.c.containsKey(comparable);
    }

    /* renamed from: d */
    public final Object put(Comparable comparable, Object obj) {
        e();
        int a2 = a(comparable);
        if (a2 >= 0) {
            return ((b) this.b.get(a2)).setValue(obj);
        }
        e();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.f8147a);
        }
        int i = -(a2 + 1);
        if (i >= this.f8147a) {
            e();
            if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
                this.c = new TreeMap();
            }
            return ((SortedMap) this.c).put(comparable, obj);
        }
        int size = this.b.size();
        int i2 = this.f8147a;
        if (size == i2) {
            b bVar = (b) this.b.remove(i2 - 1);
            e();
            if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
                this.c = new TreeMap();
            }
            ((SortedMap) this.c).put(bVar.f8149a, bVar.b);
        }
        this.b.add(i, new b(comparable, obj));
        return null;
    }

    public final void e() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    public final Set entrySet() {
        if (this.e == null) {
            this.e = new d();
        }
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return super.equals(obj);
        }
        w wVar = (w) obj;
        int size = size();
        if (size != wVar.size()) {
            return false;
        }
        int size2 = this.b.size();
        if (size2 != wVar.b.size()) {
            return ((AbstractSet) entrySet()).equals(wVar.entrySet());
        }
        for (int i = 0; i < size2; i++) {
            if (!((Map.Entry) this.b.get(i)).equals((Map.Entry) wVar.b.get(i))) {
                return false;
            }
        }
        if (size2 != size) {
            return this.c.equals(wVar.c);
        }
        return true;
    }

    public void f() {
        if (!this.d) {
            this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
            this.d = true;
        }
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        return a2 >= 0 ? ((b) this.b.get(a2)).b : this.c.get(comparable);
    }

    public final int hashCode() {
        int size = this.b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((b) this.b.get(i2)).hashCode();
        }
        return this.c.size() > 0 ? i + this.c.hashCode() : i;
    }

    public final Object remove(Object obj) {
        e();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            e();
            Object obj2 = ((b) this.b.remove(a2)).b;
            if (!this.c.isEmpty()) {
                e();
                if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
                    this.c = new TreeMap();
                }
                Iterator it = ((SortedMap) this.c).entrySet().iterator();
                List list = this.b;
                Map.Entry entry = (Map.Entry) it.next();
                list.add(new b((Comparable) entry.getKey(), entry.getValue()));
                it.remove();
            }
            return obj2;
        } else if (this.c.isEmpty()) {
            return null;
        } else {
            return this.c.remove(comparable);
        }
    }

    public final int size() {
        return this.c.size() + this.b.size();
    }

    public /* synthetic */ w(int i, int i2) {
        this(i);
    }
}
