package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

public class DiskCacheAdapter implements DiskCache {

    public static final class Factory implements DiskCache.Factory {
        public DiskCache build() {
            return new DiskCacheAdapter();
        }
    }

    public void a(Key key, DiskCache.Writer writer) {
    }

    public File b(Key key) {
        return null;
    }
}
