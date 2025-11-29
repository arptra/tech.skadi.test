package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jetty.util.URIUtil;

public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{URIUtil.HTTP, URIUtil.HTTPS})));

    /* renamed from: a  reason: collision with root package name */
    public final ModelLoader f2597a;

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream> {
        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlUriLoader(multiModelLoaderFactory.d(GlideUrl.class, InputStream.class));
        }
    }

    public UrlUriLoader(ModelLoader modelLoader) {
        this.f2597a = modelLoader;
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(Uri uri, int i, int i2, Options options) {
        return this.f2597a.a(new GlideUrl(uri.toString()), i, i2, options);
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
