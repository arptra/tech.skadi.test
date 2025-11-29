package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public interface MemoryCache {

    public interface ResourceRemovedListener {
        void d(Resource resource);
    }

    void a(int i);

    void b();

    long c();

    Resource d(Key key, Resource resource);

    Resource e(Key key);

    void f(ResourceRemovedListener resourceRemovedListener);

    long getMaxSize();
}
