package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final List f2667a;
    public final ResourceDecoder b;
    public final ArrayPool c;

    public StreamGifDecoder(List list, ResourceDecoder resourceDecoder, ArrayPool arrayPool) {
        this.f2667a = list;
        this.b = resourceDecoder;
        this.c = arrayPool;
    }

    public static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e);
            return null;
        }
    }

    /* renamed from: c */
    public Resource b(InputStream inputStream, int i, int i2, Options options) {
        byte[] e = e(inputStream);
        if (e == null) {
            return null;
        }
        return this.b.b(ByteBuffer.wrap(e), i, i2, options);
    }

    /* renamed from: d */
    public boolean a(InputStream inputStream, Options options) {
        return !((Boolean) options.c(GifOptions.b)).booleanValue() && ImageHeaderParserUtils.f(this.f2667a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }
}
