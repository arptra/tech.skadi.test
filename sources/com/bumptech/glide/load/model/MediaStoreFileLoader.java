package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2567a;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2568a;

        public Factory(Context context) {
            this.f2568a = context;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f2568a);
        }
    }

    public static class FilePathFetcher implements DataFetcher<File> {
        public static final String[] c = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final Context f2569a;
        public final Uri b;

        public FilePathFetcher(Context context, Uri uri) {
            this.f2569a = context;
            this.b = uri;
        }

        public Class a() {
            return File.class;
        }

        public void b() {
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
            Cursor query = this.f2569a.getContentResolver().query(this.b, c, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                dataCallback.f(new FileNotFoundException("Failed to find file path for: " + this.b));
                return;
            }
            dataCallback.e(new File(str));
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f2567a = context;
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(uri), new FilePathFetcher(this.f2567a, uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return MediaStoreUtil.c(uri);
    }
}
