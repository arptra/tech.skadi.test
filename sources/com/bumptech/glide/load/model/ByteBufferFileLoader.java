package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {

    public static final class ByteBufferFetcher implements DataFetcher<ByteBuffer> {

        /* renamed from: a  reason: collision with root package name */
        public final File f2551a;

        public ByteBufferFetcher(File file) {
            this.f2551a = file;
        }

        public Class a() {
            return ByteBuffer.class;
        }

        public void b() {
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
            try {
                dataCallback.e(ByteBufferUtil.a(this.f2551a));
            } catch (IOException e) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                dataCallback.f(e);
            }
        }
    }

    public static class Factory implements ModelLoaderFactory<File, ByteBuffer> {
        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteBufferFileLoader();
        }
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(File file, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(file), new ByteBufferFetcher(file));
    }

    /* renamed from: d */
    public boolean b(File file) {
        return true;
    }
}
