package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.InputStream;

@RequiresApi
public final class InputStreamBitmapImageDecoderResourceDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final BitmapImageDecoderResourceDecoder f2632a = new BitmapImageDecoderResourceDecoder();

    /* renamed from: c */
    public Resource b(InputStream inputStream, int i, int i2, Options options) {
        return this.f2632a.b(ImageDecoder.createSource(ByteBufferUtil.b(inputStream)), i, i2, options);
    }

    /* renamed from: d */
    public boolean a(InputStream inputStream, Options options) {
        return true;
    }
}
