package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final BitmapPool f2613a;
    public final ResourceEncoder b;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder resourceEncoder) {
        this.f2613a = bitmapPool;
        this.b = resourceEncoder;
    }

    public EncodeStrategy b(Options options) {
        return this.b.b(options);
    }

    /* renamed from: c */
    public boolean a(Resource resource, File file, Options options) {
        return this.b.a(new BitmapResource(((BitmapDrawable) resource.get()).getBitmap(), this.f2613a), file, options);
    }
}
