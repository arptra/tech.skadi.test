package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class FitCenter extends BitmapTransformation {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(Key.f2451a);

    public void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    public Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.f(bitmapPool, bitmap, i, i2);
    }

    public boolean equals(Object obj) {
        return obj instanceof FitCenter;
    }

    public int hashCode() {
        return 1572326941;
    }
}
