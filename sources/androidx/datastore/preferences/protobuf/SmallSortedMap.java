package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
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

class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final int f1136a;
    public List b;
    public Map c;
    public boolean d;
    public volatile EntrySet e;
    public Map f;
    public volatile DescendingEntrySet g;

    public class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        public int f1137a;
        public Iterator b;

        public DescendingEntryIterator() {
            this.f1137a = SmallSortedMap.this.b.size();
        }

        public final Iterator a() {
            if (this.b == null) {
                this.b = SmallSortedMap.this.f.entrySet().iterator();
            }
            return this.b;
        }

        /* renamed from: b */
        public Map.Entry next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List c2 = SmallSortedMap.this.b;
            int i = this.f1137a - 1;
            this.f1137a = i;
            return (Map.Entry) c2.get(i);
        }

        public boolean hasNext() {
            int i = this.f1137a;
            return (i > 0 && i <= SmallSortedMap.this.b.size()) || a().hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        public DescendingEntrySet() {
            super();
        }

        public Iterator iterator() {
            return new DescendingEntryIterator();
        }
    }

    public static class EmptySet {

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator f1138a = new Iterator<Object>() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        public static final Iterable b = new Iterable<Object>() {
            public Iterator iterator() {
                return EmptySet.f1138a;
            }
        };

        public static Iterable b() {
            return b;
        }
    }

    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {

        /* renamed from: a  reason: collision with root package name */
        public final Comparable f1139a;
        public Object b;

        public Entry(SmallSortedMap smallSortedMap, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        /* renamed from: a */
        public int compareTo(Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        public final boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        /* renamed from: d */
        public Comparable getKey() {
            return this.f1139a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.f1139a, entry.getKey()) && b(this.b, entry.getValue());
        }

        public Object getValue() {
            return this.b;
        }

        public int hashCode() {
            Comparable comparable = this.f1139a;
            int i = 0;
            int hashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.b;
            if (obj != null) {
                i = obj.hashCode();
            }
            return hashCode ^ i;
        }

        public Object setValue(Object obj) {
            SmallSortedMap.this.h();
            Object obj2 = this.b;
            this.b = obj;
            return obj2;
        }

        public String toString() {
            return this.f1139a + "=" + this.b;
        }

        public Entry(Comparable comparable, Object obj) {
            this.f1139a = comparable;
            this.b = obj;
        }
    }

    public class EntryIterator implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        public int f1140a;
        public boolean b;
        public Iterator c;

        public EntryIterator() {
            this.f1140a = -1;
        }

        public final Iterator a() {
            if (this.c == null) {
                this.c = SmallSortedMap.this.c.entrySet().iterator();
            }
            return this.c;
        }

        /* renamed from: b */
        public Map.Entry next() {
            this.b = true;
            int i = this.f1140a + 1;
            this.f1140a = i;
            return i < SmallSortedMap.this.b.size() ? (Map.Entry) SmallSortedMap.this.b.get(this.f1140a) : (Map.Entry) a().next();
        }

        public boolean hasNext() {
            if (this.f1140a + 1 >= SmallSortedMap.this.b.size()) {
                return !SmallSortedMap.this.c.isEmpty() && a().hasNext();
            }
            return true;
        }

        public void remove() {
            if (this.b) {
                this.b = false;
                SmallSortedMap.this.h();
                if (this.f1140a < SmallSortedMap.this.b.size()) {
                    SmallSortedMap smallSortedMap = SmallSortedMap.this;
                    int i = this.f1140a;
                    this.f1140a = i - 1;
                    Object unused = smallSortedMap.t(i);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            SmallSortedMap.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator iterator() {
            return new EntryIterator();
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return SmallSortedMap.this.size();
        }
    }

    public static SmallSortedMap r(int i) {
        return new SmallSortedMap<FieldSet.FieldDescriptorLite<Object>, Object>(i) {
            public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                return SmallSortedMap.super.put((FieldSet.FieldDescriptorLite) obj, obj2);
            }

            public void q() {
                if (!p()) {
                    for (int i = 0; i < l(); i++) {
                        Map.Entry k = k(i);
                        if (((FieldSet.FieldDescriptorLite) k.getKey()).isRepeated()) {
                            k.setValue(Collections.unmodifiableList((List) k.getValue()));
                        }
                    }
                    for (Map.Entry entry : n()) {
                        if (((FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                SmallSortedMap.super.q();
            }
        };
    }

    public void clear() {
        h();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return g(comparable) >= 0 || this.c.containsKey(comparable);
    }

    public Set entrySet() {
        if (this.e == null) {
            this.e = new EntrySet();
        }
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int l = l();
        if (l != smallSortedMap.l()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int i = 0; i < l; i++) {
            if (!k(i).equals(smallSortedMap.k(i))) {
                return false;
            }
        }
        if (l != size) {
            return this.c.equals(smallSortedMap.c);
        }
        return true;
    }

    public final int g(Comparable comparable) {
        int i;
        int size = this.b.size();
        int i2 = size - 1;
        if (i2 >= 0) {
            int compareTo = comparable.compareTo(((Entry) this.b.get(i2)).getKey());
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
            int compareTo2 = comparable.compareTo(((Entry) this.b.get(i4)).getKey());
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

    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int g2 = g(comparable);
        return g2 >= 0 ? ((Entry) this.b.get(g2)).getValue() : this.c.get(comparable);
    }

    public final void h() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    public int hashCode() {
        int l = l();
        int i = 0;
        for (int i2 = 0; i2 < l; i2++) {
            i += ((Entry) this.b.get(i2)).hashCode();
        }
        return m() > 0 ? i + this.c.hashCode() : i;
    }

    public Set i() {
        if (this.g == null) {
            this.g = new DescendingEntrySet();
        }
        return this.g;
    }

    public final void j() {
        h();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.f1136a);
        }
    }

    public Map.Entry k(int i) {
        return (Map.Entry) this.b.get(i);
    }

    public int l() {
        return this.b.size();
    }

    public int m() {
        return this.c.size();
    }

    public Iterable n() {
        return this.c.isEmpty() ? EmptySet.b() : this.c.entrySet();
    }

    public final SortedMap o() {
        h();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    public boolean p() {
        return this.d;
    }

    public void q() {
        if (!this.d) {
            this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
            this.f = this.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f);
            this.d = true;
        }
    }

    public Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int g2 = g(comparable);
        if (g2 >= 0) {
            return t(g2);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    /* renamed from: s */
    public Object put(Comparable comparable, Object obj) {
        h();
        int g2 = g(comparable);
        if (g2 >= 0) {
            return ((Entry) this.b.get(g2)).setValue(obj);
        }
        j();
        int i = -(g2 + 1);
        if (i >= this.f1136a) {
            return o().put(comparable, obj);
        }
        int size = this.b.size();
        int i2 = this.f1136a;
        if (size == i2) {
            Entry entry = (Entry) this.b.remove(i2 - 1);
            o().put(entry.getKey(), entry.getValue());
        }
        this.b.add(i, new Entry(comparable, obj));
        return null;
    }

    public int size() {
        return this.b.size() + this.c.size();
    }

    public final Object t(int i) {
        h();
        Object value = ((Entry) this.b.remove(i)).getValue();
        if (!this.c.isEmpty()) {
            Iterator it = o().entrySet().iterator();
            this.b.add(new Entry(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public SmallSortedMap(int i) {
        this.f1136a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }
}
