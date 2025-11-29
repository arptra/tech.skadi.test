package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import com.geetest.sdk.x;
import java.security.MessageDigest;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class BitmapPreFillRunner implements Runnable {
    public static final Clock i = new Clock();
    public static final long j = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: a  reason: collision with root package name */
    public final BitmapPool f2541a;
    public final MemoryCache b;
    public final PreFillQueue c;
    public final Clock d;
    public final Set e;
    public final Handler f;
    public long g;
    public boolean h;

    @VisibleForTesting
    public static class Clock {
        public long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    public static final class UniqueKey implements Key {
        public void b(MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean a() {
        Bitmap bitmap;
        long a2 = this.d.a();
        while (!this.c.a() && !d(a2)) {
            PreFillType b2 = this.c.b();
            if (!this.e.contains(b2)) {
                this.e.add(b2);
                bitmap = this.f2541a.e(b2.c(), b2.b(), b2.a());
            } else {
                bitmap = Bitmap.createBitmap(b2.c(), b2.b(), b2.a());
            }
            int i2 = Util.i(bitmap);
            if (b() >= ((long) i2)) {
                this.b.d(new UniqueKey(), BitmapResource.e(bitmap, this.f2541a));
            } else {
                this.f2541a.c(bitmap);
            }
            if (Log.isLoggable("PreFillRunner", 3)) {
                Log.d("PreFillRunner", "allocated [" + b2.c() + x.f + b2.b() + "] " + b2.a() + " size: " + i2);
            }
        }
        return !this.h && !this.c.a();
    }

    public final long b() {
        return this.b.getMaxSize() - this.b.c();
    }

    public final long c() {
        long j2 = this.g;
        this.g = Math.min(4 * j2, j);
        return j2;
    }

    public final boolean d(long j2) {
        return this.d.a() - j2 >= 32;
    }

    public void run() {
        if (a()) {
            this.f.postDelayed(this, c());
        }
    }
}
