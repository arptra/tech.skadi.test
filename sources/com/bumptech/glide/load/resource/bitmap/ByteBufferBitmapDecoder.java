package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.nio.ByteBuffer;

public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final Downsampler f2617a;

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.f2617a = downsampler;
    }

    /* renamed from: c */
    public Resource b(ByteBuffer byteBuffer, int i, int i2, Options options) {
        return this.f2617a.g(byteBuffer, i, i2, options);
    }

    /* renamed from: d */
    public boolean a(ByteBuffer byteBuffer, Options options) {
        return this.f2617a.q(byteBuffer);
    }
}
