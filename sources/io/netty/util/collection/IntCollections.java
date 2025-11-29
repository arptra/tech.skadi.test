package io.netty.util.collection;

import io.netty.util.collection.IntObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class IntCollections {
    private static final IntObjectMap<Object> EMPTY_MAP = new EmptyMap();

    public static final class EmptyMap implements IntObjectMap<Object> {
        private EmptyMap() {
        }

        public void clear() {
        }

        public boolean containsKey(int i) {
            return false;
        }

        public boolean containsValue(Object obj) {
            return false;
        }

        public Iterable<IntObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        public Set<Map.Entry<Integer, Object>> entrySet() {
            return Collections.emptySet();
        }

        public Object get(int i) {
            return null;
        }

        public boolean isEmpty() {
            return true;
        }

        public Set<Integer> keySet() {
            return Collections.emptySet();
        }

        public void putAll(Map<? extends Integer, ?> map) {
            throw new UnsupportedOperationException();
        }

        public Object remove(int i) {
            return null;
        }

        public int size() {
            return 0;
        }

        public Collection<Object> values() {
            return Collections.emptyList();
        }

        public boolean containsKey(Object obj) {
            return false;
        }

        public Object get(Object obj) {
            return null;
        }

        public Object put(int i, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        public Object remove(Object obj) {
            return null;
        }

        public Object put(Integer num, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class UnmodifiableMap<V> implements IntObjectMap<V> {
        private Iterable<IntObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Integer, V>> entrySet;
        private Set<Integer> keySet;
        /* access modifiers changed from: private */
        public final IntObjectMap<V> map;
        private Collection<V> values;

        public class EntryImpl implements IntObjectMap.PrimitiveEntry<V> {
            private final IntObjectMap.PrimitiveEntry<V> entry;

            public EntryImpl(IntObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            public int key() {
                return this.entry.key();
            }

            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }

            public V value() {
                return this.entry.value();
            }
        }

        public class IteratorImpl implements Iterator<IntObjectMap.PrimitiveEntry<V>> {
            final Iterator<IntObjectMap.PrimitiveEntry<V>> iter;

            public IteratorImpl(Iterator<IntObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            public IntObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                throw new NoSuchElementException();
            }
        }

        public UnmodifiableMap(IntObjectMap<V> intObjectMap) {
            this.map = intObjectMap;
        }

        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        public boolean containsKey(int i) {
            return this.map.containsKey(i);
        }

        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        public Iterable<IntObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<IntObjectMap.PrimitiveEntry<V>>() {
                    public Iterator<IntObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        public Set<Map.Entry<Integer, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        public V get(int i) {
            return this.map.get(i);
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public Set<Integer> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        public void putAll(Map<? extends Integer, ? extends V> map2) {
            throw new UnsupportedOperationException("putAll");
        }

        public V remove(int i) {
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

        public V put(int i, V v) {
            throw new UnsupportedOperationException("put");
        }

        public V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        public V put(Integer num, V v) {
            throw new UnsupportedOperationException("put");
        }
    }

    private IntCollections() {
    }

    public static <V> IntObjectMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    public static <V> IntObjectMap<V> unmodifiableMap(IntObjectMap<V> intObjectMap) {
        return new UnmodifiableMap(intObjectMap);
    }
}
