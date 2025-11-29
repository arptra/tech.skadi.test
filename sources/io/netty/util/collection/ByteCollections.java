package io.netty.util.collection;

import io.netty.util.collection.ByteObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class ByteCollections {
    private static final ByteObjectMap<Object> EMPTY_MAP = new EmptyMap();

    public static final class EmptyMap implements ByteObjectMap<Object> {
        private EmptyMap() {
        }

        public void clear() {
        }

        public boolean containsKey(byte b) {
            return false;
        }

        public boolean containsValue(Object obj) {
            return false;
        }

        public Iterable<ByteObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        public Set<Map.Entry<Byte, Object>> entrySet() {
            return Collections.emptySet();
        }

        public Object get(byte b) {
            return null;
        }

        public boolean isEmpty() {
            return true;
        }

        public Set<Byte> keySet() {
            return Collections.emptySet();
        }

        public void putAll(Map<? extends Byte, ?> map) {
            throw new UnsupportedOperationException();
        }

        public Object remove(byte b) {
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

        public Object put(byte b, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        public Object remove(Object obj) {
            return null;
        }

        public Object put(Byte b, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class UnmodifiableMap<V> implements ByteObjectMap<V> {
        private Iterable<ByteObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Byte, V>> entrySet;
        private Set<Byte> keySet;
        /* access modifiers changed from: private */
        public final ByteObjectMap<V> map;
        private Collection<V> values;

        public class EntryImpl implements ByteObjectMap.PrimitiveEntry<V> {
            private final ByteObjectMap.PrimitiveEntry<V> entry;

            public EntryImpl(ByteObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            public byte key() {
                return this.entry.key();
            }

            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }

            public V value() {
                return this.entry.value();
            }
        }

        public class IteratorImpl implements Iterator<ByteObjectMap.PrimitiveEntry<V>> {
            final Iterator<ByteObjectMap.PrimitiveEntry<V>> iter;

            public IteratorImpl(Iterator<ByteObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            public ByteObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                throw new NoSuchElementException();
            }
        }

        public UnmodifiableMap(ByteObjectMap<V> byteObjectMap) {
            this.map = byteObjectMap;
        }

        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        public boolean containsKey(byte b) {
            return this.map.containsKey(b);
        }

        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        public Iterable<ByteObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<ByteObjectMap.PrimitiveEntry<V>>() {
                    public Iterator<ByteObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        public Set<Map.Entry<Byte, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        public V get(byte b) {
            return this.map.get(b);
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public Set<Byte> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        public void putAll(Map<? extends Byte, ? extends V> map2) {
            throw new UnsupportedOperationException("putAll");
        }

        public V remove(byte b) {
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

        public V put(byte b, V v) {
            throw new UnsupportedOperationException("put");
        }

        public V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        public V put(Byte b, V v) {
            throw new UnsupportedOperationException("put");
        }
    }

    private ByteCollections() {
    }

    public static <V> ByteObjectMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    public static <V> ByteObjectMap<V> unmodifiableMap(ByteObjectMap<V> byteObjectMap) {
        return new UnmodifiableMap(byteObjectMap);
    }
}
