package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;

public final class PreFillType {
    public static final Bitmap.Config e = Bitmap.Config.RGB_565;

    /* renamed from: a  reason: collision with root package name */
    public final int f2543a;
    public final int b;
    public final Bitmap.Config c;
    public final int d;

    public static class Builder {
    }

    public Bitmap.Config a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f2543a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        return this.b == preFillType.b && this.f2543a == preFillType.f2543a && this.d == preFillType.d && this.c == preFillType.c;
    }

    public int hashCode() {
        return (((((this.f2543a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f2543a + ", height=" + this.b + ", config=" + this.c + ", weight=" + this.d + '}';
    }
}
