package com.google.common.graph;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
    @NullableDecl
    private volatile transient CacheEntry<K, V> cacheEntry1;
    @NullableDecl
    private volatile transient CacheEntry<K, V> cacheEntry2;

    public static final class CacheEntry<K, V> {
        final K key;
        final V value;

        public CacheEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    public MapRetrievalCache(Map<K, V> map) {
        super(map);
    }

    private void addToCache(K k, V v) {
        addToCache(new CacheEntry(k, v));
    }

    public void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    public V get(@NullableDecl Object obj) {
        V ifCached = getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        V withoutCaching = getWithoutCaching(obj);
        if (withoutCaching != null) {
            addToCache(obj, withoutCaching);
        }
        return withoutCaching;
    }

    public V getIfCached(@NullableDecl Object obj) {
        V ifCached = super.getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        CacheEntry<K, V> cacheEntry = this.cacheEntry1;
        if (cacheEntry != null && cacheEntry.key == obj) {
            return cacheEntry.value;
        }
        CacheEntry<K, V> cacheEntry3 = this.cacheEntry2;
        if (cacheEntry3 == null || cacheEntry3.key != obj) {
            return null;
        }
        addToCache(cacheEntry3);
        return cacheEntry3.value;
    }

    private void addToCache(CacheEntry<K, V> cacheEntry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = cacheEntry;
    }
}
