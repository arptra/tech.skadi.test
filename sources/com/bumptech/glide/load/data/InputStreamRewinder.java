package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

public final class InputStreamRewinder implements DataRewinder<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclableBufferedInputStream f2459a;

    public static final class Factory implements DataRewinder.Factory<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayPool f2460a;

        public Factory(ArrayPool arrayPool) {
            this.f2460a = arrayPool;
        }

        public Class a() {
            return InputStream.class;
        }

        /* renamed from: c */
        public DataRewinder b(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f2460a);
        }
    }

    public InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f2459a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    public void b() {
        this.f2459a.release();
    }

    public void c() {
        this.f2459a.b();
    }

    /* renamed from: d */
    public InputStream a() {
        this.f2459a.reset();
        return this.f2459a;
    }
}
