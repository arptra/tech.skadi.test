package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

public class UrlLoader implements ModelLoader<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final ModelLoader f2608a;

    public static class StreamFactory implements ModelLoaderFactory<URL, InputStream> {
        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlLoader(multiModelLoaderFactory.d(GlideUrl.class, InputStream.class));
        }
    }

    public UrlLoader(ModelLoader modelLoader) {
        this.f2608a = modelLoader;
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(URL url, int i, int i2, Options options) {
        return this.f2608a.a(new GlideUrl(url), i, i2, options);
    }

    /* renamed from: d */
    public boolean b(URL url) {
        return true;
    }
}
