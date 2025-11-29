package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f2669a;

    public BitmapDrawableTranscoder(Resources resources) {
        this.f2669a = (Resources) Preconditions.d(resources);
    }

    public Resource a(Resource resource, Options options) {
        return LazyBitmapDrawableResource.e(this.f2669a, resource);
    }
}
