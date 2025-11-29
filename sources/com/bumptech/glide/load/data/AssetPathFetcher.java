package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f2453a;
    public final AssetManager b;
    public Object c;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.f2453a = str;
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

    public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
        try {
            Object f = f(this.b, this.f2453a);
            this.c = f;
            dataCallback.e(f);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            dataCallback.f(e);
        }
    }

    public abstract void e(Object obj);

    public abstract Object f(AssetManager assetManager, String str);
}
