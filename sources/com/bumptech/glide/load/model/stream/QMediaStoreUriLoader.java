package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RequiresApi
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2605a;
    public final ModelLoader b;
    public final ModelLoader c;
    public final Class d;

    public static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2606a;
        public final Class b;

        public Factory(Context context, Class cls) {
            this.f2606a = context;
            this.b = cls;
        }

        public final ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new QMediaStoreUriLoader(this.f2606a, multiModelLoaderFactory.d(File.class, this.b), multiModelLoaderFactory.d(Uri.class, this.b), this.b);
        }
    }

    @RequiresApi
    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    @RequiresApi
    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    public static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {
        public static final String[] k = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final Context f2607a;
        public final ModelLoader b;
        public final ModelLoader c;
        public final Uri d;
        public final int e;
        public final int f;
        public final Options g;
        public final Class h;
        public volatile boolean i;
        public volatile DataFetcher j;

        public QMediaStoreUriFetcher(Context context, ModelLoader modelLoader, ModelLoader modelLoader2, Uri uri, int i2, int i3, Options options, Class cls) {
            this.f2607a = context.getApplicationContext();
            this.b = modelLoader;
            this.c = modelLoader2;
            this.d = uri;
            this.e = i2;
            this.f = i3;
            this.g = options;
            this.h = cls;
        }

        public Class a() {
            return this.h;
        }

        public void b() {
            DataFetcher dataFetcher = this.j;
            if (dataFetcher != null) {
                dataFetcher.b();
            }
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
            this.i = true;
            DataFetcher dataFetcher = this.j;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
        }

        public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
            try {
                DataFetcher f2 = f();
                if (f2 == null) {
                    dataCallback.f(new IllegalArgumentException("Failed to build fetcher for: " + this.d));
                    return;
                }
                this.j = f2;
                if (this.i) {
                    cancel();
                } else {
                    f2.d(priority, dataCallback);
                }
            } catch (FileNotFoundException e2) {
                dataCallback.f(e2);
            }
        }

        public final ModelLoader.LoadData e() {
            if (Environment.isExternalStorageLegacy()) {
                return this.b.a(h(this.d), this.e, this.f, this.g);
            }
            if (MediaStoreUtil.a(this.d)) {
                return this.c.a(this.d, this.e, this.f, this.g);
            }
            return this.c.a(g() ? MediaStore.setRequireOriginal(this.d) : this.d, this.e, this.f, this.g);
        }

        public final DataFetcher f() {
            ModelLoader.LoadData e2 = e();
            if (e2 != null) {
                return e2.c;
            }
            return null;
        }

        public final boolean g() {
            return this.f2607a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        public final File h(Uri uri) {
            Cursor cursor = null;
            try {
                cursor = this.f2607a.getContentResolver().query(uri, k, (String) null, (String[]) null, (String) null);
                if (cursor == null || !cursor.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursor.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public QMediaStoreUriLoader(Context context, ModelLoader modelLoader, ModelLoader modelLoader2, Class cls) {
        this.f2605a = context.getApplicationContext();
        this.b = modelLoader;
        this.c = modelLoader2;
        this.d = cls;
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(uri), new QMediaStoreUriFetcher(this.f2605a, this.b, this.c, uri, i, i2, options, this.d));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return MediaStoreUtil.c(uri);
    }
}
