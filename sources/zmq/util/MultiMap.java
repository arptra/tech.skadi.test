package zmq.util;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MultiMap<K extends Comparable<? super K>, V> {

    /* renamed from: a  reason: collision with root package name */
    public final Comparator f3671a = new EntryComparator();
    public final Map b = new HashMap();
    public final Map c = new HashMap();

    public final class EntryComparator implements Comparator<Map.Entry<V, K>> {
        public EntryComparator() {
        }

        /* renamed from: a */
        public int compare(Map.Entry entry, Map.Entry entry2) {
            return ((Comparable) entry.getValue()).compareTo(entry2.getValue());
        }
    }

    public Collection a() {
        ArrayList arrayList = new ArrayList(this.c.entrySet());
        Collections.sort(arrayList, this.f3671a);
        return arrayList;
    }

    public Object b(Object obj) {
        Comparable comparable = (Comparable) this.c.get(obj);
        if (comparable == null) {
            return null;
        }
        List list = (List) this.b.get(comparable);
        return list.get(list.indexOf(obj));
    }

    public final List c(Comparable comparable) {
        List list = (List) this.b.get(comparable);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        this.b.put(comparable, arrayList);
        return arrayList;
    }

    public boolean d(Comparable comparable) {
        List list = (List) this.b.get(comparable);
        if (list == null) {
            return false;
        }
        return !list.isEmpty();
    }

    public boolean e(Comparable comparable, Object obj) {
        Comparable comparable2 = (Comparable) this.c.get(obj);
        if (comparable2 != null) {
            j(comparable2, obj);
        }
        boolean add = c(comparable).add(obj);
        if (add) {
            this.c.put(obj, comparable);
        } else {
            this.c.remove(obj);
        }
        return add;
    }

    public boolean f() {
        return this.c.isEmpty();
    }

    public Collection g(Comparable comparable) {
        List<Object> list = (List) this.b.remove(comparable);
        if (list != null) {
            for (Object remove : list) {
                this.c.remove(remove);
            }
        }
        return list;
    }

    public boolean h(Comparable comparable, Object obj) {
        boolean j = j(comparable, obj);
        if (j) {
            this.c.remove(obj);
        }
        return j;
    }

    public boolean i(Object obj) {
        Comparable comparable = (Comparable) this.c.remove(obj);
        if (comparable != null) {
            return j(comparable, obj);
        }
        return false;
    }

    public final boolean j(Comparable comparable, Object obj) {
        List list = (List) this.b.get(comparable);
        if (list == null) {
            return false;
        }
        boolean remove = list.remove(obj);
        if (!list.isEmpty()) {
            return remove;
        }
        this.b.remove(comparable);
        return remove;
    }

    public String toString() {
        return this.b.toString();
    }
}
