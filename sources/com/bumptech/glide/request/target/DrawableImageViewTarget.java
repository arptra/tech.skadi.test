package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    public DrawableImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* renamed from: t */
    public void r(Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }
}
