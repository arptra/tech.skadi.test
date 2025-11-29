package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import com.geetest.sdk.x;

@RequiresApi
public final class BitmapImageDecoderResourceDecoder implements ResourceDecoder<ImageDecoder.Source, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final BitmapPool f2615a = new BitmapPoolAdapter();

    /* renamed from: c */
    public Resource b(ImageDecoder.Source source, int i, int i2, Options options) {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new DefaultOnHeaderDecodedListener(i, i2, options));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + x.f + decodeBitmap.getHeight() + "] for [" + i + x.f + i2 + "]");
        }
        return new BitmapResource(decodeBitmap, this.f2615a);
    }

    /* renamed from: d */
    public boolean a(ImageDecoder.Source source, Options options) {
        return true;
    }
}
