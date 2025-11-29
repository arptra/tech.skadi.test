package io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

abstract class ReferenceMap<K, V> implements Map<K, V> {
    private final Map<K, Reference<V>> delegate;

    public ReferenceMap(Map<K, Reference<V>> map) {
        this.delegate = map;
    }

    private V unfold(Reference<V> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public void clear() {
        this.delegate.clear();
    }

    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    public abstract Reference<V> fold(V v);

    public V get(Object obj) {
        return unfold(this.delegate.get(obj));
    }

    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    public Set<K> keySet() {
        return this.delegate.keySet();
    }

    public V put(K k, V v) {
        return unfold(this.delegate.put(k, fold(v)));
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            this.delegate.put(next.getKey(), fold(next.getValue()));
        }
    }

    public V remove(Object obj) {
        return unfold(this.delegate.remove(obj));
    }

    public int size() {
        return this.delegate.size();
    }

    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }
}
