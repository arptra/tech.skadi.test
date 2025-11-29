package com.bumptech.glide.load.resource.transcode;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public final BitmapPool f2670a;
    public final ResourceTranscoder b;
    public final ResourceTranscoder c;

    public DrawableBytesTranscoder(BitmapPool bitmapPool, ResourceTranscoder resourceTranscoder, ResourceTranscoder resourceTranscoder2) {
        this.f2670a = bitmapPool;
        this.b = resourceTranscoder;
        this.c = resourceTranscoder2;
    }

    public static Resource b(Resource resource) {
        return resource;
    }

    public Resource a(Resource resource, Options options) {
        Drawable drawable = (Drawable) resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(BitmapResource.e(((BitmapDrawable) drawable).getBitmap(), this.f2670a), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.c.a(b(resource), options);
        }
        return null;
    }
}
