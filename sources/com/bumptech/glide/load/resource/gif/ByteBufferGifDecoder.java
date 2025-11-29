package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.geetest.sdk.x;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    public static final GifDecoderFactory f = new GifDecoderFactory();
    public static final GifHeaderParserPool g = new GifHeaderParserPool();

    /* renamed from: a  reason: collision with root package name */
    public final Context f2660a;
    public final List b;
    public final GifHeaderParserPool c;
    public final GifDecoderFactory d;
    public final GifBitmapProvider e;

    @VisibleForTesting
    public static class GifDecoderFactory {
        public GifDecoder a(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i);
        }
    }

    @VisibleForTesting
    public static class GifHeaderParserPool {

        /* renamed from: a  reason: collision with root package name */
        public final Queue f2661a = Util.g(0);

        public synchronized GifHeaderParser a(ByteBuffer byteBuffer) {
            GifHeaderParser gifHeaderParser;
            try {
                gifHeaderParser = (GifHeaderParser) this.f2661a.poll();
                if (gifHeaderParser == null) {
                    gifHeaderParser = new GifHeaderParser();
                }
            } catch (Throwable th) {
                throw th;
            }
            return gifHeaderParser.p(byteBuffer);
        }

        public synchronized void b(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.a();
            this.f2661a.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context, List list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, g, f);
    }

    public static int e(GifHeader gifHeader, int i, int i2) {
        int min = Math.min(gifHeader.a() / i2, gifHeader.d() / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + x.f + i2 + "], actual dimens: [" + gifHeader.d() + x.f + gifHeader.a() + "]");
        }
        return max;
    }

    public final GifDrawableResource c(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        long b2 = LogTime.b();
        try {
            GifHeader c2 = gifHeaderParser.c();
            if (c2.b() > 0) {
                if (c2.c() == 0) {
                    Bitmap.Config config = options.c(GifOptions.f2666a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                    GifDecoder a2 = this.d.a(this.e, c2, byteBuffer, e(c2, i, i2));
                    a2.a(config);
                    a2.f();
                    Bitmap e2 = a2.e();
                    if (e2 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(b2));
                        }
                        return null;
                    }
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f2660a, a2, UnitTransformation.c(), i, i2, e2));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(b2));
                    }
                    return gifDrawableResource;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(b2));
            }
        }
    }

    /* renamed from: d */
    public GifDrawableResource b(ByteBuffer byteBuffer, int i, int i2, Options options) {
        GifHeaderParser a2 = this.c.a(byteBuffer);
        try {
            return c(byteBuffer, i, i2, a2, options);
        } finally {
            this.c.b(a2);
        }
    }

    /* renamed from: f */
    public boolean a(ByteBuffer byteBuffer, Options options) {
        return !((Boolean) options.c(GifOptions.b)).booleanValue() && ImageHeaderParserUtils.g(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context, List list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.f2660a = context.getApplicationContext();
        this.b = list;
        this.d = gifDecoderFactory;
        this.e = new GifBitmapProvider(bitmapPool, arrayPool);
        this.c = gifHeaderParserPool;
    }
}
