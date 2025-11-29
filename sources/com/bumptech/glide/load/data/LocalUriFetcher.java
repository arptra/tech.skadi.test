package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f2461a;
    public final ContentResolver b;
    public Object c;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.f2461a = uri;
    }

    public void b() {
        Object obj = this.c;
        if (obj != null) {
            try {
                e(obj);
            } catch (IOException unused) {
            }
        }
    }

    public DataSource c() {
        return DataSource.LOCAL;
    }

    public void cancel() {
    }

    public final void d(Priority priority, DataFetcher.DataCallback dataCallback) {
        try {
            Object f = f(this.f2461a, this.b);
            this.c = f;
            dataCallback.e(f);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            dataCallback.f(e);
        }
    }

    public abstract void e(Object obj);

    public abstract Object f(Uri uri, ContentResolver contentResolver);
}
