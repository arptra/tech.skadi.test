package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

@RequiresApi
public final class AnimatedImageDecoder {

    /* renamed from: a  reason: collision with root package name */
    public final List f2649a;
    public final ArrayPool b;

    public static final class AnimatedImageDrawableResource implements Resource<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        public final AnimatedImageDrawable f2650a;

        public AnimatedImageDrawableResource(AnimatedImageDrawable animatedImageDrawable) {
            this.f2650a = animatedImageDrawable;
        }

        public void a() {
            this.f2650a.stop();
            this.f2650a.clearAnimationCallbacks();
        }

        public int b() {
            return this.f2650a.getIntrinsicWidth() * this.f2650a.getIntrinsicHeight() * Util.j(Bitmap.Config.ARGB_8888) * 2;
        }

        public Class c() {
            return Drawable.class;
        }

        /* renamed from: d */
        public AnimatedImageDrawable get() {
            return this.f2650a;
        }
    }

    public static final class ByteBufferAnimatedImageDecoder implements ResourceDecoder<ByteBuffer, Drawable> {

        /* renamed from: a  reason: collision with root package name */
        public final AnimatedImageDecoder f2651a;

        public ByteBufferAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder) {
            this.f2651a = animatedImageDecoder;
        }

        /* renamed from: c */
        public Resource b(ByteBuffer byteBuffer, int i, int i2, Options options) {
            return this.f2651a.b(ImageDecoder.createSource(byteBuffer), i, i2, options);
        }

        /* renamed from: d */
        public boolean a(ByteBuffer byteBuffer, Options options) {
            return this.f2651a.d(byteBuffer);
        }
    }

    public static final class StreamAnimatedImageDecoder implements ResourceDecoder<InputStream, Drawable> {

        /* renamed from: a  reason: collision with root package name */
        public final AnimatedImageDecoder f2652a;

        public StreamAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder) {
            this.f2652a = animatedImageDecoder;
        }

        /* renamed from: c */
        public Resource b(InputStream inputStream, int i, int i2, Options options) {
            return this.f2652a.b(ImageDecoder.createSource(ByteBufferUtil.b(inputStream)), i, i2, options);
        }

        /* renamed from: d */
        public boolean a(InputStream inputStream, Options options) {
            return this.f2652a.c(inputStream);
        }
    }

    public AnimatedImageDecoder(List list, ArrayPool arrayPool) {
        this.f2649a = list;
        this.b = arrayPool;
    }

    public static ResourceDecoder a(List list, ArrayPool arrayPool) {
        return new ByteBufferAnimatedImageDecoder(new AnimatedImageDecoder(list, arrayPool));
    }

    public static ResourceDecoder f(List list, ArrayPool arrayPool) {
        return new StreamAnimatedImageDecoder(new AnimatedImageDecoder(list, arrayPool));
    }

    public Resource b(ImageDecoder.Source source, int i, int i2, Options options) {
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new DefaultOnHeaderDecodedListener(i, i2, options));
        if (decodeDrawable instanceof AnimatedImageDrawable) {
            return new AnimatedImageDrawableResource((AnimatedImageDrawable) decodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + decodeDrawable);
    }

    public boolean c(InputStream inputStream) {
        return e(ImageHeaderParserUtils.f(this.f2649a, inputStream, this.b));
    }

    public boolean d(ByteBuffer byteBuffer) {
        return e(ImageHeaderParserUtils.g(this.f2649a, byteBuffer));
    }

    public final boolean e(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF);
    }
}
