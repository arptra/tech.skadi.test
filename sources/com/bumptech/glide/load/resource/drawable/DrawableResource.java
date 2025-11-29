package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f2658a;

    public DrawableResource(Drawable drawable) {
        this.f2658a = (Drawable) Preconditions.d(drawable);
    }

    /* renamed from: d */
    public final Drawable get() {
        Drawable.ConstantState constantState = this.f2658a.getConstantState();
        return constantState == null ? this.f2658a : constantState.newDrawable();
    }

    public void initialize() {
        Drawable drawable = this.f2658a;
        if (drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
        } else if (drawable instanceof GifDrawable) {
            ((GifDrawable) drawable).e().prepareToDraw();
        }
    }
}
