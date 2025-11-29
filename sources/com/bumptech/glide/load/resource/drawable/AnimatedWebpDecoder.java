package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
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
@Deprecated
public final class AnimatedWebpDecoder {

    /* renamed from: a  reason: collision with root package name */
    public final List f2653a;
    public final ArrayPool b;

    public static final class AnimatedImageDrawableResource implements Resource<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        public final AnimatedImageDrawable f2654a;

        public AnimatedImageDrawableResource(AnimatedImageDrawable animatedImageDrawable) {
            this.f2654a = animatedImageDrawable;
        }

        public void a() {
            this.f2654a.stop();
            this.f2654a.clearAnimationCallbacks();
        }

        public int b() {
            return this.f2654a.getIntrinsicWidth() * this.f2654a.getIntrinsicHeight() * Util.j(Bitmap.Config.ARGB_8888) * 2;
        }

        public Class c() {
            return Drawable.class;
        }

        /* renamed from: d */
        public AnimatedImageDrawable get() {
            return this.f2654a;
        }
    }

    public static final class ByteBufferAnimatedWebpDecoder implements ResourceDecoder<ByteBuffer, Drawable> {

        /* renamed from: a  reason: collision with root package name */
        public final AnimatedWebpDecoder f2655a;

        /* renamed from: c */
        public Resource b(ByteBuffer byteBuffer, int i, int i2, Options options) {
            return this.f2655a.a(ImageDecoder.createSource(byteBuffer), i, i2, options);
        }

        /* renamed from: d */
        public boolean a(ByteBuffer byteBuffer, Options options) {
            return this.f2655a.c(byteBuffer);
        }
    }

    public static final class StreamAnimatedWebpDecoder implements ResourceDecoder<InputStream, Drawable> {

        /* renamed from: a  reason: collision with root package name */
        public final AnimatedWebpDecoder f2656a;

        /* renamed from: c */
        public Resource b(InputStream inputStream, int i, int i2, Options options) {
            return this.f2656a.a(ImageDecoder.createSource(ByteBufferUtil.b(inputStream)), i, i2, options);
        }

        /* renamed from: d */
        public boolean a(InputStream inputStream, Options options) {
            return this.f2656a.b(inputStream);
        }
    }

    public Resource a(ImageDecoder.Source source, int i, int i2, Options options) {
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new DefaultOnHeaderDecodedListener(i, i2, options));
        if (decodeDrawable instanceof AnimatedImageDrawable) {
            return new AnimatedImageDrawableResource((AnimatedImageDrawable) decodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated webp, failing: " + decodeDrawable);
    }

    public boolean b(InputStream inputStream) {
        return d(ImageHeaderParserUtils.f(this.f2653a, inputStream, this.b));
    }

    public boolean c(ByteBuffer byteBuffer) {
        return d(ImageHeaderParserUtils.g(this.f2653a, byteBuffer));
    }

    public final boolean d(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP;
    }
}
