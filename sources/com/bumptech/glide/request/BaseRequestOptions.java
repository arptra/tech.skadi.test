package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.here.posclient.PositionEstimate;
import java.util.Map;

public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public int f2707a;
    public float b = 1.0f;
    public DiskCacheStrategy c = DiskCacheStrategy.e;
    public Priority d = Priority.NORMAL;
    public Drawable e;
    public int f;
    public Drawable g;
    public int h;
    public boolean i = true;
    public int j = -1;
    public int k = -1;
    public Key l = EmptySignature.c();
    public boolean m;
    public boolean n = true;
    public Drawable o;
    public int p;
    public Options q = new Options();
    public Map r = new CachedHashCodeArrayMap();
    public Class s = Object.class;
    public boolean t;
    public Resources.Theme u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y = true;
    public boolean z;

    public static boolean J(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public final Map A() {
        return this.r;
    }

    public final boolean B() {
        return this.z;
    }

    public final boolean C() {
        return this.w;
    }

    public final boolean D() {
        return this.v;
    }

    public final boolean E(BaseRequestOptions baseRequestOptions) {
        return Float.compare(baseRequestOptions.b, this.b) == 0 && this.f == baseRequestOptions.f && Util.e(this.e, baseRequestOptions.e) && this.h == baseRequestOptions.h && Util.e(this.g, baseRequestOptions.g) && this.p == baseRequestOptions.p && Util.e(this.o, baseRequestOptions.o) && this.i == baseRequestOptions.i && this.j == baseRequestOptions.j && this.k == baseRequestOptions.k && this.m == baseRequestOptions.m && this.n == baseRequestOptions.n && this.w == baseRequestOptions.w && this.x == baseRequestOptions.x && this.c.equals(baseRequestOptions.c) && this.d == baseRequestOptions.d && this.q.equals(baseRequestOptions.q) && this.r.equals(baseRequestOptions.r) && this.s.equals(baseRequestOptions.s) && Util.e(this.l, baseRequestOptions.l) && Util.e(this.u, baseRequestOptions.u);
    }

    public final boolean F() {
        return this.i;
    }

    public final boolean G() {
        return I(8);
    }

    public boolean H() {
        return this.y;
    }

    public final boolean I(int i2) {
        return J(this.f2707a, i2);
    }

    public final boolean K() {
        return this.n;
    }

    public final boolean L() {
        return this.m;
    }

    public final boolean M() {
        return I(2048);
    }

    public final boolean N() {
        return Util.v(this.k, this.j);
    }

    public BaseRequestOptions O() {
        this.t = true;
        return a0();
    }

    public BaseRequestOptions P() {
        return T(DownsampleStrategy.e, new CenterCrop());
    }

    public BaseRequestOptions Q() {
        return S(DownsampleStrategy.d, new CenterInside());
    }

    public BaseRequestOptions R() {
        return S(DownsampleStrategy.c, new FitCenter());
    }

    public final BaseRequestOptions S(DownsampleStrategy downsampleStrategy, Transformation transformation) {
        return Z(downsampleStrategy, transformation, false);
    }

    public final BaseRequestOptions T(DownsampleStrategy downsampleStrategy, Transformation transformation) {
        if (this.v) {
            return clone().T(downsampleStrategy, transformation);
        }
        i(downsampleStrategy);
        return i0(transformation, false);
    }

    public BaseRequestOptions U(int i2, int i3) {
        if (this.v) {
            return clone().U(i2, i3);
        }
        this.k = i2;
        this.j = i3;
        this.f2707a |= 512;
        return b0();
    }

    public BaseRequestOptions V(int i2) {
        if (this.v) {
            return clone().V(i2);
        }
        this.h = i2;
        this.g = null;
        this.f2707a = (this.f2707a | 128) & -65;
        return b0();
    }

    public BaseRequestOptions W(Priority priority) {
        if (this.v) {
            return clone().W(priority);
        }
        this.d = (Priority) Preconditions.d(priority);
        this.f2707a |= 8;
        return b0();
    }

    public BaseRequestOptions X(Option option) {
        if (this.v) {
            return clone().X(option);
        }
        this.q.e(option);
        return b0();
    }

    public final BaseRequestOptions Y(DownsampleStrategy downsampleStrategy, Transformation transformation) {
        return Z(downsampleStrategy, transformation, true);
    }

    public final BaseRequestOptions Z(DownsampleStrategy downsampleStrategy, Transformation transformation, boolean z2) {
        BaseRequestOptions j0 = z2 ? j0(downsampleStrategy, transformation) : T(downsampleStrategy, transformation);
        j0.y = true;
        return j0;
    }

    public final BaseRequestOptions a0() {
        return this;
    }

    public BaseRequestOptions b(BaseRequestOptions baseRequestOptions) {
        if (this.v) {
            return clone().b(baseRequestOptions);
        }
        if (J(baseRequestOptions.f2707a, 2)) {
            this.b = baseRequestOptions.b;
        }
        if (J(baseRequestOptions.f2707a, PositionEstimate.Value.BUILDING_NAME)) {
            this.w = baseRequestOptions.w;
        }
        if (J(baseRequestOptions.f2707a, PositionEstimate.Value.SITUATION)) {
            this.z = baseRequestOptions.z;
        }
        if (J(baseRequestOptions.f2707a, 4)) {
            this.c = baseRequestOptions.c;
        }
        if (J(baseRequestOptions.f2707a, 8)) {
            this.d = baseRequestOptions.d;
        }
        if (J(baseRequestOptions.f2707a, 16)) {
            this.e = baseRequestOptions.e;
            this.f = 0;
            this.f2707a &= -33;
        }
        if (J(baseRequestOptions.f2707a, 32)) {
            this.f = baseRequestOptions.f;
            this.e = null;
            this.f2707a &= -17;
        }
        if (J(baseRequestOptions.f2707a, 64)) {
            this.g = baseRequestOptions.g;
            this.h = 0;
            this.f2707a &= -129;
        }
        if (J(baseRequestOptions.f2707a, 128)) {
            this.h = baseRequestOptions.h;
            this.g = null;
            this.f2707a &= -65;
        }
        if (J(baseRequestOptions.f2707a, 256)) {
            this.i = baseRequestOptions.i;
        }
        if (J(baseRequestOptions.f2707a, 512)) {
            this.k = baseRequestOptions.k;
            this.j = baseRequestOptions.j;
        }
        if (J(baseRequestOptions.f2707a, 1024)) {
            this.l = baseRequestOptions.l;
        }
        if (J(baseRequestOptions.f2707a, 4096)) {
            this.s = baseRequestOptions.s;
        }
        if (J(baseRequestOptions.f2707a, 8192)) {
            this.o = baseRequestOptions.o;
            this.p = 0;
            this.f2707a &= -16385;
        }
        if (J(baseRequestOptions.f2707a, 16384)) {
            this.p = baseRequestOptions.p;
            this.o = null;
            this.f2707a &= -8193;
        }
        if (J(baseRequestOptions.f2707a, 32768)) {
            this.u = baseRequestOptions.u;
        }
        if (J(baseRequestOptions.f2707a, 65536)) {
            this.n = baseRequestOptions.n;
        }
        if (J(baseRequestOptions.f2707a, 131072)) {
            this.m = baseRequestOptions.m;
        }
        if (J(baseRequestOptions.f2707a, 2048)) {
            this.r.putAll(baseRequestOptions.r);
            this.y = baseRequestOptions.y;
        }
        if (J(baseRequestOptions.f2707a, PositionEstimate.Value.TIME_SINCE_BOOT)) {
            this.x = baseRequestOptions.x;
        }
        if (!this.n) {
            this.r.clear();
            int i2 = this.f2707a;
            this.m = false;
            this.f2707a = i2 & -133121;
            this.y = true;
        }
        this.f2707a |= baseRequestOptions.f2707a;
        this.q.d(baseRequestOptions.q);
        return b0();
    }

    public final BaseRequestOptions b0() {
        if (!this.t) {
            return a0();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public BaseRequestOptions c() {
        if (!this.t || this.v) {
            this.v = true;
            return O();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public BaseRequestOptions c0(Option option, Object obj) {
        if (this.v) {
            return clone().c0(option, obj);
        }
        Preconditions.d(option);
        Preconditions.d(obj);
        this.q.f(option, obj);
        return b0();
    }

    public BaseRequestOptions d() {
        return j0(DownsampleStrategy.e, new CenterCrop());
    }

    public BaseRequestOptions d0(Key key) {
        if (this.v) {
            return clone().d0(key);
        }
        this.l = (Key) Preconditions.d(key);
        this.f2707a |= 1024;
        return b0();
    }

    public BaseRequestOptions e() {
        return j0(DownsampleStrategy.d, new CircleCrop());
    }

    public BaseRequestOptions e0(float f2) {
        if (this.v) {
            return clone().e0(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.b = f2;
        this.f2707a |= 2;
        return b0();
    }

    public boolean equals(Object obj) {
        if (obj instanceof BaseRequestOptions) {
            return E((BaseRequestOptions) obj);
        }
        return false;
    }

    /* renamed from: f */
    public BaseRequestOptions clone() {
        try {
            BaseRequestOptions baseRequestOptions = (BaseRequestOptions) super.clone();
            Options options = new Options();
            baseRequestOptions.q = options;
            options.d(this.q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            baseRequestOptions.r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.r);
            baseRequestOptions.t = false;
            baseRequestOptions.v = false;
            return baseRequestOptions;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public BaseRequestOptions f0(boolean z2) {
        if (this.v) {
            return clone().f0(true);
        }
        this.i = !z2;
        this.f2707a |= 256;
        return b0();
    }

    public BaseRequestOptions g(Class cls) {
        if (this.v) {
            return clone().g(cls);
        }
        this.s = (Class) Preconditions.d(cls);
        this.f2707a |= 4096;
        return b0();
    }

    public BaseRequestOptions g0(Resources.Theme theme) {
        if (this.v) {
            return clone().g0(theme);
        }
        this.u = theme;
        if (theme != null) {
            this.f2707a |= 32768;
            return c0(ResourceDrawableDecoder.b, theme);
        }
        this.f2707a &= -32769;
        return X(ResourceDrawableDecoder.b);
    }

    public BaseRequestOptions h(DiskCacheStrategy diskCacheStrategy) {
        if (this.v) {
            return clone().h(diskCacheStrategy);
        }
        this.c = (DiskCacheStrategy) Preconditions.d(diskCacheStrategy);
        this.f2707a |= 4;
        return b0();
    }

    public BaseRequestOptions h0(Transformation transformation) {
        return i0(transformation, true);
    }

    public int hashCode() {
        return Util.q(this.u, Util.q(this.l, Util.q(this.s, Util.q(this.r, Util.q(this.q, Util.q(this.d, Util.q(this.c, Util.r(this.x, Util.r(this.w, Util.r(this.n, Util.r(this.m, Util.p(this.k, Util.p(this.j, Util.r(this.i, Util.q(this.o, Util.p(this.p, Util.q(this.g, Util.p(this.h, Util.q(this.e, Util.p(this.f, Util.m(this.b)))))))))))))))))))));
    }

    public BaseRequestOptions i(DownsampleStrategy downsampleStrategy) {
        return c0(DownsampleStrategy.h, Preconditions.d(downsampleStrategy));
    }

    public BaseRequestOptions i0(Transformation transformation, boolean z2) {
        if (this.v) {
            return clone().i0(transformation, z2);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z2);
        k0(Bitmap.class, transformation, z2);
        k0(Drawable.class, drawableTransformation, z2);
        k0(BitmapDrawable.class, drawableTransformation.c(), z2);
        k0(GifDrawable.class, new GifDrawableTransformation(transformation), z2);
        return b0();
    }

    public BaseRequestOptions j() {
        return Y(DownsampleStrategy.c, new FitCenter());
    }

    public final BaseRequestOptions j0(DownsampleStrategy downsampleStrategy, Transformation transformation) {
        if (this.v) {
            return clone().j0(downsampleStrategy, transformation);
        }
        i(downsampleStrategy);
        return h0(transformation);
    }

    public final DiskCacheStrategy k() {
        return this.c;
    }

    public BaseRequestOptions k0(Class cls, Transformation transformation, boolean z2) {
        if (this.v) {
            return clone().k0(cls, transformation, z2);
        }
        Preconditions.d(cls);
        Preconditions.d(transformation);
        this.r.put(cls, transformation);
        int i2 = this.f2707a;
        this.n = true;
        this.f2707a = 67584 | i2;
        this.y = false;
        if (z2) {
            this.f2707a = i2 | 198656;
            this.m = true;
        }
        return b0();
    }

    public final int l() {
        return this.f;
    }

    public BaseRequestOptions l0(Transformation... transformationArr) {
        return transformationArr.length > 1 ? i0(new MultiTransformation(transformationArr), true) : transformationArr.length == 1 ? h0(transformationArr[0]) : b0();
    }

    public final Drawable m() {
        return this.e;
    }

    public BaseRequestOptions m0(boolean z2) {
        if (this.v) {
            return clone().m0(z2);
        }
        this.z = z2;
        this.f2707a |= PositionEstimate.Value.SITUATION;
        return b0();
    }

    public final Drawable n() {
        return this.o;
    }

    public final int o() {
        return this.p;
    }

    public final boolean p() {
        return this.x;
    }

    public final Options q() {
        return this.q;
    }

    public final int r() {
        return this.j;
    }

    public final int s() {
        return this.k;
    }

    public final Drawable t() {
        return this.g;
    }

    public final int u() {
        return this.h;
    }

    public final Priority v() {
        return this.d;
    }

    public final Class w() {
        return this.s;
    }

    public final Key x() {
        return this.l;
    }

    public final float y() {
        return this.b;
    }

    public final Resources.Theme z() {
        return this.u;
    }
}
