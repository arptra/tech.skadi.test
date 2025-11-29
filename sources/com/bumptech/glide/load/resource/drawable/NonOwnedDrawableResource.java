package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    public NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    public static Resource e(Drawable drawable) {
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }

    public void a() {
    }

    public int b() {
        return Math.max(1, this.f2658a.getIntrinsicWidth() * this.f2658a.getIntrinsicHeight() * 4);
    }

    public Class c() {
        return this.f2658a.getClass();
    }
}
