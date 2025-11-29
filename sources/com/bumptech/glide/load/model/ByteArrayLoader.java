package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    public final Converter f2547a;

    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {
        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<ByteBuffer>() {
                public Class a() {
                    return ByteBuffer.class;
                }

                /* renamed from: c */
                public ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }
    }

    public interface Converter<Data> {
        Class a();

        Object b(byte[] bArr);
    }

    public static class Fetcher<Data> implements DataFetcher<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f2549a;
        public final Converter b;

        public Fetcher(byte[] bArr, Converter converter) {
            this.f2549a = bArr;
            this.b = converter;
        }

        public Class a() {
            return this.b.a();
        }

        public void b() {
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
            dataCallback.e(this.b.b(this.f2549a));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {
        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<InputStream>() {
                public Class a() {
                    return InputStream.class;
                }

                /* renamed from: c */
                public InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }
            });
        }
    }

    public ByteArrayLoader(Converter converter) {
        this.f2547a = converter;
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(byte[] bArr, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(bArr), new Fetcher(bArr, this.f2547a));
    }

    /* renamed from: d */
    public boolean b(byte[] bArr) {
        return true;
    }
}
