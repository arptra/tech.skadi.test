package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import com.geetest.sdk.x;

class AttributeStrategy implements LruPoolStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final KeyPool f2503a;
    public final GroupedLinkedMap b;

    @VisibleForTesting
    public static class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        public final KeyPool f2504a;
        public int b;
        public int c;
        public Bitmap.Config d;

        public Key(KeyPool keyPool) {
            this.f2504a = keyPool;
        }

        public void a() {
            this.f2504a.c(this);
        }

        public void b(int i, int i2, Bitmap.Config config) {
            this.b = i;
            this.c = i2;
            this.d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.b == key.b && this.c == key.c && this.d == key.d;
        }

        public int hashCode() {
            int i = ((this.b * 31) + this.c) * 31;
            Bitmap.Config config = this.d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.f(this.b, this.c, this.d);
        }
    }

    @VisibleForTesting
    public static class KeyPool extends BaseKeyPool<Key> {
        /* renamed from: d */
        public Key a() {
            return new Key(this);
        }

        public Key e(int i, int i2, Bitmap.Config config) {
            Key key = (Key) b();
            key.b(i, i2, config);
            return key;
        }
    }

    public static String f(int i, int i2, Bitmap.Config config) {
        return "[" + i + x.f + i2 + "], " + config;
    }

    public static String g(Bitmap bitmap) {
        return f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public String a(int i, int i2, Bitmap.Config config) {
        return f(i, i2, config);
    }

    public int b(Bitmap bitmap) {
        return Util.i(bitmap);
    }

    public void c(Bitmap bitmap) {
        this.b.d(this.f2503a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return (Bitmap) this.b.a(this.f2503a.e(i, i2, config));
    }

    public String e(Bitmap bitmap) {
        return g(bitmap);
    }

    public Bitmap removeLast() {
        return (Bitmap) this.b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }
}
