package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class MapCollections<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public EntrySet f457a;
    public KeySet b;
    public ValuesCollection c;

    public final class ArrayIterator<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f458a;
        public int b;
        public int c;
        public boolean d = false;

        public ArrayIterator(int i) {
            this.f458a = i;
            this.b = MapCollections.this.d();
        }

        public boolean hasNext() {
            return this.c < this.b;
        }

        public Object next() {
            if (hasNext()) {
                Object b2 = MapCollections.this.b(this.c, this.f458a);
                this.c++;
                this.d = true;
                return b2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.d) {
                int i = this.c - 1;
                this.c = i;
                this.b--;
                this.d = false;
                MapCollections.this.h(i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final class EntrySet implements Set<Map.Entry<K, V>> {
        public EntrySet() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            int d = MapCollections.this.d();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                MapCollections.this.g(entry.getKey(), entry.getValue());
            }
            return d != MapCollections.this.d();
        }

        public void clear() {
            MapCollections.this.a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e = MapCollections.this.e(entry.getKey());
            if (e < 0) {
                return false;
            }
            return ContainerHelpers.c(MapCollections.this.b(e, 1), entry.getValue());
        }

        public boolean containsAll(Collection collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return MapCollections.k(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int d = MapCollections.this.d() - 1; d >= 0; d--) {
                Object b = MapCollections.this.b(d, 0);
                Object b2 = MapCollections.this.b(d, 1);
                i += (b == null ? 0 : b.hashCode()) ^ (b2 == null ? 0 : b2.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return MapCollections.this.d() == 0;
        }

        public Iterator iterator() {
            return new MapIterator();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return MapCollections.this.d();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    public final class KeySet implements Set<K> {
        public KeySet() {
        }

        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            MapCollections.this.a();
        }

        public boolean contains(Object obj) {
            return MapCollections.this.e(obj) >= 0;
        }

        public boolean containsAll(Collection collection) {
            return MapCollections.j(MapCollections.this.c(), collection);
        }

        public boolean equals(Object obj) {
            return MapCollections.k(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int d = MapCollections.this.d() - 1; d >= 0; d--) {
                Object b = MapCollections.this.b(d, 0);
                i += b == null ? 0 : b.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return MapCollections.this.d() == 0;
        }

        public Iterator iterator() {
            return new ArrayIterator(0);
        }

        public boolean remove(Object obj) {
            int e = MapCollections.this.e(obj);
            if (e < 0) {
                return false;
            }
            MapCollections.this.h(e);
            return true;
        }

        public boolean removeAll(Collection collection) {
            return MapCollections.o(MapCollections.this.c(), collection);
        }

        public boolean retainAll(Collection collection) {
            return MapCollections.p(MapCollections.this.c(), collection);
        }

        public int size() {
            return MapCollections.this.d();
        }

        public Object[] toArray() {
            return MapCollections.this.q(0);
        }

        public Object[] toArray(Object[] objArr) {
            return MapCollections.this.r(objArr, 0);
        }
    }

    public final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public int f461a;
        public int b;
        public boolean c = false;

        public MapIterator() {
            this.f461a = MapCollections.this.d() - 1;
            this.b = -1;
        }

        /* renamed from: a */
        public Map.Entry next() {
            if (hasNext()) {
                this.b++;
                this.c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                return ContainerHelpers.c(entry.getKey(), MapCollections.this.b(this.b, 0)) && ContainerHelpers.c(entry.getValue(), MapCollections.this.b(this.b, 1));
            }
        }

        public Object getKey() {
            if (this.c) {
                return MapCollections.this.b(this.b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object getValue() {
            if (this.c) {
                return MapCollections.this.b(this.b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.b < this.f461a;
        }

        public int hashCode() {
            if (this.c) {
                int i = 0;
                Object b2 = MapCollections.this.b(this.b, 0);
                Object b3 = MapCollections.this.b(this.b, 1);
                int hashCode = b2 == null ? 0 : b2.hashCode();
                if (b3 != null) {
                    i = b3.hashCode();
                }
                return hashCode ^ i;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.c) {
                MapCollections.this.h(this.b);
                this.b--;
                this.f461a--;
                this.c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public Object setValue(Object obj) {
            if (this.c) {
                return MapCollections.this.i(this.b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    public final class ValuesCollection implements Collection<V> {
        public ValuesCollection() {
        }

        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            MapCollections.this.a();
        }

        public boolean contains(Object obj) {
            return MapCollections.this.f(obj) >= 0;
        }

        public boolean containsAll(Collection collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return MapCollections.this.d() == 0;
        }

        public Iterator iterator() {
            return new ArrayIterator(1);
        }

        public boolean remove(Object obj) {
            int f = MapCollections.this.f(obj);
            if (f < 0) {
                return false;
            }
            MapCollections.this.h(f);
            return true;
        }

        public boolean removeAll(Collection collection) {
            int d = MapCollections.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (collection.contains(MapCollections.this.b(i, 1))) {
                    MapCollections.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection collection) {
            int d = MapCollections.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (!collection.contains(MapCollections.this.b(i, 1))) {
                    MapCollections.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return MapCollections.this.d();
        }

        public Object[] toArray() {
            return MapCollections.this.q(1);
        }

        public Object[] toArray(Object[] objArr) {
            return MapCollections.this.r(objArr, 1);
        }
    }

    public static boolean j(Map map, Collection collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static boolean p(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void a();

    public abstract Object b(int i, int i2);

    public abstract Map c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(Object obj, Object obj2);

    public abstract void h(int i);

    public abstract Object i(int i, Object obj);

    public Set l() {
        if (this.f457a == null) {
            this.f457a = new EntrySet();
        }
        return this.f457a;
    }

    public Set m() {
        if (this.b == null) {
            this.b = new KeySet();
        }
        return this.b;
    }

    public Collection n() {
        if (this.c == null) {
            this.c = new ValuesCollection();
        }
        return this.c;
    }

    public Object[] q(int i) {
        int d = d();
        Object[] objArr = new Object[d];
        for (int i2 = 0; i2 < d; i2++) {
            objArr[i2] = b(i2, i);
        }
        return objArr;
    }

    public Object[] r(Object[] objArr, int i) {
        int d = d();
        if (objArr.length < d) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), d);
        }
        for (int i2 = 0; i2 < d; i2++) {
            objArr[i2] = b(i2, i);
        }
        if (objArr.length > d) {
            objArr[d] = null;
        }
        return objArr;
    }
}
