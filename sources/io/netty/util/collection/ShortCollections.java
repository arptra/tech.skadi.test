package io.netty.util.collection;

import io.netty.util.collection.ShortObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class ShortCollections {
    private static final ShortObjectMap<Object> EMPTY_MAP = new EmptyMap();

    public static final class EmptyMap implements ShortObjectMap<Object> {
        private EmptyMap() {
        }

        public void clear() {
        }

        public boolean containsKey(Object obj) {
            return false;
        }

        public boolean containsValue(Object obj) {
            return false;
        }

        public Iterable<ShortObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        public Set<Map.Entry<Short, Object>> entrySet() {
            return Collections.emptySet();
        }

        public Object get(Object obj) {
            return null;
        }

        public boolean isEmpty() {
            return true;
        }

        public Set<Short> keySet() {
            return Collections.emptySet();
        }

        public void putAll(Map<? extends Short, ?> map) {
            throw new UnsupportedOperationException();
        }

        public Object remove(Object obj) {
            return null;
        }

        public int size() {
            return 0;
        }

        public Collection<Object> values() {
            return Collections.emptyList();
        }

        public boolean containsKey(short s) {
            return false;
        }

        public Object get(short s) {
            return null;
        }

        public Object put(short s, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        public Object remove(short s) {
            return null;
        }

        public Object put(Short sh, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class UnmodifiableMap<V> implements ShortObjectMap<V> {
        private Iterable<ShortObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Short, V>> entrySet;
        private Set<Short> keySet;
        /* access modifiers changed from: private */
        public final ShortObjectMap<V> map;
        private Collection<V> values;

        public class EntryImpl implements ShortObjectMap.PrimitiveEntry<V> {
            private final ShortObjectMap.PrimitiveEntry<V> entry;

            public EntryImpl(ShortObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            public short key() {
                return this.entry.key();
            }

            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }

            public V value() {
                return this.entry.value();
            }
        }

        public class IteratorImpl implements Iterator<ShortObjectMap.PrimitiveEntry<V>> {
            final Iterator<ShortObjectMap.PrimitiveEntry<V>> iter;

            public IteratorImpl(Iterator<ShortObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            public ShortObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                throw new NoSuchElementException();
            }
        }

        public UnmodifiableMap(ShortObjectMap<V> shortObjectMap) {
            this.map = shortObjectMap;
        }

        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        public boolean containsKey(short s) {
            return this.map.containsKey(s);
        }

        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        public Iterable<ShortObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<ShortObjectMap.PrimitiveEntry<V>>() {
                    public Iterator<ShortObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        public Set<Map.Entry<Short, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        public V get(short s) {
            return this.map.get(s);
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public Set<Short> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        public void putAll(Map<? extends Short, ? extends V> map2) {
            throw new UnsupportedOperationException("putAll");
        }

        public V remove(short s) {
            throw new UnsupportedOperationException("remove");
        }

        public int size() {
            return this.map.size();
        }

        public Collection<V> values() {
            if (this.values == null) {
                this.values = Collections.unmodifiableCollection(this.map.values());
            }
            return this.values;
        }

        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        public V get(Object obj) {
            return this.map.get(obj);
        }

        public V put(short s, V v) {
            throw new UnsupportedOperationException("put");
        }

        public V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        public V put(Short sh, V v) {
            throw new UnsupportedOperationException("put");
        }
    }

    private ShortCollections() {
    }

    public static <V> ShortObjectMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    public static <V> ShortObjectMap<V> unmodifiableMap(ShortObjectMap<V> shortObjectMap) {
        return new UnmodifiableMap(shortObjectMap);
    }
}
