package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    /* renamed from: c */
    public Resource b(Drawable drawable, int i, int i2, Options options) {
        return NonOwnedDrawableResource.e(drawable);
    }

    /* renamed from: d */
    public boolean a(Drawable drawable, Options options) {
        return true;
    }
}
