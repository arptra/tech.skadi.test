package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    public void r(Object obj) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.b).getLayoutParams();
        Drawable t = t(obj);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            t = new FixedSizeDrawable(t, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.b).setImageDrawable(t);
    }

    public abstract Drawable t(Object obj);
}
