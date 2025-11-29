package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> implements Initializable {
    public final BitmapPool b;

    public void a() {
        this.b.c(((BitmapDrawable) this.f2658a).getBitmap());
    }

    public int b() {
        return Util.i(((BitmapDrawable) this.f2658a).getBitmap());
    }

    public Class c() {
        return BitmapDrawable.class;
    }

    public void initialize() {
        ((BitmapDrawable) this.f2658a).getBitmap().prepareToDraw();
    }
}
