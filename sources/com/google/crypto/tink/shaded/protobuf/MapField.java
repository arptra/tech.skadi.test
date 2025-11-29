package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapField<K, V> implements MutabilityOracle {
    private final Converter<K, V> converter;
    private volatile boolean isMutable;
    private List<Message> listData;
    private MutatabilityAwareMap<K, V> mapData;
    private volatile StorageMode mode;

    public interface Converter<K, V> {
        Message convertKeyAndValueToMessage(K k, V v);

        void convertMessageToKeyAndValue(Message message, Map<K, V> map);

        Message getMessageDefaultInstance();
    }

    public static class ImmutableMessageConverter<K, V> implements Converter<K, V> {
        private final MapEntry<K, V> defaultEntry;

        public ImmutableMessageConverter(MapEntry<K, V> mapEntry) {
            this.defaultEntry = mapEntry;
        }

        public Message convertKeyAndValueToMessage(K k, V v) {
            return this.defaultEntry.newBuilderForType().setKey(k).setValue(v).buildPartial();
        }

        public void convertMessageToKeyAndValue(Message message, Map<K, V> map) {
            MapEntry mapEntry = (MapEntry) message;
            map.put(mapEntry.getKey(), mapEntry.getValue());
        }

        public Message getMessageDefaultInstance() {
            return this.defaultEntry;
        }
    }

    public static class MutatabilityAwareMap<K, V> implements Map<K, V> {
        private final Map<K, V> delegate;
        private final MutabilityOracle mutabilityOracle;

        public static class MutatabilityAwareCollection<E> implements Collection<E> {
            private final Collection<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutatabilityAwareCollection(MutabilityOracle mutabilityOracle2, Collection<E> collection) {
                this.mutabilityOracle = mutabilityOracle2;
                this.delegate = collection;
            }

            public boolean add(E e) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            public boolean contains(Object obj) {
                return this.delegate.contains(obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return this.delegate.containsAll(collection);
            }

            public boolean equals(Object obj) {
                return this.delegate.equals(obj);
            }

            public int hashCode() {
                return this.delegate.hashCode();
            }

            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            public Iterator<E> iterator() {
                return new MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            public boolean remove(Object obj) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(obj);
            }

            public boolean removeAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(collection);
            }

            public boolean retainAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(collection);
            }

            public int size() {
                return this.delegate.size();
            }

            public Object[] toArray() {
                return this.delegate.toArray();
            }

            public String toString() {
                return this.delegate.toString();
            }

            public <T> T[] toArray(T[] tArr) {
                return this.delegate.toArray(tArr);
            }
        }

        public static class MutatabilityAwareIterator<E> implements Iterator<E> {
            private final Iterator<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutatabilityAwareIterator(MutabilityOracle mutabilityOracle2, Iterator<E> it) {
                this.mutabilityOracle = mutabilityOracle2;
                this.delegate = it;
            }

            public boolean equals(Object obj) {
                return this.delegate.equals(obj);
            }

            public boolean hasNext() {
                return this.delegate.hasNext();
            }

            public int hashCode() {
                return this.delegate.hashCode();
            }

            public E next() {
                return this.delegate.next();
            }

            public void remove() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.remove();
            }

            public String toString() {
                return this.delegate.toString();
            }
        }

        public static class MutatabilityAwareSet<E> implements Set<E> {
            private final Set<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutatabilityAwareSet(MutabilityOracle mutabilityOracle2, Set<E> set) {
                this.mutabilityOracle = mutabilityOracle2;
                this.delegate = set;
            }

            public boolean add(E e) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.add(e);
            }

            public boolean addAll(Collection<? extends E> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.addAll(collection);
            }

            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            public boolean contains(Object obj) {
                return this.delegate.contains(obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return this.delegate.containsAll(collection);
            }

            public boolean equals(Object obj) {
                return this.delegate.equals(obj);
            }

            public int hashCode() {
                return this.delegate.hashCode();
            }

            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            public Iterator<E> iterator() {
                return new MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            public boolean remove(Object obj) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(obj);
            }

            public boolean removeAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(collection);
            }

            public boolean retainAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(collection);
            }

            public int size() {
                return this.delegate.size();
            }

            public Object[] toArray() {
                return this.delegate.toArray();
            }

            public String toString() {
                return this.delegate.toString();
            }

            public <T> T[] toArray(T[] tArr) {
                return this.delegate.toArray(tArr);
            }
        }

        public MutatabilityAwareMap(MutabilityOracle mutabilityOracle2, Map<K, V> map) {
            this.mutabilityOracle = mutabilityOracle2;
            this.delegate = map;
        }

        public void clear() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.clear();
        }

        public boolean containsKey(Object obj) {
            return this.delegate.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return this.delegate.containsValue(obj);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return new MutatabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
        }

        public boolean equals(Object obj) {
            return this.delegate.equals(obj);
        }

        public V get(Object obj) {
            return this.delegate.get(obj);
        }

        public int hashCode() {
            return this.delegate.hashCode();
        }

        public boolean isEmpty() {
            return this.delegate.isEmpty();
        }

        public Set<K> keySet() {
            return new MutatabilityAwareSet(this.mutabilityOracle, this.delegate.keySet());
        }

        public V put(K k, V v) {
            this.mutabilityOracle.ensureMutable();
            Internal.checkNotNull(k);
            Internal.checkNotNull(v);
            return this.delegate.put(k, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            this.mutabilityOracle.ensureMutable();
            for (Object next : map.keySet()) {
                Internal.checkNotNull(next);
                Internal.checkNotNull(map.get(next));
            }
            this.delegate.putAll(map);
        }

        public V remove(Object obj) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.remove(obj);
        }

        public int size() {
            return this.delegate.size();
        }

        public String toString() {
            return this.delegate.toString();
        }

        public Collection<V> values() {
            return new MutatabilityAwareCollection(this.mutabilityOracle, this.delegate.values());
        }
    }

    public enum StorageMode {
        MAP,
        LIST,
        BOTH
    }

    private MapField(Converter<K, V> converter2, StorageMode storageMode, Map<K, V> map) {
        this.converter = converter2;
        this.isMutable = true;
        this.mode = storageMode;
        this.mapData = new MutatabilityAwareMap<>(this, map);
        this.listData = null;
    }

    private Message convertKeyAndValueToMessage(K k, V v) {
        return this.converter.convertKeyAndValueToMessage(k, v);
    }

    private MutatabilityAwareMap<K, V> convertListToMap(List<Message> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Message convertMessageToKeyAndValue : list) {
            convertMessageToKeyAndValue(convertMessageToKeyAndValue, linkedHashMap);
        }
        return new MutatabilityAwareMap<>(this, linkedHashMap);
    }

    private List<Message> convertMapToList(MutatabilityAwareMap<K, V> mutatabilityAwareMap) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : mutatabilityAwareMap.entrySet()) {
            arrayList.add(convertKeyAndValueToMessage(next.getKey(), next.getValue()));
        }
        return arrayList;
    }

    private void convertMessageToKeyAndValue(Message message, Map<K, V> map) {
        this.converter.convertMessageToKeyAndValue(message, map);
    }

    public static <K, V> MapField<K, V> emptyMapField(MapEntry<K, V> mapEntry) {
        return new MapField<>(mapEntry, StorageMode.MAP, Collections.emptyMap());
    }

    public static <K, V> MapField<K, V> newMapField(MapEntry<K, V> mapEntry) {
        return new MapField<>(mapEntry, StorageMode.MAP, new LinkedHashMap());
    }

    public void clear() {
        this.mapData = new MutatabilityAwareMap<>(this, new LinkedHashMap());
        this.mode = StorageMode.MAP;
    }

    public MapField<K, V> copy() {
        return new MapField<>(this.converter, StorageMode.MAP, MapFieldLite.copy(getMap()));
    }

    public void ensureMutable() {
        if (!isMutable()) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MapField)) {
            return false;
        }
        return MapFieldLite.equals(getMap(), ((MapField) obj).getMap());
    }

    public List<Message> getList() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.MAP;
        if (storageMode == storageMode2) {
            synchronized (this) {
                try {
                    if (this.mode == storageMode2) {
                        this.listData = convertMapToList(this.mapData);
                        this.mode = StorageMode.BOTH;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Collections.unmodifiableList(this.listData);
    }

    public Map<K, V> getMap() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.LIST;
        if (storageMode == storageMode2) {
            synchronized (this) {
                try {
                    if (this.mode == storageMode2) {
                        this.mapData = convertListToMap(this.listData);
                        this.mode = StorageMode.BOTH;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Collections.unmodifiableMap(this.mapData);
    }

    public Message getMapEntryMessageDefaultInstance() {
        return this.converter.getMessageDefaultInstance();
    }

    public List<Message> getMutableList() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.LIST;
        if (storageMode != storageMode2) {
            if (this.mode == StorageMode.MAP) {
                this.listData = convertMapToList(this.mapData);
            }
            this.mapData = null;
            this.mode = storageMode2;
        }
        return this.listData;
    }

    public Map<K, V> getMutableMap() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.MAP;
        if (storageMode != storageMode2) {
            if (this.mode == StorageMode.LIST) {
                this.mapData = convertListToMap(this.listData);
            }
            this.listData = null;
            this.mode = storageMode2;
        }
        return this.mapData;
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(getMap());
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public void mergeFrom(MapField<K, V> mapField) {
        getMutableMap().putAll(MapFieldLite.copy(mapField.getMap()));
    }

    private MapField(MapEntry<K, V> mapEntry, StorageMode storageMode, Map<K, V> map) {
        this(new ImmutableMessageConverter(mapEntry), storageMode, map);
    }
}
