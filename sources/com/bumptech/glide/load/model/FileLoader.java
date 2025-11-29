package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.upuphone.runasone.uupcast.CaptureType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileLoader<Data> implements ModelLoader<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final FileOpener f2561a;

    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        public final FileOpener f2562a;

        public Factory(FileOpener fileOpener) {
            this.f2562a = fileOpener;
        }

        public final ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f2562a);
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory() {
            super(new FileOpener<ParcelFileDescriptor>() {
                public Class a() {
                    return ParcelFileDescriptor.class;
                }

                /* renamed from: c */
                public void close(ParcelFileDescriptor parcelFileDescriptor) {
                    parcelFileDescriptor.close();
                }

                /* renamed from: d */
                public ParcelFileDescriptor b(File file) {
                    return ParcelFileDescriptor.open(file, CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                }
            });
        }
    }

    public static final class FileFetcher<Data> implements DataFetcher<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final File f2563a;
        public final FileOpener b;
        public Object c;

        public FileFetcher(File file, FileOpener fileOpener) {
            this.f2563a = file;
            this.b = fileOpener;
        }

        public Class a() {
            return this.b.a();
        }

        public void b() {
            Object obj = this.c;
            if (obj != null) {
                try {
                    this.b.close(obj);
                } catch (IOException unused) {
                }
            }
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
            try {
                Object b2 = this.b.b(this.f2563a);
                this.c = b2;
                dataCallback.e(b2);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
                dataCallback.f(e);
            }
        }
    }

    public interface FileOpener<Data> {
        Class a();

        Object b(File file);

        void close(Object obj);
    }

    public static class StreamFactory extends Factory<InputStream> {
        public StreamFactory() {
            super(new FileOpener<InputStream>() {
                public Class a() {
                    return InputStream.class;
                }

                /* renamed from: c */
                public void close(InputStream inputStream) {
                    inputStream.close();
                }

                /* renamed from: d */
                public InputStream b(File file) {
                    return new FileInputStream(file);
                }
            });
        }
    }

    public FileLoader(FileOpener fileOpener) {
        this.f2561a = fileOpener;
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(File file, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(file), new FileFetcher(file, this.f2561a));
    }

    /* renamed from: d */
    public boolean b(File file) {
        return true;
    }
}
