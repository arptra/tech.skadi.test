package io.netty.util.collection;

import io.netty.util.collection.CharObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class CharCollections {
    private static final CharObjectMap<Object> EMPTY_MAP = new EmptyMap();

    public static final class EmptyMap implements CharObjectMap<Object> {
        private EmptyMap() {
        }

        public void clear() {
        }

        public boolean containsKey(char c) {
            return false;
        }

        public boolean containsValue(Object obj) {
            return false;
        }

        public Iterable<CharObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        public Set<Map.Entry<Character, Object>> entrySet() {
            return Collections.emptySet();
        }

        public Object get(char c) {
            return null;
        }

        public boolean isEmpty() {
            return true;
        }

        public Set<Character> keySet() {
            return Collections.emptySet();
        }

        public void putAll(Map<? extends Character, ?> map) {
            throw new UnsupportedOperationException();
        }

        public Object remove(char c) {
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

        public Object put(char c, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        public Object remove(Object obj) {
            return null;
        }

        public Object put(Character ch, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class UnmodifiableMap<V> implements CharObjectMap<V> {
        private Iterable<CharObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Character, V>> entrySet;
        private Set<Character> keySet;
        /* access modifiers changed from: private */
        public final CharObjectMap<V> map;
        private Collection<V> values;

        public class EntryImpl implements CharObjectMap.PrimitiveEntry<V> {
            private final CharObjectMap.PrimitiveEntry<V> entry;

            public EntryImpl(CharObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            public char key() {
                return this.entry.key();
            }

            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }

            public V value() {
                return this.entry.value();
            }
        }

        public class IteratorImpl implements Iterator<CharObjectMap.PrimitiveEntry<V>> {
            final Iterator<CharObjectMap.PrimitiveEntry<V>> iter;

            public IteratorImpl(Iterator<CharObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            public CharObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                throw new NoSuchElementException();
            }
        }

        public UnmodifiableMap(CharObjectMap<V> charObjectMap) {
            this.map = charObjectMap;
        }

        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        public boolean containsKey(char c) {
            return this.map.containsKey(c);
        }

        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        public Iterable<CharObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<CharObjectMap.PrimitiveEntry<V>>() {
                    public Iterator<CharObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        public Set<Map.Entry<Character, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        public V get(char c) {
            return this.map.get(c);
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public Set<Character> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        public void putAll(Map<? extends Character, ? extends V> map2) {
            throw new UnsupportedOperationException("putAll");
        }

        public V remove(char c) {
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

        public V put(char c, V v) {
            throw new UnsupportedOperationException("put");
        }

        public V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        public V put(Character ch, V v) {
            throw new UnsupportedOperationException("put");
        }
    }

    private CharCollections() {
    }

    public static <V> CharObjectMap<V> emptyMap() {
        return EMPTY_MAP;
    }

    public static <V> CharObjectMap<V> unmodifiableMap(CharObjectMap<V> charObjectMap) {
        return new UnmodifiableMap(charObjectMap);
    }
}
