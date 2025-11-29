package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class RoundedCorners extends BitmapTransformation {
    public static final byte[] c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(Key.f2451a);
    public final int b;

    public RoundedCorners(int i) {
        Preconditions.a(i > 0, "roundingRadius must be greater than 0.");
        this.b = i;
    }

    public void b(MessageDigest messageDigest) {
        messageDigest.update(c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    public Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.q(bitmapPool, bitmap, this.b);
    }

    public boolean equals(Object obj) {
        return (obj instanceof RoundedCorners) && this.b == ((RoundedCorners) obj).b;
    }

    public int hashCode() {
        return Util.p(-569625254, Util.o(this.b));
    }
}
