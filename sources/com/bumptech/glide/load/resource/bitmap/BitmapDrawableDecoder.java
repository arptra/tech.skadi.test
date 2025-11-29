package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final ResourceDecoder f2612a;
    public final Resources b;

    public BitmapDrawableDecoder(Resources resources, ResourceDecoder resourceDecoder) {
        this.b = (Resources) Preconditions.d(resources);
        this.f2612a = (ResourceDecoder) Preconditions.d(resourceDecoder);
    }

    public boolean a(Object obj, Options options) {
        return this.f2612a.a(obj, options);
    }

    public Resource b(Object obj, int i, int i2, Options options) {
        return LazyBitmapDrawableResource.e(this.b, this.f2612a.b(obj, i, i2, options));
    }
}
