package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.util.Log;
import com.geetest.sdk.x;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
    public static final Bitmap.Config k = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    public final LruPoolStrategy f2510a;
    public final Set b;
    public final long c;
    public final BitmapTracker d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public int j;

    public interface BitmapTracker {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    public static final class NullBitmapTracker implements BitmapTracker {
        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }
    }

    public static class ThrowingBitmapTracker implements BitmapTracker {

        /* renamed from: a  reason: collision with root package name */
        public final Set f2511a;

        public void a(Bitmap bitmap) {
            if (!this.f2511a.contains(bitmap)) {
                this.f2511a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + x.f + bitmap.getHeight() + "]");
        }

        public void b(Bitmap bitmap) {
            if (this.f2511a.contains(bitmap)) {
                this.f2511a.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    public LruBitmapPool(long j2, LruPoolStrategy lruPoolStrategy, Set set) {
        this.c = j2;
        this.e = j2;
        this.f2510a = lruPoolStrategy;
        this.b = set;
        this.d = new NullBitmapTracker();
    }

    public static void f(Bitmap.Config config) {
        if (config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    public static Bitmap g(int i2, int i3, Bitmap.Config config) {
        if (config == null) {
            config = k;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    public static Set k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add((Object) null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(hashSet);
    }

    public static LruPoolStrategy l() {
        return new SizeConfigStrategy();
    }

    public static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    public static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    public void a(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 40 || i2 >= 20) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            q(n() / 2);
        }
    }

    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0);
    }

    public synchronized void c(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f2510a.b(bitmap)) <= this.e) {
                        if (this.b.contains(bitmap.getConfig())) {
                            int b2 = this.f2510a.b(bitmap);
                            this.f2510a.c(bitmap);
                            this.d.a(bitmap);
                            this.i++;
                            this.f += (long) b2;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f2510a.e(bitmap));
                            }
                            h();
                            j();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f2510a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        Bitmap m = m(i2, i3, config);
        if (m == null) {
            return g(i2, i3, config);
        }
        m.eraseColor(0);
        return m;
    }

    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        Bitmap m = m(i2, i3, config);
        return m == null ? g(i2, i3, config) : m;
    }

    public final void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    public final void i() {
        Log.v("LruBitmapPool", "Hits=" + this.g + ", misses=" + this.h + ", puts=" + this.i + ", evictions=" + this.j + ", currentSize=" + this.f + ", maxSize=" + this.e + "\nStrategy=" + this.f2510a);
    }

    public final void j() {
        q(this.e);
    }

    public final synchronized Bitmap m(int i2, int i3, Bitmap.Config config) {
        Bitmap d2;
        try {
            f(config);
            d2 = this.f2510a.d(i2, i3, config != null ? config : k);
            if (d2 == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f2510a.a(i2, i3, config));
                }
                this.h++;
            } else {
                this.g++;
                this.f -= (long) this.f2510a.b(d2);
                this.d.b(d2);
                p(d2);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f2510a.a(i2, i3, config));
            }
            h();
        } catch (Throwable th) {
            throw th;
        }
        return d2;
    }

    public long n() {
        return this.e;
    }

    public final synchronized void q(long j2) {
        while (this.f > j2) {
            try {
                Bitmap removeLast = this.f2510a.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        i();
                    }
                    this.f = 0;
                    return;
                }
                this.d.b(removeLast);
                this.f -= (long) this.f2510a.b(removeLast);
                this.j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f2510a.e(removeLast));
                }
                h();
                removeLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public LruBitmapPool(long j2) {
        this(j2, l(), k());
    }
}
