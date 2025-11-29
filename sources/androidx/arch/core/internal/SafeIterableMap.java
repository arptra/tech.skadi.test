package androidx.arch.core.internal;

import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@RestrictTo
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    public Entry f381a;
    public Entry b;
    public final WeakHashMap c = new WeakHashMap();
    public int d = 0;

    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        public AscendingIterator(Entry entry, Entry entry2) {
            super(entry, entry2);
        }

        public Entry b(Entry entry) {
            return entry.d;
        }

        public Entry c(Entry entry) {
            return entry.c;
        }
    }

    public static class DescendingIterator<K, V> extends ListIterator<K, V> {
        public DescendingIterator(Entry entry, Entry entry2) {
            super(entry, entry2);
        }

        public Entry b(Entry entry) {
            return entry.c;
        }

        public Entry c(Entry entry) {
            return entry.d;
        }
    }

    public static class Entry<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f382a;
        public final Object b;
        public Entry c;
        public Entry d;

        public Entry(Object obj, Object obj2) {
            this.f382a = obj;
            this.b = obj2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.f382a.equals(entry.f382a) && this.b.equals(entry.b);
        }

        public Object getKey() {
            return this.f382a;
        }

        public Object getValue() {
            return this.b;
        }

        public int hashCode() {
            return this.b.hashCode() ^ this.f382a.hashCode();
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f382a + "=" + this.b;
        }
    }

    @RestrictTo
    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        public Entry f383a;
        public boolean b = true;

        public IteratorWithAdditions() {
        }

        public void a(Entry entry) {
            Entry entry2 = this.f383a;
            if (entry == entry2) {
                Entry entry3 = entry2.d;
                this.f383a = entry3;
                this.b = entry3 == null;
            }
        }

        /* renamed from: b */
        public Map.Entry next() {
            if (this.b) {
                this.b = false;
                this.f383a = SafeIterableMap.this.f381a;
            } else {
                Entry entry = this.f383a;
                this.f383a = entry != null ? entry.c : null;
            }
            return this.f383a;
        }

        public boolean hasNext() {
            if (this.b) {
                return SafeIterableMap.this.f381a != null;
            }
            Entry entry = this.f383a;
            return (entry == null || entry.c == null) ? false : true;
        }
    }

    public static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        public Entry f384a;
        public Entry b;

        public ListIterator(Entry entry, Entry entry2) {
            this.f384a = entry2;
            this.b = entry;
        }

        public void a(Entry entry) {
            if (this.f384a == entry && entry == this.b) {
                this.b = null;
                this.f384a = null;
            }
            Entry entry2 = this.f384a;
            if (entry2 == entry) {
                this.f384a = b(entry2);
            }
            if (this.b == entry) {
                this.b = e();
            }
        }

        public abstract Entry b(Entry entry);

        public abstract Entry c(Entry entry);

        /* renamed from: d */
        public Map.Entry next() {
            Entry entry = this.b;
            this.b = e();
            return entry;
        }

        public final Entry e() {
            Entry entry = this.b;
            Entry entry2 = this.f384a;
            if (entry == entry2 || entry2 == null) {
                return null;
            }
            return c(entry);
        }

        public boolean hasNext() {
            return this.b != null;
        }
    }

    @RestrictTo
    public static abstract class SupportRemove<K, V> {
        public abstract void a(Entry entry);
    }

    public Map.Entry a() {
        return this.f381a;
    }

    public Entry b(Object obj) {
        Entry entry = this.f381a;
        while (entry != null && !entry.f382a.equals(obj)) {
            entry = entry.c;
        }
        return entry;
    }

    public IteratorWithAdditions c() {
        IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.c.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    public Map.Entry d() {
        return this.b;
    }

    public Iterator descendingIterator() {
        DescendingIterator descendingIterator = new DescendingIterator(this.b, this.f381a);
        this.c.put(descendingIterator, Boolean.FALSE);
        return descendingIterator;
    }

    public Entry e(Object obj, Object obj2) {
        Entry entry = new Entry(obj, obj2);
        this.d++;
        Entry entry2 = this.b;
        if (entry2 == null) {
            this.f381a = entry;
            this.b = entry;
            return entry;
        }
        entry2.c = entry;
        entry.d = entry2;
        this.b = entry;
        return entry;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public Object f(Object obj, Object obj2) {
        Entry b2 = b(obj);
        if (b2 != null) {
            return b2.b;
        }
        e(obj, obj2);
        return null;
    }

    public Object h(Object obj) {
        Entry b2 = b(obj);
        if (b2 == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            for (SupportRemove a2 : this.c.keySet()) {
                a2.a(b2);
            }
        }
        Entry entry = b2.d;
        if (entry != null) {
            entry.c = b2.c;
        } else {
            this.f381a = b2.c;
        }
        Entry entry2 = b2.c;
        if (entry2 != null) {
            entry2.d = entry;
        } else {
            this.b = entry;
        }
        b2.c = null;
        b2.d = null;
        return b2.b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    public Iterator iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.f381a, this.b);
        this.c.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
