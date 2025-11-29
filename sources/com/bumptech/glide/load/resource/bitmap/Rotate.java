package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class Rotate extends BitmapTransformation {
    public static final byte[] c = "com.bumptech.glide.load.resource.bitmap.Rotate".getBytes(Key.f2451a);
    public final int b;

    public void b(MessageDigest messageDigest) {
        messageDigest.update(c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    public Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.n(bitmap, this.b);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Rotate) && this.b == ((Rotate) obj).b;
    }

    public int hashCode() {
        return Util.p(-950519196, Util.o(this.b));
    }
}
