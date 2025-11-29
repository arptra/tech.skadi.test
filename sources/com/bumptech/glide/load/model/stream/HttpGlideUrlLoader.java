package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    public static final Option b = Option.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a  reason: collision with root package name */
    public final ModelCache f2599a;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final ModelCache f2600a = new ModelCache(500);

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.f2600a);
        }
    }

    public HttpGlideUrlLoader(ModelCache modelCache) {
        this.f2599a = modelCache;
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(GlideUrl glideUrl, int i, int i2, Options options) {
        ModelCache modelCache = this.f2599a;
        if (modelCache != null) {
            GlideUrl glideUrl2 = (GlideUrl) modelCache.a(glideUrl, 0, 0);
            if (glideUrl2 == null) {
                this.f2599a.b(glideUrl, 0, 0, glideUrl);
            } else {
                glideUrl = glideUrl2;
            }
        }
        return new ModelLoader.LoadData(glideUrl, new HttpUrlFetcher(glideUrl, ((Integer) options.c(b)).intValue()));
    }

    /* renamed from: d */
    public boolean b(GlideUrl glideUrl) {
        return true;
    }
}
