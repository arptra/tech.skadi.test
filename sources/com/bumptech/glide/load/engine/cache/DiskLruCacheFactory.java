package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final long f2520a;
    public final CacheDirectoryGetter b;

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$1  reason: invalid class name */
    class AnonymousClass1 implements CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2521a;

        public File a() {
            return new File(this.f2521a);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$2  reason: invalid class name */
    class AnonymousClass2 implements CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2522a;
        public final /* synthetic */ String b;

        public File a() {
            return new File(this.f2522a, this.b);
        }
    }

    public interface CacheDirectoryGetter {
        File a();
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j) {
        this.f2520a = j;
        this.b = cacheDirectoryGetter;
    }

    public DiskCache build() {
        File a2 = this.b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.isDirectory() || a2.mkdirs()) {
            return DiskLruCacheWrapper.c(a2, this.f2520a);
        }
        return null;
    }
}
