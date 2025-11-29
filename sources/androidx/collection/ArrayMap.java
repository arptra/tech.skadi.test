package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    public MapCollections h;

    public ArrayMap() {
    }

    public Set entrySet() {
        return o().l();
    }

    public Set keySet() {
        return o().m();
    }

    public final MapCollections o() {
        if (this.h == null) {
            this.h = new MapCollections<K, V>() {
                public void a() {
                    ArrayMap.this.clear();
                }

                public Object b(int i, int i2) {
                    return ArrayMap.this.b[(i << 1) + i2];
                }

                public Map c() {
                    return ArrayMap.this;
                }

                public int d() {
                    return ArrayMap.this.c;
                }

                public int e(Object obj) {
                    return ArrayMap.this.g(obj);
                }

                public int f(Object obj) {
                    return ArrayMap.this.i(obj);
                }

                public void g(Object obj, Object obj2) {
                    ArrayMap.this.put(obj, obj2);
                }

                public void h(int i) {
                    ArrayMap.this.l(i);
                }

                public Object i(int i, Object obj) {
                    return ArrayMap.this.m(i, obj);
                }
            };
        }
        return this.h;
    }

    public boolean p(Collection collection) {
        return MapCollections.p(this, collection);
    }

    public void putAll(Map map) {
        d(this.c + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection values() {
        return o().n();
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
