package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements GifDecoder.BitmapProvider {

    /* renamed from: a  reason: collision with root package name */
    public final BitmapPool f2662a;
    public final ArrayPool b;

    public GifBitmapProvider(BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f2662a = bitmapPool;
        this.b = arrayPool;
    }

    public byte[] a(int i) {
        ArrayPool arrayPool = this.b;
        return arrayPool == null ? new byte[i] : (byte[]) arrayPool.c(i, byte[].class);
    }

    public Bitmap b(int i, int i2, Bitmap.Config config) {
        return this.f2662a.e(i, i2, config);
    }

    public void c(Bitmap bitmap) {
        this.f2662a.c(bitmap);
    }

    public int[] d(int i) {
        ArrayPool arrayPool = this.b;
        return arrayPool == null ? new int[i] : (int[]) arrayPool.c(i, int[].class);
    }

    public void e(byte[] bArr) {
        ArrayPool arrayPool = this.b;
        if (arrayPool != null) {
            arrayPool.put(bArr);
        }
    }

    public void f(int[] iArr) {
        ArrayPool arrayPool = this.b;
        if (arrayPool != null) {
            arrayPool.put(iArr);
        }
    }
}
