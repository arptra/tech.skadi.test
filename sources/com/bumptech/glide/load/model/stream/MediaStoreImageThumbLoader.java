package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreImageThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2601a;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2602a;

        public Factory(Context context) {
            this.f2602a = context;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreImageThumbLoader(this.f2602a);
        }
    }

    public MediaStoreImageThumbLoader(Context context) {
        this.f2601a = context.getApplicationContext();
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(Uri uri, int i, int i2, Options options) {
        if (MediaStoreUtil.e(i, i2)) {
            return new ModelLoader.LoadData(new ObjectKey(uri), ThumbFetcher.f(this.f2601a, uri));
        }
        return null;
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return MediaStoreUtil.b(uri);
    }
}
