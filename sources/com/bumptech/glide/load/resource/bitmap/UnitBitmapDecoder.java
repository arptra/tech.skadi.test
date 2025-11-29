package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    public static final class NonOwnedBitmapResource implements Resource<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f2642a;

        public NonOwnedBitmapResource(Bitmap bitmap) {
            this.f2642a = bitmap;
        }

        public void a() {
        }

        public int b() {
            return Util.i(this.f2642a);
        }

        public Class c() {
            return Bitmap.class;
        }

        /* renamed from: d */
        public Bitmap get() {
            return this.f2642a;
        }
    }

    /* renamed from: c */
    public Resource b(Bitmap bitmap, int i, int i2, Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }

    /* renamed from: d */
    public boolean a(Bitmap bitmap, Options options) {
        return true;
    }
}
