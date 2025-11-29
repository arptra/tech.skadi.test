package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.List;

public final class ResourceUriLoader<DataT> implements ModelLoader<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2585a;
    public final ModelLoader b;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2586a;

        public AssetFileDescriptorFactory(Context context) {
            this.f2586a = context;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceUriLoader(this.f2586a, multiModelLoaderFactory.d(Integer.class, AssetFileDescriptor.class));
        }
    }

    public static final class InputStreamFactory implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2587a;

        public InputStreamFactory(Context context) {
            this.f2587a = context;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceUriLoader(this.f2587a, multiModelLoaderFactory.d(Integer.class, InputStream.class));
        }
    }

    public ResourceUriLoader(Context context, ModelLoader modelLoader) {
        this.f2585a = context.getApplicationContext();
        this.b = modelLoader;
    }

    public static ModelLoaderFactory e(Context context) {
        return new AssetFileDescriptorFactory(context);
    }

    public static ModelLoaderFactory f(Context context) {
        return new InputStreamFactory(context);
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(Uri uri, int i, int i2, Options options) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return g(uri, i, i2, options);
        }
        if (pathSegments.size() == 2) {
            return h(uri, i, i2, options);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
        return null;
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return "android.resource".equals(uri.getScheme()) && this.f2585a.getPackageName().equals(uri.getAuthority());
    }

    public final ModelLoader.LoadData g(Uri uri, int i, int i2, Options options) {
        try {
            int parseInt = Integer.parseInt(uri.getPathSegments().get(0));
            if (parseInt != 0) {
                return this.b.a(Integer.valueOf(parseInt), i, i2, options);
            }
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (NumberFormatException e) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e);
            }
            return null;
        }
    }

    public final ModelLoader.LoadData h(Uri uri, int i, int i2, Options options) {
        List<String> pathSegments = uri.getPathSegments();
        String str = pathSegments.get(1);
        int identifier = this.f2585a.getResources().getIdentifier(str, pathSegments.get(0), this.f2585a.getPackageName());
        if (identifier != 0) {
            return this.b.a(Integer.valueOf(identifier), i, i2, options);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
        return null;
    }
}
