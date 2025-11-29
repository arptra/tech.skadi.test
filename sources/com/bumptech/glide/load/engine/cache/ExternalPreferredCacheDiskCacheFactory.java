package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory$1  reason: invalid class name */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f2525a;
        public final /* synthetic */ String b;

        public File a() {
            File externalCacheDir;
            File b2 = b();
            return ((b2 == null || !b2.exists()) && (externalCacheDir = this.f2525a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir : b2;
        }

        public final File b() {
            File cacheDir = this.f2525a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }
    }
}
