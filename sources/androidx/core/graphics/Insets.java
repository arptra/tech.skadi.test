package androidx.core.graphics;

import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class Insets {
    public static final Insets e = new Insets(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f712a;
    public final int b;
    public final int c;
    public final int d;

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static android.graphics.Insets a(int i, int i2, int i3, int i4) {
            return android.graphics.Insets.of(i, i2, i3, i4);
        }
    }

    public Insets(int i, int i2, int i3, int i4) {
        this.f712a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static Insets a(Insets insets, Insets insets2) {
        return b(Math.max(insets.f712a, insets2.f712a), Math.max(insets.b, insets2.b), Math.max(insets.c, insets2.c), Math.max(insets.d, insets2.d));
    }

    public static Insets b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new Insets(i, i2, i3, i4);
    }

    public static Insets c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static Insets d(android.graphics.Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public android.graphics.Insets e() {
        return Api29Impl.a(this.f712a, this.b, this.c, this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.d == insets.d && this.f712a == insets.f712a && this.c == insets.c && this.b == insets.b;
    }

    public int hashCode() {
        return (((((this.f712a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "Insets{left=" + this.f712a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
