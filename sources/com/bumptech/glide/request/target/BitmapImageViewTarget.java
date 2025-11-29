package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* renamed from: t */
    public void r(Bitmap bitmap) {
        ((ImageView) this.b).setImageBitmap(bitmap);
    }
}
