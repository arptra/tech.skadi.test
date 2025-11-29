package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

public interface GifDecoder {

    public interface BitmapProvider {
        byte[] a(int i);

        Bitmap b(int i, int i2, Bitmap.Config config);

        void c(Bitmap bitmap);

        int[] d(int i);

        void e(byte[] bArr);

        void f(int[] iArr);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    void a(Bitmap.Config config);

    void b();

    int c();

    void clear();

    int d();

    Bitmap e();

    void f();

    int g();

    ByteBuffer getData();

    int h();

    int i();
}
