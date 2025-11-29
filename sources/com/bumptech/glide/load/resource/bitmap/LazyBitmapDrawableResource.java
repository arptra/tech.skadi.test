package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f2633a;
    public final Resource b;

    public LazyBitmapDrawableResource(Resources resources, Resource resource) {
        this.f2633a = (Resources) Preconditions.d(resources);
        this.b = (Resource) Preconditions.d(resource);
    }

    public static Resource e(Resources resources, Resource resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }

    public void a() {
        this.b.a();
    }

    public int b() {
        return this.b.b();
    }

    public Class c() {
        return BitmapDrawable.class;
    }

    /* renamed from: d */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f2633a, (Bitmap) this.b.get());
    }

    public void initialize() {
        Resource resource = this.b;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
    }
}
