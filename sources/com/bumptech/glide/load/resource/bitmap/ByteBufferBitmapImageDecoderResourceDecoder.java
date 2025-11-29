package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.nio.ByteBuffer;

@RequiresApi
public final class ByteBufferBitmapImageDecoderResourceDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final BitmapImageDecoderResourceDecoder f2618a = new BitmapImageDecoderResourceDecoder();

    /* renamed from: c */
    public Resource b(ByteBuffer byteBuffer, int i, int i2, Options options) {
        return this.f2618a.b(ImageDecoder.createSource(byteBuffer), i, i2, options);
    }

    /* renamed from: d */
    public boolean a(ByteBuffer byteBuffer, Options options) {
        return true;
    }
}
