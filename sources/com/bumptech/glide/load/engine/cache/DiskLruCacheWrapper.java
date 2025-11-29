package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {

    /* renamed from: a  reason: collision with root package name */
    public final SafeKeyGenerator f2523a;
    public final File b;
    public final long c;
    public final DiskCacheWriteLocker d = new DiskCacheWriteLocker();
    public DiskLruCache e;

    public DiskLruCacheWrapper(File file, long j) {
        this.b = file;
        this.c = j;
        this.f2523a = new SafeKeyGenerator();
    }

    public static DiskCache c(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    public void a(Key key, DiskCache.Writer writer) {
        DiskLruCache.Editor w;
        String b2 = this.f2523a.b(key);
        this.d.a(b2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b2 + " for for Key: " + key);
            }
            try {
                DiskLruCache d2 = d();
                if (d2.N(b2) == null) {
                    w = d2.w(b2);
                    if (w != null) {
                        if (writer.a(w.f(0))) {
                            w.e();
                        }
                        w.b();
                        this.d.b(b2);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + b2);
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            } catch (Throwable th) {
                w.b();
                throw th;
            }
        } finally {
            this.d.b(b2);
        }
    }

    public File b(Key key) {
        String b2 = this.f2523a.b(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b2 + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value N = d().N(b2);
            if (N != null) {
                return N.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }

    public final synchronized DiskLruCache d() {
        try {
            if (this.e == null) {
                this.e = DiskLruCache.T(this.b, 1, 1, this.c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e;
    }
}
