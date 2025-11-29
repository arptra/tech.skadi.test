package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

@RequiresApi
final class SizeStrategy implements LruPoolStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final KeyPool f2515a;
    public final GroupedLinkedMap b;
    public final NavigableMap c;

    @VisibleForTesting
    public static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        public final KeyPool f2516a;
        public int b;

        public Key(KeyPool keyPool) {
            this.f2516a = keyPool;
        }

        public void a() {
            this.f2516a.c(this);
        }

        public void b(int i) {
            this.b = i;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Key) && this.b == ((Key) obj).b;
        }

        public int hashCode() {
            return this.b;
        }

        public String toString() {
            return SizeStrategy.g(this.b);
        }
    }

    @VisibleForTesting
    public static class KeyPool extends BaseKeyPool<Key> {
        /* renamed from: d */
        public Key a() {
            return new Key(this);
        }

        public Key e(int i) {
            Key key = (Key) super.b();
            key.b(i);
            return key;
        }
    }

    public static String g(int i) {
        return "[" + i + "]";
    }

    private static String h(Bitmap bitmap) {
        return g(Util.i(bitmap));
    }

    public String a(int i, int i2, Bitmap.Config config) {
        return g(Util.h(i, i2, config));
    }

    public int b(Bitmap bitmap) {
        return Util.i(bitmap);
    }

    public void c(Bitmap bitmap) {
        Key e = this.f2515a.e(Util.i(bitmap));
        this.b.d(e, bitmap);
        Integer num = (Integer) this.c.get(Integer.valueOf(e.b));
        NavigableMap navigableMap = this.c;
        Integer valueOf = Integer.valueOf(e.b);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        navigableMap.put(valueOf, Integer.valueOf(i));
    }

    public Bitmap d(int i, int i2, Bitmap.Config config) {
        int h = Util.h(i, i2, config);
        Key e = this.f2515a.e(h);
        Integer num = (Integer) this.c.ceilingKey(Integer.valueOf(h));
        if (!(num == null || num.intValue() == h || num.intValue() > h * 8)) {
            this.f2515a.c(e);
            e = this.f2515a.e(num.intValue());
        }
        Bitmap bitmap = (Bitmap) this.b.a(e);
        if (bitmap != null) {
            bitmap.reconfigure(i, i2, config);
            f(num);
        }
        return bitmap;
    }

    public String e(Bitmap bitmap) {
        return h(bitmap);
    }

    public final void f(Integer num) {
        Integer num2 = (Integer) this.c.get(num);
        if (num2.intValue() == 1) {
            this.c.remove(num);
        } else {
            this.c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.b.f();
        if (bitmap != null) {
            f(Integer.valueOf(Util.i(bitmap)));
        }
        return bitmap;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.b + "\n  SortedSizes" + this.c;
    }
}
