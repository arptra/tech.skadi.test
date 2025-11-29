package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class BitmapResource implements Resource<Bitmap>, Initializable {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f2616a;
    public final BitmapPool b;

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        this.f2616a = (Bitmap) Preconditions.e(bitmap, "Bitmap must not be null");
        this.b = (BitmapPool) Preconditions.e(bitmapPool, "BitmapPool must not be null");
    }

    public static BitmapResource e(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    public void a() {
        this.b.c(this.f2616a);
    }

    public int b() {
        return Util.i(this.f2616a);
    }

    public Class c() {
        return Bitmap.class;
    }

    /* renamed from: d */
    public Bitmap get() {
        return this.f2616a;
    }

    public void initialize() {
        this.f2616a.prepareToDraw();
    }
}
