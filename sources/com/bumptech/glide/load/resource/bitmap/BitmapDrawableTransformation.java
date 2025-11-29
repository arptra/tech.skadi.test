package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

@Deprecated
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    public final Transformation b;

    public static Resource c(Resource resource) {
        if (resource.get() instanceof BitmapDrawable) {
            return resource;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + resource.get());
    }

    public static Resource d(Resource resource) {
        return resource;
    }

    public Resource a(Context context, Resource resource, int i, int i2) {
        return c(this.b.a(context, d(resource), i, i2));
    }

    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.b.equals(((BitmapDrawableTransformation) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}
