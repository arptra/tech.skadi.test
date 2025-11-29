package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final DataDecoder f2552a;

    public interface DataDecoder<Data> {
        Class a();

        void close(Object obj);

        Object decode(String str);
    }

    public static final class DataUriFetcher<Data> implements DataFetcher<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final String f2553a;
        public final DataDecoder b;
        public Object c;

        public DataUriFetcher(String str, DataDecoder dataDecoder) {
            this.f2553a = str;
            this.b = dataDecoder;
        }

        public Class a() {
            return this.b.a();
        }

        public void b() {
            try {
                this.b.close(this.c);
            } catch (IOException unused) {
            }
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
            try {
                Object decode = this.b.decode(this.f2553a);
                this.c = decode;
                dataCallback.e(decode);
            } catch (IllegalArgumentException e) {
                dataCallback.f(e);
            }
        }
    }

    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final DataDecoder f2554a = new DataDecoder<InputStream>() {
            public Class a() {
                return InputStream.class;
            }

            /* renamed from: b */
            public void close(InputStream inputStream) {
                inputStream.close();
            }

            /* renamed from: c */
            public InputStream decode(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        };

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f2554a);
        }
    }

    public DataUrlLoader(DataDecoder dataDecoder) {
        this.f2552a = dataDecoder;
    }

    public ModelLoader.LoadData a(Object obj, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(obj), new DataUriFetcher(obj.toString(), this.f2552a));
    }

    public boolean b(Object obj) {
        return obj.toString().startsWith("data:image");
    }
}
