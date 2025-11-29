package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

class DataCacheWriter<DataType> implements DiskCache.Writer {

    /* renamed from: a  reason: collision with root package name */
    public final Encoder f2473a;
    public final Object b;
    public final Options c;

    public DataCacheWriter(Encoder encoder, Object obj, Options options) {
        this.f2473a = encoder;
        this.b = obj;
        this.c = options;
    }

    public boolean a(File file) {
        return this.f2473a.a(this.b, file, this.c);
    }
}
