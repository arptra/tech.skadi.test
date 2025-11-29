package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2603a;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2604a;

        public Factory(Context context) {
            this.f2604a = context;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.f2604a);
        }
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.f2603a = context.getApplicationContext();
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(Uri uri, int i, int i2, Options options) {
        if (!MediaStoreUtil.e(i, i2) || !e(options)) {
            return null;
        }
        return new ModelLoader.LoadData(new ObjectKey(uri), ThumbFetcher.g(this.f2603a, uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return MediaStoreUtil.d(uri);
    }

    public final boolean e(Options options) {
        Long l = (Long) options.c(VideoDecoder.d);
        return l != null && l.longValue() == -1;
    }
}
