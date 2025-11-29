package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    public MemoryCache.ResourceRemovedListener e;

    public LruResourceCache(long j) {
        super(j);
    }

    public void a(int i) {
        if (i >= 40) {
            b();
        } else if (i >= 20 || i == 15) {
            m(getMaxSize() / 2);
        }
    }

    public /* bridge */ /* synthetic */ Resource d(Key key, Resource resource) {
        return (Resource) super.k(key, resource);
    }

    public /* bridge */ /* synthetic */ Resource e(Key key) {
        return (Resource) super.l(key);
    }

    public void f(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.e = resourceRemovedListener;
    }

    /* renamed from: n */
    public int i(Resource resource) {
        return resource == null ? super.i((Object) null) : resource.b();
    }

    /* renamed from: o */
    public void j(Key key, Resource resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.e;
        if (resourceRemovedListener != null && resource != null) {
            resourceRemovedListener.d(resource);
        }
    }
}
