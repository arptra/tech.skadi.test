package io.netty.util.collection;

import io.netty.util.collection.LongObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LongCollections {
    private static final LongObjectMap<Object> EMPTY_MAP = new EmptyMap();

    public static final class EmptyMap implements LongObjectMap<Object> {
        private EmptyMap() {
        }

        public void clear() {
        }

        public boolean containsKey(long j) {
            return false;
        }

        public boolean containsValue(Object obj) {
            return false;
        }

        public Iterable<LongObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        public Set<Map.Entry<Long, Object>> entrySet() {
            return Collections.emptySet();
        }

        public Object get(long j) {
            return null;
        }

        public boolean isEmpty() {
            return true;
        }

        public Set<Long> keySet() {
            return Collections.emptySet();
        }

        public void putAll(Map<? extends Long, ?> map) {
            throw new UnsupportedOperationException();
        }

        public Object remove(long j) {
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

        public Object put(long j, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        public Object remove(Object obj) {
            return null;
        }

        public Object put(Long l, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class UnmodifiableMap<V> implements LongObjectMap<V> {
        private Iterable<LongObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Long, V>> entrySet;
        private Set<Long> keySet;
        /* access modifiers changed from: private */
        public final LongObjectMap<V> map;
        private Collection<V> values;

        public class EntryImpl implements LongObjectMap.PrimitiveEntry<V> {
            private final LongObjectMap.PrimitiveEntry<V> entry;

            public EntryImpl(LongObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            public long key() {
                return this.entry.key();
            }

            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }

            public V value() {
                return this.entry.value();
            }
        }

        public class IteratorImpl implements Iterator<LongObjectMap.PrimitiveEntry<V>> {
            final Iterator<LongObjectMap.PrimitiveEntry<V>> iter;

            public IteratorImpl(Iterator<LongObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            public LongObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                throw new NoSuchElementException();
            }
        }

        public UnmodifiableMap(LongObjectMap<V> longObjectMap) {
            this.map = longObjectMap;
        }

        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        public boolean containsKey(long j) {
            return this.map.containsKey(j);
        }

        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        public Iterable<LongObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<LongObjectMap.PrimitiveEntry<V>>() {
                    public Iterator<LongObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        public Set<Map.Entry<Long, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        public V get(long j) {
            return this.map.get(j);
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public Set<Long> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        public void putAll(Map<? extends Long, ? extends V> map2) {
            throw new UnsupportedOperationException("putAll");
        }

        public V remove(long j) {
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

        public V put(long j, V v) {
            throw new UnsupportedOperationException("put");
        }

        public V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        public V put(Long l, V v) {
            throw new UnsupportedOperationException("put");
        }
    }

    private LongCollections() {
    }

    public static <V> LongObjectMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    public static <V> LongObjectMap<V> unmodifiableMap(LongObjectMap<V> longObjectMap) {
        return new UnmodifiableMap(longObjectMap);
    }
}
