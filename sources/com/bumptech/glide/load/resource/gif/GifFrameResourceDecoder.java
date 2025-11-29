package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public final class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final BitmapPool f2665a;

    public GifFrameResourceDecoder(BitmapPool bitmapPool) {
        this.f2665a = bitmapPool;
    }

    /* renamed from: c */
    public Resource b(GifDecoder gifDecoder, int i, int i2, Options options) {
        return BitmapResource.e(gifDecoder.e(), this.f2665a);
    }

    /* renamed from: d */
    public boolean a(GifDecoder gifDecoder, Options options) {
        return true;
    }
}
