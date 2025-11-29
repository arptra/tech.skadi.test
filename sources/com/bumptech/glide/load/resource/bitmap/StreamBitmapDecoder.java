package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionPassthroughInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final Downsampler f2637a;
    public final ArrayPool b;

    public static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {

        /* renamed from: a  reason: collision with root package name */
        public final RecyclableBufferedInputStream f2638a;
        public final ExceptionPassthroughInputStream b;

        public UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionPassthroughInputStream exceptionPassthroughInputStream) {
            this.f2638a = recyclableBufferedInputStream;
            this.b = exceptionPassthroughInputStream;
        }

        public void a() {
            this.f2638a.b();
        }

        public void b(BitmapPool bitmapPool, Bitmap bitmap) {
            IOException a2 = this.b.a();
            if (a2 != null) {
                if (bitmap != null) {
                    bitmapPool.c(bitmap);
                }
                throw a2;
            }
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.f2637a = downsampler;
        this.b = arrayPool;
    }

    /* renamed from: c */
    public Resource b(InputStream inputStream, int i, int i2, Options options) {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            z = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.b);
        }
        ExceptionPassthroughInputStream b2 = ExceptionPassthroughInputStream.b(recyclableBufferedInputStream);
        try {
            return this.f2637a.f(new MarkEnforcingInputStream(b2), i, i2, options, new UntrustedCallbacks(recyclableBufferedInputStream, b2));
        } finally {
            b2.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    /* renamed from: d */
    public boolean a(InputStream inputStream, Options options) {
        return this.f2637a.p(inputStream);
    }
}
