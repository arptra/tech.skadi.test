package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final ResourceDrawableDecoder f2636a;
    public final BitmapPool b;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.f2636a = resourceDrawableDecoder;
        this.b = bitmapPool;
    }

    /* renamed from: c */
    public Resource b(Uri uri, int i, int i2, Options options) {
        Resource c = this.f2636a.b(uri, i, i2, options);
        if (c == null) {
            return null;
        }
        return DrawableToBitmapConverter.a(this.b, (Drawable) c.get(), i, i2);
    }

    /* renamed from: d */
    public boolean a(Uri uri, Options options) {
        return "android.resource".equals(uri.getScheme());
    }
}
