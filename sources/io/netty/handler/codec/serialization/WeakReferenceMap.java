package io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

final class WeakReferenceMap<K, V> extends ReferenceMap<K, V> {
    public WeakReferenceMap(Map<K, Reference<V>> map) {
        super(map);
    }

    public Reference<V> fold(V v) {
        return new WeakReference(v);
    }
}
