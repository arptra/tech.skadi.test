package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

public class MemoryCacheAdapter implements MemoryCache {

    /* renamed from: a  reason: collision with root package name */
    public MemoryCache.ResourceRemovedListener f2527a;

    public void a(int i) {
    }

    public void b() {
    }

    public long c() {
        return 0;
    }

    public Resource d(Key key, Resource resource) {
        if (resource == null) {
            return null;
        }
        this.f2527a.d(resource);
        return null;
    }

    public Resource e(Key key) {
        return null;
    }

    public void f(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f2527a = resourceRemovedListener;
    }

    public long getMaxSize() {
        return 0;
    }
}
