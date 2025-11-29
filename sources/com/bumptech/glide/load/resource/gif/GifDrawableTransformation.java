package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public class GifDrawableTransformation implements Transformation<GifDrawable> {
    public final Transformation b;

    public GifDrawableTransformation(Transformation transformation) {
        this.b = (Transformation) Preconditions.d(transformation);
    }

    public Resource a(Context context, Resource resource, int i, int i2) {
        GifDrawable gifDrawable = (GifDrawable) resource.get();
        BitmapResource bitmapResource = new BitmapResource(gifDrawable.e(), Glide.c(context).f());
        Resource a2 = this.b.a(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(a2)) {
            bitmapResource.a();
        }
        gifDrawable.m(this.b, (Bitmap) a2.get());
        return resource;
    }

    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof GifDrawableTransformation) {
            return this.b.equals(((GifDrawableTransformation) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}
