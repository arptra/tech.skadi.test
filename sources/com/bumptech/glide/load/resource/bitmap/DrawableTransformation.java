package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class DrawableTransformation implements Transformation<Drawable> {
    public final Transformation b;
    public final boolean c;

    public DrawableTransformation(Transformation transformation, boolean z) {
        this.b = transformation;
        this.c = z;
    }

    public Resource a(Context context, Resource resource, int i, int i2) {
        BitmapPool f = Glide.c(context).f();
        Drawable drawable = (Drawable) resource.get();
        Resource a2 = DrawableToBitmapConverter.a(f, drawable, i, i2);
        if (a2 != null) {
            Resource a3 = this.b.a(context, a2, i, i2);
            if (!a3.equals(a2)) {
                return d(context, a3);
            }
            a3.a();
            return resource;
        } else if (!this.c) {
            return resource;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    public Transformation c() {
        return this;
    }

    public final Resource d(Context context, Resource resource) {
        return LazyBitmapDrawableResource.e(context.getResources(), resource);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.b.equals(((DrawableTransformation) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}
