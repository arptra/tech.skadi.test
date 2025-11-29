package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget<Bitmap> {
    /* renamed from: u */
    public Drawable t(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.b).getResources(), bitmap);
    }
}
